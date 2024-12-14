const assert = require('chai').assert;

let homePage = require('../pages/homePage');
let loginPage = require('../pages/loginPage');
let recipeBoxPage = require('../pages/recipeBoxPage')


describe('test home page', function () {
    let userName;
    beforeEach(() => {

        console.log(browser.options.baseUrl);
        browser.url('/');
    });


   it('Verify creating new user', function () {

       userName = loginPage.loginPage.registerNewUserAndVerify();
       homePage.formPage.verifyHomepageDisplayed();
   });

    it('Verify Saving Recipe', function () {
        homePage.formPage.saveROTDandVerify();
        let expectedRecipeTitle = homePage.formPage.rotdTitle.getAttribute('data-name');
        homePage.formPage.clickRecipeBoxLink();
        let actRecipeTitle = recipeBoxPage.recipePage.savedRecipeTitle.getText();
        assert.equal(actRecipeTitle, expectedRecipeTitle, 'Verify recipe in recipe box')

    });

    it('Verify Unsaving Recipe', function () {
        let user_id = browser.execute(function () {
            return window.initState.user.id;
        }).value;
        let nytCookie = browser.getCookie('NYT-S').value;
        let recipe_id = homePage.formPage.rotdId.getAttribute('data-id');
        recipeBoxPage.recipePage.unsaveRecipe(user_id, recipe_id, nytCookie);
        browser.pause(4000);
        homePage.formPage.clickRecipeBoxLink();
        homePage.formPage.clickRecipeBoxLink();
        recipeBoxPage.recipePage.savedRecipeTitle.waitForVisible(null,true);
    })

});
