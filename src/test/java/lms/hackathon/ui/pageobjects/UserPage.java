package lms.hackathon.ui.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import lms.hackathon.ui.utilities.FilloExcel;
import lms.hackathon.ui.utilities.LoggerLoad;

public class UserPage {
	private WebDriver driver;
	private By userModule = By.id("user");
	private By addUserButton = By.xpath("//span[contains(text(),'Add New User')]");
	private By assignStudent = By.xpath("//span[contains(text(),'Assign Student')]");
	private By addUserPopupfields = By.xpath("//label[contains(@class,'inserted')]//span");
	private By textBoxes = By.xpath("//input[contains(@class,'mat-input')]");
	private By popUpButton =  By.xpath("//*[contains(@class,'mat-card')]//span[contains(@class,'button-wrapper')]");
	private By popupDropdown = By.xpath("//label[contains(text(),'User')]");
	private By emailField = By.xpath("//input[@placeholder='Email address']");
	
	private By allDropDown = By.xpath("//div//label[contains(text(),'User')]");
    private By errorMessage = By.xpath("//div[contains(@class,'transitionMessages')]//mat-error");
	private By closeIcon = By.xpath("//div[contains(@class,'header-icons')]//span");
	private List<String> popupTextBox ;
	private Map<String,String> popupMap ;

	
	private By editButton = By.xpath("//div[@class='action']//button[contains(@class,'p-button-success')]");
	
	// ******************By Sayali**********************************
	private By popUpCancelButton = By.xpath("//button[@label='Cancel']");
	private By popUpSaveButton = By.xpath("//button[@label='Save']");
	private By popUpCloseButton = By.xpath("//span[contains(@class,'p-dialog-header-close-icon')]");
	private By popUpRoleId = By.xpath("//input[@id='roleId']");
	private By popUpStudentEmail = By.xpath("//div//label[text()='Student Email Id']//..//div[@role='button']");
	private By popUpStaffEmail = By.xpath("//*[@id=\"userId\"]/div");
	private By popUpStaffEmailClick = By.xpath("//*[@id=\"userId\"]/div/div[2]/span");
	private By popUpStaffprogram = By.xpath("//*[@id=\"programName\"]/div");
	private By popUpStaffBatch = By.xpath("//div[2]/form/div[5]");
	private By popUpemailplaceholder = By.xpath("//span[@class='ng-tns-c101-99 p-dropdown-label p-inputtext p-placeholder ng-star-inserted']");
	private By popUpStudentProgram = By.xpath("//input[@id='programName']");
	private By popUpStudentBatch = By.xpath("//input[@id='batchName']");
	private By popUpStudentRadio = By.xpath("//div[@class='radio']");
	private By popUpStaffskill = By.xpath("//input[@id='skillName']");
	private By assignStaff = By.xpath("//span[contains(text(),'Assign Staff')]");
	
	private By rowleveldeleteicon = By.xpath("/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[6]/div/span/button[2]");
	private By rowleveldeletePopUpYesBtn = By.xpath("/html/body/app-root/app-user/div/p-confirmdialog/div/div/div[3]/button[2]/span[1]");
	private By rowleveldeletePopUpNoBtn = By.xpath("//div/div/div[3]/button[1]/span[2]");
	//*****************Empty****************
	  private By emptyemailmessage = By.xpath("/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[2]/div");
	    private By emptyemailstaffmessage = By.xpath("/html/body/app-root/app-user/div/p-dialog[2]/div/div/div[2]/form/div[2]/div");
	    private By emptyprogmessage = By.xpath("/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[3]/div");
	    private By emptyprogramstaffmessage = By.xpath("//div/div/div[2]/form/div[4]/div");
	    private By emptybatchmessage = By.xpath("/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[4]/div");
	    private By emptybatchstaffmessage = By.xpath("/html/body/app-root/app-user/div/p-dialog[2]/div/div/div[2]/form/div[5]/div");
	  private By emptystatusmessage = By.xpath("//div[2]/form/div[6]");
	  private By emptystatusStaffMessage = By.xpath("/html/body/app-root/app-user/div/p-dialog[2]/div/div/div[2]/form/div[7]");

