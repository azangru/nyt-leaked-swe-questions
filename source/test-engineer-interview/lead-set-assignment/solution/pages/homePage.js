'use strict';

const homePageSelectors = {
    editorsCollectionSection: '#popular-collections',
    cookingGuidesSection: '#cooking-guides',
    subscribeLink: "a.nytc---subscribenavbtn---subLink",
    seeAllCollectionsBtn: "a[href*='collections']",
    seeAllCookingGuidesBtn: ".btn-group.see-all-btn-group [href*='learn-to-cook']",
    samSuggestions: "#sams-suggestions",
    saveBtn: "[class='card card-static static'] div[class='save btn']",
    savedBtn: "[class='card card-static static saved'] div[class='save btn']",
    rotdTitle: `div.rotd .name`,
    rotdId: `div.rotd article`,
    recipeBoxLink: "a.nytc---navbtn---login-child.nytc---navbtn---navLabel",
    createNewFolderTxt: "div.nytc---newcollectionbutton---container span"
};

const homePageCommands = {
    verifyHomepageDisplayed: function () {
        return this
            .verify.visible('@editorsCollectionSection', 'Verify if Editors Collection Section is Present')
            .verify.visible('@cookingGuidesSection', 'Verify if Cooking Guides Section is Present.')
            .verify.visible('@seeAllCollectionsBtn', 'Verify if seeAllCollectionsBtn is Present.')
            .verify.visible('@seeAllCookingGuidesBtn', 'Verify if seeAllCookingGuidesBtn is Present.')
            .verify.visible('@samSuggestions', 'Verify if samSuggestions is Present.')
    },

    saveROTDandVerify: function () {
        return this
            .click('@saveBtn')
            .waitForElementVisible('@savedBtn', 'Verify saved btn displayed');
    },

    clickRecipeBoxLink: function () {
        return this.click('@recipeBoxLink')
            .waitForElementVisible('@createNewFolderTxt', 'Waiting for Create new folder element');
    }
};

module.exports = {
    elements: [
        homePageSelectors,
    ],
    commands: [
        homePageCommands,
    ]
};
