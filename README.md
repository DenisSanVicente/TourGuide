# TourGuide

TourGuide is a Spring Boot application that provides users with information about nearby tourist attractions and calculates reward points based on their visits.

This project was developed as part of the **OpenClassrooms Java Application Developer training program**, with a particular focus on application performance, concurrent programming, and asynchronous processing.

## Project objectives

The main objectives of the project were to improve the existing TourGuide application by:

* optimizing user location processing;
* improving reward calculation performance;
* handling a large number of users efficiently;
* providing information about the five tourist attractions closest to a user;
* validating the application's behavior and performance through automated tests.

## Features

### User location

TourGuide tracks users and retrieves their current location through the GPS utility service.

Location processing was optimized to support multiple users while maintaining acceptable execution times.

### Nearby attractions

The application provides the five attractions closest to the user's current location.

For each attraction, the API provides:

* attraction name;
* attraction latitude and longitude;
* user latitude and longitude;
* distance between the user and the attraction;
* reward points available for visiting the attraction.

### Reward system

Users can earn reward points when visiting tourist attractions.

Reward calculations are processed asynchronously in order to improve performance when handling multiple users.

### Concurrent and asynchronous processing

The application uses Java concurrency mechanisms to improve the execution of operations involving multiple users.

`ExecutorService` is used to manage thread pools, while `CompletableFuture` is used to coordinate asynchronous tasks and their results.

This approach reduces sequential processing and improves the application's ability to handle a larger number of users.

## Technologies

* Java 17
* Spring Boot
* REST API
* Maven
* JUnit
* CompletableFuture
* ExecutorService
* Git / GitHub

## Architecture

The application follows a layered architecture separating the main responsibilities of the application.

The project includes:

* REST controllers for exposing application endpoints;
* services containing the business logic;
* user-related domain objects;
* tracking components responsible for periodically updating user locations;
* external utility libraries used for geolocation, attraction data, pricing and reward calculations.

## External libraries

TourGuide relies on several external libraries provided for the project:

* **gpsUtil** — provides user locations and tourist attraction data;
* **RewardCentral** — provides reward point calculations;
* **TripPricer** — provides trip pricing information.

These libraries must be available locally for the application to build correctly.

## Testing

The project includes automated tests covering both application behavior and performance.

Tests were used to validate:

* user location tracking;
* reward calculation;
* nearby attraction retrieval;
* application performance when processing multiple users.

The performance tests were particularly important for validating the concurrency and asynchronous processing improvements introduced during the project.

## Running the application

### Prerequisites

Make sure the following tools are installed:

* Java 17
* Maven

The required external libraries (`gpsUtil`, `RewardCentral` and `TripPricer`) must also be installed in the local Maven repository.

### Build

```bash
mvn clean install
```

### Run

```bash
mvn spring-boot:run
```

### Run the tests

```bash
mvn test
```

## What I learned

This project allowed me to deepen my understanding of:

* concurrent programming in Java;
* asynchronous processing with `CompletableFuture`;
* thread pool management with `ExecutorService`;
* REST API development with Spring Boot;
* performance optimization;
* automated and performance testing;
* integration of external Java libraries.

## Context

This project was completed as part of the **OpenClassrooms Java Application Developer training program**.

The initial application and external libraries were provided as part of the project. My work focused primarily on implementing the required features, improving application performance, introducing concurrent and asynchronous processing, and validating the resulting behavior through automated tests.
