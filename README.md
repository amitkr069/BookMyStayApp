### Use Case 5: Add-On Service Selection

In the use case -> The admin adds the add-on services like (breakfast, spa, etc.) and the User selects the add-on services while booking the room.

Data Structure used -> Map<String, List<Service>> – reservation ID → services


##### Key Requirements

Attach services (breakfast, spa, pickup)

Allow multiple services per booking

Calculate the additional cost


Goal was to -> Enhance bookings with optional services.

Actors were -> Guest, Service Management Module

Flow was -> Select service → Add to List → Map to reservation ID
