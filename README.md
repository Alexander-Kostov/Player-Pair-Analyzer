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

<br></br>

# Backend Overview

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

## Backend Logic Displayed
![image](https://github.com/user-attachments/assets/a38da0b0-dd06-4e83-ae62-414c249e9307)

<br></br>

# Databse Overview
### Database Entities

#### **Player**
- **Description:** Represents a football player.
- **Attributes:**
  - `id`: Unique player identifier.
  - `name`: Full name.
  - `teamId`: References the player's team.
  - `position`: Playing position.
- **Relationships:** Linked to `Team` and `Participation`.

#### **Team**
- **Description:** Represents a football team.
- **Attributes:**
  - `id`: Unique team identifier.
  - `name`: Team name.
  - `group`: Tournament group.
- **Relationships:** Contains `Player` entities and participates in `Match` entities.

#### **Match**
- **Description:** Represents a football match between two teams.
- **Attributes:**
  - `id`: Unique match identifier.
  - `date`: Match date.
  - `teamA_id`: First team.
  - `teamB_id`: Second team.
  - `score`: Match result.
- **Relationships:** References `Team` entities and has `Participation` records.

#### **Participation**
- **Description:** Represents a player’s involvement in a match.
- **Attributes:**
  - `id`: Unique participation identifier.
  - `playerId`: References the player.
  - `matchId`: References the match.
  - `minutesPlayed`: Minutes played in the match.
- **Relationships:** Linked to `Player` and `Match`.

### EER Diagram
![image](https://github.com/user-attachments/assets/dc56e28e-ccb5-4690-87b5-a8358a13b7b6)

<br></br>

# Frontend Overview

The front-end part of the application is built using React, ensuring a dynamic and responsive user experience. The data retrieved from the backend API is displayed in a structured and user-friendly manner, allowing users to easily explore the Euro Cup 2024 statistics.

***The frontend is mainly responsible for visualizing the matches in bracket view, single match details and roster view of all players in a team. It also allows users to browse through the different matches, view teams, and players, and see detailed statistics. The data is fetched from the backend and displayed using modern React components and responsive layouts.***

### Key Features:
- **React Components**: The application is divided into reusable components for better scalability and maintainability.
- **Data Fetching**: Utilizes **React Query** for efficient and optimized data fetching and caching.
- **CSS Grid and Flexbox Layout**: The application uses modern CSS techniques for building responsive layouts.
- **Interactive UI**: Provides users with filters, sorting options, and detailed views for teams, players, and match statistics.

### Tools & Libraries Used:
- **React** for building the UI components.
- **React Query** for data fetching and caching.
- **CSS (Flexbox & Grid)** for styling and responsive design.
- **JavaScript** for dynamic behavior.

### Images

#### Home Page

![image](https://github.com/user-attachments/assets/27531c9d-a147-4aab-aeec-c190aa61659d)

### Custom Match

![image](https://github.com/user-attachments/assets/b5e11196-dc44-429a-9c74-94a4c175ed0b)

### All Players

![image](https://github.com/user-attachments/assets/7e910f27-dc64-436b-bcc0-3ad6717d272a)

### Team Players by ID

![image](https://github.com/user-attachments/assets/1a8c9ac7-37be-4a4c-a852-8ef2e7b28c5d)

### Players With Most Mutual Time
![image](https://github.com/user-attachments/assets/0937cf3c-fa4c-46b6-a6ec-db8922dfe96b)

