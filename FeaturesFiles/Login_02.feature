Feature: User Login

Background:
#only applicable for this feature files
Given chrome setup
When Enter the URL
And Click on Login

#Before> Background> Senario> After


@sanity 
Scenario: Successful Login with single account deatils
  
    Given the user is on the nopCommerce login page
    When the user enters valid credentials (username: "hemanth123@gmail.com", password: "test@123")
    And the user clicks on the Login button
    Then the user should be redirected to the My Account page
    And the user should see a welcome message
    
@regression
Scenario Outline: Successful Login with multiple account deatils   # Scenario Outline used for multiple action
  #code reusability form abve senario
    Given the user is on the nopCommerce login page
    When the user enters valid credentials (username: "<username>", password: "<password>")  
    And the user clicks on the Login button
    Then the user should be redirected to the My Account page
    And the user should see a welcome message
    
Examples:
# parametrization
  | username              | password  |
  | hemanth123@gmail.com  | test@123  |
  | hemanth1234@gmail.com | test@123  |  