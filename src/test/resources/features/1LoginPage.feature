#gitproject
@loginPageVerfication
Feature: Login Page Verification
Background: Luanching Valid LMS URL
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
 
  @loginPage-01
  Scenario: Verify Admin is able to land on Home page with valid URL
    Then Admin should land on the home page

 @loginPage-02
  Scenario: Verify Broken links in the Home page
    Then HTTP response >= 400. Then the link is broken
    
  @loginPage-03
  Scenario: Verify the text spelling in every field in the Home page  
    Then Admin should see correct spellings in all fields 

	
	@loginPage-04
	 Scenario: Verify the Login Content on the Home page  
    Then Admin should see "Please login to LMS application"
    
  @loginPage-05
	 Scenario: Verify the Text fields count on the Home page  
     Then Admin should see 2 text field

	@loginPage-06
	 Scenario: Verify the see First Text field "User" on the Home page  
    Then Admin should see "User" in the first text field
    
  @loginPage-07
   Scenario: Verify asterik next to user text
     Then Admin should see * symbol next to user text

	@loginPage-08
	 Scenario: Verify the Second Text field "password" on the Home page  
    Then Admin should see "Password" in the second text field
	
	@loginPage-09
   Scenario: Verify asterik next to password text
    Then Admin should see * symbol next to password text

	@loginPage-10
	Scenario: Verify the alignment of input field for the login
    Then Admin should see input field on the centre of the page
    
  @loginPage-11
	Scenario: Verify the Login Button visibility on the Home page
    Then Admin should see login button 

	@loginPage-12
	Scenario: Verify the alignment of the Login Button
    Then Admin should see login button on the centre of the page
    
   @loginPage-13
	Scenario: Verify input descriptive test in user field
    Then Admin should see user in gray color
    
    @loginPage-14
	Scenario: Verify input descriptive test in password field
    Then Admin should see password in gray color

	 @loginPage-15
  Scenario Outline: Validate login with valid credentials
    Given Admin is in Home Page
    When Admin enter valid credentials "<SheetName>" and row <Rownumber> and clicks login button 
    Then Admin should land on dashboard page

  Examples: 
      | SheetName    | Rownumber | 
      | LoginData    |     0     |
      
    @loginPage-16
  Scenario Outline: Validate login with invalid credentials
    Given Admin is in Home Page
    When Admin enter invalid credentials "<SheetName>" and row <Rownumber> and clicks login button 
    Then validate Error message please check username/password
    
    Examples: 
      | SheetName    | Rownumber | 
      | LoginData    |     1     |
      | LoginData    |     2     |
      | LoginData    |     3     |
      
      @loginPage-17
    Scenario Outline: Validate login with Null user in the Field
    Given Admin is in Home Page
    When Admin enter null user "<SheetName>" and row <Rownumber> and clicks login button 
    Then validate Error message please enter your username/password
    
    Examples: 
     | SheetName    | Rownumber | 
     | LoginData    |     5     |
    
    
      @loginPage-18
    Scenario Outline: Validate login with Null password in the Field
    Given Admin is in Home Page
    When Admin enter null password "<SheetName>" and row <Rownumber> and clicks login button 
    Then Password Field turns into red color
     Examples: 
      | SheetName    | Rownumber | 
      | LoginData    |     4     |
      
    @loginPage-19
  Scenario Outline: verify login button action through keyboard
    Given Admin is in Home Page
    When Admin enter valid credentials "<SheetName>" and row <Rownumber> and clicks login button through keyboard 
    Then Admin should land on dashboard page
    
     Examples: 
      | SheetName    | Rownumber | 
      | LoginData    |     0     |
    
     @loginPage-20
  Scenario Outline: verify login button action through mouse
    Given Admin is in Home Page
    When Admin enter valid credentials "<SheetName>" and row <Rownumber> and clicks login button through mouse
    Then Admin should land on dashboard page
    
     Examples: 
      | SheetName    | Rownumber | 
      | LoginData    |     0     |
      
      
    #  loginPage-21
  #Scenario: Verify Admin is able to land on Home page with invalid URL
   # Given Admin launch the browser
   # When Admin gives the invalid LMS portal URL
   # Then Admin should recieve 404 page not found error 

