!!! danger
    As of 4/15/2022, this question is still a work in progress. We've made some
    modifications to make the question more completable within the time limit but
    we've yet to test this latest version on external candidates.

## The Question

Use the National Weather Service API to fetch recent temperature data from 
weather stations around NYC.

Acknowledgements and thanks to the excellent [Octopus Getting Started Guide](https://de.tech.nyt.net/de-octopus/docs/tutorial/)
for inspiration!

### Interactive Coding Environment Setup

Coderpad.io links:

- <a href="https://app.coderpad.io/sandbox?question_id=182839" target="_blank">Python</a>

Click the `Create Live Pad` link to create a unique CoderPad for your
interview, and share it with your co-interviewer and interviewee. Name the pad
after the candidate.

Since this question involves reading API documentation, it may be helpful to ask
the candidate to share their entire screen, so you can see their actions and
thought process beyond just the code they write in the pad.

### Requirements

The National Weather Service has a public API for weather station data.

https://www.weather.gov/documentation/services-web-api > Specification tab

Your task is to write a script that fetches the latest observation from all
New York State weather stations that fall within the following lat/long 
coordinates:

- Mininum: 40.5, -74.25
- Maximum: 41, -73.7

which is (roughly) the bounding box of the five boroughs of New York City.

Your script should output comma separated values (printing each line to STDOUT
is fine) representing the following data for each recent observation:

- Station coordinates
- Temperature (unit is a nice to have, but not required!)
- Human-readable name

You may notice that you've been given a helper function to start. This function
will help you determine whether a given latitude and longitude falls
within New York City. Feel free to use it however you'd like.

### Sample output

```
station name,latitude,longitude,temperature
"New York, Kennedy International Airport",-73.76393,40.63915,12.2 degC
"New York City, Central Park",-73.9666699,40.78333,15.6 degC
"New York, La Guardia Airport",-73.88,40.77917,16.1 degC
"Kings Point",-73.765,40.8103,13.89 degC
"The Battery",-74.0142,40.7006,14.44 degC
"DW5729 Sheepshead Bay",-73.94883,40.60028,14.44 degC
"DW8569 Eltingville",-74.16139,40.55383,No temp recorded
```

### Follow-ups

If candidates finish this question early, possible follow up questions include:

- Writing thorough unit tests that mock the API's responses
- Expanding the solution to include more station and weather attributes, such as
    - Elevation
    - Wind speed
    - Barometric pressure
- Sanity checking the outputs -- what range of values makes sense for a
temperature in Celsius? etc.
- Describing how the code would change if it were part of a larger system instead
a quick script -- how would we represent this data if it we were persisting it
somewhere? etc.

## Possible Solutions

??? example "Python"
    ```python
    import requests
    import logging
    from typing import List, Dict

    CSV_HEADERS="station name,latitude,longitude,temperature"
    
    # hard-coded range to represent the bounds of NYC
    MIN_LAT = 40.5
    MIN_LON = -74.25
    MAX_LAT = 41
    MAX_LON = -73.7
    
    def is_in_bounding_box(latitude: float, longitude: float) -> bool:
        """
        Helper function to determine whether or not a station's coordinates
        fall within the hardcoded bounds we've set for this problem.
    
            Args:
                latitude: The latitude of the station
                longitude: The longitude of the station
            Returns:
                True if coordinates are within bounds, else False.
        """
        return MIN_LON <= latitude <= MAX_LON and MIN_LAT <= longitude <= MAX_LAT
    
    def get_stations_by_state(state: str) -> List[Dict]:
        response = requests.get(f"https://api.weather.gov/stations?state={state}")
        return response.json()['features']
    
    def format_csv_row(coordinates: List, name: str, temperature: str) -> str:
        return f'"{name}",{coordinates[0]},{coordinates[1]},{temperature}'
    
    def get_latest_observation(station_id: str) -> Dict:
        response = requests.get(f"{station_id}/observations/latest")
        return response.json()
    
    def get_last_recorded_temp(station_id: str) -> str:
        try:
            observation = get_latest_observation(station_id)['properties']
            temperature = observation['temperature']['value']
            unit = observation['temperature']['unitCode'].split(':')[-1]
            return f"{temperature} {unit}"
        except KeyError:
            logging.warning(f"No latest temperature for {station_id}/observations/latest")
            pass
        return "No temp recorded"
    
    def get_csv_as_list(stations: List) -> List:
        csv_rows = [CSV_HEADERS]
        for station in stations:
            station_id = station['id']
            coords = station['geometry']['coordinates']
            name = station['properties']['name']
            if is_in_bounding_box(coords[0], coords[1]):
                temp = get_last_recorded_temp(station_id)
                csv_rows.append(format_csv_row(coords, name, temp))
        return csv_rows
    
    stations = get_stations_by_state(state='NY')
    for row in get_csv_as_list(stations):
        print(row)
    ```

### Solution Notes

This is a straightforward question that isn't about finding an algorithm, but
rather is designed to help us observe the candidate's real skills they may use
on the job, such as reading documentation, interacting with a new API,
processing data, and testing their work.

The basic structure of any solution, in any language, would be:

- Fetch all weather stations in New York State using the `/stations` endpoint
and `state` query parameter.
- Filter the list of stations by the bounding box coordinates given. We added
this step because fetching the latest observation from *all* weather stations in
NY state puts us over CoderPad's network limit :(. However, we noticed that this
extra step makes the problem harder to complete within the time limit, so we've
provided a helper function to guide the candidate through the bounding box logic.
- For each station, request the latest observation using the
`/{station}/observations/latest` endpoint.
- Get the temperature from the latest observation.
- Finally, format and print the output.

### Leveling notes

#### Associate

An associate engineer is expected to have a basic grasp of core programming
concepts (data structures, control flows), but they are not expected to be
deeply familiar with language-specific paradigms or APIs. An associate candidate
might use simpler control flows and avoid splitting code into helper methods.
A candidate at this level may not always take the most direct or efficient route
to the expected output.

Associate candidates might not finish this question in the time limit, or might
need significant hinting about how to navigate the API docs if that is a new
skill for them. For example, you might point out how the candidate can use the
"Try it out" button to help them understand API usage. An associate engineer
may also require more guidance when encountering unexpected circumstances. For
example, you might suggest adding some error handling if the candidate faces an
error due to an API response that lacks an expected property.

#### Mid-Level

A mid-level engineer is expected to be able to write clean and reusable code,
following best practices. Mid-level candidates should be able to recognize when
to split out code into separate functions, and more consistently use common
language paradigms. It's acceptable for any candidate to have to check
documentation for exact APIs, such as the `requests` library, but it's important
that candidates have a sense of what can be done in the language they're working
in and what best practices are. An engineer at this level should recognize the
need to sanitize and handle errant data, even if the method for achieving this
looks different between candidates.

Mid-level candidates should finish the listed requirements. They should 
independently make suggestions about how they would improve or test their 
code if they had more time outside of the interview.

#### Senior

A senior engineer should quickly break up their solution into steps (preferably
before starting to code). They should be able to extract what they need from the
API documentation without getting overwhelmed or daunted. They should display
expertise and fluency in translating thought to code, write modularly, and
anticipate what their code will do before it runs. A senior candidate should be 
able to comfortably sanitize data and anticipate any error-handling needed.

Senior candidates will likely also have time to speak to follow-up questions,
come up with useful tests, and/or expand the output data to include
more weather attributes, as described above.