	  private By AssignStudentdialog1 = By.xpath("/html/body/app-root/app-user/div/p-dialog[2]/div/div");
	//**************************************************************
	
	List<Map<String,String>> dataMapList;
	Map<String,String> dataMap = new HashMap<String,String>();
	Map<String,String> dataMapMulti;

	public UserPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String userName, String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}
    public void navigate() throws InterruptedException {
    	driver.findElement(userModule).click();
    }
    public void locateButton(String button) throws InterruptedException {
    	if(button.contentEquals("Add New User"))
    		driver.findElement(addUserButton).click();
    	if(button.contentEquals("Assign Student"))
    		driver.findElement(assignStudent).click();
    	if(button.contentEquals("Assign Staff"))
    		driver.findElement(assignStaff).click();
    	if(button.contentEquals("User Details"))
    		driver.findElement(editButton).click();
     }
    public String validate() {
    	return driver.findElement(By.className("box")).getText();
    }
    public Map<String,String> isPopUpDisplayed(String runType){
        driver.switchTo().window(driver.getWindowHandle());      
	    List<WebElement> popupList = driver.findElements(addUserPopupfields);
	    List<WebElement> popupBtn = driver.findElements(popUpButton);
	    List<WebElement> popupDrop = driver.findElements(popupDropdown);
	    
        popupMap = new HashMap<String,String>();
        if(runType.contains("userdetailsfields"))
              addIntoMap(popupList);
	   addIntoMap(popupDrop);
	    popupMap.put(driver.findElement(emailField).getAttribute("placeholder"),
	    		driver.findElement(emailField).isDisplayed()?"true":"false");
	    addIntoMap(popupBtn);
        
	    popupMap.put(driver.findElement(closeIcon).getAttribute("placeholder"),
	    		driver.findElement(emailField).isDisplayed()?"true":"false");
	    popupMap.put(driver.findElement(closeIcon).getText(),
	    		driver.findElement(closeIcon).isDisplayed()?"true":"false");
	    return popupMap;
	
}	
    
