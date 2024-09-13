# Introduction
- This web application provides comprehensive statistics for the Euro Cup 2024.
- Data is imported into the application from CSV files, ensuring efficient data ingestion.
- The backend API server interacts with the database to retrieve and structure the data.
- The structured data is then presented to users through the front-end interface in the browser.
- This project is a full-stack application, integrating both backend and frontend technologies for a seamless user experience.

### Backend built with:
<a href="https://www.java.com" target="_blank" rel="noreferrer">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/>
</a>
<a href="https://spring.io/" target="_blank" rel="noreferrer">
  <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/>
</a>

### Database:
<a href="https://www.mysql.com/" target="_blank" rel="noreferrer">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/>
</a>

### Frontend built With:
<a href="https://www.w3.org/html/" target="_blank" rel="noreferrer">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/>
</a>
<a href="https://developer.mozilla.org/en-US/docs/Web/CSS" target="_blank" rel="noreferrer">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css" width="40" height="40"/>
</a>
<a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank" rel="noreferrer">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/>
</a>
<a href="https://reactjs.org/" target="_blank" rel="noreferrer">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/react/react-original-wordmark.svg" alt="react" width="40" height="40"/>
</a>
<a href="https://react-query.tanstack.com/" target="_blank" rel="noreferrer">
  <img src="https://img.shields.io/badge/React_Query-FF4154?style=flat&logo=reactquery&logoColor=ffffff" alt="react-query" width="120" height="40"/>
</a>


### API Endpoints
### Main Url: localhost:8080

Here are the available API endpoints for this application:
#### Team Controller

#### `/teams/with-players`

- **Method:** GET
- **Description:** Retrieves an array of all teams with an array of players.
- **Request Parameters:** None
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON array of team objects.

#### `/teams/without-players`

- **Method:** GET
- **Description:** Retrieves an array of all teams without an array of players.
- **Request Parameters:** None
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON array of team objects.

#### `/teams/{teamId}`

- **Method:** GET
- **Description:** Retrieves an array of team with all its players.
- **Request Parameters:**
  - **Path Parameter:** `id` (Long) - The ID of the team.
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON object with team details.
  - **Status Code:** 404 Not Found (if team with specified ID does not exist)

#### Meet Controller

#### `/meets/all`

- **Method:** GET
- **Description:** Retrieves an array of all matches.
- **Request Parameters:** None
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON array of match objects.

#### `/meets/tournament-data`

- **Method:** GET
- **Description:** Retrieves an array of all tournament matches.
- **Request Parameters:** None
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON array of match objects.

#### `/meets/group-data`

- **Method:** GET
- **Description:** Retrieves an array of all matches in group stage.
- **Request Parameters:** None
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON array of match objects.

#### `/meets/{id}/details`

- **Method:** GET
- **Description:** Retrieves details of a specific match by its ID.
- **Request Parameters:**
  - **Path Parameter:** `id` (Long) - The ID of the match.
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON object with match details.
  - **Status Code:** 404 Not Found (if match with specified ID does not exist)

#### `/players/all`

- **Method:** GET
- **Description:** Retrieves an array of all players.
- **Request Parameters:** None
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON array of player objects.

#### `/participations/all-time`

- **Method:** GET
- **Description:** Retrieves a list of players who have accumulated the most mutual playtime in common matches. This endpoint returns an array of player pairs, each representing players who have played the most time together in matches.
- **Request Parameters:** None
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON array of participation objects.

#### `/participations/different-teams-time`

- **Method:** GET
- **Description:** Retrieves a list of player pairs who have accumulated the most mutual playtime in common matches but played for different teams. This endpoint filters out player pairs from the same team and returns only those from opposing teams.from different teams.
- **Request Parameters:**
  - **Path Parameter:** `id` (integer) - The ID of the participation.
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON object with participation details.
  - **Status Code:** 404 Not Found (if participation with specified ID does not exist)
#### `/participations/all`

- **Method:** GET
- **Description:** Retrieves an array of all the player and their participation times in all matches.
- **Request Parameters:** None
- **Response:** 
  - **Status Code:** 200 OK
  - **Body:** JSON array of participation objects.

### Notes

