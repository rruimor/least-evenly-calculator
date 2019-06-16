# Least Evenly Divisible App

This is an API for calculating the smallest positive integer that can be evenly divided (without remainder) by
a sequential range of positive integers (from 1 to 25).

# Installation

## Requirements

* [Maven](https://maven.apache.org/download.cgi)
* [Java JDK 1.8 x64](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

## Steps

* To start the web application (by default on port 8080)

```bash
$ mvn spring-boot:run 
```


* To run the tests

```bash
$ mvn test
```

# Usage


### Set upper range number

To set the upper range number to be checked, send a **POST** request to `/least-evenly-divisor/upper-range` with the following JSON payload:

```json
{
  "value": 10
}
```

* Curl example request for setting the upper range number:
```bash
$ curl -d '{"value":10}' -H "Content-Type: application/json" --cookie-jar - http://localhost:8080/least-evenly-divisor/upper-range
```
will output
```sh
# Netscape HTTP Cookie File
# https://curl.haxx.se/docs/http-cookies.html
# This file was generated by libcurl! Edit at your own risk.

#HttpOnly_localhost	FALSE	/	FALSE	0	JSESSIONID	3DC0953D380710E33EB462DA67B38C44
```

### Find the smallest dividable number 

To get the calculation result and the time elapsed, send a **GET** request to `/least-evenly-divisor`.

As the upper range number is stored in the session, you would need to pass the **JSESSIONID** cookie for getting the calculation.

* Curl example request for finding the number:
```bash
$ curl --cookie JSESSIONID=<YOUR_JSESSION_ID> -H "Accept: application/json" -X GET http://localhost:8080/least-evenly-divisor
```

```json
{
  "result": 2520,
  "timeElapsedInSeconds": 0.000158389,
}
```

* Or in XML:
```bash
$ curl --cookie JSESSIONID=<YOUR_JSESSION_ID> -H "Accept: application/xml" -X GET http://localhost:8080/least-evenly-divisor
```

```xml
<CalculationResult>
    <result>2520</result>
    <timeElapsedInSeconds>0.000195897</timeElapsedInSeconds>
</CalculationResult>
```