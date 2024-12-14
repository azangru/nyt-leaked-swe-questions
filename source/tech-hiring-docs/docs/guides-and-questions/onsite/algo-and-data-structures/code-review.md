## Code Review Interview

### Interactive Coding Environment Setup

Coderpad Link

-   <a href="https://app.coderpad.io/dashboard/questions/all/253057" target="_blank">Interview Prompt</a>

Click the `Create Pad` link to create a unique coderpad for your interview, and share it with your co-interviewer and interviewee. Name the pad after the candidate.


### Links

-   <a href="https://drive.google.com/drive/u/0/folders/1ABgRO_-kgbd6A9q-0_OmOxB34rG58nEX" target="_blank">Google Drive</a>
- <a href="https://docs.google.com/document/d/1RLmk_MDNsvqosueqng-YxMgIDAP4lkVP8WM7VwEkWig/edit" target="_blank">Table of Contents</a>
-   <a href="https://docs.google.com/document/d/1M4zGc6jh_ZJtEh-yL6xNKUCeQ5vRYLDV-ntL3YTOalA/edit" target="_blank">Pre-interview Candidate Communication</a>
-   <a href="https://docs.google.com/document/d/1rQYd1hXWAfsu6VZyDl3atRMM-r8NkE1RCs8MZiEblys/edit" target="_blank">Interviewer Script</a>
-   <a href="https://docs.google.com/spreadsheets/d/14Wh4iqe_jZq2UE3KxZGbRLo8N0ZNwAmehgGIDQo9TnU/edit#gid=0" target="_blank">Solutions Guide Spreadsheet</a>
-   <a href="https://www.google.com/url?q=https://github.com/nytimes/code-review-wg/pull/18/files&sa=D&source=docs&ust=1704919370905497&usg=AOvVaw2SSmaeJ78oiZ8ybaDrXnlW" target="_blank">Solutions Guide Github</a>
-   <a href="https://github.com/nytimes/code-review-wg/" target="_blank">Github repo</a>
-   <a href="https://docs.google.com/document/d/1w-N4Q0mTb8Dgr-gOLJphu92YH85YJIKToeTxIlV3278/edit" target="_blank">Rubric</a>


### Interview Format

- 5 minutes for introductions
- 5 minutes for exercise instructions
- 30 minutes for code review and discussion (with optional focus time)
- 5 minutes for feature instructions
- 20 minutes to implement and discuss execution of a small feature (with optional focus time)
- 10 minutes for questions

### I. Exercise Instructions

:paperclip:   <a href="https://docs.google.com/document/d/1rQYd1hXWAfsu6VZyDl3atRMM-r8NkE1RCs8MZiEblys/edit" target="_blank"> Interviewer Script</a>

!!! quote
    Your team is working on a new tool for searching for articles. Your coworker started this work but had a family emergency and wasn’t able to finish it. They're new to the team and have asked you to review their work and provide feedback and implement a small feature, as well as help them take the ticket across the finish line (they left some to-dos).

    We’ll do the code review portion for about 30 minutes and then we'll use the rest of the time to add a small feature. We'll also leave 5-10 minutes at the end for any questions you may have for us. In each section, you’ll have the option to work solo/off-camera for a bit, if that aligns better with your working style. This won’t count against you — please feel free to use that time if you’d like it. 

    Some general guidance:
    - Please leave notes in the code to help guide discussion (these only need to be detailed enough to jog your memory)
    - You don’t need to fix the bugs
    - Focus on `/src` directory and `secrets.json`
    - You can use the internet as a resource
    - If you’re feeling stuck, just let me know and I can give you some guidance
    - We DO NOT expect you to get every bug or comment
    - You can ignore any commented out code related to a bookmark feature. We'll get to that in the next section

    We'll be looking for a few things during this interview:
    - Process — how you approach code review
    - Critiquing the code at a high level
    - Detailed critique (bugs, code quality issues) and language fluency
    - Collaboration — how you express your thoughts and feedback with me

    Do you have any initial questions before we dive in?

    Let's jump into the review. Please share your screen while you work. Would you like to take the solo working time, or stay on camera while you review the code?

If candidate answers YES

!!! quote
    You can take up to 20 minutes to work on your own. Please leave comments in the code. Then we’ll come back and discuss. 


If candidate answers NO

!!! quote
    We have up to 30 minutes for you to review the code and identify any bugs you see or improvements you'd recommend. Start wherever you think is best.

If the candidate chooses solo working time, they can turn off their camera and stop screen sharing for up to 20 minutes. When they come back, have them go through their observations.


#### Guiding Questions

If the candidate gets stuck at any point, you can use any of these guiding questions to help:

- What changes would you make or what would you add to make this production quality work?
- What would you suggest changing in the css files to align with styling best practices?
- Are there any improvements to accessibility you would make?
- How does the code handle when there are no search results? Is there something you can improve upon there?
- Have we accounted for the different response types the articles API might return? How are errors being handled?
- What happens when you click “show details”? Is it what you’d expect?
- Do you notice anything about the initial state of the API results? How would you expect this to work?
- Is there anything you can address with regards to naming or duplicate code?

If candidate is overwhelmed and doesn’t know what to look at:

- Let’s focus on \<file> for now… (then reference solutions guide for ideas of specific things to point them to)


### II. Feature Implementation Instructions

