####Purpose- Online Flight Booking using selenium WebDriver and Page Object Model.

This framework is used to test flight booking option in a travelsite(southwest.com) using limted feature.This JAVA maven project uses selenium webdriver and POM and page factory concepts

### class file explanation 
Inputs values are in constant file.
browserType and drivers is set in BaseSetup class.
Page objects for each page is created in separate  package
util class is used to calculate date functions and send mail option

test class is SelectFlightAndPricePage and can be executed by testng.

####TestCase Flow

1.Go to travelsite (in this project- SouthWset.com)
2.Select flight tab and provide departure, arrival location.
3.Provide the departure date, 3 days after the current date.
4.Set the return date one week later from the departure date.
5.click search for list of flights.
6.select required flight option 
7.check the price and continue 
8.Sending an email with price and  itenary details  as end point(#assumed end point)

#####Environment Setup(latest version of all software)

Java 8 
Install Maven
selenium Dependencies
testng Dependency




