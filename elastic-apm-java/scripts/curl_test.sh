#!/bin/bash

curl -X POST http://localhost:8081/api/v1/users -H "Content-Type: application/json" -d "{\"name\":\"test1\",\"email\":\"test1@tipsport.cz\"}"
curl -X POST http://localhost:8081/api/v1/users -H "Content-Type: application/json" -d "{\"name\":\"test2\",\"email\":\"test2@tipsport.cz\"}"
curl -X GET http://localhost:8081/api/v1/users/1
curl -X GET http://localhost:8081/api/v1/users/2
curl -X DELETE http://localhost:8081/api/v1/users/2
curl -X GET http://localhost:8081/api/v1/users/1
curl -X GET http://localhost:8081/api/v1/users/1
curl -X GET http://localhost:8081/api/v1/users/2
curl -X POST http://localhost:8081/api/v1/users -H "Content-Type: application/json" -d "{\"name\":\"test3\",\"email\":\"test3@tipsport.cz\"}"
