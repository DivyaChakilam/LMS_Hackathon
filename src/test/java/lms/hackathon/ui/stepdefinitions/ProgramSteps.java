package lms.hackathon.ui.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.hackathon.ui.pageobjects.ProgramPage;
import lms.hackathon.ui.utilities.LoggerLoad;
import lms.hackathon.ui.utilities.TestContextSetUp;

public class ProgramSteps {

	TestContextSetUp testContextSetUp ;
	public ProgramPage programPage;
	
	String newProgramName="";
	String programNameBeforeEdit="";
	String programDescriptionBeforeEdit="";
	String actualErrorMsg_programName="";
	String actualErrorMsg_programDescription="";
	String actualErrorMsg_programStatus="";
	String programName_to_delete="";
	List<String> actualList= new ArrayList<String>();
	
	public ProgramSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.programPage = testContextSetUp.pageObjManager.getProgramPage();
	}
	//@Program_S1
//	@Given("Admin is in Home Page")
//	public void admin_is_in_home_page() {
//		LoggerLoad.info("Landed on homepage");
//	}

	@When("Admin enter valid credentials and clicks login button to test program page")
	public void admin_enter_valid_credentials_and_clicks_login_button_to_test_program_page() {
		programPage.login();
	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {
	   //Assert.assertTrue(programPage.validate_programHeader());
		programPage.validate_programHeader();
	}
	//@Program_S2
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		programPage.getDashboardPage();
	}

	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_program_on_the_navigation_bar() {
	   programPage.click_on_programModule();
	   programPage.validate_programHeader();
	}
	
	@Then("Admin should see URL with Manage Program")
	public void admin_should_see_url_with_manage_program() {
		Assert.assertEquals(programPage.getCurrentURL(), programPage.expectedManageProgramURL, "URL validation failed");
	}
	//@Program_S3
	@Then("Admin should see a heading with text Manage Program on the page")
	public void admin_should_see_a_heading_with_text_manage_program_on_the_page() {
		 Assert.assertTrue(programPage.validate_programHeader());
	}
	//@Program_S4
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table() {
		Assert.assertTrue(programPage.validatePaginationFooterText());
	}
	//@Program_S5
	@Then("Admin should see the program footer as In total there are z programs")
	public void admin_should_see_the_program_footer_as_in_total_there_are_z_programs() {
		Assert.assertTrue(programPage.validateProgramFooterText());
	}
	//@Program_S6
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
	   Assert.assertTrue(programPage.validateDeleteButton());
	}
	//@Program_S7
	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String button) {
		Assert.assertTrue(programPage.isDisplayed(button));
	}
	//@Program_S8
	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer expectedCount) {
	  Assert.assertEquals(programPage.totalRecordsDisplayed(),expectedCount);
	}
	//@Program_S9
	@Then("Admin should see data table on the Manage Program Page with following column headers") 
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers(DataTable dataTable) {
	List<String> columnHeaders = dataTable.asList(String.class);
		for(String columnHeader : columnHeaders) {
			Assert.assertTrue(programPage.isDisplayed(columnHeader));
		}
	}
	//@Program_S10
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		Assert.assertTrue(programPage.isDisplayed("sort icon"));
	}
	//@Program_S11
	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
		Assert.assertTrue(programPage.isDisplayed("checkbox"));
	}
	//@Program_S12
	@Then("Admin should see the following buttons on each row of the data table")
	public void admin_should_see_the_following_buttons_on_each_row_of_the_data_table(DataTable dataTable) {
	   List<String> buttons = dataTable.asList(String.class);
		for(String button : buttons) {
			Assert.assertTrue(programPage.isDisplayed(button));
		}
	}
	//@Program_S13
	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String search) {
		Assert.assertTrue(programPage.isDisplayed("searchbar"));
	}
	
	//@Program_S14
	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() {
	   programPage.getManageProgramPage();
	}

	
	@When("Admin clicks A New Program button")
	public void admin_clicks_a_new_program_button() {
		programPage.click_on_newProgramButton();
	}
	
	@Then("Admin should see a popup open for Program details with empty form along with following buttons")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_following_buttons(DataTable elements) {
		List<String> buttons = elements.asList(String.class);
		for(String button : buttons) {
			Assert.assertTrue(programPage.isDisplayed(button));
		}
	}
	//@Program_S15
	@Then("Admin should see below two input fields and their respective text boxes in the program details window")
	public void admin_should_see_below_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window(DataTable elements) {
		List<String> buttons = elements.asList(String.class);
		for(String button : buttons) {
			Assert.assertTrue(programPage.isDisplayed(button));
		}
	}
	//@Program_S16
	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status(DataTable elements) {
		List<String> buttons = elements.asList(String.class);
		for(String button : buttons) {
			Assert.assertTrue(programPage.isDisplayed(button));
		}
	}
	//@Program_S17
	@Given("Admin is on Program Details Popup window")
	public void admin_is_on_program_details_popup_window() {
		programPage.getManageProgramPage();
		programPage.click_on_newProgramButton();
	}
	
	@When("Admin clicks Save button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
		programPage.click_on_saveProgramButton();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
	  
	   String expectedErrorMsg_programName= programPage.programNameRequiredErrMsg;
	   String expectedErrorMsg_programDescription=programPage.programDescriptionRequiredErrMsg;
	   String expectedErrorMsg_programStatus=programPage.programStatusRequiredErrMsg;
	   
	   actualErrorMsg_programName = programPage.getActualErrorMessage("Program name");
	   actualErrorMsg_programDescription = programPage.getActualErrorMessage("Description");
	   actualErrorMsg_programStatus = programPage.getActualErrorMessage("Status");
	   
	   LoggerLoad.info("Expected error message for program name : "+expectedErrorMsg_programName +
			   "\nActual error message for program name : "+actualErrorMsg_programName);
	   LoggerLoad.info("Expected error message for program description : "+expectedErrorMsg_programDescription +
			   "\nActual error message for program name : "+actualErrorMsg_programDescription);
	   LoggerLoad.info("Expected error message for program status : "+expectedErrorMsg_programStatus +
			   "\nActual error message for program name : "+actualErrorMsg_programStatus);
	   
	   Assert.assertEquals(actualErrorMsg_programName, expectedErrorMsg_programName);
	   Assert.assertEquals(actualErrorMsg_programDescription, expectedErrorMsg_programDescription);
	   Assert.assertEquals(actualErrorMsg_programStatus, expectedErrorMsg_programStatus);
	}
	
	//@Program_S18
	@When("Admin enters only Program Name in text box and clicks Save button")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
	  programPage.enterProgramName("valid");
	  programPage.click_on_saveProgramButton();
	}

	
	@Then("Admin gets a message alert Description is required")
	public void admin_gets_a_message_alert_description_is_required() {
		String expectedErrorMsg_programDescription=programPage.programDescriptionRequiredErrMsg;
		actualErrorMsg_programDescription = programPage.getActualErrorMessage("Description");
		
		LoggerLoad.info("Expected error message for program description : "+expectedErrorMsg_programDescription +
				   "\nActual error message for program name : "+actualErrorMsg_programDescription);
		
		Assert.assertEquals(actualErrorMsg_programDescription, expectedErrorMsg_programDescription);
	}
	//@Program_S19
	@When("Admin enters only Program description in text box and clicks Save button")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
		programPage.enterProgramDescription("valid");
		programPage.click_on_saveProgramButton();
	}
	
	@Then("Admin gets a message alert Program name is required")
	public void admin_gets_a_message_alert_program_name_is_required() {
		 String expectedErrorMsg_programName= programPage.programNameRequiredErrMsg;
		 actualErrorMsg_programName = programPage.getActualErrorMessage("Program name");
		 LoggerLoad.info("Expected error message for program name : "+expectedErrorMsg_programName +
				   "\nActual error message for program name : "+actualErrorMsg_programName);
		 Assert.assertEquals(actualErrorMsg_programName, expectedErrorMsg_programName);
	}

	
	//@Program_S20
	@When("Admin selects only Status and clicks Save button")
	public void admin_selects_only_status_and_clicks_save_button() {
		programPage.click_on_InactiveStatus();
		programPage.click_on_saveProgramButton();
		
	}
	
	@Then("Admin gets a message alert Name and Description required")
	public void admin_gets_a_message_alert_name_and_description_required() {
		 String expectedErrorMsg_programName= programPage.programNameRequiredErrMsg; 
		 String expectedErrorMsg_programDescription=programPage.programDescriptionRequiredErrMsg;
		 
		 actualErrorMsg_programName = programPage.getActualErrorMessage("Program name");
		 actualErrorMsg_programDescription = programPage.getActualErrorMessage("Description");
		 
		 LoggerLoad.info("Expected error message for program name : "+expectedErrorMsg_programName +
				   "\nActual error message for program name : "+actualErrorMsg_programName);
		 LoggerLoad.info("Expected error message for program description : "+expectedErrorMsg_programDescription +
				   "\nActual error message for program name : "+actualErrorMsg_programDescription);
		
		 Assert.assertEquals(actualErrorMsg_programName, expectedErrorMsg_programName);
		 Assert.assertEquals(actualErrorMsg_programDescription, expectedErrorMsg_programDescription);
	
	}
	//@Program_S21
	@When("Admin enters only numbers or special char in name and desc column")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column() {
		programPage.enterProgramName("onlynumbers");
		programPage.enterProgramDescription("onlyspecialcharacters");
	}

	@Then("Admin gets a Error message alert for invalid values")
	public void admin_gets_a_error_message_alert_for_invalid_values() {
		String expectedErrorMsg_programName= programPage.invalidProgramNameErrMsg; 
		String expectedErrorMsg_programDescription=programPage.invalidProgramDescriptionErrMsg;
		 
		actualErrorMsg_programName = programPage.getActualErrorMessage_invalidValues("Name");
		actualErrorMsg_programDescription = programPage.getActualErrorMessage_invalidValues("Description");
		 
		LoggerLoad.info("Expected error message for program name : "+expectedErrorMsg_programName +
				   "\nActual error message for program name : "+actualErrorMsg_programName);
		LoggerLoad.info("Expected error message for program description : "+expectedErrorMsg_programDescription +
				   "\nActual error message for program name : "+actualErrorMsg_programDescription);
		
		Assert.assertEquals(actualErrorMsg_programName, expectedErrorMsg_programName);
		Assert.assertEquals(actualErrorMsg_programDescription, expectedErrorMsg_programDescription);
	}
	//@Program_S22
	@When("Admin clicks CloseX Icon on Program Details form")
	public void admin_clicks_close_x_icon_on_program_details_form() {
	   programPage.click_on_closeXProgramButton();
	}

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {
	   Assert.assertFalse(programPage.isDisplayed("programdetailspopupwindowclosed"));
	}
	//@Program_S23
	@When("Enter all the required fields with valid values and click Save button")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button() {
		newProgramName = programPage.enterProgramName("valid");
		programPage.enterProgramDescription("valid");
		programPage.click_on_ActiveStatus();
		programPage.click_on_saveProgramButton();
	}

	@Then("Admin gets a message Successful Program Created alert and able to see the new program added in the data table")
	public void admin_gets_a_message_successful_program_created_alert_and_able_to_see_the_new_program_added_in_the_data_table() {
	 Assert.assertTrue(programPage.isDisplayed("successmsg"));
	 Assert.assertTrue(programPage.validate_programAddition(newProgramName));
	}
	//@Program_S24
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		programPage.click_on_cancelProgramButton();
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
		Assert.assertFalse(programPage.isDisplayed("programdetailspopupwindowclosed"));
	}
	
	//@Program_S25
	@Given("Admin is on Manage Program page to click on module link")
	public void admin_is_on_manage_program_page_to_click_on_module_link() {
		programPage.getManageProgramPage();
	}
	@When("Admin clicks on Batch link on Manage Program page")
	public void admin_clicks_on_batch_link_on_manage_program_page() {
	   programPage.click_on_batchModule();
	}

	@Then("Admin is re-directed to Batch page")
	public void admin_is_re_directed_to_batch_page() {
		Assert.assertTrue(programPage.validatePage("batch"));
	}
	//@Program_S26
	@When("Admin clicks on User link on Manage Program page")
	public void admin_clicks_on_user_link_on_manage_program_page() {
		 programPage.click_on_userModule();
	}

	@Then("Admin is re-directed to User page")
	public void admin_is_re_directed_to_user_page() {
		Assert.assertTrue(programPage.validatePage("user"));
	}
	
	//@Program_S27
	@When("Admin clicks Delete button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
	    programName_to_delete = programPage.deleteSingleRecord(1);
	}
	@Then("Admin should see a alert open with heading Confirm along with YES and NO button for deletion")
	public void admin_should_see_a_alert_open_with_heading_confirm_along_with_yes_and_no_button_for_deletion() {
		Assert.assertTrue(programPage.isDisplayed("ConfirmDeletionPopUp"));
		Assert.assertTrue(programPage.isDisplayed("DeletionPopUp_Yes"));
		Assert.assertTrue(programPage.isDisplayed("DeletionPopUp_No"));
	}
	
	//@Program_S28
	@Then("Admin should see a message Are you sure you want to delete Program name")
	public void admin_should_see_a_message_are_you_sure_you_want_to_delete_Program_name() {
	   String expectedMsg = programPage.expectedMsgDeletionPopUp + programName_to_delete;
	   LoggerLoad.info("Expected message on confirm program deletion pop up : "+expectedMsg);
	   Assert.assertTrue(programPage.validateConfirmDeletionMsg(programName_to_delete));
	}
	
	//@Program_S29
	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		programPage.getManageProgramPage();
		programName_to_delete = programPage.deleteSingleRecord(1);
	}
	@When("Admin clicks YES button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		programPage.click_on_YES_DeletionPopUp();
	}
	@Then("Admin gets a message Successful Program Deleted alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_successful_program_deleted_alert_and_able_to_see_that_program_deleted_in_the_data_table() {
		 Assert.assertTrue(programPage.isDisplayed("successmsg"));
	}
	
	//@Program_S30
	@When("Admin clicks NO button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
		programPage.click_on_NO_DeletionPopUp();
	}
	
	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		Assert.assertFalse(programPage.isDisplayed("confirmdeletionpopupclosed"));
	}
	
	//@Program_S31
	@When("Admin clicks CloseX Icon on Deletion alert")
	public void admin_clicks_cancel_close_x_icon_on_deletion_alert() {
	   programPage.click_on_CloseX_DeletionPopUp();
	}
	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
		Assert.assertFalse(programPage.isDisplayed("confirmdeletionpopupclosed"));
	}
	
	//@Program_S32
	@Given("Admin is in Manage Program page")
	public void admin_is_in_manage_program_page() {
		programPage.getManageProgramPage();
	}

	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
	   programPage.click_on_checkBox(1,1);
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		Assert.assertTrue(programPage.isEnabled("commonDeleteOption"));
		programPage.click_on_commonDeleteIcon();
	}

	//@Program_S33
	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
		programPage.waitForElementToBeVisible(programPage.program_Header);
		Assert.assertFalse(programPage.validateIfProgramNamePresentInTable(programName_to_delete));
	}

	//@Program_S34
	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {
		programPage.waitForElementToBeVisible(programPage.program_Header); 
		Assert.assertTrue(programPage.validateIfProgramNamePresentInTable(programName_to_delete));
	}

	//@Program_S35
	@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {
		Assert.assertTrue(programPage.isDisplayed("successmsg"));
		Assert.assertFalse(programPage.validateIfProgramNamePresentInTable(programName_to_delete));
	}

	//@Program_S36
	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() {
		Assert.assertFalse(programPage.validateIfProgramNamePresentInTable(programName_to_delete)); 
	}
	
	//@Program_S37
	@When("Admin clicks <Edit> button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
	   programPage.click_on_programEditIcon(1,3);
	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {
		Assert.assertTrue(programPage.isDisplayed("programdetailspopupwindow"));
	}

	//@Program_S38
	@Given("Admin is on Program Details Popup window to Edit")
	public void admin_is_on_program_details_popup_window_to_edit() {
		programPage.getManageProgramPage();
		programPage.click_on_programEditIcon(1,3);
		programPage.isDisplayed("programdetailspopupwindow");
	}

	@When("Admin edits the Name column and clicks save button")
	public void admin_edits_the_name_column_and_clicks_save_button() {
		programNameBeforeEdit = programPage.getProgramNameBeforeEdit();
	    newProgramName = programPage.enterProgramName("valid");
	    programPage.click_on_saveProgramButton();
	}

	@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) {
		 Assert.assertTrue(programPage.isDisplayed("successmsg"));
	}
	//@Program_S39
	@When("Admin edits the Description column and clicks save button")
	public void admin_edits_the_description_column_and_clicks_save_button() {
		programDescriptionBeforeEdit = programPage.getProgramDescriptionBeforeEdit();
	    programPage.enterProgramDescription("valid");
	    programPage.click_on_saveProgramButton();
	}

	@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {
		 Assert.assertTrue(programPage.isDisplayed("successmsg")); 
	}

	//@Program_S40
	@When("Admin changes the Status and clicks save button")
	public void admin_changes_the_status_and_clicks_save_button() {
	   programPage.click_on_InactiveStatus();
	   programPage.click_on_saveProgramButton();
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {
		 Assert.assertTrue(programPage.isDisplayed("successmsg")); 
	}

	//@Program_S41
	@When("Admin edits only numbers or special char in name and desc column")
	public void admin_edits_only_numbers_or_special_char_in_name_and_desc_column() {
		programPage.enterProgramName("onlynumbers");
		programPage.enterProgramDescription("onlyspecialcharacters");
	}
	@Then("Admin gets Error message alert for entering invalid values in text column")
	public void admin_gets_error_message_alert_for_entering_invalid_values_in_text_column() {
		String expectedErrorMsg_programName= programPage.invalidProgramNameErrMsg; 
		String expectedErrorMsg_programDescription=programPage.invalidProgramDescriptionErrMsg;
		 
		actualErrorMsg_programName = programPage.getActualErrorMessage_invalidValues("Name");
		actualErrorMsg_programDescription = programPage.getActualErrorMessage_invalidValues("Description");
		 
		LoggerLoad.info("Expected error message for program name : "+expectedErrorMsg_programName +
				   "\nActual error message for program name : "+actualErrorMsg_programName);
		LoggerLoad.info("Expected error message for program description : "+expectedErrorMsg_programDescription +
				   "\nActual error message for program name : "+actualErrorMsg_programDescription);
		
		Assert.assertEquals(actualErrorMsg_programName, expectedErrorMsg_programName);
		Assert.assertEquals(actualErrorMsg_programDescription, expectedErrorMsg_programDescription);
	
	}
	
	//@Program_S42
	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		programPage.click_on_cancelProgramButton();
	}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
		Assert.assertFalse(programPage.isDisplayed("programdetailspopupwindowclosed"));
	}

	//@Program_S43
	@When("Admin clicks Save button on edit popup")
	public void admin_clicks_save_button_on_edit_popup() {
	   programPage.click_on_saveProgramButton();
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) {
		Assert.assertTrue(programPage.isDisplayed("successmsg")); 
	}

	//@Program_S44
	@Given("Admin is on Manage Program page to sort Program Data table")
	public void admin_is_on_manage_program_page_to_sort_Program_Data_table() {
	  programPage.getManageProgramPage();
	}

	@When("Admin clicks the sort icon of program name column")
	public void admin_clicks_the_sort_icon_of_program_name_column() {
		programPage.click_on_sortIcon("Program Name ");
		actualList.clear();
		actualList = programPage.getListOfRecords("Program Name", 2);
		LoggerLoad.info("-------------------------------------------------");
		LoggerLoad.info("Actual List of Program Names: ");
		LoggerLoad.info("-------------------------------------------------");
		for(String str : actualList) {
			LoggerLoad.info(str);
		}
	}

	@Then("The data get sorted on the table based on the program name column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {
		Assert.assertTrue(programPage.validateIfSortedInAscendingOrder(actualList));
	}

	//@Program_S45
	@Given("The data is in the ascending order on the table based on Program Name column")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
		programPage.getManageProgramPage();
		programPage.click_on_sortIcon("Program Name ");
	}

	@Then("The data get sorted on the table based on the program name column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
		
		Assert.assertTrue(programPage.validateIfSortedInDescendingOrder(actualList));
	}
	//@Program_S46
	@When("Admin clicks the sort icon of program Desc column")
	public void admin_clicks_the_sort_icon_of_program_desc_column() {
		 programPage.click_on_sortIcon("Program Description ");  
		 actualList.clear();
		 actualList = programPage.getListOfRecords("Program Description", 3);
		 LoggerLoad.info("-------------------------------------------------");
		 LoggerLoad.info("Actual List of Program Descriptions : ");
		 LoggerLoad.info("-------------------------------------------------");
		 for(String str : actualList) {
				LoggerLoad.info(str);
			}
	}

	@Then("The data get sorted on the table based on the program description column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
		Assert.assertTrue(programPage.validateIfSortedInAscendingOrder(actualList));
	}

	//@Program_S47
	@Given("The data is in the ascending order on the table based on Program Description column")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() {
		programPage.getManageProgramPage();
		programPage.click_on_sortIcon("Program Description ");
	}

	@Then("The data get sorted on the table based on the program description column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {

		Assert.assertTrue(programPage.validateIfSortedInDescendingOrder(actualList));
	}
	//@Program_S48
	@When("Admin clicks the sort icon of program Status column")
	public void admin_clicks_the_sort_icon_of_program_status_column() {
		programPage.click_on_sortIcon("Program Status ");
		actualList.clear();
		actualList = programPage.getListOfRecords("Program Status", 4);
		LoggerLoad.info("-------------------------------------------------");
		LoggerLoad.info("Actual List of Program Status : ");
		LoggerLoad.info("-------------------------------------------------");
		for(String str : actualList) {
				LoggerLoad.info(str);
			}
	}

	@Then("The data get sorted on the table based on the program status column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {

		Assert.assertTrue(programPage.validateIfSortedInAscendingOrder(actualList));
	}
	//@Program_S49
	@Given("The data is in the ascending order on the table based on Program Status column")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column() {
		programPage.getManageProgramPage();
		programPage.click_on_sortIcon("Program Status ");
	}

	@Then("The data get sorted on the table based on the program status column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
		Assert.assertTrue(programPage.validateIfSortedInDescendingOrder(actualList));
	}
	
	//@last
	@When("Admin clicks on Logout link on Manage Program page")
	public void admin_clicks_on_logout_link_on_manage_program_page() {
		programPage.click_on_logOut();
	}

	@Then("Admin is re-directed to Login page")
	public void admin_is_re_directed_to_login_page() {
		Assert.assertTrue(programPage.validatePage("login"));
	}
}
