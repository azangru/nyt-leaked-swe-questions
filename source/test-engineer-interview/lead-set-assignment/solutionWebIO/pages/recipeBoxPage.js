const {elementBy, verifyElementVisible} = require('./utils');
var page = require('./page');
let axios = require('axios');

var recipePage = Object.create(page, {

    savedRecipeTitle: elementBy('.nytc---cardbase---name'),





    unsaveRecipe: {
        value: function (user_id, recipe_id, cookies) {

            let api_domain = browser.options.baseUrl;
            let url = `${api_domain}/api/v2/users/${user_id}/collectables/recipe/${recipe_id}`;

            axios.delete(url, {
                headers: {
                    Cookie: `NYT-S=${cookies}`
                }
            }).then(res => {
                console.log(res.data);
            });
        },
    },



});


module.exports = {recipePage};
