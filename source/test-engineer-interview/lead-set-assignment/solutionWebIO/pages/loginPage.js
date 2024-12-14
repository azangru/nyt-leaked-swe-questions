const {elementBy, verifyElementVisible} = require('./utils');
var page = require('./page');
const assert = require('chai').assert;

var loginPage = Object.create(page, {

    loginNavBar: elementBy('.nytc---loginbtn---loginBtn'),
    modalBody: elementBy(".nytc---largepicturemodal---contentBody"),
    singUpLoginBtn: elementBy(".nytc---regimodal---tabButton"),
    email: elementBy('.nytc---largepicturemodal---contentBody input[name=\'email_address\']'),
    password1: elementBy('.nytc---largepicturemodal---contentBody input[name=\'password1\']'),
    password2: elementBy('.nytc---largepicturemodal---contentBody input[name=\'password2\']'),
    createAccount: elementBy('.nytc---largepicturemodal---contentBody span.nytc---buttonstyles---standard.nytc---buttonstyles---redCTA'),
    loggedInNavBar: elementBy('.nytc---loginbtn---registered'),
    username: elementBy('.nytc---loginbtn---navSubLabel'),
    userId: elementBy("input[name=userid][placeholder=Email]"),
    password: elementBy("input[name=password][placeholder=Password]"),
    loginBtn: elementBy(".nytc---regimodal---buttonContainer span[role='button']"),
    passwordAccountPage: elementBy('#password'),
    loginBtnAccountPage: elementBy('#submitButton'),


    registerNewUserAndVerify: {
        value: function (password) {
            let userName = 'ilya.gerasimov+' + Math.floor(Date.now() / 1000).toString();
            let userEmail = userName + '@nytimes.com';
            let passw = (typeof password === 'undefined') ? 'password' : password;
            console.log(userEmail);
            this.clickLoginBtn();
            this.singUpLoginBtn.click();
            let isVis = this.email.waitForVisible(false);
            this.email.setValue(userEmail);
            this.password1.setValue(passw);
            this.password2.setValue(passw);
            this.createAccount.click();
            this.loggedInNavBar.waitForVisible();
            browser.refresh();
            assert.include(this.username.getText(), userName, 'Verify expected username is displayed in navbar')
            return userEmail;


        },
    },

    clickLoginBtn: {
        value: function () {
            this.loginNavBar.click();
            this.modalBody.waitForVisible();
        }
    },

});


module.exports = {loginPage};
