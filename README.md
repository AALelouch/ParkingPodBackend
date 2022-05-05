<h1 align="center">Parking Pod Backend 🚗</h1>
<div align="center">
  <img src="https://st.depositphotos.com/1004713/1337/i/600/depositphotos_13370145-stock-photo-parking-garage-underground-interior.jpg">
</div>

<h2>Description 💻</h2>
<p>Parking Pod Backend is a web API that follow a bussiness logic, and contains the part business, persistence and presentation, it doesn't have frontend, it can calculate the prices with the following logic: </p>

- 3 hours count as one.
- 25 hours count as two days, 49 hours count as three days...
- The owner can edit the number of slots, prices and availability.
- The owner can request the number of available slots.
- The date can change in any moment

<h2 align="left">Languages and Tools 💎</h2>

- Java: The lenguage of the proyect .
- Spring: I used this for create entities, repositories, services, mappers, advices and controllers.
- Git: I used this for add, commit and push the changes. Also for do some cherry-picks when i needed.
- Postman: To test the endpoints.
- MongoDB: To save the records.
- MySql: To save records that the owner use actually.
- Swagger: To Test the endpoints.

<p align="left"> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"><img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/></a> <a href="https://www.java.com" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://www.mongodb.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mongodb/mongodb-original-wordmark.svg" alt="mongodb" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>

<h2>How download and run 🧰</h2>
<h3>Tools</h3>
<ul>
  <li>An IDE as IntelliJ</li>
  <li>JDK of Java 11</li>
  <li>A console</li>
</ul>

<h3>Steps for install it</h3>
<ul>
  <li>Download, extract all and open with you IDE</li>
  <li>Go to the POM and download the dependencies</li>
  <li>In your mysql create de database parkingapi</li>
  <li>Open the console, go to the folder and run this command ./mvnw spring-boot:run</li>
  <li>Using PasswordEncoderGenerator located in security/util, create you password and insert a user name and the password encoded for login</li>
  <li>Open the browser and go to http://localhost:8080/open-api/swagger-ui/index.html?configUrl=/open-api/api-docs/swagger-config#</li>
  <li>Write the credentials and enjoy!</li>
</ul>

