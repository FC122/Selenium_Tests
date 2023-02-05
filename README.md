# Selenium_Tests
Selenium Maven

Five test cases automated in Selenium.

Test cases are writen for https://www.saucedemo.com login page.

Main parts of the project:
  configs/Configuration.properties - file where all strings used in the project are stored (driver path, error messages...)
  src/test/java/config/ConfigFileReader.java - class that reads the configuration file and gives the interface for accesing configurations
  src/test/java/config/PageLocators - folder that contains classes with all web elements used in tests
  src/test/java/config/LoginPageActions - folder that contains classes with commonly used functions
  src/test/java/config/tests - folder that contains all tests
  
  High level overview: \n
  ![image](https://user-images.githubusercontent.com/72666124/216820523-f50f00b2-764a-40b2-8c30-e1528ae1f1c4.png)

Usage with gui:
  Clone the repo \n
  Open the project with intelij \n
  Go Build->Build Project \n
  Go Run -> Run...
  
 Tools:
    Maven \n
    Şelenium \n 
    Intelij 
