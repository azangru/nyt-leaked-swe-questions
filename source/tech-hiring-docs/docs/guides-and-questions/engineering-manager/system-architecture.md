# System Architecture

## Competencies to Vet For:
* Diversity, Inclusion and Team Health
* IC Management
* Delivery
* Team Leadership
* Empathy and Communication Skills
* Technical Fluency

## THIS INTERVIEW IS NOT ASSESSING FOR (assessed elsewhere):
* Cross-Organizational and External Leadership
* Hiring experience and philosophy

## Sample Format (30-45 minutes): 
* Intro: interviewers introduce themselves and explain interview purpose & format (30 sec)
* Overview of team (5 min)
* Your questions (20-35 min) 
* Their questions (5-10 min)

## Questions:
* Tell us about your current team and what they work on 
    * depending on how they answer, you can follow up with any details you might want to know about: how many reports the candidate has, whether there are cross-functional product/project/design partners, who are their peer teams, what their management style is, the seniority of the team etc.
* Tell me about a system you have architected in the past. Expect the candidate to lead.
    * Expect the candidate to share, or ask if they don’t ask:
        * What is the business case
        * Who are the users (audience size, location)
        * Native/web solution? (ask them to describe trade-offs, if they don’t bring this up on their own)
        * API layer (GraphQL, REST)
        * Authentication layer
        * Third party APIs (Facebook, AppleSSO, Google Login, Analytics (GTM, etc), A/B testing, ChartBeat etc.) -- integration, testing, performance concerns
        * MVP -> Production level product, user testing with an MVP, tradeoffs to get to market quickly
        * Client technology (Swift, Kotlin, Flutter, React Native, React for mobile web, Vue, etc.) which one and why?
        * State maintenance
        * Large file management (images, video)
        * Metadata (article/video/image tagging, etc.)
        * Database layer (which one and why)
        * Production support, possibly -- monitoring, alerting, observability, on-call
        * Testing strategy
        * Code quality
        * Performance of the system
        * If there’s time, can get into CMS development (this is probably a whole different conversation, but can go there if there’s lots of time left)
        * What if we wanted to scale to 2-3x the user traffic, or if there were usage spikes? (looking for a somewhat nuanced view of CDNs, caching, distributed databases)
        * What if we wanted to internationalize?

## Interviewer is looking for:
* Technical fluency
* Clarifying questions
* Understanding trade-offs
* When the candidate might bring in a tech lead, architect or product lead to answer a question instead of answering it themselves
* How they might socialize this solution (RFCs, etc)

