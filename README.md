# Congestion Tax Calculator

Welcome the Volvo Cars Congestion Tax Calculator assignment.

This repository contains a developer [assignment](ASSIGNMENT.md) used as a basis for candidate intervew and evaluation.

Clone this repository to get started. Due to a number of reasons, not least privacy, you will be asked to zip your solution and mail it in, instead of submitting a pull-request. In order to maintain an unbiased reviewing process, please ensure to **keep your name or other Personal Identifiable Information (PII) from the code**.

# How to run application:
You can run the application, but it's not going to show anything yet. However, you can examine the functionality through running the tests.

Ensure maven is installed on your machine and run `mvn clean install`
Entry point to application is through the MySpringBootAppApplication class (for lack of better name). 
Start the application and visit http://localhost:8080/calculation
You should get a String response "GET request successful".

# How to run tests:
There are unit tests for different layers of the application (Application, Controller, Service, HttpRequest). 
In order to test the logic you should run CalculationServiceTest. You can run it directly from within the class.
You can also run through all the tests with `mvn test`

# Notes
Spent time: ~6 hours
Spring boot project with maven:
Spring boot comes with a lot of pre-configured tools for web applications and is a common framework.
It's quick to set up and get things to work in a short time.

I set some configuration to the SecurityFilterChain as it is preconfigured to block any incoming http requests if they are unauthorized, and redirects it to a login page.
I wanted to open the controller to any incoming request as I was setting up the test environment.
I focused on setting up the test environment as I like to have a test driven approach.

Refactored the Date class to the newer java.time package using LocalDateTime.
The Date and Calendar packages can be complex to work with and also the constructor is deprecated.

Turned Vehicle interface into an abstract class. An abstract class can't be instantiated but can still have
all the fields and methods implemented. I prefer the abstract class before the interface in this case,
because I can implement all the methods and use them directly without having to override in each subclass.

I moved the logic of determining vehicle type into the service-layer, since some vehicles should not be
calculated, so there's no point in entering the calculator flow if we already know which vehicle type it is.

I made a VehicleType enum to have more control of the vehicle types.

BUGS I found:
- The totalFee of 60SEK was not applying per date but by total period, so I had to make a new method to let it add
every unique date into a Map and the totalFee per that date, and then to sum up the total of the entries. 

- The time limit of 60 minutes per fee, the intervalStart starts from the first time point but never updates once one hour has passed.
If I had more time I would use it for solving this bug.