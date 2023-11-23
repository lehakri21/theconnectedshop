Feature: Open HomePage and Title and Quent url

  Scenario: Check open HomePage
    Given I open on theconnectedshop.com homepage
    Then I check Title
    And I check qurrent url
    And Close browser

  Scenario: Verify the homepage elements
    Given I open on theconnectedshop.com homepage
    Then I check the logo
    And I check main manu
    And Close browser
