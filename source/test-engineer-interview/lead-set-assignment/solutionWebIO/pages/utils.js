const assert = require('chai').assert;

module.exports= {
    elementBy(selector) {
        return {
            get(){
                return browser.element(selector);
            }
        }
    },

    verifyElementVisible(element, msg){
        var isVisib = element.isVisible();
        console.log(`${msg} is Visible ${isVisib}`);
        assert.isTrue(isVisib, `Verify ${msg} is visible`);
    }

};