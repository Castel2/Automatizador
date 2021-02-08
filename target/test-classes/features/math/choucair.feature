Feature: ChoucairTesting
    
Scenario: Sign In
    Given I want to log in with admin@phptravels.com demoadmin
    When I enter my account
    Then I find my information

Scenario: New Category
    Given I want to create a new category
    When I create the category
    Then a new category is created
    
Scenario: New Posts
    Given I want to create a new posts
    When I create the posts
    Then a new posts is created