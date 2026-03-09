### Use Case 3: Booking Request Feature
Data Structure used: Queue

In this use case the user can request for room booking and the booking order will be served in FIFO order.

##### Key Requirements

Accept booking requests

Enforce arrival order

Handle high-traffic scenarios


Goal of this use case -> Ensure booking fairness during peak demand.

Actors were -> 
Guest, Booking Queue Service

Flow was -> Booking request → Enqueue → Await processing
