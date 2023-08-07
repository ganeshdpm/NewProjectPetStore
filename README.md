# NewProjectPetStore
Functional Test Cases:

1. Validate retrieve the user details API
2. Validate create a new user details API
3. Verify user can able to update pet user FirstName, LastName and Email details and check updated details by retrieving it
4. Validate deleting the user details
5. Validate pet user is created without payload
6. Validate retrieving invalid pet username gives 404 response code

Attached the extent report.

Performance testing - It is used to check the performance of the application by adding threads and performing load and stress testing. It can be achieved by using Apache Jemeter
Security Testing: It is nothing but penetration testing. we can do security testing using Brup Suite or Owasp zap tools.


Note: I have supported performance and security testing but I don't have much exposure on it.

Automation Execution Steps:

1. Test steps are written under com.feature package
2. Test methods are written under com.stepdefinition package
3. Test Execution are written under com.TestRunner package
4. Reports were attached under ExtentReports folder
5. For Execution use maven commands - clean test
