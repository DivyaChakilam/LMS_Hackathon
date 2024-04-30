#gitproject
@loginPageVerfication
Feature: Login Page Verification
Background: Luanching Valid LMS URL
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
 
  @landsOnHome
  Scenario: Verify Admin is able to land on Home page with valid URL
    Then Admin should land on the home page

  @brokenLinksCheck
  Scenario: Verify Broken links in the Home page
    Then HTTP response >= 400. Then the link is broken
    
    @textSpellingCheck
  Scenario: Verify the text spelling in every field in the Home page  
    Then Admin should see correct spellings in all fields 

	
	@verifyloginContent
	 Scenario: Verify the Login Content on the Home page  
    Then Admin should see "Please login to LMS application"
    
   @verifyTextFields
	 Scenario: Verify the Text fields count on the Home page  
     Then Admin should see 2 text field

	@verifyFirstTextField
	 Scenario: Verify the see First Text field "User" on the Home page  
    Then Admin should see "User" in the first text field
    
  @verifyUserasterik 
   Scenario: Verify asterik next to user text
     Then Admin should see * symbol next to user text

	@verifySecondTextField
	 Scenario: Verify the Second Text field "password" on the Home page  
    Then Admin should see "Password" in the second text field
	
	 @verifyPwdasterik 
   Scenario: Verify asterik next to password text
    Then Admin should see * symbol next to password text

	@inputFieldsAllignment
	Scenario: Verify the alignment of input field for the login
    Then Admin should see input field on the centre of the page
    
    @loginBtnCheck
	Scenario: Verify the Login Button visibility on the Home page
    Then Admin should see login button 

	@loginBtnAllignment
	Scenario: Verify the alignment of the Login Button
    Then Admin should see login button on the centre of the page
    
   @userFieldDesc
	Scenario: Verify input descriptive test in user field
    Then Admin should see user in gray color
    
   @passwordFieldDesc
	Scenario: Verify input descriptive test in password field
    Then Admin should see password in gray color

	@validLogin
  Scenario Outline: Validate login with valid credentials
    Given Admin is in Home Page
    When Admin enter valid credentials "<SheetName>" and row <Rownumber> and clicks login button 
    Then Admin should land on dashboard page

  Examples: 
      | SheetName    | Rownumber | 
      | LoginData    |     0     |
      
   @invalidLogin
  Scenario Outline: Validate login with invalid credentials
    Given Admin is in Home Page
    When Admin enter invalid credentials "<SheetName>" and row <Rownumber> and clicks login button 
    Then validate Error message please check username/password
    
    Examples: 
      | SheetName    | Rownumber | 
      | LoginData    |     1     |
      | LoginData    |     2     |
      | LoginData    |     3     |
      
    @loginButtonKeyboardClick
  Scenario Outline: verify login button action through keyboard
    Given Admin is in Home Page
    When Admin enter valid credentials "<SheetName>" and row <Rownumber> and clicks login button through keyboard 
    Then Admin should land on dashboard page
    
     Examples: 
      | SheetName    | Rownumber | 
      | LoginData    |     0     |
    
    @loginButtonMouseClick
  Scenario Outline: verify login button action through mouse
    Given Admin is in Home Page
    When Admin enter valid credentials "<SheetName>" and row <Rownumber> and clicks login button through mouse
    Then Admin should land on dashboard page
    
     Examples: 
      | SheetName    | Rownumber | 
      | LoginData    |     0     |
      
      
    #  @invalidURL
  #Scenario: Verify Admin is able to land on Home page with invalid URL
   # Given Admin launch the browser
   # When Admin gives the invalid LMS portal URL
   # Then Admin should recieve 404 page not found error 
    
    
    
