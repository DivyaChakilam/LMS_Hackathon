package lms.hackathon.ui.stepdefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.Assert;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.hackathon.ui.pageobjects.UserPage;
import lms.hackathon.ui.utilities.FilloExcel;
import lms.hackathon.ui.utilities.LoggerLoad;
import lms.hackathon.ui.utilities.TestContextSetUp;

public class UserSteps {
	
	public UserPage userPage;
	public TestContextSetUp testContextSetUp;
	
	public UserSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		userPage = testContextSetUp.pageObjManager.getUserPage();
	}
	
	@Given("Admin is on dashboardpage after login")
	public void admin_is_on_dashboardpage_after_login() throws InterruptedException {
	    String userName = testContextSetUp.base.configs.getUserName();
	    String password = testContextSetUp.base.configs.getPassword();
	    userPage.login(userName, password);
	}
	@When("Admin Clicks user from Navigation Bar")
	public void admin_clicks_user_from_navigation_bar() throws InterruptedException {
		userPage.navigate();	   
	}
	@Then("Admin Should see a heading Manage User")
	public void admin_should_see_a_heading_manage_user() {
		LoggerLoad.info(userPage.validate());	   
	}
	
	@Given("Admin is on Manage User page")
	public void admin_is_on_manage_user_page() throws InterruptedException {
	}
	@When("Admin clicks {string} button")
	public void admin_clicks_button(String button) throws InterruptedException {
		userPage.locateButton(button);	    
	}
	@Then("Admin should able to see {string} popup")
	public void admin_should_able_to_see_popup(String validateButton) {
	    
	}
	@Given("Admin is on  {string} popup window")
	public void admin_is_on_popup_window(String button) {
		try {
			userPage.locateButton(button);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}	    
	}
	@When("Admin enters {string} in the form and clicks on {string} button")
	public void admin_enters_in_the_form_and_clicks_on_button(String runType, String actionType) throws InterruptedException {
		//System.out.println("runty: "+runType+ " mat: "+ runType.matches("update.*"));
		if(runType.matches("update.*")) 
			userPage.updateUser(runType,actionType);
		else
		   userPage.addUser(runType,actionType);		
	}
	
	@Then("Admin checks {string} in the form")
	public void admin_checks_in_the_form(String runType) throws InterruptedException {
	   String fileName = System.getProperty("user.dir")+"/src/test/resources/testdata/usertestdata.xlsx";
  	   String sheetName ="UserSheet";
  	   Map<String,String> dataMap = new HashMap<String,String>(); 	
  	   if(runType.contains("userdetailsfields")|| 
  			   runType.contains("dropdowns"))
  	   dataMap = FilloExcel.getSingleData(fileName,sheetName,"userdetailsfields");

  	   List<String> actualList = new ArrayList<String>();
       Map<String,String> actualMap = new HashMap<String,String>();
    	 if(runType.contains("userdetailsfields") ||
    			 runType.contains("dropdowns")) {
              actualMap = userPage.isPopUpDisplayed(runType);
    	 }       	 
    	 else actualMap = userPage.isTextBoxedisplay();
        for(Map.Entry<String, String> map: actualMap.entrySet()) {
          if(map.getKey()!=null)	{
 	    	//System.out.println(runType +" : Is Display: "+ map.getKey() +" : "+map.getValue());
           
        	Assert.assertTrue(map.getValue().equalsIgnoreCase("true"));
          }	
        }
    	 
     Thread.sleep(1000);
	}


	@Then("Admin gets message {string}")
	public void admin_gets_message(String expectedmessage) throws InterruptedException {
	        userPage.validateAddUser();
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() throws InterruptedException {
		userPage.validateAddUser();
	   
	}
	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {
		//userPage.validateTextField();
	}

	@When("Admin clicks Cancel Close Icon on User Details form")
	public void admin_clicks_cancel_close_x_icon_on_user_details_form() {
		userPage.clickClose();
	  
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() {
		LoggerLoad.info(userPage.validate());	
		Assert.assertTrue(userPage.validate().matches(".*Manage User.*"));

	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
	    userPage.selectEditUser();
	}

	@Then("A new pop up with User details")
	public void a_new_pop_up_with_user_details() {
	   
	}
	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() throws InterruptedException {
		//userPage.validateAddUser();

	   
	}
	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
	}
	
	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) throws InterruptedException {
		userPage.validateAddUser();
		
	}
	@Then("Admin gets message {string} and see the old values in data table")
	public void admin_gets_message_and_see_the_old_values_in_data_table(String string) throws InterruptedException {
		userPage.validateUpdateInvalidData();

 
	}

