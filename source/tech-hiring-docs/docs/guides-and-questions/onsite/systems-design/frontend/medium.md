# Design medium.com

## The Question

Talk through how you would design a hosted blogging website, such as medium.com.

??? question "What if my candidate currently works at Medium or somewhere really similar?"
    For such candidates, you can ask them to design one of these backup services:

    1. Twitter, a microblogging site with support for real-time updates
    1. Reddit, a social news aggregation site and discussion forum

### Requirements

The requirements here are loose and flexible. Make sure to talk about the pros
and cons of the assumptions and decisions that are made.

We can assume that users should be able to have accounts, and that users with
accounts will be able to create publicly visible blog posts, with some amount of
rich text and media (like embedded photos and videos).

## Guiding the conversation

This is less like an interview and more like a conversation. The goal is not to
ask each of these questions specifically, but to use them when appropriate to
move the conversation forward. Try to touch on various parts of the stack, and
feel free to ask the candidate about parts of the stack that they haven't
touched on yet. Some things to look for:

-   Databases. SQL vs NoSQL, managed vs non-managed, schema, etc. For frontend
    engineers, this does not have to go into too much depth, but try to figure
    out how comfortable they are discussing databases.
-   Backend technology. For frontend engineers, this does not have to go into
    too much depth, but try to figure out how comfortable they are discussing
    backend technology.
-   API decisions. Does the candidate understand RESTful API design, are they
    aware of GraphQL or gRPC? What are the endpoints for this API, and what
    parameters/data do we need to send them?
-   Frontend technology and design. What frontend technology would we use here?
    Should we use a dynamic rendering library like React or Vue? Does
    server-side rendering make sense? Are there different parts of the interface
    that might have different requirements? Try to understand why the candidate
    has chosen the libraries and design patterns that they have, and what would
    change those initial decisions.

??? warning "Caveat if you're using one of the backup services"
    Twitter and Reddit support real-time updates; for example, you will see 
    a new post in your feed as soon as it's been posted. The candidate should
    also talk about how they would design for this.

    We also recognize that Twitter does not have rich text support as of this writing.
    However, since here at NYT rich text is a significant feature of our website, 
    the candidate should go about their design as if Twitter does support it.

## The Solution

There's no single correct answer to this question. The goal is to learn about
the candidates' familiarity with each part of the tech stack, and about how they
make decisions.

### Leveling notes

#### Associate

An associate engineer is expected to have a basic grasp of core programming
concepts (data structures, control flows), but not necessarily have a "big
picture" understanding of large, complex systems. Associates should be familiar
with the concepts of databases and backend technology and APIs, but will likely
not be able to explain why one might choose one solution over another. When
given harder requirements and a more defined scope (e.g. how would you implement
the save button for the blog post editor), associates should be able to talk
about completing a task in concrete terms.

Associate engineers should be able to communicate their thought process
effectively, even if they don't fully understand a part of the question or
system, and ask questions that help clarify requirements and scope. They should
be able to take and incorporate feedback about their decisions.

#### Mid-level

A mid-level engineer is expected to be able to think about design at a feature
level. They might be able to easily talk through features (e.g. discussing the
publishing or saving flow through the system), but have trouble analyzing the
pros and cons of large-scale decisions, like what type of database or deployment
strategy to use.

Mid-level engineers should be able to discuss at least the frontend technology
stack, design, and patterns in depth. They should display a solid understanding
of javascript, and of any libraries or frameworks that they suggest using to
build the frontend. It's expected that mid-level frontend engineers have less
familiarity with database and backend design than the frontend, but they should
have a basic working knowledge of database schema and API design.

#### Senior

A senior engineer is expected to be comfortable making design decisions at every
level of the stack. They should be able to talk about deployment and testing
strategies, and talk through tradeoffs in all frontend design decisions. Senior
frontend engineers might not have in-depth practical knowledge of database
operations, but should be able to weight the pros and cons of SQL vs NoSQL and
managed vs un-managed databases, and make appropriate decisions based on
requirements.

Overall, a senior candidate should be able to converse fluently about every
level of the stack, and display an in-depth knowledge of browser APIs, RESTful
API design, frontend libraries and frameworks, and HTTP.
