# Welcome to the Games API take home test!

To better assess a candidate development skills, we would like to provide the following challenge. You have as much time as you'd like (though we ask that you not spend more than a few hours).

## Submission instructions

1. First, fork the project on GitHub. You will need to create an account if you don't already have one. The project is at https://github.com/nytm/games-api-interview it's a private repo and all your forks will be private as well.
2. Complete the project as described below within your fork.
3. Finally, push all of your changes to your fork on GitHub and submit a pull-request. You should also email your HR contact at The New York Times to let them know you have submitted a solution. Make sure to include your GitHub username in your email (so we can match people with pull requests).

### Alternative

You may receive this as a tar.gz file, the file contains a git repo (.git) and you should branch from master and return the zip file including the .git directory with your branch. Please make a note on the email about the name of your branch.

## Project Description

In petsdb.yaml you'll find an Open API specification for a 'Pets DB' service. It describes endpoints for users to create and update a profile along with endpoints to add, update and retrieve and delete the information about the pets in their life. 

A Makefile with several commands running MySQL 5.7 locally via Docker has been provided. Both tools will need to be installed for the server to run locally. The Makefile also contains wiring to execute ddl on the local MySQL server via the [migrate](https://github.com/golang-migrate/migrate) command. A small migration currently exists to help you get started.

In cmd/server/ you'll find a main package that demonstrates how to connect to the local database on start up. The `make run` command will set up the environment with the proper configuration before running the server.

### Here's what your API must do:

1. Implement all the endpoints in the petsdb.yaml spec. You mad add additional endpoints or fields as you see fit.
2. Implement a client and CLI tool for interacting with the API.
3. Develop some sort of identity system as hinted with the 'Authorization' header in the API specs. It can be as simple as a basic header or as advanced as OAuth, your call.
4. Be well tested.
5. Can be run via `make run`.

### Your application does not need to:

1. Be written with any framework (although bonus points for using our Gizmo servers https://github.com/nytimes/gizmo)

## Evaluation

Evaluation of your submission will be based on the following criteria. Additionally, reviewers will attempt to assess your familiarity with standard libraries and how you've structured your submission.

1. Did your application fulfill the basic requirements?
2. Did you document the method for setting up and running your application?
3. Did you follow the instructions for submission?
4. Did you follow best practices, methodologies like 12factor app?
