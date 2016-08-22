### To generate war
gradle war -> .war file will be located in {project_dir}/build/libs

### To run
gradle cargoRunLocal

## Rest API

### List all festivities
GET localhost:8080/festapivity/api/festivity

### Find festivity by id
GET localhost:8080/festapivity/api/festivity/{id}

### Create festivity
POST localhost:8080/festapivity/api/festivity with {"name":"Cool party","startDate":"2016-02-04T00:00:00Z","endDate":"2016-02-11T23:59:59Z","place":"My place"}
