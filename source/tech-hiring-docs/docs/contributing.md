You can suggest changes to the docs by making a PR to the Tech Hiring Docs [GitHub repository](https://github.com/nytimes/tech-hiring-docs). Like other tech.nyt.net sites at the New York Times, The Tech Hiring Docs website is built using [mkdoks](https://www.mkdocs.org/), so familiarizing yourself with that framework is useful for extensive changes.

If you want to raise an issue with the docs, feel free to make a github issue on the [GitHub repository](https://github.com/nytimes/tech-hiring-docs).

All changes and raised issues should take into consideration our [hiring principles](principles.md).

## Adding New Questions

All new question PRs should include:

-   A one-sentence problem description
-   A link to any necessary code scaffolding (e.g. jsfiddle, glitch, or gist)
-   Any requirements that should be shared with the candidate (these can also be
    in docstrings in the code scaffolding)
-   If relevant, an example test case for the candidate

Additionally, all questions must have at least one complete example solution,
along with leveling notes. Leveling notes should include expectations for
answers from Associate, Mid, and Senior level candidates. These expectations
should be tied back to the career ladder expectations for each position:
[Software Engineering Career Ladder](https://docs.google.com/document/d/1l4DPQr5RmuzxS_sAYOKCHx0IyOXXJ5iQSY_6dx8Mlao/edit#heading=h.5iul97h3nji).
See the frontend
[byline formatting question](/guides-and-questions/onsite/algo-and-data-structures/bylines/)
as an example.

Approval for questions will be based on the following guidelines:

-   Difficulty: A question should be able to scale in difficulty. The goal is to
    have different expectations for varied experience levels, outlined in the
    leveling notes.
-   Clarity: Any interviewee with a technical background should be able to
    clearly understand the question. More written clarifications and examples
    are better so interviewers don't have to come up with them on the spot.
    There should also be instructions for the interviewer especially for what
    may be good follow up questions.
-   Relevance: The question should examine knowledge/skills required in the
    day-to-day performance of one's job duties. It should not depend on knowing
    any special tricks or having obscure knowledge not required to do the job.
-   Not findable online: We should aim for questions that are not a 'typical' 
    interview question found in books or online. We should also aim to have 
    enough variety that questions won't end up on Glassdoor.

## Modifying questions

Question Modification and removal will go through the same process as above,
with the PR justifying _why_ the question should be changed/removed. Some
possible reasons:

-   The question demonstrably doesn’t meet the above criteria under “Adding
    Questions”.
-   The question has been publicly listed on an interviewing review site.
-   The question needs changes due to observed limitations when implemented in
    practice.

## Process Modification

Change proposals to this process are also welcome via pull request, but efforts
will be made to make sure most of the question reviewers, hiring process leads,
and recruiters agree with the process changes. This will be done asynchronously
via Github conversations and the tech-hiring channel.

## Reviewing PRs

Contributions made via pull request must be reviewed per the specifications
above within a week of the pull request’s creation. Each pull request should be
labeled with its related process name in the title so that it is clear at a
glance which requests are open for each process’ set of code owners. (For
example: [Backend Process] New Question with Data Structures)