// ******************************** By Sayali********************************
	@Then("Admin should able to see Assign Student popup")
	public void admin_should_able_to_see_assign_student_popup() {
		userPage.validateAssignStudentPopUp();
		Assert.assertEquals(userPage.validatePopUpSavebtn(), true);
	    Assert.assertEquals(userPage.validatePopUpClosebtn(), true);
	    Assert.assertEquals(userPage.validatePopUpCancelbtn(), true);	
	}
	
	@Then("Admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status() {
	    Assert.assertEquals(userPage.validateAssignStudentRadio(), true);
	}
	@Then("Admin should see User Role as R03 with other mandatory fields")
	public void admin_should_see_user_role_as_r03_with_other_mandatory_fields(){
		userPage.validateAssignStudentPopUp();
	      // userPage.validateAssignStudentPopUpFields();
			Assert.assertEquals(userPage.validateStudentRoleIddisplay(), true);
			Assert.assertEquals(userPage.validateStudentEmaildisplay(), true);
			Assert.assertEquals(userPage.validateStudentProgramdisplay(), true);
			Assert.assertEquals(userPage.validateStudentBatchdisplay(), true);
			Assert.assertEquals(userPage.validateStudentStatusdisplay(), true);			
	}

	@Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name & Batch Name")
	public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_batch_name() throws InterruptedException {
		Thread.sleep(3000);
	    userPage.validatePopupStudentEmail();//need to add code for dropdown selection
	}
	@Then("Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button")
	public void admin_should_see_a_pop_up_open_for_assign_staff_details_with_empty_form_along_with_save_and_cancel_button() {
	    userPage.validateAssignStaffPopUp();
	    Assert.assertEquals(userPage.validatePopUpSavebtn(), true);
	    Assert.assertEquals(userPage.validatePopUpClosebtn(), true);
	    Assert.assertEquals(userPage.validatePopUpCancelbtn(), true);    
	}
	@Then("Admin should see User Role as R02 with other mandatory fields")
	public void admin_should_see_user_role_as_r02_with_other_mandatory_fields() throws InterruptedException {
         Assert.assertEquals(userPage.validatepopUpstaffRoleId(), true);	
         //code to check RO2 in roleID
		Assert.assertEquals(userPage.validatepopUpstaffemail(), true);
		Assert.assertEquals(userPage.validatepopUpstaffprogram(), true);
		Assert.assertEquals(userPage.validatepopUpstaffBatch(), true);
		Assert.assertEquals(userPage.validatepopUpstaffRadio(), true);
		Assert.assertEquals(userPage.validatepopUpstaffskill(), true);
		
	 // userPage.validateAssignStaffPopUpFields();
	}
	@Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name")
	public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name() {
	    //userPage.validatepopUpstaffemail();
		//code to check dropdown data for email,program and batch 
		Assert.assertEquals(userPage.validatepopUpstaffemail(), true);
		Assert.assertEquals(userPage.validatepopUpstaffprogram(), true);
		Assert.assertEquals(userPage.validatepopUpstaffBatch(), true);
	}

