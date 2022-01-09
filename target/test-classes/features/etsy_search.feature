@etsy @regression #this is a tag (also notice the hash symbol for notes in features file)
Feature: User etsy search
  As a user, when I search for item, I should see the results

  Scenario: User searches for wooden spoon
    Given User is on Etsy homepage
    Then page title should be as expected
    When User searches for wooden spoon page
    Then page title should start with wooden spoon

  Scenario: Users empty search
    Given User is on Etsy homepage
    Then page title should be as expected
    When User searches for empty value
    Then all search categories should be displayed