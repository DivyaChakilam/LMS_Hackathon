package lms.hackathon.ui.stepdefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.hackathon.ui.pageobjects.LoginPage;
import lms.hackathon.ui.utilities.ExcelReader;
import lms.hackathon.ui.utilities.TestContextSetUp;

public class LoginSteps {

	public LoginPage loginpage;
	TestContextSetUp testContSetup;
	public String expTitle = "LMS";
	public int rowNum;
	public String message;
	public String message2;
	public String userFieldColor;
	public String passwordFieldColor;

	public LoginSteps(TestContextSetUp testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
		

	}
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		System.out.println("Admin launched the browser");
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		// admins entered url
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
		System.out.println("Admin landed on the home page");
		Assert.assertEquals(loginpage.getTitleName(), expTitle);
	}

	@Then("HTTP response >= {int}. Then the link is broken")
		public void http_response_then_the_link_is_broken(Integer expectedResponsecode) throws MalformedURLException, IOException {
			int resCode = loginpage.actualResponseCode();
			Assert.assertFalse(resCode >= expectedResponsecode, "The link is broken");
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() throws IOException {
		loginpage.fieldsSpellCheck();
	}

	@Then("Admin should see logo on the left side")
	public void admin_should_see_logo_on_the_left_side() {

	}

	@Then("Admin should see LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {

	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {

	}

	@Then("Admin should see {string}")
	public void admin_should_see(String loginMess) {
		Assert.assertEquals(loginpage.getLoginMess(), loginMess);
	}

	@Then("Admin should see {int} text field")
	public void admin_should_see_two_text_field(int textFieldsCount) {
		Assert.assertEquals(loginpage.getTextFieldsCount(), textFieldsCount);
	}

	@Then("Admin should see {string} in the first text field")
	public void admin_should_in_the_first_text_field(String user) {
		Assert.assertEquals(loginpage.getFirstField(), user);

	}

	@Then("Admin should see * symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text() {
	
		Assert.assertEquals(loginpage.verifyUserAstrik(), "*");
	}
	
	@Then("Admin should see {string} in the second text field")
	public void admin_should_in_the_second_text_field(String password) {
		Assert.assertEquals(loginpage.getSecondField(), password);

	}

	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		Assert.assertEquals(loginpage.verifyPasswordAstrik(), "*");
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		loginpage.verifyInputFieldAlignment();
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		Assert.assertTrue(loginpage.loginButtonVisibility());
	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
		loginpage.verifyLoginButtonAlignment();
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		loginpage.verifyUserFieldColor();
		Assert.assertEquals("#000000", loginpage.actualColor);
		System.out.println("The Hex value for gray color is #000000 : The text is in gray color");
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		loginpage.verifyPasswordFieldColor();
		Assert.assertEquals("#000000", loginpage.actualColor);
		System.out.println("The Hex value for gray color is #000000 : The text is in gray color");
	}

	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
		
		  System.out.println("Admin entered valid url and landed on home page");
	}
	
	
	//Admin enters valid data
	@When("Admin enter valid credentials {string} and row {int} and clicks login button")
	public void admin_enter_valid_credentials_and_row_and_clicks_login_button(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {

		
		  rowNum=rowNumber; 
		  ExcelReader reader = new ExcelReader();
		  List<Map<String,String>> userData =
		  reader.getData("src/test/resources/testData/LMSLoginData.xlsx", sheetName);
		  System.out.println(userData.toString());
		  
		  String heading = userData.get(rowNumber).get("subjectheading");
		  System.out.println("Hearder: "+heading); 
		  String Username = userData.get(rowNumber).get("UserName");
		  System.out.println("username: "+Username);
		  
		  String Password = userData.get(rowNumber).get("Password");
		  System.out.println("password :"+Password);
		  
		  
		  //message = userData.get(rowNumber).get("Message");
		 // System.out.println("Expected message: "+Message);
		  
		  loginpage.enterUsername(Username); 
		  loginpage.enterPassword(Password);
		  loginpage.submitLogin();
		  Thread.sleep(500);
		  
		 
	}
	
	
	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	
		//confirming admin is on dashboard page by checking the logout button visibility
		Assert.assertTrue(loginpage.logoutButtonVisibility());
		
	}

	//admin enters atleast 1 invalid data
	@When("Admin enter invalid credentials {string} and row {int} and clicks login button")
	public void admin_enter_invalid_credentials_and_row_and_clicks_login_button(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		
		  rowNum=rowNumber; ExcelReader reader = new ExcelReader();
		  List<Map<String,String>> userData =
		  reader.getData("src/test/resources/testData/LMSLoginData.xlsx", sheetName);
		  System.out.println(userData.toString());
		  
		  String heading = userData.get(rowNumber).get("subjectheading");
		  System.out.println("Hearder: "+heading); String Username =
		  userData.get(rowNumber).get("UserName");
		  System.out.println("username: "+Username);
		  
		  String Password = userData.get(rowNumber).get("Password");
		  System.out.println("password :"+Password);
		  
		  
		  message = userData.get(rowNumber).get("ErrorMessage1");
		  System.out.println("Expected message: "+message);
		  
		  loginpage.enterUsername(Username); loginpage.enterPassword(Password);
		  loginpage.submitLogin();
		  Thread.sleep(200);
		  
		 
	}
	
	@Then("validate Error message please check username\\/password")
	public void validate_error_message_please_check_username_password() {
		
		Assert.assertEquals(loginpage.errorMeassageValidation(),message.trim());
	
	}
	
	
	//admin enters valid data through keyboard
	@When("Admin enter valid credentials {string} and row {int} and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_row_and_clicks_login_button_through_keyboard(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		rowNum=rowNumber; ExcelReader reader = new ExcelReader();
		  List<Map<String,String>> userData =
		  reader.getData("src/test/resources/testData/LMSLoginData.xlsx", sheetName);
		  System.out.println(userData.toString());
		  
		  String heading = userData.get(rowNumber).get("subjectheading");
		  System.out.println("Hearder: "+heading); 
		  String Username = userData.get(rowNumber).get("UserName");
		  System.out.println("username: "+Username);
		  
		  String Password = userData.get(rowNumber).get("Password");
		  System.out.println("password :"+Password);
		  
		  
		  //message = userData.get(rowNumber).get("Message");
		 // System.out.println("Expected message: "+Message);
		  loginpage.loginActionUsingKeyboard(Username,Password);
		  Thread.sleep(500);
		  
	}

	//admin enters valid data through mouse
	@When("Admin enter valid credentials {string} and row {int} and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_row_and_clicks_login_button_through_mouse(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		rowNum=rowNumber; ExcelReader reader = new ExcelReader();
		  List<Map<String,String>> userData =
		  reader.getData("src/test/resources/testData/LMSLoginData.xlsx", sheetName);
		  System.out.println(userData.toString());
		  
		  String heading = userData.get(rowNumber).get("subjectheading");
		  System.out.println("Hearder: "+heading); 
		  String Username = userData.get(rowNumber).get("UserName");
		  System.out.println("username: "+Username);
		  
		  String Password = userData.get(rowNumber).get("Password");
		  System.out.println("password :"+Password);
		  
		  loginpage.enterUsername(Username); loginpage.enterPassword(Password);
		  //Thread.sleep(200);
		  loginpage.loginActionUsingMouse();
		  Thread.sleep(200);
		  
		  
	}

	
}