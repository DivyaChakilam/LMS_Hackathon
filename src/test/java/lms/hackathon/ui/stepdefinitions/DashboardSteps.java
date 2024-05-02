package lms.hackathon.ui.stepdefinitions;


import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import lms.hackathon.ui.pageobjects.DashboardPage;
import lms.hackathon.ui.utilities.LoggerLoad;
import lms.hackathon.ui.utilities.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {

	public DashboardPage dashboardPage;
	public TestContextSetUp testContextSetUp;

	public DashboardSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.dashboardPage = testContextSetUp.pageObjManager.getDashboardPage();
	}
	//@DashboardPage-01
	/*
	 * @Given("Admin is in Home Page") public void admin_is_in_home_page() {
	 * LoggerLoad.info("Admin is in login page"); }
	 */

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		LoggerLoad.info("Admin is trying to login ");
		String userName = testContextSetUp.base.configs.getUserName();
		String password = testContextSetUp.base.configs.getPassword();
		dashboardPage.dashlogin(userName, password);

	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {

		String valtext = dashboardPage.validateModuleHeader();
		//LoggerLoad.info(valtext);
		LoggerLoad.info("Admin should see: \" " +valtext+ "\" as header");
		Assert.assertEquals(valtext, "Manage Program", "Title do not match");

	}
	//@DashboardPage-02
	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer expectedTimeoutSeconds) {

		dashboardPage.verifyMaximumNavigationTime(expectedTimeoutSeconds);
		boolean isTimeoutCorrect = dashboardPage.verifyMaximumNavigationTime(expectedTimeoutSeconds);
		if (isTimeoutCorrect) {
			LoggerLoad.info("Timeout validation passed!");
		} else {
			LoggerLoad.info("Timeout validation failed!");
			LoggerLoad.info("Expected Timeout (seconds): " + expectedTimeoutSeconds);
			LoggerLoad.info("Actual Timeout (seconds): " + dashboardPage.getActualWaitTime());
		}
	}

	//@DashboardPage-03
	/*
	 * @Then("HTTP response >= {int}. Then the link is broken") public void
	 * http_response_then_the_link_is_broken(Integer expectedResponsecode) throws
	 * MalformedURLException, IOException { int resCode =
	 * dashboardPage.actualResponseCode(); //assertEquals(resCode,
	 * expectedResponsecode,"Response code matches, the above link is broken");
	 * Assert.assertTrue(resCode < expectedResponsecode, "The link is not broken");
	 * }
	 */

	//@DashboardPage-04
	@Then("Admin should see LMS - Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		LoggerLoad.info("Admin should see LMS - Learning management system  as title");
		Boolean Title = dashboardPage.titleOfPageISdispalyed();	
		if(Title) {
			LoggerLoad.info("Title of the Page : is displayed");


		}
		//dashboardPage.verifyLMSTitle();
	}

	//@DashboardPage-05
	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		int loc = dashboardPage.titleLocation();
		if (loc == 1) {
			LoggerLoad.info("LMS title is on the top left corner");
		}
		else {
			LoggerLoad.info("LMS title is not on the top left corner");
		}		
	}

	//@DashboardPage-06
	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() throws IOException {

		dashboardPage.navBarfieldsSpellCheck();
	}

	//@DashboardPage-07
	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() throws IOException {

		dashboardPage.titleSpellCheckSpaceCheck();

	}

	//@DashboardPage-08
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {

		//dashboardPage.navigationBarLocation();
		int navloc = dashboardPage.navigationBarLocation();
		if (navloc == 1) {
			LoggerLoad.info("Navigation Bar is on the top left corner");
		}
		else {
			LoggerLoad.info("Navigation Bar is not on the top left corner");
		}		
	}

	//@DashboardPage-09 
	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() {

		//dashboardPage.navigationBarOrderOne();
		String valtext = dashboardPage.navigationBarOrderOne();
		Assert.assertEquals(valtext, "Program", "Title matches ");
	}

	//@DashboardPage-10 
	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() {
		//dashboardPage.navigationBarOrderTwo();
		String valtext = dashboardPage.navigationBarOrderTwo();
		Assert.assertEquals(valtext, "Batch", "Title matches ");
	}

	//@DashboardPage-11
	@Then("Admin should see user in the  3rd place")
	public void admin_should_see_user_in_the_3rd_place() {

		String valtext = dashboardPage.navigationBarOrderThree();
		Assert.assertEquals(valtext, "User", "Title matches ");
	}

	//@DashboardPage-12
	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() {

		String valtext = dashboardPage.navigationBarOrderfour();
		Assert.assertEquals(valtext, "Logout", "Title matches ");
	}

	//@DashboardPage-13
	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {

		dashboardPage.clickLogout();
		LoggerLoad.info("Admin is able to click Logout button");
	}


}
