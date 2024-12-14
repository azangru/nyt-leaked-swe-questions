'use strict';
let axios = require('axios');
const recipeBoxPageSelectors = {
    savedRecipeTitle: '.nytc---cardbase---name'
};

const recipeBoxPageCommands = {
     unsaveRecipe: function (user_id, recipe_id, cookies) {
         let api_domain = this.api.launchUrl;
         let url = `${api_domain}/api/v2/users/${user_id}/collectables/recipe/${recipe_id}`;

        axios.delete(url, {
             headers: {
                 Cookie: `NYT-S=${cookies}`
             }
         }).then(res => {
            console.log(res.data);
         });
     }
    
};

module.exports = {
    elements: [
        recipeBoxPageSelectors,
    ],
    commands: [
        recipeBoxPageCommands,
    ]
};
