package lms.hackathon.ui.stepdefinitions;

import org.testng.Assert;

import lms.hackathon.ui.pageobjects.*;
import lms.hackathon.ui.utilities.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.hackathon.ui.utilities.TestContextSetUp;

public class BatchSteps {
	
	public BatchPage batchPage;
	TestContextSetUp testContextSetup;
	//Base base=new Base();
	//private BatchPage batchPage=new BatchPage(base.WebDriverManager());
	
	public BatchSteps(TestContextSetUp testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.batchPage=testContextSetup.pageObjManager.getBatchPage();
	}
	
//	@Given("Admin is on dashboard page after Login")
//	public void admin_is_on_dashboard_page_after_login() {
//	    
//	    batchPage.loginPage();
//	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) throws InterruptedException {
		batchPage.clickBatch();
	    
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string) {
	    
		Assert.assertTrue(batchPage.batchURL());
		
	}
		
	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String string) {
	    
	    batchPage.manageBatch();
		//Assert.assertEquals(batchPage.manageBatch(), "Batch");
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
	    
	    batchPage.paginationControl();
        Assert.assertTrue(batchPage.paginationControl());
	}

	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
	    
	    batchPage.headersBatch();
	}

	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
	    
	    batchPage.deleteDisable();
	    
	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {
	    
		// batchPage.aNewBatch();
		  Assert.assertTrue(batchPage.aNewBatch());
		    
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
	   
	  batchPage.rowWiseCheckBox();
	}

	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		batchPage.rowsEditButtonEnable();
	    
	    
	}

	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		batchPage.rowsDeleteButtonEnable();
	    
	}
	
	@Given("Admin is on batch page after Login")
	public void admin_is_on_batch_page_after_login() throws InterruptedException {
	    batchPage.loginPage();
	    batchPage.clickBatch();

		
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
		batchPage.clickNewBatch();
		
	}

	@Then("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears() {
		batchPage.popUpValidationBatchTitle();
		
	}
	

	@Then("The pop up should include the {string} as respective text boxs,radio button,dropdown")
	public void the_pop_up_should_include_the_as_respective_text_boxs_radio_button_dropdown(String string) {
	 batchPage.popUpFeildsValidtion();
	
	}


	@Given("A new pop up with Batch details appears after clicking add batch on BatchPage")
	public void a_new_pop_up_with_batch_details_appears_after_clicking_add_batch_on_batch_page() throws InterruptedException {

		batchPage.loginPage();
		batchPage.clickBatch();
		batchPage.clickNewBatch();
		
	}

	@When("Fill in all the {string},{string},{string} and {string} except description with valid values and click save")
	public void fill_in_all_the_and_except_description_with_valid_values_and_click_save(String string, String string2, String string3, String string4) throws InterruptedException {

		batchPage.enterFeildsExpectDesc();
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() {
        // Assert.assertTrue(batchPage.searchDescriptionMissingBatch());
	}

	@When("Fill in all the {string},{string},{string} and {string} with valid values and click save")
	public void fill_in_all_the_and_with_valid_values_and_click_save(String string, String string2, String string3, String string4) throws InterruptedException {
   
		
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page when you search")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page_when_you_search() {

	}

	@When("Fill in all the {string},{string},{string} and {string} with batch name invalid value and click save")
	public void fill_in_all_the_and_with_batch_name_invalid_value_and_click_save(String string, String string2, String string3, String string4) throws InterruptedException {
		 batchPage.batchCreateInvalidBatchName();
	}

	@Then("Error message should appear for batch name")
	public void error_message_should_appear_for_batch_name() throws InterruptedException {
		Assert.assertTrue( batchPage.batchCreateInvalidBatchName());
	}

	@When("Fill in all the {string},{string},{string} and {string} with program name empty value and click save")
	public void fill_in_all_the_and_with_program_name_empty_value_and_click_save(String string, String string2, String string3, String string4) throws InterruptedException {
    batchPage.batchCreateWithoutProgramName();
	}

	@Then("Error message should appear for program name")
	public void error_message_should_appear_for_program_name() throws InterruptedException {
		Assert.assertTrue( batchPage.batchCreateWithoutProgramName());


	}

	@Given("The delete icon on row level in data table is enabled after landing on batchpage")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled_after_landing_on_batchpage() throws InterruptedException {
		
		batchPage.loginPage();
	    batchPage.clickBatch();
		
	}

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		
		batchPage.deleteRowLevelAlertAppears();

	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() {
		
		Assert.assertTrue(batchPage.deleteRowLevelAlertAppears());

	}

	@Given("Admin clicks the delete icon for one batch after landing on batchpage")
	public void admin_clicks_the_delete_icon_for_one_batch_after_landing_on_batchpage() throws InterruptedException {
		batchPage.loginPage();
	    batchPage.clickBatch();
	}

	@When("Admin click yes option")
	public void admin_click_yes_option() throws InterruptedException {
		batchPage.acceptAlertForDeleteWithCheck();
		
	}

	@Then("Batch deleted alert pops and batch is no more available in the data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_the_data_table() {
		Assert.assertTrue(batchPage.acceptAlertForDeleteWithCheck());

	}

	@Given("Admin clicks the delete icon for another batch after landing on batchpage")
	public void admin_clicks_the_delete_icon_for_another_batch_after_landing_on_batchpage() throws InterruptedException {
		batchPage.loginPage();
	    batchPage.clickBatch();

	}

	@When("Admin click No option")
	public void admin_click_no_option() throws InterruptedException {
		batchPage.rejectAlertForDelete();

	}

	@Then("Batch is still listed in data table after searching")
	public void batch_is_still_listed_in_data_table_after_searching() throws InterruptedException {
		Assert.assertTrue(batchPage.rejectAlertForDelete());


	}

	@Given("None of the checkboxes in data table are selected after landing on batchpage")
	public void none_of_the_checkboxes_in_data_table_are_selected_after_landing_on_batchpage() throws InterruptedException {
		batchPage.loginPage();
	    batchPage.clickBatch();

	}

	@Then("The delete icon under the {string} header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled(String string) {
     Assert.assertTrue(batchPage.deleteDisable());
	}

	@Given("One of the checkbox of row is selected after landing on batchpage")
	public void one_of_the_checkbox_of_row_is_selected_after_landing_on_batchpage() throws InterruptedException {
		batchPage.loginPage();
	    batchPage.clickBatch();

	}

	@When("Click delete icon below {string} header")
	public void click_delete_icon_below_header(String string) throws InterruptedException {
		batchPage.singleBatchDelete();
	    

	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() throws InterruptedException {
		Assert.assertTrue(batchPage.singleBatchDelete());
	}

	@Given("Two or more checkboxes of row is selected after landing on batchpage")
	public void two_or_more_checkboxes_of_row_is_selected_after_landing_on_batchpage() throws InterruptedException {
		batchPage.loginPage();
	    batchPage.clickBatch();
	}

	@Then("The respective row in the data table is deleted for selected rows")
	public void the_respective_row_in_the_data_table_is_deleted_for_selected_rows() {
    batchPage.multipleBatchDelete();
	}

	@Given("The edit icon on row level in data table is enabled after landing on batchpage")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled_after_landing_on_batchpage() throws InterruptedException {
		batchPage.loginPage();
	    batchPage.clickBatch();
		
	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
		batchPage.rowsEditButtonEnable();
	}

	@Given("Admin clicks the edit icon after landing on batchpage")
	public void admin_clicks_the_edit_icon_after_landing_on_batchpage() throws InterruptedException {
		batchPage.loginPage();
	    batchPage.clickBatch();
	}

	@When("Update the fields {string},{string},{string} and {string}  click save")
	public void update_the_fields_and_click_save(String string, String string2, String string3, String string4) {
		batchPage.editBatchWithValidData();
	}

	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() {
		Assert.assertTrue(batchPage.editBatchWithValidData());
	}

	@When("Update the fields {string},{string},{string} and {string} with invalid description click save")
	public void update_the_fields_and_with_invalid_description_click_save(String string, String string2, String string3, String string4) throws InterruptedException {
	batchPage.editBatchWithInvalidDesc();
	}

	@Then("Error message should appear")
	public void error_message_should_appear()  {
		//Assert.assertThrows(batchPage.editBatchWithInvalidDesc());
	}

	@When("Update the fields {string},{string},{string} and {string} with no noOfClasses click save")
	public void update_the_fields_and_with_no_noOfClasses_click_save(String string, String string2, String string3, String string4) throws InterruptedException {
		batchPage.editBatchWithEmptyNoOfClasses();
	}

	@Then("Error message should appear for mandatory fields")
	public void error_message_should_appear_for_mandatory_fields() {
	}

	@When("Update the fields {string},{string},{string} and {string} with no description click save")
	public void update_the_fields_and_with_no_description_click_save(String string, String string2, String string3, String string4) throws InterruptedException {

     batchPage.editBatchWithEmptyDesc();
	}


}
