@percent
Feature: Calculate 5% multiple values
  Agile Story: As a user, I should be able to calculate 5% of multiple values

  Scenario: User calculating 5% values
    Given User is on percentage calculator page
    Then User should see following calculations:
      |100|5|
      |500|25|
      |1300|65|
      |2100|105|