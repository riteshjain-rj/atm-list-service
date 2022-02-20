# atm-list-service
Java coding exercise for ATM list 

The entire application is contained within the `atm-list.jar` file.

## Clean Install
    mvn clean install

## Run the app
    ./mvnw spring-boot:run

# REST  Details
The REST API to the ATM's, should return the identification value as well as full details of ATMs as described below.

## Use Cases
This is a REST service to expose the identification value as well as full details of ATMs.

### Request

    curl --location --request GET 'http://localhost:8085/api/atms' \
    --header 'identification: 234324'

| Header Parameter | Type | Description |
| :--- | :--- | :--- |
| `identification` | `long` | **Required**. 234324 |

### Response
Returning the "Human Friendly Text" as JSON.

    {
    "data": [
    {
    "Brand": [
    {
    "BrandName": "Lloyds Bank",
    "ATM": [
    {
    "Identification": "LFFDCC11",
    "SupportedCurrencies": [
    "GBP"
    ],
    "Location": {
    "PostalAddress": {
    "AddressLine": [
    "102 GREY STREET;"
    ],
    "StreetName": "102 GREY STREET",
    "TownName": "NEWCASTLE UPON TYNE",
    "CountrySubDivision": [
    "TYNE AND WEAR"
    ],
    "Country": "GB",
    "PostCode": "NE1 6AG"
    }
    }
    }
    ],
    "Country": "GB",
    "PostCode": "NE23 6QR"
    }
    }
    }
    ]
    }
    ]
    }
    ]
    }

### Errors

    Required request header 'identification' for method parameter type long is not present

## Status Codes

Application returns the following status codes in its API:

| Status Code | Description |
| :--- | :--- |
| 200 | `OK` |
| 400 | `BAD REQUEST` |
| 404 | `NOT FOUND` |
| 500 | `INTERNAL SERVER ERROR` |

##Actuator Endpoint.

### Request

    curl --location --request GET 'http://localhost:8085/actuator/health'

### Response

    {
    "status": "UP"
    }

### Request

    curl --location --request GET 'http://localhost:8085/actuator/health'

### Response

    {
    "status": "UP"
    }

##Docker commands

- docker images
- docker container ls
- docker logs <container_name>
- docker container rm <container_name
- docker image rm <image_name
- docker build -f Dockfile -t atm-list .
- docker run -p 8085:8085 atm-list

#Actuator

##Actuator Endpoints
The following table describes the widely used endpoints.

| Id | Usage | Default |
| :--- | :--- | :--- |
| actuator | It provides a hypermedia-based discovery page for the other endpoints. It requires Spring HATEOAS to be on the classpath. | True
| auditevents | It exposes audit events information for the current application. | True
| autoconfig | It is used to display an auto-configuration report showing all auto-configuration candidates and the reason why they 'were' or 'were not' applied. | True
| beans | It is used to display a complete list of all the Spring beans in your application. | True
| configprops | It is used to display a collated list of all @ConfigurationProperties. | True
| dump | It is used to perform a thread dump. | True
| env | It is used to expose properties from Spring's ConfigurableEnvironment. | True
| flyway | It is used to show any Flyway database migrations that have been applied. | True
| health | It is used to show application health information. | False
| info | It is used to display arbitrary application info. | false
| loggers | It is used to show and modify the configuration of loggers in the application. | True
| liquibase	| It is used to show any Liquibase database migrations that have been applied. | True
| metrics | It is used to show metrics information for the current application. | True
| mappings | It is used to display a collated list of all @RequestMapping paths. | True
| shutdown | It is used to allow the application to be gracefully shutdown. | True
| trace | It is used to display trace information. | True
| heapdump | It is used to return a GZip compressed hprof heap dump file. | True
| logfile | It is used to return the contents of the logfile. | True

###following configuration to expose all endpoints:
    management.endpoints.web.exposure.include=*

###To explicitly enable a specific endpoint (e.g., /shutdown), we use:
    management.endpoint.shutdown.enabled=true

###To expose all enabled endpoints except one (e.g., /loggers), we use:
    management.endpoints.web.exposure.include=*
    management.endpoints.web.exposure.exclude=loggers
