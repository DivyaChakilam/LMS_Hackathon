@DashboardPage
Feature: Dashboard Page
  #BackGround: Admin gives the correct LMS portal URL
@DashboardPage-01
  Scenario: Verify after login  admin lands on manage program as dashboard page
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then Admin should see manage program as header 
    
@DashboardPage-02
  Scenario: Verify the response time
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then  Maximum navigation time in milliseconds, defaults to 30 seconds
    
@DashboardPage-03
  Scenario: Verify broken link
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then  HTTP response >= 400. Then the link is broken
    
@DashboardPage-04
  Scenario: Verify LMS title 
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then  Admin should see LMS - Learning management system  as title 

@DashboardPage-05
  Scenario: Verify  LMS title alignment
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then  LMS title should be on the top left corner of page

@DashboardPage-06
  Scenario: Validate navigation bar text
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then  Admin should see correct spelling in navigation bar text
    
@DashboardPage-07
  Scenario: Validate LMS title has correct spelling and space
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then  Admin should see correct spelling and space in LMS title
    
@DashboardPage-08
  Scenario: Validate alignment for navigation bar
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then  Admin should see the navigation bar text on the top right side
 
@DashboardPage-09   
 Scenario: Validate navigation bar order  1st Program
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then Admin should see program in the 1st place
    
@DashboardPage-10  
 Scenario: Validate navigation bar order  2nd Batch
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then Admin should see batch in the 2nd place 
    
@DashboardPage-11 
 Scenario: Validate navigation bar order 3rd User
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then Admin should see user in the  3rd place
    
@DashboardPage-12 
 Scenario: Validate navigation bar order 4th Logout 
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    Then Admin should see logout in the 4th place
    
@DashboardPage-13 
Scenario: Verify Logout button function
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button 
    And Admin click Logout button on navigation bar
    Then Admin should land on the home page
    
     