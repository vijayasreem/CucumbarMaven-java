Feature: Search for item

  @tag1
  Scenario: search for item in amazon site
    Given User Launch chrome browser
    And I navigate to "https://www.amazon.in/"
    When I search for an item "<item_name>"
    Then I should see items based on my search keyword
    And I close browser
   Examples:
   |item_name|
   |mobile|
   