public void addIntoMap(List<WebElement> listPopup) {
	 for(WebElement textbox: listPopup) {
    	popupMap.put(textbox.getText(), 
    			textbox.isDisplayed()?"true":"false");
    }    	 
}

    public Map<String,String> isTextBoxedisplay(){
    	driver.switchTo().window(driver.getWindowHandle());
        List<WebElement> textBoxList = driver.findElements(textBoxes);
        popupMap = new HashMap<String,String>();


        for(WebElement box: textBoxList) {
        	popupMap.put(box.getAttribute("data-placeholder"),
        			box.isDisplayed()?"true":"false");
        }
        return popupMap;
    }
     public void clickClose() {
    	driver.findElement(closeIcon).click();   	
    }
    public void addUser(String runType, String actionType) throws InterruptedException {
    	
       if(runType.contains("skips all mandatory fields") ||
    		   runType.contains("without data")) 	{
    		clickSubmit(actionType);
    		validateAllTextFieldForError();
       }		
 
       else if(runType.matches("user mandatory fields.*")) {
    	   
    	   String fileName = System.getProperty("user.dir")+"/src/test/resources/testdata/usertestdata.xlsx";
    	   String sheetName ="UserSheet";
    	   dataMap = FilloExcel.getSingleData(fileName,sheetName,runType);
    	   
    	   sendDataToTextBoxes(dataMap);  
    	   Thread.sleep(1000);
    	   
    	   sendDropDown(dataMap);

    	   Thread.sleep(1000);
    	   
    	   clickSubmit(actionType);
  	    		 
	    	 }
        
       else if(runType.contains("invalid data")) {
    	   
    	   String fileName = System.getProperty("user.dir")+"/src/test/resources/testdata/usertestdata.xlsx";
    	   String sheetName ="UserSheet";
    	   dataMap = FilloExcel.getSingleData(fileName,sheetName,"user mandatory fields");
    	   dataMap.put("User Comments","111");
    	   sendDataToTextBoxes(dataMap);  
    	   Thread.sleep(1000);
    	   
    	   sendDropDown(dataMap);
    	   Thread.sleep(1000);
    	   
    	  clickSubmit(actionType);
    	  Thread.sleep(1000);
    	  WebElement activeElement = driver.switchTo().activeElement();
    	  System.out.println("Error Message: "+ activeElement.getAriaRole() );
    	  System.out.println(activeElement.getTagName()+ "text: "+ activeElement.getText());
    	  System.out.println("att: "+activeElement.getAttribute("value"));

       }
       else if(runType.contains("skip one field")){
    	    String fileName = System.getProperty("user.dir")+"/src/test/resources/testdata/usertestdata.xlsx";
       		String sheetName ="UserSheet";
       		dataMap = FilloExcel.getSingleData(fileName,sheetName,"user mandatory fields");
       		
       }
       else if(runType.contains("skip text%")){
       	String fileName = System.getProperty("user.dir")+"/src/test/resources/testdata/usertestdata.xlsx";
          	String sheetName ="UserSheet";  	
          	dataMapMulti = new HashMap<String,String>();
          	dataMapList = FilloExcel.getData(fileName,sheetName,runType);
  
    	System.out.println("countList: "+dataMapList.size());
    	for(Map<String,String> dataMapMulti: dataMapList) {
    	
    		sendDataToTextBoxes(dataMapMulti);  
            Thread.sleep(1000);
    		clickSubmit("Submit");
     		Thread.sleep(1000);
            validateTextField(dataMapMulti);

     		clickClose();
    		driver.findElement(addUserButton).click();
    	}    
       }
      
     }
    public void updateUser(String runType, String actionType) throws InterruptedException {
          if(runType.matches("update optional.*")) {
        	  System.out.println("RunType: "+ runType);

        		    WebElement textBox = driver.findElement(By.xpath("//input[contains(@class,'mat-input') "
        		   		+ "and @data-placeholder='Middle name']"));
        		   String textField = textBox.getAttribute("data-Placeholder");
        		   textBox.clear();
        		   textBox.sendKeys("newValue");
        		   if(runType.contains("update optional with email")) {
           	        	textBox = driver.findElement(emailField);	   
           	        	textField = textBox.getAttribute("placeholder");
           	        	String newValue = "abssssd@gmail.com";
           	        	textBox.clear();
           	        	textBox.sendKeys(newValue);
           	        	
        		   }
        		   Thread.sleep(1000);

        		   clickSubmit(actionType);  
        		   if(runType.contains("update optional with email")) {
        			   String actual[] = getActualMessage();
        			 	
        		    	System.out.println("Expected Message: "+ dataMap.get("message"));
        		    	System.out.println("Actual Detail Message : "+ actual[1]);
        		    	Assert.assertTrue(("Failed").matches(".*"+actual[0]+".*"));
        LoggerLoad.info("Expected Message: "+ dataMap.get("message")+
        		"Actual Detail Message : "+ actual[1]);	    

        		   }
        		    Thread.sleep(1000);
            		clickClose();
        }
          //else if(runType.contentEquals("update all fields")) {
          else if(runType.matches("update all.*")) { 
        	  System.out.println("RunType: "+ runType);
        	  String fielName = System.getProperty("user.dir")+"/src/test/resources/testdata/usertestdata.xlsx";
        	 String sheetName = "UserSheet";
       	   dataMap = FilloExcel.getSingleData(fielName, sheetName, runType);   
       	   
       	   sendDataToTextBoxes(dataMap);       
       	  Thread.sleep(2000);
       	  if(runType.contentEquals("update all mandatory fields"))
       	    sendDropDown(dataMap);
          if(runType.contentEquals("update all optional fields")) {
        	    WebElement textBox = driver.findElement(emailField);		   
		       String textField = textBox.getAttribute("placeholder");
  	           String  newValue = dataMap.get(textField);
          textBox.clear();
		   textBox.sendKeys(newValue);
          }
		   Thread.sleep(1000);

   	   clickSubmit(actionType);    
   	   Thread.sleep(1000);
   		clickClose();
   		//selectEditUser();
          }
    }
    public void selectEditUser() {	
    	List<WebElement> editList =  driver.findElements(editButton);
       	for(WebElement editEle: editList) {
       		editEle.click();
       		break;
       	}
    	
    }
    public String[] getActualMessage() throws InterruptedException {
    	   Thread.sleep(1000);
    	WebElement ele = driver.switchTo().activeElement();
             String[] actMsg = new String[2];
	    	 String[] lines = ele.getText().split("\\r?\\n");
	    	 for(String msg: lines) {
	    		 if(msg.matches("Failed") || msg.matches("Successful")) {
	    			 actMsg[0]= msg;
	    		 }
	    		 if(msg.matches("Failed.*") || msg.matches(".*Success.*")) {
	    			 actMsg[1] = msg;
	    		 }
	    	 }	 
         return actMsg;			
    }
    public void validateAddUser() throws InterruptedException {
    	String actual[] = getActualMessage();
 	
    	System.out.println("Expected Message: "+ dataMap.get("message"));
    	System.out.println("Actual Detail Message : "+ actual[1]);
    	Assert.assertTrue(dataMap.get("message").matches(".*"+actual[0]+".*"));
    	LoggerLoad.info("Expected Message: "+ dataMap.get("message")+
        		"Actual Detail Message : "+ actual[1]);	    

    	
    	if(dataMap.get("First name").matches("134")) {
    	   LoggerLoad.info("Expected Message: userFirstName must contain two or more alphabets only");
    	   LoggerLoad.info("Actual Message: ");

    	}   
    	if(dataMap.get("First name").matches("13##")) {
    		LoggerLoad.info("Expected Message: userFirstName must contain two or more alphabets only");
    		LoggerLoad.info("Actual Message: ");}
    }
    public void validateUpdateInvalidData() {
		Assert.assertTrue(validate().matches(".*Manage User.*"));
    }

    public void sendDataToTextBoxes(Map<String,String> dataMap) {
    	List<WebElement> textBoxList = driver.findElements(textBoxes);
    	for(WebElement inputField: textBoxList) {
    		inputField.clear();
    		String placeHolderField = inputField.getAttribute("data-placeholder");
    		//System.out.println("send da: "+ dataMap.get(placeHolderField));
    	 if(!(dataMap.get(placeHolderField)==null)) {
    		inputField.sendKeys(dataMap.get(placeHolderField));
    	 }	
    	}    	
    }
    public void getDataFromTextBoxes() {
    	List<WebElement> textBoxList = driver.findElements(textBoxes);
    	for(WebElement inputField: textBoxList) {
    		LoggerLoad.info("field: "+ inputField.getAttribute("data-placeholder")
    		+" value: "+ inputField.getText());
    		
    	}
    }
    public void sendDropDown(Map<String,String> dataMap) throws InterruptedException {
    	String dropdownType="";
    	List<WebElement> allDropdownList = driver.findElements(allDropDown);
           for(WebElement dropText: allDropdownList) {
        	    dropdownType =  dropText.getText();
                driver.findElement(By.xpath("//div//label[text()='"+dropdownType+"']//..//div[@role='button']")).click();
               List<WebElement> menuList = driver.findElements(By.xpath("//ul[@role='listbox']//span"));
               List<String> menuTextList = new ArrayList<String>();
               for(int i=0;i<menuList.size();i++) {
            	   menuTextList.add(menuList.get(i).getText());           	   
               }
               
                for(String subText: menuTextList) {  
             		if(subText.contains(dataMap.get(dropdownType))) {
             			driver.findElement(By.xpath("//ul[@role='listbox']"
             					+ "//span[contains(text(),'"+subText+"')]")).click();
                  		Thread.sleep(1000);
              		}          		
            	}
                Thread.sleep(1000);
           }
      }
    public void clickSubmit(String actionType) {
    	List<WebElement> popupButton = driver.findElements(popUpButton);
    	for(WebElement buttonElement: popupButton) {
    		if(buttonElement.getText().contains(actionType))
    			buttonElement.click();
    	}
    }
 
    public void validateAllTextFieldForError() {
    	List<WebElement> errorList = driver.findElements(errorMessage);
    	for(WebElement errorEle: errorList) {
        	String color = errorEle.getCssValue("color").trim();
          
            Assert.assertTrue(errorEle.getText().matches(".*is required.*"));
            //Assert.assertTrue(("#f44336").matches(Color.fromString(color).asHex()));


            LoggerLoad.info("Actual Error: "+errorEle.getText());
    	}
    } 
    public void validateTextField(Map<String,String> dataMap) {
    	WebElement error = driver.findElement(errorMessage);
    	String color = error.getCssValue("color").trim();
    	
    	LoggerLoad.info("Expected Error: "+dataMap.get("message")+ " Actual Error: "+error.getText());
    	LoggerLoad.info("Expected Text Color: "+dataMap.get("text color") +" Actual Color: "+ Color.fromString(color).asHex());
        Assert.assertTrue(dataMap.get("message").matches(".*is required.*"));

        Assert.assertTrue(dataMap.get("text color").matches(Color.fromString(color).asHex()));
    }
   
   
    public WebElement callDriverWait(By locator) {
    	return new WebDriverWait(driver, Duration.ofSeconds(6))
    			.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
   //*********************By Sayali******************************
    
    public void validateAssignStudentPopUp()
    {
        //driver.switchTo().window(driver.getWindowHandle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
    }

 //======================Validtion for display of Close/Save/Cancel on Assign student and staff========================
    
    public boolean validatePopUpSavebtn() {
    	return driver.findElement(popUpSaveButton).isDisplayed();
    }
    
    public boolean validatePopUpClosebtn() {
         return driver.findElement(popUpCloseButton).isDisplayed();	
    }
    
    public boolean validatePopUpCancelbtn() {
    	return driver.findElement(popUpCancelButton).isDisplayed();
    }
    //=======================================================================================//
    public boolean validateAssignStudentRadio() {
    	return driver.findElement(popUpStudentRadio).isDisplayed();
    	
    }
    //=================Admin should see User Role as R03 with other mandatory fields====================================
    public void validateAssignStudentPopUpFields() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
    }
    
    public boolean validateStudentRoleIddisplay() {
    	return  driver.findElement(popUpRoleId).isDisplayed(); 	
    }
    
    public boolean validateStudentEmaildisplay() {
    	return driver.findElement(popUpStudentEmail).isDisplayed();
    }
    public boolean validateStudentProgramdisplay() {
    	return driver.findElement(popUpStudentProgram).isDisplayed();

    }
    public boolean validateStudentBatchdisplay() {
    	return driver.findElement(popUpStudentBatch).isDisplayed();
    }
    public boolean validateStudentStatusdisplay() {
    	return driver.findElement(popUpStudentRadio).isDisplayed();
    }
    public void validatePopupStudentEmail()
    {
    	driver.findElement(popUpStudentEmail).click();
    }
    public void validateAssignStaffPopUp()
    {
        driver.switchTo().window(driver.getWindowHandle());
    }
    
    //=======================================================================================================// 
  /* validation of mandatory fields display on assign staff */
    
    public String validatestaffemailRole() {
    	String staffRoleID = driver.findElement(popUpRoleId).getText();
    	return staffRoleID;
    }
    
    public boolean validatepopUpstaffRoleId() throws InterruptedException {
    	Thread.sleep(1000);
    	return driver.findElement(popUpRoleId).isDisplayed();

    }
    public boolean validatepopUpstaffemail() {
    	return driver.findElement(popUpStaffEmail).isDisplayed();
    }
    
    public boolean validatepopUpstaffprogram() {
    	return driver.findElement(popUpStaffprogram).isDisplayed();
    }
    
    public boolean validatepopUpstaffBatch() {
    	return driver.findElement(popUpStaffBatch).isDisplayed();
    }
    
    public boolean validatepopUpstaffRadio() {
	    return driver.findElement(popUpStudentRadio).isDisplayed();
    }
    public boolean validatepopUpstaffskill() {
	    return driver.findElement(popUpStaffskill).isDisplayed();

    }
   //=======================================================================================================// 
    public void navigateAssignStudent() throws InterruptedException {
    	driver.findElement(assignStudent).click();
		//Thread.sleep(3000);
    }
    public void AssignSave() throws InterruptedException {
    	driver.findElement(popUpSaveButton).click();
    	Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }
  //====Error message display for empty fields on Assign Student Page======//
    
    
    public boolean ValidateEmptyEmail() {
    	return driver.findElement(emptyemailmessage).isDisplayed();
    }
    public boolean ValidateEmptyProgram() {
    	return driver.findElement(emptyprogmessage).isDisplayed();
    }
    
    public boolean ValidateEmptyBatch() {
    	return driver.findElement(emptybatchmessage).isDisplayed();
    }
    
    public boolean ValidateEmptyStatus() {
    	return driver.findElement(emptystatusmessage).isDisplayed();
    	
    }
    
    
    //===========Error message display for empty fields on Assign Staff Page============================//

    
    public void AssignStudentClose() throws InterruptedException {
    	driver.findElement(popUpCloseButton).click();
    	Thread.sleep(3000);
    }
    public boolean validatestudentframedisappear() throws InterruptedException {
    	//return driver.findElement(By.className("box")).isDisplayed();
    	return driver.findElement(AssignStudentdialog1).isDisplayed();
    }
    public void ValidateAssignStudentCancel()
    {
    	//driver.findElement(AssignStudentdialog)
    	driver.switchTo().window(driver.getWindowHandle());
    }
    public void AssignStudentCancel() throws InterruptedException {
    	driver.findElement(popUpCancelButton).click();
    	Thread.sleep(3000);
    }
    public void validatetextofemail()
    {
    	Assert.assertTrue(driver.findElement(emptyemailmessage).getText().contains("Student Email id is required"));
    	
    }
    public void navigateAssignStaff() throws InterruptedException {
    	driver.findElement(assignStaff).click();
		Thread.sleep(3000);
    }
  //===========Error message display for empty fields on Assign Staff Page============================//
    public boolean ValidateEmptyStaffEmailMessage() {
    	return driver.findElement(emptyemailstaffmessage).isDisplayed();
    }
    
    public boolean ValidateEmptyStaffProgramMessage() {
    	return driver.findElement(emptyprogramstaffmessage).isDisplayed();
    }
    
    public boolean ValidateEmptyStaffBatchMessage() {
    	return driver.findElement(emptybatchstaffmessage).isDisplayed();
    }
    
    public boolean ValidateEmptyStaffStatusMessage() {
    	return driver.findElement(emptystatusStaffMessage).isDisplayed();
    }
    
    public void InputSkill() {
    	driver.findElement(popUpStaffskill).sendKeys("JAVA");
    }
    public boolean validateDeleteYes() {
    	return driver.findElement(rowleveldeletePopUpYesBtn).isDisplayed();
    }
    
    public boolean validateDeleteNo() {
    	return driver.findElement(rowleveldeletePopUpNoBtn).isDisplayed();
    }
    public void ClickRowleveldelete() throws InterruptedException
    {
    	Thread.sleep(3000);
    	driver.findElement(rowleveldeleteicon).click();
    }
    public void validterowleveldeleteconfirmPopUp() {
        driver.switchTo().window(driver.getWindowHandle());
    }
    
    public void ConfirmrowleveldeletePopUpNoBtn() throws InterruptedException
    {
    	 driver.findElement(rowleveldeletePopUpNoBtn).click();
    	 Thread.sleep(1000);
    	 //driver.switchTo( ).alert( ).dismiss();

    }
    
// **********************************End Sayali*************************************
}