# api_java_test
Project test Java

After the git clone, run the mvn clean install command.

You can see the tests being run.

Then run "java -jar target/JumiaPhone-0.0.1-SNAPSHOT.jar"  command

If you want to change the port other than 8080 is in the file application.properties property server.port

After executing the commands, import the JumiaPhone.postman_collection.json file from the doc folder in Postman to test the services.

# FindAll
GET: http://localhost:8080/api/phone/0/40

# FindByCountryState
http://localhost:8080/api/phone/0/41/212/Valid

# FindCountries
http://localhost:8080/api/phone/countries


# Chart

http://localhost:8080/api/phone/chart
