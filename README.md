# vehicles
A application that categorizes vehicles read from xml file based on types and displays summary report in tabular format

`vehicles-app` is the front end developed in angular 6, this application asks user to upload a xml file which is then sent to REST API for
generating report summary for catergorization.

`src` contains the REST API which reads the input xml file, parses it and categorizes it based on types.

`upload-dir`contains the upload file for vehicle categorization.

#Installation<br/>
For running REST API Service, <br/>
- To install run `mvn clean install` in root directory. <br/>
- Start by running `MainApplication` Spring Boot application. <br/>

For running Angular application, go to `vehicles-app` directory and run below commands, <br/>
- `npm install`
- `ng serve`
This will start running application on `localhost:4200`
