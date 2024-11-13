This is just a basic POC for KAFKA and Sharing of data between different microservices.
*********************************************************************************************

Customer microservice sends the the JSON to be saved in the product microservice. After success/failed transaction
it gets a notification from Products Microservice. It also gets all the list of products saved in the product microservice
using RestTemplate. Find the Product microservice here https://github.com/jyotimoydas/kafkaPocProducts


Products microservice, fetching data from the customer(bestBuy) microservice using @kafkaListener and saving the data into the DB.
On successfull save operation, it sends a notification to the customer microservice using KafkaTemplate.
Find the customer microservice here https://github.com/jyotimoydas/kafkaPocCustomer
