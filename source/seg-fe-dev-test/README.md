SEG-FE In-Person Developer Test
==============================

## Getting started

1. Make sure you are running Node >= 6. Use `nvm` if necessary.
1. Install dependencies: `npm install`
1. Build and start dev server: `npm start` / `yarn start`
1. Verify app runs at [http://localhost:3000](http://localhost:3000).


## Objective

You will be building a stopwatch.

The existing code contains a partially working stopwatch. Your task is to flesh out the code until it matches the functionality of [this stopwatch](https://www.google.com/search?q=google+stopwatch&oq=google+stopwatch&aqs=chrome..69i57j69i64.1788j0j1&sourceid=chrome&ie=UTF-8).

### Tasks

1. Add a start/pause button
1. Adjust the number format to render as: `0h 0m 0s 00`
    - 3s 00
    - 11s 00
    - 1m 22s 00
    - 1h 22m 13s 00
    - etc...
1. Add a reset button
1. *Bonus*: Add the ability to save/record specific time intervals (clicking on the snapshot button saves the stopwatch time at that moment)
1. *Bonus*: Create a timer in addition to the stopwatch (counts down instead of up)
