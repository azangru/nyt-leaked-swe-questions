Please see the following challenge which is designed to assess a candidate on various skills such as development skills, test framework design principles, documentation, code quality, etc. 

## Project Description

You have to automate following given user scenarios using Nodejs selenium framework. It can be either using nightwatch.js or webdriver.io. Please stick to base project lib and do not use any boilerplate projects such as https://github.com/mucsi96/nightwatch-cucumber , https://github.com/js-republic/nightwatch-boilerplate

### User scenarios

Base URL: https://cooking.nytimes.com/

**1) Verify Creating New User**
  * Navigate to base url & click 'Login' button located on top left navigation bar
  * In login modal, click 'Sign up'
  * Fill in all the details and hit 'Create Account'
  * Verify your username appears on top right
  * Verify home page is loaded (please verify bare minimum DOM elements)

**2) Verify Saving Recipe**
* Login and save any recipe from homepage
* Click on 'Your Recipe Box' on top right navigation bar
* Click on 'Saved Recipes' located on left vertical navigation bar
* Verify the recipe saved from homepage appears here

**3) Verify Unsaving Recipe**
* Save recipe by following (Verify Saving Recipe) user scenario mentioned above
* Call API to unsave recipe which was recently saved by following above point
* Verify recipe is unsaved and no longer appears in recipe box

**Hint:**
* API to unsave can be traced by networking tool
* API will require passing cookie while making request and user agent, cookie name is `NYT-S`
* API will require passing user id in api call for e.g `cooking.nytimes.com/api/v2/users/$user_id/`
* User id can be obtained by passing `window.initState.user.id` in browser console, it will be six digit number such as `82301438`

**Bonus points if you login using custom command for user scenario 3 (Verify Unsaving Recipe)**
* Nightwatchjs and webdriverIO both allow us to create custom commands e.g http://webdriver.io/guide/usage/customcommands.html
* Please create command call `customLogin` that will do following
* Set cookie with key as `NYT-S`, you can get the value of `NYT-S` from cookie inspector after you create account and remain logged in
* Along with passing cookies, also include one assertion that validates login was succesful

## Submission instructions

* Please include README.md with all the instructions regarding executing, setup, test organization etc 
* You can submit either through git, gitbucket, zip file via email, etc

## Evaluation

Following criteria will be used to grade your submission. 

1. Working solution is submitted by following given guidelines. 
2. Along with working code, we care about the quality of the code which will be heavily assessed i.e comments, structure, clear variables names, avoiding magic numbers, etc.   
3. The solution is implemented using Page object pattern and use optimized CSS selector strategy. 
4. Bonus points if custom command is created to login by setting cookies. 
5. More bonus points if the code is written in es6 standard. 
