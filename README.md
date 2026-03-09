### Use Case 1: Room Inventory Setup & Management

This use case contains just the initialization of the Book My Stay app where admin makes room types and sets its price and number of rooms.

Data Structures Used - HashMap

##### Key Requirements

Initialize room types (Single, Double, Suite)

Store room counts and prices

Support dynamic inventory updates

Provide real-time availability status
Goal

Maintain a single source of truth for hotel room inventory.

##### Actors are

Hotel Admin, Inventory Service

Flow is as follows: 
Add room type → Store in HashMap → Update count/price → Confirm