:paperclip: <a href="https://github.com/nytimes/code-review-wg/pull/17/files">Feature Solutions Guide</a>


!!! quote
    We're now going to ask you to implement a small feature to enable bookmarking articles. The requirements are in the CoderPad instructions (under "Instructions Part 2"). They are:

    - Add and remove bookmarks on each Article
    - Display whether the article is bookmarked or not on each Article component
    - Update the button functionality and text to add or remove a bookmark depending on the current state of the Article
    - Make the bookmark list dialog work — that includes opening/closing the dialog, listing the saved articles, and displaying the count of the number of saved articles
    - Enable removing a bookmark from within the dialog

    We have 20 minutes for this part. Would you like to take any solo working time? 

If the candidate answers YES, allow them to turn their camera off and stop sharing their screen for 10 minutes. After 10 minutes, have them come back to discuss what they've implemented.

!!! attention

    Interviewer should uncomment all the code relating to bookmarks now.


### III. Candidate Questions

!!! quote
    “We want to make sure we leave some time for your questions, so we’ll wrap up with our portion of the interview and turn it over to you. Are there any questions you have for us about tech at The Times?”

Answer questions and wrap up.

### IV. Interviewer Evaluation

:paperclip:  <a href="https://docs.google.com/document/d/1w-N4Q0mTb8Dgr-gOLJphu92YH85YJIKToeTxIlV3278/edit">Rubric</a>
:paperclip:  <a href="https://docs.google.com/spreadsheets/d/14Wh4iqe_jZq2UE3KxZGbRLo8N0ZNwAmehgGIDQo9TnU/edit#gid=0">Solutions Guide Spreadsheet</a>
:paperclip:  <a href="https://github.com/nytimes/code-review-wg/pull/18/files">Solutions Guide — Github</a>

</br>

|  | Does not meet requirements | Associate - Mid-level | Mid-level - Senior | Senior - Staff |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Process            |Does not clarify requirements or organize thoughts before starting work. Addresses issues in no discernible order, or jumps back and forth. Does not manage time well, or spends too much time on a small subset of issues, neglecting others. Forgets or ignores requirements. | May jump into work before clarifying all the requirements. Has some intentional process, but may need to go back and revisit work after gaining more context. Does demonstrate a willingness to learn via Googling, reading documentation, asking questions, etc.  May not allocate time for certain bugs/features they wanted to address, or does not prioritize effectively. | Clarifies most of the requirements before starting work. Is intentional about approach, but may need to modify it. Mostly manages time effectively, but may run out of time or be unable to get to all the work they identified as priorities. | Clarifies and restates requirements before jumping into the code. Lays out and executes a logical approach. Manages time effectively. Demonstrates ability to prioritize. |
| High-level critique | Fails to address any opportunities for high-level improvements, such as testing, security, reliability, accessibility, performance, team processes, inter-team communication, etc. | Acknowledges at least one high-level improvement (e.g. testing, security, reliability, performance, team processes, inter-team communication, etc.), but does not elaborate on any. Considers how high-level changes may improve their own work, but not how they may affect the larger team or system. |Acknowledges at least one high-level improvement (e.g. testing, security, reliability, performance, team processes, inter-team communication, etc.), and elaborates on one of these areas. | Acknowledges a number of opportunities for high-level improvements (e.g. accessibility, testing, security, reliability, performance, team processes, inter-team communication, etc.), and elaborates on more than one of these areas. Demonstrates ability to investigate how a piece of code fits into other related systems. |
| Detailed critique/code fluency | Identifies almost none of the bugs or code quality issues present. Shows lack of familiarity with Javascript and/or React. Unable to reason about what is happening in the code. | Identifies some of the bugs and code quality issues. Familiar with Javascript syntax and concepts. More-junior candidates may struggle with explaining advanced concepts like closures, but all candidates in this range should be able to speak to fundamental web ecosystem concepts and browser APIs, frequently encountered when building web applications. | Identifies some of the bugs – including issues that rely on a solid grasp of the JS runtime – and correctly reasons about an approach toward resolution. Correct justification for proposed changes is provided along with the original review feedback or by request if not initially volunteered. Demonstrates strong understanding of core concepts. | Is able to identify many of the existing bugs and code quality issues, and is able to communicate how to fix them. Demonstrates strong understanding of Javascript/React concepts. Can clearly articulate what is happening in the code – has a natural intuition for how syntax maps to actual behavior.|
|Collaboration |Never or rarely communicates thought process aloud, or communication is incoherent.  Unable to tell what the candidate is thinking. Relies almost entirely on the interviewer for guidance, or is entirely independent. Provides vague feedback. |Communicates with the interviewer and looks to them for guidance and answers. Possibly relies on help for tougher questions but explains what they’ve figured out. Responds to differing opinions without condescension or blame. Is able to provide constructive, actionable feedback, though it may not be as thorough as more senior levels.|Asks effective, easy-to-understand clarifying questions. Balances their working style and process with  confirming understanding from both sides, but has a few moments where they need a push. Responds to differing opinions without condescension or blame. Provides clear, constructive, actionable feedback. |Engages in clear, coherent conversation with interviewer, thinking of the greater team/system context. Balances their working style and process with  confirming understanding from both sides. Demonstrates listening and absorbing what the interviewer says. Responds to differing opinions without condescension or blame. Provides clear, constructive, actionable feedback.|