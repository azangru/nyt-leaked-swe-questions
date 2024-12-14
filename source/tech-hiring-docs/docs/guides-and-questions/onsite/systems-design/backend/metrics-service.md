## System Description and Requirements

(given to candidate during the interview)

Design a metrics system that can be used for collecting response times for a
hypothetical app. The metrics system has two components -- a collection service
and a query service. The collection service receives messages from the app. The
messages contain a value that represents the response time for each request the
app receives. The query service can return aggregate values of metrics sent to
the collection service.

### Collection​ ​Service

-   The collection service should accept messages in the format: (key,value)
-   If an instance of the collection service is not available:

    -   It should not affect the client
    -   It should not affect the collection service's ability to respond to
        requests
    -   It should not affect the query service's ability to respond to requests

### Query​ ​Service

-   The query service should expose a JSON endpoint that returns aggregates of
    metrics by hour for a particular instance of an app. Hours are
    non-overlapping. (i.e. tumbling windows, not sliding windows)
-   The forrmat of the JSON endpoint URI should be:
    `http://hostname/<key>/<stat_type>/<date>/<hour>`
-   `stat_type` is one of the following aggregate functions: average, min, max,
    median
-   Users should be able to interact with the endpoint using curl
