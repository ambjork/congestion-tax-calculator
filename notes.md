Spring boot project with maven:
Spring boot comes with a lot of pre-configured tools for web applications and is a common framework.
It's quick to set up and get things to work in a short time.

Refactored the Date class to the newer java.time package using LocalDateTime.
The Date and Calendar packages are difficult to work with and also the constructor is deprecated.

Turned Vehicle interface into an abstract class. An abstract class can't be instantiated but can still have
all the fields and methods implemented. I prefer the abstract class before the interface in this case, 
because I read that interface should be described as an adjective (like Runnable<T>, Serializable<T> etc).

I moved the logic of determining vehicle type into the service-layer, since some vehicles should not even be
calculated, so it's no point in entering the calculator if we already know which vehicle type it is.

I made a VehiclyType enum to have more control of the vehicle types.


BUGS I found:
The totalFee of 60SEK was not applying per date but by total period, so I had to make a new method to let it add
every unique date into a Map and the totalFee per that date, and then to sum up the total of the entries. 