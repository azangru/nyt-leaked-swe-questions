**Interview Format**

1. 5 mins: Introduction
2. 40 mins: Design of a Theoretical System: The Meter Service
3. 5 mins: Candidate Questions

**I. Introduction** (5 mins)

-   Interviewers introduce themselves
-   Interviewers explain the format of the interview

Hi {candidate}. I'm {interviewer}, and this is {interviewer}. Thanks for taking
the time to meet with us today. We're both excited to get to know you and your
work better.

First we'll both tell you a bit more about ourselves. I'm a {role} on {team},
and I've been at The Times for {time}. (Allow the other interviewer to introduce
themselves.)

Our role today is to assess your experience and skills in application design.
We're going to spend about 40 minutes asking you to design a theoretical
application, and we'll save some time at the end for your questions. Do you have
any questions before we get started?

_Note: We generally recommend against providing the candidate with a chance to
tell us a bit about yourself, as many candidates tend to spend this time
repeating information that can already be gleaned from their resume._

**II. Design of a Theoretical System: The Meter Service** (40 mins)

-   _Interviewers provide a description of the system and requirements_
-   _Interviewers ask progressively more complex questions about the system as
    the interviewer masters basic questions_

Great. Let's dive right in. We're going to ask you to design a Meter Service.

Have you ever read the New York Times or another publication and encountered a
paywall that kept you from reading any additional articles until you registered,
or subscribed? Imagine a user is browsing the New York Times via the web or a
native application and hits their article limit. We want you to design the
system that communicates to the browser or app that it should show the paywall.

For our purposes, you can assume:

-   the service should return a simple true if the paywall should be shown or
    false if it shouldn't
-   the service is running on nytimes.com and has access to all the cookies set
    on that domain
-   there is one cookie in particular that the service can use to determine
    whether a user is a subscriber or not
-   your service has access to an Auth Service, a REST API that receives the
    cookie value referenced above and returns to you whether the user is a
    subscriber or not

Those are the system requirements. We'd like you to use the whiteboard to sketch
this application. We're here to help you, so we encourage you to talk as you
sketch/build.

Let's start by asking if you have any questions.

_Look for the candidate to ask questions such as:_

-   _What is the number of articles a user can view before they hit the
    paywall?_
-   _Is it the same for every non-subscriber?_
-   _Is there a TTL on the pageview limit? Does it refresh at some point?_
-   _Are there any limitations on services, technologies, languages I'm allowed
    to use that I should know about?_

_If the candidate has no questions, encourage them to start by drawing the basic
system components. There may be questions that naturally occur as the candidate
begins to sketch their initial design_. _For a junior candidate, you should
expect to spend your entire 40 minutes simply sketching out the system._

_Before advancing to additional questions, look for:_

-   _The candidate understands and is able to build a basic REST API_
    -   _The candidate discusses communication between the browser and the
        service and between the service and the Auth Service as HTTP protocol
        and uses the proper terminology for the correct REST methods_
    -   _The candidate considers and understands the format of requests and
        responses_
-   _The candidate considers how user/article count data should be stored,
    proposes a reasonable solution, and is able to discuss trade-offs of this
    choice_
    -   _The candidate chooses between a SQL or noSQL database_
    -   _The candidate discusses a database schema_
-   _The candidate understands and is able to articulate how the hypothetical
    service could/should communicate with the Auth Service_
-   _The candidate articulates an appropriate data layout for access (e.g. the
    service would consult the Auth Service before consulting a datastore of
    users and article counts … or vice versa … or in some other way)._
-   _The candidate walks through a user flow for their system for different
    types of users (a subscriber, a non-subscriber who has not hit the paywall,
    a non-subscriber who has hit the paywall)._

_If the candidate quickly sketches out a working solution from end to end, these
follow up questions are intended to advance the interview._

Technologies

-   What specific services and technologies would you use for each of the
    components you've sketched here?
-   Why? What are the tradeoffs involved in that choice? What else might you
    consider?

_Look for:_

-   _The candidate is able to consider more than one service/technology and able
    to make and explain their choice_
-   _The candidate is able to articulate the tradeoffs of their choice_
-   _The candidate mentions a service/technology they have never worked with
    directly but have learned about_

Datastorage &amp; Caching

-   Why did you choose the data store you did? What are its downsides? If I told
    you the NYTimes has no contract with that service and we're prohibited from
    using it, what would be your next choice, and why?

-   Could a cache be useful to your system at all? If not, why not? If so, build
    it.

Scaling

-   As NYTimes traffic scales up 10x, 100x, 1000x, where is this application
    likely to experience pain points?
-   What strategies might you use to mitigate that?

_Look for:_

-   _The candidate is able to identify where the application would break. (It is
    a red flag if the candidate considers their system to be invulnerable to
    traffic spikes.)_
-   _The candidate is able to identify strategies for scaling multiple parts of
    the application (they discuss auto-scaling or manual scaling and how this
    work work, they discuss load balancing, they discuss scaling their datastore
    in some way, they are sensitive to downstream effects, for example, on the
    Auth Service)_
-   _If the candidate identifies a way to scale, and is presented with an issue
    with their approach, they can pivot to another strategy_

A/B Testing

-   Imagine the Business wants to serve a certain population of non-subscribers
    a different paywall limit than others. How might your service accomplish
    this?
-   Does this effect your overall architectural approach? How does this affect
    the pain points you previously identified? You caching strategy? Your
    datastore and schema?

Production Outage

-   Let's say you receive a PagerDuty alert that your system is issuing an
    unusually high number of 500s. Walk me through the steps you take to
    diagnose the issue.

Security

-   How would you secure your system?

**IV. Candidate Questions (5 mins)**

We want to make sure we leave some time for your questions, so we'll wrap up
with our portion of the interview and turn it over to you. Are there any
questions you have for us about tech at The Times?

(Answer questions, then wrap up.)
