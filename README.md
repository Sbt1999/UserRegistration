# UserRegistration
This project implements a simple User Registration API using Spring Boot.

API Endpoints
POST /api/users/signup

Register a new user.
Accepts a JSON request body with user details (name, email, password).
Returns a response with the registered user's details.
GET /api/users/fetch

Fetch user details by email.
Accepts a query parameter email.
Returns a response with the user's details if found, or a 404 Not Found if the user does not exist.
Setup Instructions
To run this application locally, follow these steps:

Clone the repository:

bash
Copy code
git clone https://github.com/your-username/user-registration-api.git
cd user-registration-api
Build the application:

bash
Copy code
mvn clean package
Run the application:

bash
Copy code
java -jar target/user-registration-api-1.0.jar
Replace user-registration-api-1.0.jar with the actual name of the generated JAR file.

Access the API:

Base URL: http://localhost:8080
Use tools like Postman to send requests to the above-mentioned endpoints.
