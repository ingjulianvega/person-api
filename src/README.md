# Read Me 
Base project for an API:

Clone the project, run it and go to http://localhost:8081/api/v1/person/swagger-ui.html

# Dependencies

###BOM 
```
Bill Of Materials. A BOM is a special kind of POM that is used to control the versions of a project's dependencies and provide a central place to define and update those versions. 
BOM provides the flexibility to add a dependency to our module without worrying about the version that we should depend on
```
* [person-bom](https://github.com/ingjulianvega/person-bom) - The BOM project
###Validations
###Lombok
###MapStruct
###Actuator
###Swagger
###JPA
###H2
```
Go to the h2 console
http://localhost:8081/api/v1/person/h2-console/
```
###MySql
```
run the project with localmysql profile
-Dspring.profiles.active=localmysql
```
###Specifications