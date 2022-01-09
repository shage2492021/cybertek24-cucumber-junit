@lyft
Feature: Lyft fare estimate
  Agile Story: As a rider , I should be able to enter pickup and drop off locations so that I can see the estimated fare

  Scenario: Fare estimate using City
    Given User is on lyft fare estimate page
    When User enters "McLean, VA, USA" to pickup address
    And User enters "Woodbridge, VA, USA" to drop-off address
    And User clicks on get estimate button
    Then User should see estimated prices

  Scenario: Fare estimate using Full Address
    Given User is on lyft fare estimate page
    When User enters "1331 Cleveland Ave, Loveland, CO 80537" to pickup address
    And User enters "2150 Joseph Allen Dr, Fort Collins, CO" to drop-off address
    And User clicks on get estimate button
    Then User should see estimated prices

  Scenario: Fare estimate using empty should show error
    Given User is on lyft fare estimate page
    When User enters "" to pickup address
    And User enters "" to drop-off address
    And User clicks on get estimate button
    Then User should see estimated prices