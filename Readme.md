#ECOMP

## ER Diagram
![ER Diagram](ER%20Diagram.jpg)

## API Request example 

curl --location --request GET 'http://localhost:8080/product/search?input=nike'


## Design Considerations
1. It is better to create audit field in each of the table to capture audit data.
2. Required to create Data Transfer Object to transfer data outside the system. 