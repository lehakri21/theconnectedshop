Feature: Registration Functionality

  Scenario: User can register a new account
    Given I am on the registration page
    When I enter the following details:
      | First Name | John     |
      | Last Name  | Doe      |
      | Email      | johndoe235@example.com |
      | Password   | mypassword |
    And I click on the Register button
#    Then I check Title
#    And I check qurrent url
    And Close browser

