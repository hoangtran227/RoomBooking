Project Structure:
- main
- test:
    + java Test runners and supporting code
    + resource:
        features Feature files : booking fearture
        webdriver binaries : chromedriver.exe, geckodriver.exe
- target:
    site
      index.html report 
Executing the tests:
     `mvn clean verify`
Webdriver configuration:
  `webdriver {
    driver = chrome(change to firefox if run with firefox browser)
  }`