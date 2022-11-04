# Bank Transaction Processor
This repo will listen to the Transaction Messages that triggers by Bank REST API.
This is related to https://github.com/thathsara404/bank-REST-API

# Technical Stack & External Dependencies
use  `mvn dependency:tree` to view more.
- Java Open JDK (17)
- spring-boot-starter-data-jpa (2.7.4)
- spring-boot-starter-test (2.7.5)
- :postgresql (42.3.7)
- log4j-api (2.19.0)
- log4j-core (2.19.0)
- slf4j-simple (2.0.3)
- amqp-client (5.16.0)

# Steps to run manually
| Step  | Instructions                                | Description                                                                                               |
| ----- |:--------------------------------------------|:--------------------------------------------------------------------------------------------------------- |
| 1     | `docker run -d --hostname my-rabbit --name some-rabbit -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password -p 8080:15672 -p 5672:5672 rabbitmq:3-management` | Spin up a RabbitMQ container.
| 2     | `http://localhost:5672/` | Access from the browser to access the RabbitMQ dashboard.
| 3     | `docker run --name postgresql -e POSTGRES_USER=myusername -e POSTGRES_PASSWORD=mypassword -p 5432:5432 -v /data:/var/lib/postgresql/data -d postgres` | Spin up a postgres container.
| 4     | Modify application properties | Need to change the postgres and RabbitMQ entries in application.properties as per your environment.|
| 5     | Start the application. Run DevTestAPI.txt file commands with REST Client plugin in VS Code or try with Postman. | Now you can consume the APIs. |
| 6     | Run bank-REST-API | Make sure bank-REST-API is up and running to get get messages. | Now you can consume the APIs. |

# Steps to run with docker
| Step  | Instructions                                | Description                                                                                               |
| ----- |:--------------------------------------------|:--------------------------------------------------------------------------------------------------------- |
| 1     | `bash docker-compose-run.sh` | Run this bash script to initiate the app container, RabbitMQ container and PostgreSQL container.
| 2     | Spin up the bankREST-API | Follow the run instructions in the bash bank-REST-API repo's README.

# Dev guide
- make sure your java version is 17
