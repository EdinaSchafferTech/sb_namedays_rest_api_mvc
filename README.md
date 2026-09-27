Namedays – REST API and MVC
Spring Boot application for managing namedays using a REST API and an MVC application.
Project Overview
The application manages namedays stored in a MySQL database. Each nameday contains two pieces of information:
Date
First name
The project consists of two separate Spring Boot applications:
namedays-rest – REST API and database access
namedays-mvc – MVC application that accesses the data through the REST API
The application architecture:
namedays-mvc
      │
      │ HTTP / REST
      ▼
namedays-rest
      │
      │ JDBC / SQL
      ▼
    MySQL
1. REST Application
The REST application connects to the MySQL database, retrieves the nameday data, and generates an XML representation of the data.
The REST API returns all namedays in XML format. The XML is included as a String in one field of a JSON response.
Example:
{
  "xml": "<namedays><nameday>...</nameday></namedays>"
}
The XML structure:
<namedays>
    <nameday>
        <name>Fruzsina</name>
        <date>01-01</date>
    </nameday>
    <nameday>
        <name>Ábel</name>
        <date>01-02</date>
    </nameday>
</namedays>
Main components of the REST application:
Nameday model
NamedayRepository
AppService
XmlGenerator
XmlResponseDTO
AppController
GET /namedays API
XML generation is implemented using JDOM.
2. MVC Application
The MVC application retrieves the nameday data through the REST API.
The MVC application extracts the XML String from the JSON response and processes the XML directly from the String.
The processed data is represented using its own MVC model and displayed on a web page using Thymeleaf.
The data flow:
REST API
   ↓
JSON
   ↓
XML String
   ↓
XML processing
   ↓
MVC model
   ↓
Thymeleaf
   ↓
Web page
3. Updating Namedays
The application will be extended with two APIs for modifying nameday data.
The MVC application will be able to initiate:
Changing the date associated with a given first name
Changing the first name associated with a given date
The REST application will provide two POST APIs for these modifications.
Technologies
Java
Spring Boot
Spring MVC
Spring Data JDBC
MySQL
JDOM
Thymeleaf
REST API
Maven
Project Structure
pti.sb_namedays-rest-api-mvc/
├── namedays-rest/
└── namedays-mvc/
The project is developed incrementally, with separate commits for the main parts of the assignment.
