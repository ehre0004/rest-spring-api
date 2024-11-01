# Sample Java Spring Boot REST API

This project uses Java and [Spring Initializr](https://start.spring.io/) as a template generator (no code generated except for the entrypoint) for Spring Boot projects.

- Entrypoint to app: src\main\java\com\algonquinlive\ehre0004\rest_spring_api\RestSpringApiApplication.java
- Student is a model for our data.
- StudentAPI is our REST API.

Once the entrypoint is run and loads the application, our StudentAPI is available automatically, on the environment variable PORT (8888).

To run the program using the Dockerfile-generated image, enter into a terminal: docker build -t student-service:latest .
Then, run the program using: docker run --rm -d -p 8888:8888 student-service:latest