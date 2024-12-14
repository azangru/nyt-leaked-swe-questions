## Overview
This document is a set of common metrics for how to evaluate candidates submitting code samples for the Martian New Reader iOS challenge. These do not represent a holistic sense of evaluating a candidate in all areas, but are focused specifically on the challenge’s requirements and the team’s expectations for what represents a quality solution to it.
This is a living document that should grow with our conversations about our interview process.

## Competencies
There are five categories of evaluation through which we seek to evaluate a candidate’s competency, as outlined below.

#### Functionality
This category represents how well the candidate answered the given specifications and generally empathized with the end user experience.

1.	Does the submission answer the requirements? (see the Readme)
2.	Does the translator work correctly? Is the solution scalable (i.e. expandable to additional languages)? Is the translation global, and not only at the article level? Is it applied to all elements containing text, not just the article body?
3.	Do images look correct? Are they sized dynamically to show their whole content and are not distorted or cropped?
4.	Do their constraints break at runtime? Safe areas insets? After screen rotation?
5.	Is there scroll stuttering? Is cell reuse handled with async images?
6.	Are networking errors handled or discarded? Is the completion handler called?
7.	Are images being cached? Are the networking and image cache operations efficient?
8.	What kind of noise is there in the debugger output?
9.	Is the network request done on a background thread?
10.	What approach is used for decoding?
11.	Is the choice of UI appropriate in particular for the language switching (i.e. switch, modal, button)?

#### Composition
This category represents how the candidate engineered their application on a broad level.

1.	What view controller architecture did they choose? MVC? MVVM? Coordinators?
    -	Did they write with dependency injection in mind?
    - How are the VCs related to each other?
2.	Did the candidate use Autolayout?
    - Did they use Interface Builder or write constraints programmatically?
    - Do their view hierarchies make sense?
3.	Did they create a services layer, or are view controllers doing most of the work?
    - Which classes handle networking? Translation? Image caching?
4.	Did they use third-party frameworks? If so, for what? Is the use of third-party code at the detriment of demonstrating core competency in the iOS stack?

#### Code Style
This category represents how well the candidate expressed their solution in its details.

1.	Does the candidate write code that is legible and easy to follow?
2.	Is the author’s "voice" & syntax consistent?
    - If it isn’t, this could be a sign that they didn’t engineer their solution based upon their own understanding. Referencing internet sources is acceptable, of course, but the submission should be more than a patchwork of elements.
3.	Xcode organization - are groups utilized in a sensible way?
4.	Are their class, property, and variable names descriptive?
5.	Did they leave any meaningful comments? Doc comments? Did they leave too many comments?
6.	Are there unused methods or types? (e.g. If their model implements Codable, is it deserialized using a Decoder)

#### Testing
This category represents how well the candidate proved that their solution works and will continue to work.

1.	Did they write additional tests? Unit Tests? UI Tests?
2.	Did they write any classes with Dependency Injection in mind?
3.	Are their test setups isolated from each other, or is there an implicit reliance upon order?
4.	Are networking tests stubbed or do they hit the network?

#### Balance
This category represents the candidate’s sense of judgment when approaching the problem.

1.	What did they choose to solve first?
2.	How did they budget their effort? Is it well-tested? What kind of trade-offs did they make when budgeting the effort they could afford to put in?
3.	What did they optimize for? Performance? Memory? Cleanliness? Simplicity?


## Expectations
Since we are submitting all candidates of all skill levels to the same evaluation, we will have a different sense of what candidates should demonstrate based upon their skill and time in the industry.

#### Common
All candidates must answer the Functionality category to a reasonable degree. The challenge’s specifications are relatively clear, and we expect everyone to be able to deliver a working application which satisfies these requirements.
The sense of authorship should be cohesive, lending a sense that the candidate engineered and understands their own solution.

#### Associate Engineer
Candidates for Associate Engineer should be able to deliver a solution to the problem that works mostly as required. They should demonstrate good awareness in two categories out of Composition, Code Style, and Testing, but are expected to have significant shortcomings in Balance. Several serious issues should be tolerated and are opportunities to practice mentorship in discussion.

#### Software Engineer
Candidates for the Software Engineer skill level should submit a solution that demonstrates high competency in 3-4 of these categories and moderate competency in the rest. Only a few significant issues with their solution should be tolerated.

#### Senior Software Engineer
We expect candidates at the Senior Software Engineer skill level to demonstrate a high level of skill in all five categories. Senior Engineers should deliver a well-balanced, expertly engineered solution that reads well for maintainability. It should handle most known edge cases already and be written clearly enough that modifying it would be straightforward. There should be very little to criticize on matters that are not opinion-based.
    
