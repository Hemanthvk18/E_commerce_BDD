Feature: Register

  Scenario Outline: : For Sucessfull Register
    Given user land on register page
    When enter all required fields (lastname: "<ln>",Password: "<pass>")
    And click on register button
    Then confirm the redireted confirmation page

    Examples: 
      | ln | pass     |
      | K  | test@123 |
      | j  | test@123 |
