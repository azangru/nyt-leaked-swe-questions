# NYT Data Engineering Homework

Thank you for your interest in the New York Times Data Engineering group! This exercise will help us get to know you a bit as an engineer.

The purpose of this set of questions is in part to evaluate your data engineering skills, but also to have a more productive and interesting conversation during our interviews. We don’t mind if you search the web for help, but we expect that you understand the principle of the solution--we may ask follow-up questions! Please include URLs for any resources you use in your answers to credit appropriately.

Depending on your experience, we expect this exercise to take between 1-6 hours. We realize this exercise is a commitment of your time and energy. We will commit to providing detailed feedback to you on your answers, regardless if you continue on to the next steps in the interview process.

To provide your answers, create a git repo, add your solutions to it, and email an archive of the repo with git history back to us within 5 days of receiving this assignment.

## SQL

Using the following tables:

**customers (customer_id INT, name VARCHAR)**

    1	COMPANY_A

    2	COMPANY_B

    ...

**orders (order_id INT, quantity INT, order_date DATETIME[YYYY-MM-DD], customer_id INT)**

    1002  12  2015-01-01	2

    1003   8  2015-01-01	1

    1003   9  2015-01-02	1

    1003  62  2015-01-02	3

    ...

1. Write a query to select the name of each customer and his or her latest order date. E.g.:

        COMPANY_A	 	2016-01-02

        COMPANY_B	 	2016-01-06

1. We want to find out which customers have changed their behavior the most from one order to the next. Write a query using a window function that shows, for each customer, the largest absolute change in quantity (positive or negative) between orders. E.g.:

          COMPANY_A	 	2016-01-03		-23

          COMPANY_B	 	2016-01-02		 15

  Caveats:

  * If two orders for a customer occur on the same day, consider them one order with the sum as the quantity.

  * Days when a customer has not ordered anything should not be considered at all, as opposed to considering them 0 quantity.

  * Ignore the theoretical increase between the time they were not a customer and their first order, as well as customers that may only have one order.


## Nearest Stars

Version 3 of the HYG star database contains almost 120,000 stars. You can download it and find field descriptions at [https://github.com/astronexus/HYG-Database](https://github.com/astronexus/HYG-Database)

1. Write a program called `findstars` to find the set of nearest K stars from the Sun without loading the entire dataset into memory. The coordinates in the database above have an origin (0,0,0) at the Earth. Please ignore the *distance* field in the original database and calculate what you need from the coordinates.

    * Provide the source code of your program. It can be in any language you want. It should be runnable from the command line as: `gunzip -c hygdata_v3.csv.gz | <launch your code> k`

    * The program should output the Cartesian coordinates of the K nearest stars.  You do not need to output the distance. You also do not need to implement this with full production level error checking on filesystem, program arguments etc. This is just an exercise, so assume a non-adversarial user.

1. How might your solution change if we wanted to create a findstars service that can respond quickly to requests for distance from an arbitrary point with no memory restrictions, and we want to query it to return the nearest K stars from arbitrary point X=(x,y,z) ?

    * Describe how you would design your solution. You don’t need implement it.

## Systems

1. Please rank the following in terms of latency to first byte arriving into a CPU register. Assume no cache effects between the target and the CPU

    * Read from L2 processor cache

    * Read cloud based Storage (S3, GCS)

    * USB flash storage

    * Read from local spinning RAID disk (7200 RPM)

    * Read from RAM on neighbor computer in same data center, one hop away

    * http API (first hit)

    * https API (first hit)

1. You are given a list of 1000 local files, each one of which needs to be put through a command line utility to do some error correction, and then uploaded to an S3 bucket. What tools would you use to parallelize? How would you estimate ideal concurrency?

1. Same 1000 files, but they are currently on S3 buckets. How might your solution change? What factors into it?

## Systems Design

Design a metrics system that can be used for collecting response times for a hypothetical app. Each instance of the app would send messages to a collection service. Each message would contain a value that represents the response time for each request the app receives. Another part of this system is a query service that can return aggregate values of metrics sent to the collection service.

As a starting point, imagine a scenario in which messages would be sent from 10 different apps at the rate of 10,000 messages per second.

You can choose off-the-shelf software or decide to build the components you would need. In either case, highlight the main characteristics of each component that satisfy the system requirements.

Express your design visually or in pseudo-code. If you create a sketch, it doesn’t have to be neat, just legible. Include justifications for your design decisions and trade-offs you may have made.

*You don’t need to actually implement this service!*

After you present the design, comment on where you think it would break as we increase utilization of the system by 10x, 100x, 1000x. How would you need to change it to adapt to that failure mode ?

## System Requirements

### Collection Service

* The collection service should accept messages in the format: (key, value)

* If an instance of the  collection service is not available:

    * It should not affect the client

    * It should not affect the collection service’s ability to respond to requests

    * It should not affect the query service’s ability to respond to requests

### Query Service

* The query service should expose a JSON endpoint that returns aggregates of metrics by hour for a particular instance of an app. Hours are non-overlapping. (i.e., tumbling windows, not sliding windows)

* The format of the JSON endpoint URI should be:

      http://hostname/<key>/<stat_type>/<date>/<hour>

* stat_type is one of the following aggregate functions: average, min, max, median

* Users should be able to interact with the endpoint using `curl`