//------------------------------------------------
	@Given("Admin is in Assign Student details pop up page")
	public void admin_is_in_assign_student_details_pop_up_page() throws InterruptedException {
		//String userName = testContextSetUp.base.configs.getUserName();
	    //String password = testContextSetUp.base.configs.getPassword();
	   // userPage.login(userName, password);
	    //userPage.navigate();
	    userPage.navigateAssignStudent();	    
	}
	@When("Admin clicks {string} button without entering any data")
	public void admin_clicks_button_without_entering_any_data(String string) throws InterruptedException {
		userPage.AssignSave();
	}
	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() throws InterruptedException  {
	     //userPage.AssignStudentErrorMessage();
			Assert.assertEquals(userPage.ValidateEmptyEmail(), true);
			Assert.assertEquals(userPage.ValidateEmptyProgram(), true);
			Assert.assertEquals(userPage.ValidateEmptyBatch(), true);
			Assert.assertEquals(userPage.ValidateEmptyStatus(), true);
	}
	@When("Admin clicks <Close>button on assign student form")
	public void admin_clicks_close_button_on_assign_student_form() throws InterruptedException {
		Thread.sleep(1000);
	     userPage.AssignStudentClose();
	     Thread.sleep(2000);
	}
	@Then("Assign Student popup window should be closed without saving")
	public void assign_student_popup_window_should_be_closed_without_saving() throws InterruptedException {
		Assert.assertTrue(userPage.validate().matches(".*Manage User.*"));
	}
	@When("Admin clicks <Cancel>button")
	public void admin_clicks_cancel_button() throws InterruptedException {
	     userPage.AssignStudentCancel();   
	}
	 
	@Then("Admin can see the Assign Student popup disappears without assigning")
	public void admin_can_see_the_assign_student_popup_disappears_without_assigning() throws InterruptedException
	{
		Assert.assertTrue(userPage.validate().matches(".*Manage User.*"));
	}
	@When("Admin clicks {string} button without entering Student Email id")
	public void admin_clicks_button_without_entering_student_email_id(String string) throws InterruptedException {
		userPage.AssignSave();
	}
	@Then("Admin gets a Error as {string}")
	public void admin_gets_a_error_as(String string) {
	    userPage.validatetextofemail();
	}
	@Given("Admin is in Assign Staff details pop up page")
	public void admin_is_in_assign_staff_details_pop_up_page() throws InterruptedException {
		//String userName = testContextSetUp.base.configs.getUserName();
	   // String password = testContextSetUp.base.configs.getPassword();
	    //userPage.login(userName, password);
	    //userPage.navigate();
	    userPage.navigateAssignStaff();	
	    }
	
	@When("Admin clicks {string} button without any data on Assign staff page")
	public void admin_clicks_button_without_any_data_on_assign_staff_page(String string) throws InterruptedException {
		userPage.AssignSave();
	}
	
	@Then("Admin gets a Error message")
	public void admin_gets_a_error_message() {
		
		Assert.assertEquals(userPage.ValidateEmptyStaffEmailMessage(), true);
		Assert.assertEquals(userPage.ValidateEmptyStaffProgramMessage(), true);
		Assert.assertEquals(userPage.ValidateEmptyStaffBatchMessage(), true);
//		Assert.assertEquals(userPage.validatepopUpstaffskill(), true);
		Assert.assertEquals(userPage.ValidateEmptyStaffStatusMessage(), true);
	}

	@When("Admin clicks {string} button without entering staff Email id")
	public void admin_clicks_button_without_entering_staff_email_id(String string) throws InterruptedException {
		userPage.InputSkill();
		userPage.AssignSave();
	}

	@Then("Admin gets a Error message as {string}")
	public void admin_gets_a_error_message_as(String string) {
		Assert.assertEquals(userPage.ValidateEmptyStaffEmailMessage(), true);
	}
	

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() throws InterruptedException {
		userPage.ClickRowleveldelete();
	}
	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
	    userPage.validterowleveldeleteconfirmPopUp();
		Assert.assertEquals(userPage.validateDeleteYes(), true);
		Assert.assertEquals(userPage.validateDeleteNo(), true);
	}
	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() throws InterruptedException {
		//String userName = testContextSetUp.base.configs.getUserName();
	    //String password = testContextSetUp.base.configs.getPassword();
	    //userPage.login(userName, password);
		userPage.navigate();
		userPage.ClickRowleveldelete();	    
	}
	@When("Admin clicks  No option")
	public void admin_clicks_no_option() throws InterruptedException {
		userPage.ConfirmrowleveldeletePopUpNoBtn();	    
	}
	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		Assert.assertTrue(userPage.validate().matches(".*Manage User.*"));  
		
	}


}