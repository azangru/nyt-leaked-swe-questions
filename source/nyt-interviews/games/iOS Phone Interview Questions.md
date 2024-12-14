# iOS Phone Interview Questions
Some guidelines to consider:

- Allocate about 10 minutes for each section, and leave 10 minutes at the end for the candidate's questions.
- You may not have time for the **Code** questions, which is ok because they are captured for the most part in the code test and its review.
- Identify common topics to establish a baseline, eg: what the candidate uses, does he/she work well in teams, etc...
- Do not get into anything too technical that would otherwise appear in the code test.
- Leave open-ended questions for later in the conversation.

Below are categories of questions to ask during the phone screen.

## Introduction
- Thank them for their time.
- Introduce yourself, and briefly describe what the role is.

## Behavioral
- Tell us about yourself.
- Why iOS at the New York Times?
- Do you read any programming or design books or blogs?
- When you're having a problem or do not understand a subject, where do you go for help?
- What is the best class you have written? Explain why.
- What app that you developed are you most proud of?
- Tell me about the most recent project in your portfolio.
- Is there ever a _right_ way to code something?
- How do you deal with edge cases?
  - Edge cases can exist in behavioral specs and in code.
- What development models have you used (ad hoc, waterfall, agile, others)?
  - What did you like or dislike about them?
- Have you ever filed an Apple Radar? What was the response?
- On working with clients, stakeholders or Product
  - Does a frustrating experience come to mind? How was it resolved?
  - How about a success story?
- What are the three biggest problems with the Crossword app?

## Technical
- Aspects
  - How would you add analytics events to a codebase?
- Cocoa Touch
  - What is the minimum recommended touch target size on iOS? (only ask in phone screen)
  - What is your favorite Cocoa framework? What is your least favorite?
  - Which Cocoa programming pattern do you feel most comfortable implementing?
  - How do you accomplish animating something at the same speed as the keyboard?
- Code signing
  - What is going on there?
- Crash logs
  - What steps would you take to debug a crash log?
  - [[Give a link to a screenshot or the copied text of a real (solved) Crossword crash log.]]
- MVC, MVVM
  - Apple pushes Model-View-Controller, right? What does the pattern mean to you? MVVM?
- Persistence
  - What are some data persistence options on iOS? Compare and constrast.
- Reactive
  - If you are familiar with "reactive" programming, what do you think about it?
- Routing
  - i.e., moving between screens in an app.
  - Compare local push/pop, flow coordinators, app-wide router.
- SCM
  - Your project has a newly reported bug and you want to figure out when it was introduced. How do you go about it?
- Build Process
  - Describe your current build process (PR workflows, branches, provisioning profile management).
  - What tools do you use (fastlane, Hockey, TestFlight)?
- Testing
  - What are some strategies for unit testing? Compare and contrast.
    - [[Think TDD, BDD, and property-based like QuickCheck.]]
  - Integration testing. Do you do it and how?
    - [[Think when and why to mock.]]
- Types
  - How do you think about types? What are they good for?

## Code
- What is a pointer?
- How might you remove duplicates from an array?
- How do you implement an object that needs to dispatch a message and get back a result?
  - Patterns? e.g. delegate, block, target/action, invocation, notifications
  - What do you have to look out for when updating, let's say, the text of a label in response to an NSNotification?
- Property behaviors
  - What do things like `lazy` `weak`  `private(set)` `didSet` do?
- Swift memory model
- Swift protocols, extensions, and generics
- Swift value and reference semantics
- Copy-on-write: Start higher level, talk about copy/reference semantics, move to arrays and dictionaries as frequent examples of data structures, then optimization, then COW
- Code generation: clarify that it is an open-ended question, no right or wrong answer.
