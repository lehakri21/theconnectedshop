Feature: Negative cases for registration

  Scenario: Email should be unique
    Given I am on the negar page
    When I enter the following details:
      | First Name | John     |
      | Last Name  | Doe      |
      | Email      | johndoe237@example.com |
      | Password   | mypassword |
    And I click on the Register button
    Then It is displayed error validation that email is unique

#    Then I check Title
#    And I check qurrent url
    And Close browser


  Scenario: Password is short
    Given I am on the registration page
    When I enter the following details:
      | First Name | John     |
      | Last Name  | Doe      |
      | Email      | johndoe245@example.com |
      | Password   | 28 |
    And I click on the Register button
    Then It is displayed error validation that password is invalid

#    Then I check Title
#    And I check qurrent url
    And Close browser