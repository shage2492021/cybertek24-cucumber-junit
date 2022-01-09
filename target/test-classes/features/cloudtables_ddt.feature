@cloudtable
  Feature: DDT examples with Cloudtable

    Scenario Outline: Adding multiple users to the table
        Given User is on cloudtables homepage
        When User clicks on New button
        When User enters "<firstName>" to first name field
        And User enters "<lastName>" to last name field
        And User enters "<position>" to position field
        And User enters "<salary>" to salary field
        And User clicks on create button
          Examples:
            |firstName  |lastName  |position      |salary|
            |Janina     |R         |SDET          |105000|
  #          |Nisso      |U         |Engineer      |150000|   # note how to comment in feature files
            |Kamila     |S         |Developer     |130000|
            |Fahima     |E         |UI Developer  |180000|
            |Adalet     |P         |Scrum Master  |200000|
            |Naserahmad |J         |PO            |130000|
