This simple project includes multiple microservices

Api-gateway : 
Acts like an entry point to application
Enables load balancer for multiple instances too

Discovery Server:
Service Registry for all other services

inventory-service
works as inventory of all products.
Provides CRUD operations
MySQL DB

Order-service
used to place orders 
CRUD operations with MySQL DB
is Kafka message Producer to be consumed by
Notification-Service
implements Circuit-Breaking with Resilinece4j
Also includes the actuator Endpoints


product-Service
used to create and retrieve products
CRUD operation with MongoDB

Notification-Service 
Used to send notification.
is Kafka message consumer


User docker-compose.yml file to use Kafka container

