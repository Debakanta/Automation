Feature: Login to Swag Labs Application get product page title and logout

Background: 
   Given User is on Saucedemo Page "https://www.saucedemo.com/"
  
   @InvalidCredentials
   Scenario Outline: Login with Invalid credentials
      
    When User enters username as "<username>" and password as "<password>"
    Then User should stay on same page with error msg as "<errormassage>"
  Examples:
  | username  | password  | errormassage  |
  | Admin|          admin123|Epic sadface: Username and password do not match any user in this service |
  | locked_out_user|secret_sauce|Epic sadface: Sorry, this user has been locked out. |
  
   
   @ValidCredentials
   Scenario Outline: Login with valid credentials and Logout
      
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to redirect to the Product page
    When User click on Logout link
    Then User should redirect back to the Login page
     
  Examples:
  | username   		| password  |
  | standard_user|secret_sauce|
  | performance_glitch_user|secret_sauce|
  | problem_user   |secret_sauce|
  | error_user|secret_sauce|
  | visual_user   |secret_sauce|