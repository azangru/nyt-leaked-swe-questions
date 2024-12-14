'use strict';


let homepage, loginPage, recipeBox, userName;
module.exports = {
    before: function (browser) {


        homepage = browser.page.homePage();
        loginPage = browser.page.loginPage();
        recipeBox = browser.page.recipeBoxPage();

    },
    beforeEach: function (browser) {
        browser.url(browser.launchUrl);

    },

    afterEach: function (browser, done) {
        browser.end(function () {
            done();
        });
    },

    'Verify Creating New User': function (browser) {

        userName = loginPage.registerNewUserAndVerify();
        homepage.verifyHomepageDisplayed();
    },

    'Verify Saving Recipe':  function (browser) {
        let expectedRecipeTitle;
        loginPage.loginAndVerify(userName);
        homepage.saveROTDandVerify();

        homepage.getAttribute('@rotdTitle', 'data-name', function (result) {
            expectedRecipeTitle = result.value;
            homepage.clickRecipeBoxLink();
            recipeBox.getText('@savedRecipeTitle', function (res) {
                browser.verify.equal(res.value, expectedRecipeTitle, 'Verify recipe in recipe box');
            })
        });
    },

    'Verify Unsaving Recipe': function (browser) {
        loginPage.loginAndVerify(userName);
        browser.perform(function () {
            browser.pause(4000);
            browser.execute(function () {
                return window.initState.user.id
            }, [], function (result) {
                console.log(result.value);
                let user_id = result.value;
                browser.getCookie('NYT-S', function (res) {
                    let nytCookie = res.value;
                    console.log(nytCookie);
                    homepage.getAttribute('@rotdId', 'data-id', function (res) {
                        let recipe_id = res.value;
                        recipeBox.unsaveRecipe(user_id,recipe_id, nytCookie)
                    });
                })
            })
        });

        browser.perform(function () {
            browser.pause(4000);
            homepage.clickRecipeBoxLink();
            recipeBox.waitForElementNotPresent('@savedRecipeTitle', 'Verify recipe unsaved');
        })

    }

};