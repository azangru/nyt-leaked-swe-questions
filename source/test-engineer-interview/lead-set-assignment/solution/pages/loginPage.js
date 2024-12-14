'use strict';

const loginPageSelectors = {
    loginNavBar: '.nytc---loginbtn---loginBtn',
    modalBody: ".nytc---largepicturemodal---contentBody",
    singUpLoginBtn: ".nytc---regimodal---tabButton",
    email: '.nytc---largepicturemodal---contentBody input[name=\'email_address\']',
    password1: '.nytc---largepicturemodal---contentBody input[name=\'password1\']',
    password2: '.nytc---largepicturemodal---contentBody input[name=\'password2\']',
    createAccount: '.nytc---largepicturemodal---contentBody span.nytc---buttonstyles---standard.nytc---buttonstyles---redCTA',
    loggedInNavBar: '.nytc---loginbtn---registered',
    username: '.nytc---loginbtn---navSubLabel',
    userId: "input[name=userid][placeholder=Email]",
    password: "input[name=password][placeholder=Password]",
    loginBtn: ".nytc---regimodal---buttonContainer span[role='button']",
    passwordAccountPage: '#password',
    loginBtnAccountPage: '#submitButton'
};

const loginPageCommands = {
    registerNewUserAndVerify: function (password) {
        let userName = 'ilya.gerasimov+' + Math.floor(Date.now() / 1000).toString();
        let userEmail =  userName+ '@nytimes.com';
        let passw = (typeof password === 'undefined') ? 'password' : password;
        console.log(userEmail);
        this.clickLoginBtn()
            .click('@singUpLoginBtn')
            .waitForElementVisible('@email', 'Verify email input is displayed in regi modal')
            .setValue('@email', userEmail)
            .setValue('@password1', passw)
            .setValue('@password2', passw)
            .click('@createAccount')
            .waitForElementVisible('@loggedInNavBar', 'Verify new user is registered')
            .api.refresh()
            this.verify.containsText('@username', userName, 'Verify expected username is displayed in navbar');
        return userEmail;
    },

    clickLoginBtn: function () {
        return this.click('@loginNavBar')
            .waitForElementVisible('@modalBody', 'Verify login modal displayed');
    },

    loginAndVerify: function (userID, password) {
        let brows = this;
        let passw = (typeof password === 'undefined') ? 'password' : password;
        this.clickLoginBtn()
            .waitForElementVisible('@userId', 'Verify login modal is displayed')
            .setValue('@userId', userID)
            .setValue('@password', passw)
            .click('@loginBtn')
        this.api.pause(2000)
            .url(function (result) {
                if(result.value.includes('auth/login')){
                    brows.setValue('@passwordAccountPage', passw)
                        .click('@loginBtnAccountPage')
                        .api.pause(2000)
                }
            })

        this.waitForElementNotPresent('@modalBody', 'Login modal should not be present');
        this.waitForElementPresent('@loggedInNavBar', 'Verify user logged in successfully');
    },



};

module.exports = {
    elements: [
        loginPageSelectors,
    ],
    commands: [
        loginPageCommands,
    ]
};
