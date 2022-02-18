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