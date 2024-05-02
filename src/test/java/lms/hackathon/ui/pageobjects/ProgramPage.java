package lms.hackathon.ui.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms.hackathon.ui.utilities.FileUtils;
import lms.hackathon.ui.utilities.LoggerLoad;

public class ProgramPage {
	private WebDriver driver;
	FileUtils utils = new FileUtils();
	
	private String lastChosenProgram = null;
	private By programModule = By.xpath("//button/span[text()='Program']");
	private By batchModule = By.xpath("//button/span[text()='Batch']");
	private By userModule = By.xpath("//button/span[text()='User']");
	private By logOut = By.xpath("//button/span[text()='Logout']");
	public By program_Header = By.xpath("//div[text()=' Manage Program']");
	private By searchbar = By.xpath("//input[@id='filterGlobal' and @placeholder='Search...']");
	private By username = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("login");
	private By table_Rows_Count = By.xpath("//table/tbody/tr"); //table/tbody[@class='p-datatable-tbody']/tr
	private By total_Entries = By.xpath("//table/tbody/tr");//div[@class='p-datatable-wrapper ng-star-inserted']/table/tbody/tr
	private By next_Paginator = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	private By footer_path = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
	private By actualText_paginationFooter = By.xpath("//span[contains(text(),'Showing')]");
	private By deleteButtonTopLeft = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	private By newProgramButton = By.id("new");	
	private By columnHeader_ProgramName = By.xpath("//th[contains(text(),'Program Name ')]");
	private By columnHeader_ProgramDescription = By.xpath("//th[contains(text(),'Program Description ')]");
	private By columnHeader_ProgramStatus = By.xpath("//th[contains(text(),'Program Status ')]");
	private By columnHeader_Edit_Delete = By.xpath("//th[contains(text(),' Edit / Delete ')]");
	private By listOfCheckBoxOnPage = By.xpath("//div/span[@class='p-checkbox-icon']");
	private By listOfEditIconOnPage = By.xpath("//button/span[@class='p-button-icon pi pi-pencil']");
	private By listOfDeleteIconOnPage = By.xpath("//button/span[@class='p-button-icon pi pi-trash']");
	private By listOfSortIcon = By.xpath("//th[(@class='p-sortable-column')and contains(text(),'Program')]");
	private By programDetailsPopUp = By.xpath("//div[contains(@class,'p-dialog-mask')]/..");
	private By popUp_programDetailsHeader = By.xpath("//span[text()='Program Details']");
	private By popUp_saveProgramButton = By.id("saveProgram");
	private By popUp_cancelProgramButton = By.xpath("//span[text()='Cancel']");
	private By popUp_closeIconProgramDetails = By.xpath("//span[contains(@class,'p-dialog-header-close-icon')]");
	private By popUp_programNameInputBox = By.id("programName");
	private By popUp_programDescriptionInputBox = By.id("programDescription");
	private By popUp_radio_ActiveStatus = By.xpath("//div[@class='radio ng-star-inserted']/div[2]/descendant::div[1]");
	private By popUp_radio_ActiveButton = By.xpath("//div[@class='radio ng-star-inserted']/div[2]/descendant::div[1]/div[2]	");
	private By popUp_radio_ActiveButton_checked = By.xpath("//div[@class='radio ng-star-inserted']/div[2]/descendant::div[1]/div/input");
	private By popUp_radio_InactiveStatus = By.xpath("//div[@class='radio ng-star-inserted']/div[3]/descendant::div[1]");
	private By popUp_radio_InactiveButton = By.xpath("//div[@class='radio ng-star-inserted']/div[3]/descendant::div[1]/div[2]	");
	private By popUp_radio_InactiveButton_checked =	By.xpath("//div[@class='radio ng-star-inserted']/div[3]/descendant::div[1]/div/input");	
	private By popUp_SuccessMessage = By.xpath("//app-program//div[text()='Successful']");
	private By popUp_confirmDeletion = By.xpath("//p-confirmdialog//span[text()='Confirm']");
	private By popUp_confirmDeletion_Yes = By.xpath("//p-confirmdialog//button/span[text()='Yes']");
	private By popUp_confirmDeletion_No = By.xpath("//p-confirmdialog//button/span[text()='No']");
	private By popUp_confirmDeletion_closeX = By.xpath("//button[contains(@class,'p-dialog-header-close')]");
	private By checkbox =By.xpath("//div[@role='checkbox']");
	private By commonDeleteIcon = By.xpath("//div[@class='box']//span[@class='p-button-icon pi pi-trash']");		
	String dynamicProgramNameToSearch;
	String dynamicErrorMsg;
	String dynamicProgramName;
	
