# [Full Tech Screen Rubric](https://docs.google.com/spreadsheets/d/1-j7YRVSlbdEBtNd5ch1CoSdUwOnDUiwqq0lfWGXm6BU/edit#gid=0)

<style>
  .md-typeset .md-typeset__table table {
    width: 1000px;
  }

  .md-typeset table:not([class]) td {
    text-align: left;
    padding: 0.4rem;
    border-left: .05rem solid rgba(0,0,0,.07);
  }

  .md-typeset__scrollwrap {
    overflow-x: visible;
  }
</style>

| **Screening For**                                                                                                                                                                             |                                                                                                                                          **Clearly Not Demonstrated**                                                                                                                                           |                                                                                                                                      **Not Demonstrated**                                                                                                                                      |                                                                                                                                                                                    **Mixed**                                                                                                                                                                                    |                                                                                                                                                                              **Demonstrated**                                                                                                                                                                                      |                                                                                                                                                                                       **Clearly Demonstrated**                                                                                                                                                                                       |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| **Problem solving -** _Do not make a call if you are not asking the candidate to solve a problem and they are not asked to describe a time where they solved a substantial problem._          |                                                                                                Unable to conceive of solution<br><br>Able to describe a basic, or naïve approach<br><br>Unable to implement it.                                                                                                 |                                                               Unable to arrive at a solution beyond the most basic, naïve approach, even with help and hints<br><br>Solution does not account for edge cases _(if time allowed)_                                                               |                                            Conceives of and implements a naïve solution independently<br><br>Conceives of a better approach with minimal hints, and is able to complete it with help<br><br>Dives in to a solution without giving the problem much thought, or asking questions, needs help to solve                                                            |  Outlines a solution beyond the most naïve, independently, and implement it, covering the vast majority of cases <br><br>Understands hint importance quickly, and moves on <br><br>Asks questions to clarify the scope of the problem and states their assumptions <br><br>If an edge case is pointed out to the candidate, they are able to modify their solution independently   |                Clarifies the scope as a natural first step <br><br>Articulates multiple approaches and describe the pros and cons of each <br><br>Makes a sensible decision based on the constraints of the interview format <br><br>Able to fully implement the approach, without much help <br><br>Recognises edge cases and draws attention to them unprompted, then solves them.                 |
| **Code fluency -** _Do not make a call if you are not testing a candidate’s ability to produce code, or asking them to read or review code._                                                  |                                                               Does not know basic language constructs like loops, conditionals<br><br>Cannot invoke functions correctly<br><br>Unable to read provided code or describe in any sense what it does                                                               |          Unable to translate their thoughts into code<br><br>Demonstrates little knowledge of the language’s standard library<br><br>Chooses nonsensical or non-descriptive variable names when writing code<br><br>Can't describe the behaviour of any provided code with precision           |                                                                             Able to write basic code, but does not demonstrate strong familiarity with properties or idioms<br><br>Reimplements standard library functions, rather than using what is available (if interviewer knows the language)                                                                             |                                      Codes fluently and naturally<br><br>Chooses to use standard library functions; able to describe their behaviour when asked (May use placeholders to abstract away functionality then fill them in later)<br><br>Able to understand the general purpose of the code quickly when reading a sample                                              |                                                      Codes without any significant pauses and writes idiomatic code by default<br><br>Thought is translated into code without any apparent difficulty<br><br>Able to understand a sample's full behaviour and nuances on first read, and point out more idiomatic approaches where appropriate                                                       |
| **Autonomy-** _People who will be able to work with minimal guidance, and people who are able to own problems._                                                                               |                                                                              Requires hand-holding and has to be led through every step of the interview<br><br>Refuses to make any decisions without consent from the interviewer                                                                              | Requires lots of support to complete their task<br><br>Decisions are made reluctantly. Approval and validation are sought for each decision<br><br>Unable to describe a time where they led or instigated a project <br><br>unable to describe a time when they solved something independently |                                                                                         Able to work independently, but seeks approval regularly in a way that abdicates responsibility<br><br>Demonstrates some ability to deliver a solution without much input from the interviewer                                                                                          |                                                                                    Owns their decisions and demonstrates a strong ability to work independently.<br><br>If more junior, takes ownership of the problem, using the interviewer as a resource to make progress, if needed                                                                                            |                                                                                     Controls the cadence of the task-oriented part of the interview, asking for guidance or clarification only where appropriate<br><br>Makes decisions without seeking approval, but describes the rationale to the interviewer                                                                                     |
| **Basic Computer Science Knowledge -** _Whether they understand that there are trade-offs in building software, and that different algorithms and data structures have different trade-offs._ |                                                                         Unfamiliar with the most common data structures, like hash, set, or array<br><br>Completely unable to assess the relative merits of competing algorithm choices                                                                         |              Heard of common data structures, but cannot describe which ones are appropriate for the task at hand, or when they might be useful<br><br>Cannot explain, for example, the difference between an O(n) solution and an O(n²) solution (the behaviour, not the terms)               |                                                                     Uses hashes, sets and the like appropriately, but cannot, for instance differentiate between a list, a queue, and an array<br><br>Aware that certain data structures are better for certain tasks, but has difficulty articulating why                                                                      |      Understands time and space complexity (even if they don’t use those terms)<br><br>Can describe the characteristics of common algorithms<br><br>Can describe the tradeoffs inherent in different approaches<br><br>Can articulate why a specific data structure is appropriate<br><br>Can implement a recursive algorithm (if recursion makes sense for the task)              |                                                      Able to pick an appropriate data structure or algorithm for a task, and has a strong understanding of their relative merits <br><br>Knowledge goes beyond the basics, and there is a demonstrated familiarity with concepts like heaps, priority queues, tries, or more exotic constructs                                                       |
| **System Design -** _Do not make a call if the task at hand is so simple that nobody would realistically do anything other than write a quick script._                                        |                     Writes all their code in one function, with no decomposition<br><br>Does not see the value in separating out code in their solution<br><br>In a design question, the candidate fails to define any reasonable abstractions, or has no idea how to construct the system                      |             Does not seek to break out their code into reusable components, and doesn’t understand the value of doing so<br><br>Unable to describe the interaction of system components with any precision<br><br>Does not demonstrate any understanding of separation of concerns             |                                               Adopts a reactive approach to code or system organisation, thinking only one step ahead at a time<br><br>Finished output has the appearance of being bolted together, rather than being coherently designed<br><br>Abstractions exist, but are leaky, rigid or resistant to change                                                | Able to structure their system in a way that separates concerns appropriately with components that interact through reasonable interfaces<br><br>In object-oriented code, the candidate demonstrates a good understanding of SOLID principles (even if they don’t know the specific terms)<br><br>For simple code, functions are used appropriately to minimise complexity         | Able to break down a complex system into elegantly structured components<br><br>Able to thoroughly describe the interaction model, the interface and the behaviour<br><br>Abstractions are clear and clean and keep open the possibility of future needs without significant refactoring<br><br>Additional thought is given to complex and subtle interactions, like race conditions and idempotency |
| **Resoluteness -** _Do not make a call if the candidate is able to provide a solution with little effort, and no questions are asked about previous challenges._                              | Fails to complete the assigned task and is ambivalent about it<br><br>Candidate is unable, when asked, to describe a time when they persisted at something, or describes a time when they quit because something was too hard<br><br>Demonstrates no capacity for sticking with something in any prior position |                                                   Shows no strong desire to finish the problem<br><br>Candidate shows no strong inclination to get to a fully working answer<br><br>Sees difficult times as barriers, rather than challenges                                                   |                     Professes a desire to finish a task, but shows signs of frustration when issues come up, and becomes negative about the situation<br><br>In describing a difficult prior position, the candidate failed to take any steps to make their situation better, did not explore alternatives, and instead moved on in relatively short order                      |                                                             Demonstrates a desire to finish the assigned task; suitably motivated to fix issues<br><br>Describes a time when they persevered with a difficult situation and achieved a good outcome<br><br>Describes prior challenges as growth opportunities                                                                      |                                               Very determined to finish the task assigned and works hard to do so<br><br>Eager to describe next steps, additional work, or extensions<br><br>Demonstrated incredible staying power in a difficult previous situation, doggedly pursuing their goal beyond what would be expected of an average person                                                |