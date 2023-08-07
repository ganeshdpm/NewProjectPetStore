@PetStore_Regression
Feature: End to End Test for PetStore API
Description: The purpose of these test to cover End to End flow for customer

PetStore Swagger API URL: https://petstore.swagger.io/#/

   Background:
    Given Enpoint Base URL "https://petstore.swagger.io/v2"
		
   Scenario: TC_1 Verify user can able to add pet user details
    Given Endpoint Base Path Url "/user" for "post" request
    When I set Headers "Content-Type" as "application/json"
    And I send "Post" request body
    When I send "POST" Request
    Then I verify status Code 200
    And I print the response
		
   Scenario: TC_2 Verify user can able to retrieve pet user details
    Given Endpoint Base Path Url "/user/" for "Get" request
    When I set Headers "Content-Type" as "application/json"
    And I send "GET" Request
    Then I verify status Code 200
    And I print the response
    Then I validate "firstName" value present in field "firstName"
    Then I validate "lastName" value present in field "lastName"
    
   Scenario: TC_3 Verify user can able to update pet user FirstName, LastName and Email details and check updated details by retrieving it
    Given Endpoint Base Path Url "/user/" for "put" request
    When I set Headers "Content-Type" as "application/json"
    And I send "Put" request body
    When I send "Put" Request
    Then I verify status Code 200
    Given Endpoint Base Path Url "/user/" for "Get" request
    And I send "GET" Request
    Then I verify status Code 200
    Then I validate "firstName" value present in field "firstName"
    Then I validate "lastName" value present in field "lastName"
    Then I validate "email" value present in field "email"
       
  Scenario: TC_4 Verify user can able to delete pet user details
    Given Endpoint Base Path Url "/user/" for "Delete" request
    When I set Headers "Content-Type" as "application/json"
    And I send "Delete" Request
    Then I verify status Code 200
    And I print the response
    
  Scenario: TC_5 Validate pet user is created without payload
  	Given Endpoint Base Path Url "/user" for "post" request
    When I set Headers "Content-Type" as "application/json"
    When I send "POST" Request
    Then I verify status Code 405
    
  Scenario: TC_6 Validate retrieving invalid pet username gives 404 response code
  	Given Endpoint Base Path Url "/user/test" for "Get" request for invalid UserName
    When I set Headers "Content-Type" as "application/json"
    When I send "GET" Request
    Then I verify status Code 404
    
    

	  
    
   

   

  
    