	/******* Needs to be added in constants/proprties*********************************/
	public String expectedManageProgramURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/ManageProgram";
	public String programURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/";
	public String batchURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/batch";
	public String userURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/user";
	public String loginURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login";
	/*******End of  Needs to be added in constants/proprties***************************/
	
	/******************Error Messages *************************************************/
	public final String programNameRequiredErrMsg = "Program name is required.";
	public final String programDescriptionRequiredErrMsg = "Description is required.";
	public final String programStatusRequiredErrMsg = "Status is required.";
	public final String invalidProgramNameErrMsg = "This field should start with an alphabet, no special char and min 2 char.";
	public final String invalidProgramDescriptionErrMsg = "This field should start with an alphabet and min 2 char.";
	public final String expectedMsgDeletionPopUp = "Are you sure you want to delete ";
	
	/******************End of Error Messages ******************************************/
	
	public ProgramPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() {
		driver.findElement(username).sendKeys("sdetorganizers@gmail.com");
		driver.findElement(password).sendKeys("UIHackathon@02");
		driver.findElement(loginButton).click();
    }
	
	public void click_on_programModule() {
		click(programModule);
	}
	
	public void click_on_batchModule() {
		click(batchModule);
	}
	
	public void click_on_userModule() {
		click(userModule);
	}
	
	public void click_on_logOut() {
		click(logOut);
	}
	
	public void click_on_newProgramButton() {
		click(newProgramButton);
		driver.switchTo().activeElement();
	}
	public void click_on_sortIcon(String columnHeader) {
		click(By.xpath("//th[contains(@class,'sortable') and text()='"+columnHeader+"']//i"));
	}
	
