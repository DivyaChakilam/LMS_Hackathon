package lms.hackathon.ui.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.hackathon.ui.pageobjects.CommonPage;
import lms.hackathon.ui.utilities.TestContextSetUp;

public class CommonSteps {
	public CommonPage commonPage;
	public TestContextSetUp testContextSetUp;
	
	public CommonSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		commonPage = testContextSetUp.pageObjManager.getCommonPage();
	}

	@When("Admin clicks on ID sort icon")
	public void admin_clicks_on_id_sort_icon() {
		
	}

	@Then("Admin should see User details are sorted by {string} column {string}")
	public void admin_should_see_user_details_are_sorted_by_column(String field, String column) {
		try {
			commonPage.sortByField(field,Integer.valueOf(column));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}