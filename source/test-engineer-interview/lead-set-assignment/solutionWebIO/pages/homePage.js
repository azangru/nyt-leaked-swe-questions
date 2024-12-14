const {elementBy, verifyElementVisible} = require('./utils');
var page = require('./page');

var formPage = Object.create(page, {


    editorsCollectionSection: elementBy('#popular-collections'),
    cookingGuidesSection: elementBy('#cooking-guides'),
    subscribeLink: elementBy("a.nytc---subscribenavbtn---subLink"),
    seeAllCollectionsBtn: elementBy("a[href*='collections']"),
    seeAllCookingGuidesBtn: elementBy(".btn-group.see-all-btn-group [href*='learn-to-cook']"),
    samSuggestions: elementBy("#sams-suggestions"),
    saveBtn: elementBy("[class='card card-static static'] div[class='save btn']"),
    savedBtn: elementBy("[class='card card-static static saved'] div[class='save btn']"),
    rotdTitle: elementBy(`div.rotd .name`),
    rotdId: elementBy(`div.rotd article`),
    recipeBoxLink: elementBy("a.nytc---navbtn---login-child.nytc---navbtn---navLabel"),
    createNewFolderTxt: elementBy("div.nytc---newcollectionbutton---container span"),


    verifyHomepageDisplayed: {
        value: function () {
            verifyElementVisible(this.editorsCollectionSection, 'editors collection');
            verifyElementVisible(this.cookingGuidesSection, 'Cooking Guides Section');
            verifyElementVisible(this.seeAllCollectionsBtn, 'seeAllCollectionsBtn');
            verifyElementVisible(this.seeAllCookingGuidesBtn, 'seeAllCookingGuidesBtn');
            verifyElementVisible(this.samSuggestions, 'samSuggestions');
        },
    },

    saveROTDandVerify: {
        value: function () {
            this.saveBtn.click();
            this.savedBtn.waitForVisible();
        }
    },

    clickRecipeBoxLink: {
        value: function () {
            this.recipeBoxLink.click();
            this.createNewFolderTxt.waitForVisible();
        }
    }


});


module.exports = {formPage};
