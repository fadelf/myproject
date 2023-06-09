## DEMO PROJECT

***

### A. Running the application

1. Compile and install all modules:
    * Online mode (use it for the first time to download dependencies):  
      `mvn clean install`
    * _(Optional)_ or use the Offline mode, if you already have all dependencies in your Maven local repository:  
      `mvn -o clean install`

2. Run the application (this will generate database structure as well):  
   localhost environment (Windows):  
   `java -jar .\target\demo-0.0.1-SNAPSHOT.jar`

3. Access the application documentation of APIs using this URL :
   http://localhost:8080/swagger-ui/index.html

4. This application uses an H2 in-memory database, so every time the application is restarted,<br> 
   the data will be reset

5. You should first register the user because every API except for registration and login requires a JWT token.<br> 
   An example is provided in the Postman collection, which is located in the Postman folder.

6. Additional info how to run with docker (make sure to compile using step 1 first)
   Locate where docker file and run this command to create docker image (you can change demo-image name as you wish)
   * `docker build -t demo-image .`<br>
   After that make sure docker image build successfully then run this command
   * `docker run -p 8080:8080 demo-image`