# FilmakRestApi
The aim of this project is to use a Rest API to access data from a Mongo database using Spring Java technology. For that purpose, a dataset was selected to be loaded into the Mongo database, that includes almost 10K movies from Netflix digital platform. 

## Dataset
At first, the dataset doesn't contain any Objects or Arrays. Instead, it has only Strigns and Integers. As the main point of the project was to work with a certain level of difficulty, the dataset was changed converting an String into a JSONObject Array by using mongosh. So after those changes, the new dataset was ready to be used (in JSON format).

[See dataset](filmak.json)

After that, MongoDB Compass was used to create the database and impoting the dataset into it.

[!NOTE] 
Before importing the dataset a connection to the server is required. (Explained later)

## Rest service
For the rest service Swagger UI was used: http://localhost:8080/swagger-ui/index.html

![Alt text](images/swagger.png)

| Type  | URL (EndPoints)  | Result |
|:------------- |:---------------| :-------------|
| GET         | /filmak/guztiak      | This returns a JSON with the movies             |
| GET         | /filmak/bilatu      | This returns a JSON with the movie id selected             |
| GET         | /filmak/bilatuHerrialdeka      | This returns a JSON with the movies from the country selected       |
| PUT         | /filmak/eguneratu/{_id}        |  Update the movie wiht the selected id  |
| POST         | /filmak/gehitu        | Stores a new movie on the database        |
| DELETE         | /filmak/ezabatu     | Deletes the movie by the name        |
| DELETE         | /filmak/ezabatu/{_id}      |  Deletes the movie by id     |

## Mongo
For using Mongo we need to have mongo installed, and also its client (Compass). Once installed, we can access by using the following:  *mongodb://localhost*

After that, we can create the database with a collection and import the dataset easily. 

--> For this porject, the default database name is "filma" and collection name is "filmak". <--

Then, the structure of the database will look like this:

![Alt text](images/database.png)

## Java
1. Models Package:

    Filma Class:
        The central class of the project representing movies. Additional attributes, such as genre, release date, director, and more, may be incorporated for a more comprehensive representation.

    Cast Class:
        The Cast class, is designed to capture details about cast members. 

2. Repositories Package:

    FilmakRepository:
        The FilmakRepository, situated within the Repositories package, houses methods for database interactions related to movies.
        The repository is equipped with error-handling mechanisms to manage potential issues, providing meaningful error messages in case of errors.

    CastRepository:
        CastRepository manage cast members, including fetching all cast members for a particular movie or searching for actors by name. Validations are implemented to ensure data consistency.

3. SpringConfiguration:

    SpringConfiguration, found outside the main packages, extends its functionalities to handle various configurations. 

4. Controller Package:

    FilmakController:
        The FilmakController, includes endpoints for searching movies by release date range or fetching movies with a minimum rating can be implemented.
        The controller ensures proper request and response handling, incorporating validation for incoming requests.

    CastController:
        In the Controller package, the CastController manages cast-related operations, providing endpoints for adding new cast members, updating their information, or deleting cast members.

5. RestapiApplication:

    Run Configuration:
        The RestapiApplication is the responsible for running the program.
   
![Alt text](<images/class diagram.png>)
