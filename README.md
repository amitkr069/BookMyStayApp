### Use Case 4: Reservation Confirmation & Room Allocation

In this use case the admin processes the reservation of the guests based on FIFO order and allocates the room to the Guests.

Data Structures Used: Set, HashMap


##### Key Requirements

Assign a unique room ID

Prevent reuse of room IDs

Update availability immediately


Goal of this use case was to -> Guarantee zero double-booking.

Actors were -> 
Booking Service, Inventory Service

Flow was -> 
Dequeue request → Assign room ID → Add to Set → Decrement count