	public void click_on_saveProgramButton() {
		Actions action = new Actions(driver);
		WebElement element_popUp_saveProgramButton = driver.findElement(popUp_saveProgramButton);
		action.moveToElement(element_popUp_saveProgramButton).click().build().perform();
    	LoggerLoad.info("Save button is clicked");
    	try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			LoggerLoad.info("Exception caught while clicking save button on program details pop up!"+e);
			e.printStackTrace();
		}
		
	}
	public void click_on_cancelProgramButton() {
		click(popUp_cancelProgramButton);
	}
	public void click_on_closeXProgramButton() {
		click(popUp_closeIconProgramDetails);
	}
	public void click_on_ActiveStatus() {
		Actions action = new Actions(driver);
		waitForElementToBeVisible(popUp_radio_ActiveButton);
		WebElement element_popUp_radio_ActiveButton = driver.findElement(popUp_radio_ActiveButton);
    	action.moveToElement(element_popUp_radio_ActiveButton).click(element_popUp_radio_ActiveButton).build().perform();
		WebElement element_popUp_radio_ActiveButton_checked = driver.findElement(popUp_radio_ActiveButton_checked);
		if(element_popUp_radio_ActiveButton_checked.getAttribute("aria-checked").compareTo("true")==0) {
    		LoggerLoad.info("Active status is clicked");
        	}else LoggerLoad.info("Active status isn't clicked");
    }
	
	public void click_on_InactiveStatus() {
		Actions action = new Actions(driver);
		waitForElementToBeVisible(popUp_radio_InactiveButton);
		WebElement element_popUp_radio_InactiveButton = driver.findElement(popUp_radio_InactiveButton);
		action.moveToElement(element_popUp_radio_InactiveButton).click(element_popUp_radio_InactiveButton).build().perform();
		WebElement element_popUp_radio_InactiveButton_checked = driver.findElement(popUp_radio_InactiveButton_checked);
		if(element_popUp_radio_InactiveButton_checked.getAttribute("aria-checked").compareTo("true")==0) {
    		LoggerLoad.info("Inactive status is clicked");
        	}else LoggerLoad.info("Inactive status isn't clicked");
	}
	
	public void click_on_CloseX_DeletionPopUp() {
		click(popUp_confirmDeletion_closeX);
	}
	public void click_on_YES_DeletionPopUp() {
		click(popUp_confirmDeletion_Yes);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			LoggerLoad.info("Exception caught while clicking yes button on program ddeletion pop up!"+e);
			e.printStackTrace();
		}
	}
	public void click_on_NO_DeletionPopUp() {
		click(popUp_confirmDeletion_No);
	}
	
	public String enterProgramName(String name) {
		String program_Name = name.toLowerCase();
		String prgNameToEnter="";
		switch (program_Name) {
		case "valid": prgNameToEnter = utils.generateProgramName();
		case "onlynumbers": prgNameToEnter = "888888888888";
		case "onlyspecialcharacters": prgNameToEnter = "$$$$$$$$$";
		case "blank": prgNameToEnter = "";
		default : prgNameToEnter = "";
		}	
		sendText(popUp_programNameInputBox,prgNameToEnter);
		return prgNameToEnter;
	}
	public void enterProgramDescription(String description) {
		String program_Description = description.toLowerCase();
		String prgDescriptionToEnter="";
		switch (program_Description) {
		case "valid": prgDescriptionToEnter =  getProgramDescription();
		case "onlynumbers": prgDescriptionToEnter = "888888888888";
		case "onlyspecialcharachers": prgDescriptionToEnter = "$$$$$$$$$";
		case "blank": prgDescriptionToEnter = "";
		default : prgDescriptionToEnter = "";
		}	
		sendText(popUp_programDescriptionInputBox,prgDescriptionToEnter);	
	}
	public List<String> deleteMultipleRecord(int count) {
		int totalRecordToDelete = count;
		List<String> listOfProgramName = new ArrayList<String>();
		listOfProgramName.add(click_on_checkBox(1,totalRecordToDelete));
		
		click_on_commonDeleteIcon();
		return listOfProgramName;
	}
	public String deleteSingleRecord(int count) {
		int totalRecordToDelete = count;
		Actions action = new Actions(driver);
		String prgmName = click_on_checkBox(1,totalRecordToDelete);
		waitForElementToBeVisible(By.xpath("//tr["+count+"]/td[5]//div[@class='action']//button[@id='deleteProgram']"));
		WebElement deleteButtonOfRowToDelete = driver.findElement(By.xpath("//tr["+count+"]/td[5]//button[@id='deleteProgram']"));//div[@class='action']//button[@id='deleteProgram']
		action.moveToElement(deleteButtonOfRowToDelete).click().build().perform();
		driver.switchTo().activeElement();	
		return prgmName;
	}
	
	public String click_on_checkBox(int fromRowNum , int toRowNum) {
		List<WebElement> checkboxEnable = new ArrayList<WebElement>();
		checkboxEnable=driver.findElements(checkbox);
		for(int i=fromRowNum; i<=toRowNum; i++) {
			if ( checkboxEnable.get(i).isEnabled()) {
					checkboxEnable.get(i).click();
					checkboxEnable.get(i).click();
				}
				}
		
		String prgmName = driver.findElement(By.xpath("//tr["+fromRowNum+"]/td[2]")).getText();
		return prgmName;
	}
	
	public void click_on_programEditIcon(int pageNum,int rowNum) {
		List<WebElement> editIconList = new ArrayList<WebElement>();
		WebElement nextPaginator = driver.findElement(By.xpath("//button[contains(@class,'p-paginator-next')]"));
		int totalPageCount = extractTotalNumberOfPagesFromFooter();
		int i = 1;
		while(i <= totalPageCount) {
			if(i==pageNum) {
				editIconList = driver.findElements(listOfEditIconOnPage);
				LoggerLoad.info("Total edit icon on given page are : "+editIconList.size());
				i= totalPageCount+1;
    			break;
			}
			
        	i++;
        	if (i <= totalPageCount) {
        	nextPaginator.click();
        	}
		}
		if(rowNum<=5 && rowNum>=1) {
		editIconList.get(rowNum-1).click();
		LoggerLoad.info("Clicked on edit icon on program page");
		}
		else {
			LoggerLoad.info("Invalid row number!! Enter valid one");
		}
	}
	
	public void click_on_commonDeleteIcon() {
		Actions action = new Actions(driver);
		waitForElementToBeVisible(commonDeleteIcon);
		WebElement deleteButtonOfRowToDelete = driver.findElement(commonDeleteIcon);
		action.moveToElement(deleteButtonOfRowToDelete).click().build().perform();
		driver.switchTo().activeElement();	
	}
	
	public String getProgramNameBeforeEdit() {
		return getText(popUp_programNameInputBox);
	}
	
	public String getProgramDescriptionBeforeEdit() {
		return getText(popUp_programDescriptionInputBox);
	}
	
	public int totalRecordsDisplayed() {
		
		waitForElementToBeVisible(total_Entries);	
		return getCount(total_Entries);
	}
		
	public String getActualErrorMessage(String errMsgType) {
		waitForElementToBeVisible(By.xpath("//small[contains(text(),'"+errMsgType+"')]"));
		WebElement errorMsgElement = driver.findElement(By.xpath("//small[contains(text(),'"+errMsgType+"')]"));
		return errorMsgElement.getText();	
	}
	
	public String getActualErrorMessage_invalidValues(String errMsgType) {
		waitForElementToBeVisible(By.xpath("//label[text()='"+errMsgType+"']/following-sibling::small"));
		WebElement errorMsgElement = driver.findElement(By.xpath("//label[text()='"+errMsgType+"']/following-sibling::small"));
		return errorMsgElement.getText();	
	}
	public int getTotalRecordsFromFooterText() {
		WebElement footer = driver.findElement(footer_path);
    	String[] recordCount =  footer.getText().split(" ");
    	LoggerLoad.info("Record count from app : "+recordCount[4]);
    	return Integer.valueOf(recordCount[4]);
    	
	}
	
	public int extractTotalNumberOfPagesFromFooter() {
    	int totalRecordCount = getTotalRecordsFromFooterText();
    	int rem = totalRecordCount/5;
    	int pageCount =0;
    	
    	if(rem > 0) {
    		pageCount = rem +1;
    	}
    	else {
    		pageCount = rem;
    	}
    	return pageCount;
    }	
	// Get Expected footer text to compare against actual footer text
	public String getExpectedShowingXoutOfYEntriesTextFromPaginationFooter(int pageNum) {
		int totalRecordCount = getTotalRecordsFromFooterText();
		int startRecordNum = (pageNum-1)*5+1;
		int endRecordNum = startRecordNum+4;
		String output = "Showing "+startRecordNum+" to "+Math.min(endRecordNum, totalRecordCount)+" of "+totalRecordCount+" entries";
		LoggerLoad.info("Pagination text on page "+pageNum+ "  : "+output);
		return output;
	}
	
	public String getExpectedFooterText(By module) {
		List<String> listOfTotalRecords = countOfEntries(module);
		int totalRecordsCount = listOfTotalRecords.size();
		if(module==programModule) {
			LoggerLoad.info("In total there are "+totalRecordsCount+" programs.");
			return "In total there are "+totalRecordsCount+" programs.";
		}
		return null;
	}
	
	// Sort the list of records for given column
	public List<String> getListOfRecords(String columnHeader, int columnNumber){
		List<String> listBeforeSorting = getRecordsByField(columnHeader,columnNumber);
		return listBeforeSorting;
	}
	
	// Sort the list in ascending order
	public List<String> getListInAscendingOrder(List<String> listOfDataToReorder){
        List<String> ascendingOrder = listOfDataToReorder.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
        LoggerLoad.info("-------------------------------------------------");
        LoggerLoad.info("List in ascending order");
        LoggerLoad.info("-------------------------------------------------");
        for(String data : ascendingOrder) {
    		LoggerLoad.info(data);
    	}
        return ascendingOrder;
	}
	
	// Sort the list in descending order
	public List<String> getListInDescendingOrder(List<String> listOfDataToReorder){
		
        List<String> descendingOrder = listOfDataToReorder.stream()
        		.sorted(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
        LoggerLoad.info("-------------------------------------------------");
        LoggerLoad.info("List in descending order");
        LoggerLoad.info("-------------------------------------------------");
        for(String data : descendingOrder) {
        	LoggerLoad.info(data);
    	}
        return descendingOrder;
	}
	
	
	// Check if the list is sorted in ascending order
	public boolean validateIfSortedInAscendingOrder(List<String> givenList) {
		
        boolean isLexicographicallyAscending = true;
        for (int i = 0; i < givenList.size() - 1; i++) {
            if (givenList.get(i).compareToIgnoreCase(givenList.get(i + 1)) > 0) {
            	isLexicographicallyAscending = false;
        LoggerLoad.info("Ascending order failing as element "+i+" : "+givenList.get(i));
        LoggerLoad.info("and element "+(i+1)+" : "+givenList.get(i+1)+" are out of order");
                break;
            }
        }
     
        if (isLexicographicallyAscending) {
        	LoggerLoad.info("The list is in case-insensitive ascending order.");
        } else {
        	LoggerLoad.info("The list is not in case-insensitive ascending order.");
        }
        return isLexicographicallyAscending;
	}
	
	// Check if the list is sorted in descending order
	public boolean validateIfSortedInDescendingOrder(List<String> givenList) {
        boolean isLexicographicallyDescending = true;
        for (int i = 0; i < givenList.size() - 1; i++) {
            if (givenList.get(i).compareToIgnoreCase(givenList.get(i + 1)) < 0) {
                isLexicographicallyDescending = false;
                LoggerLoad.info("Descending order failing as element " + i + " : " + givenList.get(i));
                LoggerLoad.info("and element " + (i+1) + " : " +givenList.get(i+1) + " are out of order");
                break;
            }
        }

        if (isLexicographicallyDescending) {
        	LoggerLoad.info("The list is in case-insensitive descending order.");
        } else {
        	LoggerLoad.info("The list is not in case-insensitive descending order.");
        }
        return isLexicographicallyDescending;
    }
	
	public  List<String> getRecordsByField(String header, int columnNum){
		int columnNumToRead = columnNum;
		WebElement element_columnHeader = driver.findElement(By.xpath("//th["+columnNumToRead+"]"));
		LoggerLoad.info("Reading "+element_columnHeader.getText()+"'s records");
		
		List<String> allRecords = new ArrayList<String>();
		WebElement nextPaginator = driver.findElement(By.xpath("//button[contains(@class,'p-paginator-next')]"));
		while(true) {
			List<WebElement> visibleRowsOnPage = driver.findElements(By.xpath("//tbody/tr"));
			for(int rowNum = 1 ; rowNum <= visibleRowsOnPage.size(); rowNum++) {
			WebElement	element = driver.findElement(By.xpath("//tr["+rowNum+"]/td["+columnNumToRead+"]"));
        	//add each entry in list
        		allRecords.add(element.getText());
        	}
        	//i++;
        	if (nextPaginator.isEnabled() ) {
        	nextPaginator.click();
        	}else {
        		break;
        	}
		}
		
		if(allRecords.size()>0) {
		return allRecords;
		}
		else return null;
	}
	
	public  List<String> countOfEntries(By module){
    	WebElement givenmodule = driver.findElement(module);
    	givenmodule.click();
    	List<String> listOfEntries = new ArrayList<String>();
    	int tableRowCount = driver.findElements(table_Rows_Count).size();
    	
    	if(tableRowCount > 0) {	
    		
            List<WebElement> totalEntries;
    		int totalPageCount = extractTotalNumberOfPagesFromFooter();
    		LoggerLoad.info("Total Page Count is : " +totalPageCount);
    		int i = 1;
    		while(i <= totalPageCount) {
    			totalEntries = driver.findElements(total_Entries);
            	//add each entry in list
            	for (WebElement element : totalEntries) {
            		listOfEntries.add(element.getText());
            	}
            	i++;
            	if (i <= totalPageCount) {
            	waitForElementToBeVisible(next_Paginator);
            	WebElement nextPaginator = driver.findElement(next_Paginator);
            	nextPaginator.click();
            	}
    		}
    	} else {
    		LoggerLoad.info("No records found on "+givenmodule.getText()+" page");
    	}
    	return listOfEntries;
    }
	
	
	public void getManageProgramPage() {
		login();
		waitForElementToBeVisible(programModule);
		driver.findElement(programModule).click();
		LoggerLoad.info("Landed on manage program page");
	}
	public void getDashboardPage() {
		login();
		waitForElementToBeVisible(program_Header);
		LoggerLoad.info("Landed on dashboard page");
	}
	
	/**********************validations ****************************************************/
	//TODO : need to generalize for variable pageNum..right now its taking only page 1.
	public boolean validatePaginationFooterText() {
		waitForElementToBeVisible(actualText_paginationFooter);
		String actualText_PaginationFooter = driver.findElement(actualText_paginationFooter).getText();
		String expectedText_PaginationFooter = getExpectedShowingXoutOfYEntriesTextFromPaginationFooter(1);
		
		return (actualText_PaginationFooter.compareTo(expectedText_PaginationFooter)==0);
	}
	
	public boolean validateProgramFooterText() {
		waitForElementToBeVisible(footer_path);
		String actualFooterText = driver.findElement(footer_path).getText();
		String expectedFooterText = getExpectedFooterText(programModule);
		return (actualFooterText.compareTo(expectedFooterText)==0);
	}
	
	public boolean validateDeleteButton() {
		waitForElementToBeVisible(deleteButtonTopLeft);
		if(driver.findElement(deleteButtonTopLeft).isEnabled()) {
			return false;
		}
		else return true;
	}
	
	public boolean validate_programHeader() {
		waitForElementToBeVisible(program_Header);
		String actualProgramHeader = driver.findElement(program_Header).getText();
		if(actualProgramHeader.equals("Manage Program")) {
			return true;
		}else {
			return false;
		}
	}
	public boolean validate_programAddition(String prgName) {
		List<String> allRecords = countOfEntries(programModule);
		if(allRecords.contains(prgName)) {
		return true;
		}
		else return false;
	}
	public boolean validatePage(String page){
		String input = page.toLowerCase();
		String currentURL = getCurrentURL();
		switch (input) {
		case "login" : if(currentURL.compareTo(loginURL)==0) {
							LoggerLoad.info("Login page is displayed");
							return true;
						}
		case "program" : if(currentURL.compareTo(programURL)==0) {
							LoggerLoad.info("Program page is displayed");
							return true;
		}
		case "batch" : if(currentURL.compareTo(batchURL)==0) {
							LoggerLoad.info("Batch page is displayed");
							return true;
		}
		case "user" : if(currentURL.compareTo(userURL)==0) {
							LoggerLoad.info("Login page is displayed");
							return true;
		}
		default : return false;
		}
	}

	public boolean validateConfirmDeletionMsg(String prgName) {
		WebElement element = driver.findElement(By.xpath("//p-confirmdialog//span[contains(text(),'"+prgName+"')]"));
		if(element.isDisplayed()) {
			LoggerLoad.info("Actual message on confirm deletion pop up : "+element.getText());
			LoggerLoad.info("Confirmation message with program name : "+prgName+" is displayed");
			return true;
		} else return false;
	}
	
	public boolean isEnabled(String elementName) {
		String element = elementName.toLowerCase();
		switch(element) {
		case "commondeleteoption" : {
			WebElement elementToCheck = driver.findElement(commonDeleteIcon);
			if(elementToCheck.isEnabled()) {
				LoggerLoad.info(elementName+" is enabled!");
				return true;
			} 
		}
		default : return false;
			}	
	}

	// Check if the list contains a specific string
	public boolean validateIfProgramNamePresentInTable(String programName) {
		 String searchString = programName;
		 List<String> listOfColumnData = getRecordsByField("Program Name Field",2);
		  if (listOfColumnData.contains(searchString)) {
			  	  LoggerLoad.info("The list contains the string: " + searchString);
		          return true;
		  } else {
			  	  LoggerLoad.info("The list does not contain the string: " + searchString);
		          return false;
		        }
			}
	
	
	/**********************end of validations**********************************************/
	
	/**********************Common methods : wait helpers **********************************************/
	
	public void waitForElementToBeVisible(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForInvisibilityOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public void waitForElementToBeClickable(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean isDisplayed(By locator) {
		waitForElementToBeVisible(locator);
		return driver.findElement(locator).isDisplayed();
	}
	
	public String confirmElementDirection(By locator) {
        WebElement element = driver.findElement(locator);
        Point location = element.getLocation();
        int xCoordinate = location.getX();
        int yCoordinate = location.getY();

        if (xCoordinate > 0 && yCoordinate > 0) {
            return "The element is located towards the bottom-right direction.";
        } else if (xCoordinate > 0 && yCoordinate < 0) {
            return "The element is located towards the top-right direction.";
        } else if (xCoordinate < 0 && yCoordinate > 0) {
            return "The element is located towards the bottom-left direction.";
        } else {
            return "The element is located towards the top-left direction.";
        }
    }
	
	public  boolean isElementDisplayed(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }
	
	/*******************end of commonmethods************************************************************/
	
	public boolean isDisplayed(String header) {
		String columnHeader = header.toLowerCase();
		switch (columnHeader) {
		case "program name": 
			if (driver.findElement(columnHeader_ProgramName).isDisplayed()) {
				LoggerLoad.info("ProgramName is Displayed ");
				return true;
			}	
		case "program description": 
			if (driver.findElement(columnHeader_ProgramDescription).isDisplayed()) {
				LoggerLoad.info("Program Description is Displayed ");
				return true;
			}
		case "program status": 
			if (driver.findElement(columnHeader_ProgramStatus).isDisplayed()) {
				LoggerLoad.info("Program Status is Displayed ");
				return true;
			}		
		case "edit_delete": 
			if (driver.findElement(columnHeader_Edit_Delete).isDisplayed()) {
				LoggerLoad.info("Edit/Delete is Displayed ");
				return true;
			}		
		case "a new program": 
			if (driver.findElement(newProgramButton).isDisplayed()) {
				LoggerLoad.info("New Program Button is Displayed ");
				return true;
			}		
		case "searchbar" :
			if (driver.findElement(searchbar).isDisplayed()) {
				LoggerLoad.info("Search bar is displayed with text as \"Search...\"");
				return true;
			}
		case "checkbox" : 
			if (driver.findElements(listOfCheckBoxOnPage).size()>1) {
				LoggerLoad.info("check box on the left side in all rows of the data table is present ");
				return true;
			}
		case "edit button" : 
			if (driver.findElements(listOfEditIconOnPage).size()>1) {
				LoggerLoad.info("Edit icon in all rows of the data table is present ");
				return true;
			}
		
		case "delete button" :
				if (driver.findElements(listOfDeleteIconOnPage).size()>2) {
					LoggerLoad.info("Delete icon in all rows of the data table is present ");
					return true;
				}
		
		case "sort icon" :
			if (driver.findElements(listOfSortIcon).size()==3) {
				LoggerLoad.info("Sort arrow icon is present beside each column header except Edit and Delete");
				return true;
			}
		
		case "programnameinputbox" : 
			if (driver.findElement(popUp_programNameInputBox).isDisplayed()) {
				LoggerLoad.info("Program Name InputBox is present on program details pop up.");
				return true;
			}
		
		case "programdescriptioninputbox" : 
			if (driver.findElement(popUp_programDescriptionInputBox).isDisplayed()) {
				LoggerLoad.info("Program Description InputBox is present on program details pop up.");
				return true;
			}	
		case "activestatusradio" : 
			if (driver.findElement(popUp_radio_ActiveStatus).isDisplayed()) {
				LoggerLoad.info("Active status is present on program details pop up.");
				return true;
			}
		case "inactivestatusradio" :
			if (driver.findElement(popUp_radio_InactiveStatus).isDisplayed()) {
				LoggerLoad.info("Inactive status is present on program details pop up.");
				return true;
			}
		case "save" : 
			if (driver.findElement(popUp_saveProgramButton).isDisplayed()) {
				LoggerLoad.info("Save button is present on program details pop up.");
				return true;
			}
		case "cancel" : 
			if (driver.findElement(popUp_cancelProgramButton).isDisplayed()) {
				LoggerLoad.info("Cancel button is present on program details pop up.");
				return true;
			}
		case "closexicon" : 
			if (driver.findElement(popUp_closeIconProgramDetails).isDisplayed()) {
				String location = confirmElementDirection(popUp_closeIconProgramDetails);
				LoggerLoad.info("Close(X) Icon "+location);
				return true;
			}
		case "successmsg" : {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				LoggerLoad.info("Exception occured in successmsg thread : "+e);
				e.printStackTrace();
			}
			if (driver.findElement(popUp_SuccessMessage).isDisplayed()) {
				LoggerLoad.info("Success pop up is displayed!");
				return true;
			}
		}
		case "programdetailspopupwindow" :{
				if (driver.findElement(popUp_programDetailsHeader).isDisplayed()) {
				LoggerLoad.info("Program Details pop up is displayed!");
				return true;
			}else return false;
		}
		case "programdetailspopupwindowclosed": {
		    waitForInvisibilityOfElement(programDetailsPopUp);
		    try {
		        if (driver.findElement(popUp_programDetailsHeader).isDisplayed()) {
		            LoggerLoad.info("Program Details pop up is still present!");
		            return true;
		        } else {
		            LoggerLoad.info("Program Details pop up is closed!");
		            return false;
		        }
		    } catch (NoSuchElementException e) {
		        LoggerLoad.info("Program Details pop up is closed!");
		        return false;
		    } catch (StaleElementReferenceException e) {
		        LoggerLoad.info("Program Details pop up is closed!");
		        return false;
		    }
		}
		case "confirmdeletionpopup" :{
			if (driver.findElement(popUp_confirmDeletion).isDisplayed()) {
				LoggerLoad.info("Deletion pop up alert is displayed with heading Confirm!");
				return true;
			} else return false;
		}
		case "confirmdeletionpopupclosed": {
		    waitForInvisibilityOfElement(popUp_confirmDeletion);
		    try {
		        if (driver.findElement(popUp_confirmDeletion_Yes).isDisplayed()) {
		            LoggerLoad.info("Deletion pop up alert is still present!");
		            return true;
		        } else {
		            LoggerLoad.info("Deletion pop up alert is closed!");
		            return false;
		        }
		    } catch (NoSuchElementException e) {
		        LoggerLoad.info("Deletion pop up alert is closed!");
		        return false;
		    } catch (StaleElementReferenceException e) {
		        LoggerLoad.info("Deletion pop up alert is closed!");
		        return false;
		    }
		}
		case "deletionpopup_closexicon" : 
			if (driver.findElement(popUp_confirmDeletion_closeX).isDisplayed()) {
				LoggerLoad.info("deletionpopup_closexicon is displayed");
				return true;
			}
		case "deletionpopup_yes" : 
			if (driver.findElement(popUp_confirmDeletion_Yes).isDisplayed()) {
				LoggerLoad.info("deletionpopup_yes is displayed");
				return true;
			}
		case "deletionpopup_no" : 
			if (driver.findElement(popUp_confirmDeletion_No).isDisplayed()) {
				LoggerLoad.info("deletionpopup_no is displayed");
				return true;
			}
		
		default:
			return false;
		}
	}
	
	public String getCurrentURL() {
		String actualURL = driver.getCurrentUrl();
		return actualURL;
	}
	
	public int getCount(By locator) {
		return driver.findElements(locator).size();
	}
	
	public void click(By locator) {
		waitForElementToBeVisible(locator);
		driver.findElement(locator).click();
	}
	public void sendText(By locator, String str) {
		waitForElementToBeVisible(locator);
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(str);
	}
	
	public String getText(By locator) {
		waitForElementToBeVisible(locator);
		WebElement element = driver.findElement(locator);
		return element.getText();
	}
	
/*===========Code for randomly choosing programDescription from given list==================================*/

	    public String getProgramDescription() {
	        ArrayList<String> programs = new ArrayList<>();
	        programs.add("SeleniumHackathon");
	        programs.add("CucumberBDD");
	        programs.add("JiraBoard");
	        programs.add("LMS");
	        programs.add("FrameworkDesign");

	        Random random = new Random();
	        String chosenProgram;
	        do {
	            chosenProgram = programs.get(random.nextInt(programs.size()));
	        } while (chosenProgram.equals(lastChosenProgram));

	        lastChosenProgram = chosenProgram;

	        // Return the chosen program
	        return chosenProgram;
	    }
}
