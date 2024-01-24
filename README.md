# uni-tel
Uni-Tel is a travel agency that appears in Grand Theft Auto: San Andreas, located around Los Santos. This project is a website of this agency, used by customers and its staff to create bookings and others tasks.
![](https://static.wikia.nocookie.net/gtawiki/images/0/0d/Uni-Tel-GTASA-DowntownLosSantos.png/revision/latest/scale-to-width-down/1000?cb=20230215105048)

## Scheme
With this image you can take a look at the schema of the application. It uses four relational tables and other one just used by employees, because flights depend to some airlines and for the same way, bookings depend to costumers. About the microservices, Airlines microservice have a relationship with Flights microservice, and Costumers microservice have relationship with Costumers microservice.

![scheme](img/scheme.png)