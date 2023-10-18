# Repository Microservice
The Repository Microservice is a simple Spring Boot application that provides CRUD (Create, Read, Update, Delete) 
for managing data, as flights, airlines, bookings, users.

## Table of Contents
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Usage](#usage)

## Getting Started
To run this microservice, follow these steps:

### 1. Clone the repository:
   ```bash
   git clone https://github.com/wikicode96/escapism-travel.git
   ```
   
### 2. Check dependencys:
- h2
- spring-boot-starter-web
- spring-boot-starter-data-jpa.

## Endpoints
The Repository Microservice provides the following RESTful endpoints:

### Create a New Record
- HTTP Method: POST
- Endpoints: `/airline, /booking, /flight, /user`
- Consumes: JSON
- Produces: JSON
- Description: Create a new record.

### Get Record by ID
- HTTP Method: GET
- Endpoints: `/airline/{id}, /booking/{id}, /flight/{id}, /user/{id}`
- Produces: JSON
- Description: Retrieve record information by providing the record's ID.

### Get All Records
- HTTP Method: GET
- Endpoints: `/airlines, /bookings /flights, /users`
- Produces: JSON
- Description: Retrieve a list of all records.

### Update Record
- HTTP Method: PUT
- Endpoints: `/airline, /booking, /flight, /user`
- Consumes: JSON
- Produces: JSON
- Description: Update an existing record.

### Delete Record
- HTTP Method: DELETE
- Endpoints: `/airline, /booking, /flight, /user`
- Consumes: JSON
- Produces: JSON
- Description: Delete an existing record.

## Usage
Make sure to include valid JSON data when sending requests.
Here's an example of creating a new JSON of records:

### Airline
```
{
    "id": 1,
    "name": "FlyUS",
    "imgLogo": "flyus"
}
```
### Booking
```
{
    "id": 1,
    "idUser": 1,
    "idFlight": 1,
    "date": "2023-10-24"
}
```
### Flight
```
{
    "id": 1,
    "idAirline": 1,
    "origin": "VC",
    "destination": "LV",
    "depart": "2024-12-05"
}
```
### User
```
{
    "id": 1,
    "firstName": "fname",
    "lastName": "lname",
    "email": "example@example.com",
    "password": "example"
}
```