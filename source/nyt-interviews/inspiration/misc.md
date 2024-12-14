* The problem was to provide a solution to an n by n Sudoku
  board. These are typically 9x9, but it was interesting to extrapolate the algorithm to a more
  general context. I spent a few hours researching different algorithms, choosing the most efficient
  one, and then creating a REST server that could solve the problem on the backend. Then I built a
  client-side interface to allow the user to input a sudoku puzzle in the browser and submit it. It
  looked like a very rudimentary version of the Times' browser crossword app (single character input
  in a grid, tabbing between squares, etc).
* Design and build a system for managing and adding financial leads using Angular. This was a lot of
  fun for me--firstly because there was an open-ended interface problem I had to solve without much
  guidance, so I had a chance to display my natural acumen for those types of situations. Secondly,
  it allowed me to demonstrate the breadth of understanding I have for developing software
  solutions--I had a full README with instructions for both development and production deployment, I
  could demonstrate that I knew that including licensing was important, that I could provide unit
  testing, end to end testing solutions, well-documented code, and that I was familiar with how to
  set up npm tooling.
* Develop an ETL that would pull in a non-trivially sized government dataset, push it into a
  database, and create a webapp to display a top 10 query of the results based on certain
  criteria. I was instructed to deploy the solution to Heroku, GCP, or AWS to demonstrate that I was
  capable with working with at least one cloud deployment service. The government dataset they
  provided was 150mb, so it's not something you should reasonably try to fit into a dataset
  in-memory or onto disk with a limited free-tier cloud machine. In fact, my solution involved
  pulling chunks of the CVS into memory and then streaming them into the database as part of an Akka
  stream. I found that I had a lot of fun working on it.
