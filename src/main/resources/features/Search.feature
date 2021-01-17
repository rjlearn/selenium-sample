Feature: As a user, I want to search Google, so that I can view results

  Scenario: Search with text to view options
    Given User is on "http://www.google.com"
    When User searches with string "cucumber"
    Then Instant search results should in the search keyword "cucumber"