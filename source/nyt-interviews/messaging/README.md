To better assess a candidate development skills, we would like to provide the following challenge. You have as much time as you'd like (though we ask that you not spend more than a few hours).

## Submission instructions

1. First, fork the project on GitHub. You will need to create an account if you don't already have one. The project is at https://github.com/nytm/messaging-interview it's a private repo and all your forks will be private as well.
2. Complete the project as described below within your fork.
3. Finally, push all of your changes to your fork on GitHub and submit a pull-request. You should also email your HR contact at The New York Times to let them know you have submitted a solution. Make sure to include your GitHub username in your email (so we can match people with pull requests).

## Project Description

This problem consists of finding a valid way to separate a string consisting of concatenated words from a dictionary. This input string can be found in concatenated.txt. The words in the dictionary can be found separated by newlines in words.txt. (these files are part of the project and you can find them in this directory)

For this problem, using the GO language, please create an API that reads in the input string from concatenated.txt and dictionary words from words.txt and separates the entire concatenated string into a set of valid dictionary words. For example, if the input string is "applepie" and the dictionary contains a standard set of English words, "apple pie" would be a valid separation. You should provide endpoints to output the separated words in a clear format of your choice; printing one solution word per line is fine. 

You can assume that the input string consists solely of a concatenation of words randomly selected from the dictionary, i.e. that there will be a way to space-separate it into dictionary words. There may be multiple valid ways to separate the string but all valid separations are equally valid and no specific one is preferred. You can assume that the entire dictionary can be loaded into memory, but do not make assumptions about the maximum length of words in the dictionary.


### Here's what your api must do:

1. be written in Go
2. have an endpoint `GET /healthcheck` that returns a json `{ 'status':'OK' }`
3. an endpoint `POST /dictionary` that will receive a file containing words and initialize the API’s dictionary.
4. an endpoint `POST /split` that will receive a file containing concatenated words and reply with the separated words one per line.
5. a SOLUTION.md with an explanation of your approach and analysis of the worst case runtime in terms of the length of the concatenated string. Please also include instructions for how to run your solution.
5. any undefined routes should return a 404


### Your application does not need to:

1. handle authentication or authorization (bonus points if it does, extra bonus points if it's via Google Cloud Endpoints)
2. be written with any framework (although bonus points for using our Gizmo framework https://github.com/nytimes/gizmo)

Your application should be easy to set up and should run on either Linux or Mac OS X. It should not require any for-pay software.

## Evaluation

Evaluation of your submission will be based on the following criteria. Additionally, reviewers will attempt to assess your familiarity with standard libraries and how you've structured your submission.

1. Did your application fulfill the basic requirements?
2. Did you document the method for setting up and running your application?
3. Did you follow the instructions for submission?
4. Did you follow best practices, methodologies like 12factor app?
