# VehicleTollCalculate
Calculate Vehicle Toll for a given times in day.

# Problem Summary
The assignment is to improve the code to get a code you think you can stand up for. There’s no direct syntax errors, it’s more about structure, general programming skills and how to think than any program specific. Feel free to re-structure, modify, use 3-party-products and so on.

This application handles the car tolls in Gothenburg and the calculation of the fee for the cars.

# Requirements
Each passage through a pay station (betalstation) costs 9,16 or 22 swedish kronas, depending of the time when you pass the station. You pay maximum 60 kr per day and car.

Time                  Fee to pay

06:00–06:29       -      9 kr

06:30–06:59       -     16 kr

07:00–07:59       -    22 kr

08:00–08:29       -     16 kr

08:30–14:59       -      9 kr

15:00–15:29       -     16 kr

15:30–16:59       -     22 kr

17:00–17:59       -     16 kr

18:00–18:29       -      9 kr

18:30–05:59       -      0 kr

The car toll is payed for both Swedish and non Swedish cars that passes a pay station (betalstation) in Gothenburg Monday to Friday between 06.00 and 18.29.

There is no fee to pay on Saturdays, Sundays, “red days”/holiday, days before “red days”/holiday nor during July.

Beyond Saturdays and Sundays and July you don’t have to pay the fee during the following days during 2020:

1 januari 

6 januari

9-10 april

13 april

30 april

1 maj

20-21 maj

5 juni

19 juni

30 oktober

24-25 december

31 december

If a car passes several pay stations within 60 minutes, you only pay for one passage (and then the highest of the fees – if they differs – is used).

The following cars don’t have to pay any fee at all:
emergency vehicles
buses with a total weight of at least 14 tonnes
diplomat-registered vehicles
motorcycles
military vehicles

# Solution Approach
Used Spring Boot (https://start.spring.io/) as backend service. Created four services to calculate car toll. Have used H2 database for storing holidays and prices for hour. 

## Backend
Invoked in autoconfiguration like 
* @ComponentScan(basePackages = { "net.evry.toll.*" })  without arguments tells Spring to scan the current package and all of its sub-packages.
* @EntityScan("net.evry.toll.entites") should specify which packages we want to scan for entity classes.
* @EnableJpaRepositories(basePackages = "net.evry.toll.repository") should specify which packages we want to scan for repository classes.
* @EnableScheduling - for schedular operations. 
* @RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody annotations, and as a result, simplifies the controller implementation:
 
# Running Spring Boot
By using Ecilipse to import project
* Import -> Maven -> Existing Maven Project -> Browse pom.xml file from saved directory then Build and Run applilcation 

You can use command prompt to run project 
* mvn -s "path\to\settings.xml" clean install
* mvn -s "path\to\settings.xml" spring-boot:run 

It will run application at 8080 port and read to accept requests.
