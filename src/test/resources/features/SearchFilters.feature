@SearchFilterTests  @AllTests
Feature: As a user I want to filter my search result so I can narrow down to what suits my needs

  @Test-3
  Scenario: Verify user can apply single filter to search results
    Given RS Components homepage is displayed
    When I search for 'monitors'
    And I apply filter for 'Samsung' 'Brand'
    Then I verify filter is present in filters breadcrumbs
    And I verify displayed results are correct
    And I verify the total search results for the applied filter

  @Test-4
  Scenario: Verify user can apply multiple filters to search results
    Given RS Components homepage is displayed
    When I search for 'camera'
    And I apply filter for 'Canon' 'Brand'
    And I apply another filter for 'Compact' 'Camera Type'
    Then I verify multiple filters is applied
    And I verify the total search results for the applied filter

  @Test-5
  Scenario: Verify user can remove all applied filters
    Given RS Components homepage is displayed
    And I search for 'clock'
    And I apply filter for 'Analogue' 'Display'
    And I apply another filter for 'AA' 'Battery Type'
    When I remove all filters
    Then I verify all filters is moved



