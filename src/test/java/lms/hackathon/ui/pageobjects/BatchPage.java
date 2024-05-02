package lms.hackathon.ui.pageobjects;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.NoSuchElementException;

//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


//import lms.hackathon.ui.pageobjects.ReUsableMethods_Batch;
import lms.hackathon.ui.utilities.LoggerLoad;
import dev.failsafe.internal.util.Assert;


public class BatchPage {

	

	By username=By.xpath("//input[@id='username']");
	By password=By.xpath("//input[@id='password']");
	By login=By.xpath("//button[@id='login']");
	By batchButton = By.xpath("//button[@id='batch']");
	By managebatch=By.xpath("//mat-card-title[@class='mat-card-title']/div[1]");
	By batchName=By.xpath("//thead[@class='p-datatable-thead']/tr/th[2]");
	By batchDesc=By.xpath("//thead[@class='p-datatable-thead']/tr/th[3]");
	By batchStatus=By.xpath("//thead[@class='p-datatable-thead']/tr/th[4]");
	By noOfClass=By.xpath("//thead[@class='p-datatable-thead']/tr/th[5]");
	By programName=By.xpath("//thead[@class='p-datatable-thead']/tr/th[6]");
	By editDelete=By.xpath("//thead[@class='p-datatable-thead']/tr/th[7]");
	By deleteIcon=By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	By addBatch=By.xpath("//button[@label='A New Batch']/span[2]");	
	By checkbox=By.xpath("//div[@role='checkbox']");
	By enable_pageBtn=By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	By disable_pageBtn=By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple p-disabled']");
	By editButton=By.xpath("//button[@icon='pi pi-pencil']");
	By deleteButton=By.xpath("//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']");
	By popUpBatchDetails=By.xpath("//span[@class='p-dialog-title ng-tns-c132-6 ng-star-inserted']");
	By popUpBatchName=By.xpath("//input[@id='batchName']");
    By popUpBatchDesc=By.xpath("//input[@id='batchDescription']");
    By popUpProgramNamemDropDown= By.xpath("//div//label[text()='Program Name ']//..//div[@role='button']");
    By popUpstatus=By.xpath("//div[@class='radio ng-star-inserted']");
    By popUpNoOfClasses=By.xpath("//input[@id='batchNoOfClasses']");
	By ActiveRadioButton=By.xpath("//div[@class='radio ng-star-inserted']/div/p-radiobutton");
	By saveButton=By.xpath("//p-dialog//*[text()='Save']");
	By clickDeleteNo=By.xpath("//span[@class='p-button-icon p-button-icon-left pi pi-times']");
	By yesDeleteButton=By.xpath("//span[@class='p-button-icon p-button-icon-left pi pi-check']");
	By searchButton=By.xpath("//input[@id='filterGlobal']");
    By errorMessageOfBatchDescp=By.xpath("//small[@class='p-invalid ng-star-inserted']");
	By NoDeleteButton=By.xpath("//span[@class='p-button-icon p-button-icon-left pi pi-times']");
	By errorMessageBatchName=By.xpath("//small[@class='p-invalid ng-star-inserted']");
	By errorMessageProgramName=By.xpath("//small[@class='p-invalid ng-star-inserted']");
	By errorMessageBatchDescEdit=By.xpath("//small[@class='p-invalid ng-star-inserted']");
	By errorMessageBatchDescEditAndNoOfClasses=By.xpath("//small[@id='text-danger']");
	By delete = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");

	
private WebDriver driver;
public WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	
	public BatchPage(WebDriver driver) {
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void loginPage() {
		driver.findElement(username).sendKeys("sdetorganizers@gmail.com");
		driver.findElement(password).sendKeys("UIHackathon@02");
		driver.findElement(login).click();
	}
	
	public void clickBatch() {
		driver.findElement(batchButton).click();
		
	}
	public boolean batchURL() {
		//String expectedURL=driver.findElement(managebatch).getAttribute("herf");
		//String URL=driver.getCurrentUrl();
		//boolean text=driver.getPageSource().contains("Manage Batch");
		String actualurl = driver.getCurrentUrl();
		
		if(actualurl.contains("Manage Batch")) {
		
		System.out.println("Manage Batch Present");
	}
		else {
			System.out.println("Manage Batch not Present");
			//LoggerLoad.info("Manage Batch not Present");
			return false;
		}
		return false;
		
	}
		
     public WebElement manageBatch() {
    	 
    	WebElement visible1= driver.findElement(batchButton);
    	System.out.println(visible1.getText());
    	return visible1;
    	
     }
    	public void headersBatch() {
    		
    		WebElement present1= driver.findElement(batchName);
    		System.out.println(present1.getText());
    		
    		

    		WebElement present2= driver.findElement(batchDesc);
    		System.out.println(present2.getText());
    		
    		WebElement present3= driver.findElement(batchStatus);
    		System.out.println(present3.getText());
    		

    		WebElement present4= driver.findElement(noOfClass);
    		System.out.println(present4.getText());
    		
    		WebElement present5= driver.findElement(programName);
    		System.out.println(present5.getText());
    		
    		WebElement present6= driver.findElement(editDelete);
    		System.out.println(present6.getText());
    		
    			}
    	
    	public boolean deleteDisable() {
    		WebElement  ele= driver.findElement(deleteIcon);//.isEnabled();
    		if(ele.isDisplayed()) {
    			//LoggerLoad.info("Delete Button Disable");
    			System.out.println("Delete Button Disable");
    		}
    		else {
    			//LoggerLoad.info("Delete Button Enable");
    			System.out.println("Delete Button Enable");
    		}
    		return true;
    		}
    	public boolean aNewBatch() {
    		return driver.findElement(addBatch).isDisplayed();
    		
    	}
    	
    	public boolean paginationControl() {
    		
    		while(true) {
    		List<WebElement> enable=driver.findElements(enable_pageBtn);
    		List<WebElement> disable=driver.findElements(disable_pageBtn);
    		
    		if(enable.size()>0) {
    			enable.get(0).click();
    		}
    		else if (disable.size()>0) {
    			//LoggerLoad.info("No more Pages");
    			System.out.println("No more Pages");
    			break;
    		}
    		}
    		return true;
    		}
    	
    	public void rowWiseCheckBox() {
    		List<WebElement> checkboxEnable=driver.findElements(checkbox);
    		while(true) {
        		List<WebElement> enable=driver.findElements(enable_pageBtn);
        		List<WebElement> disable=driver.findElements(disable_pageBtn);
        		
        		checkboxEnable=driver.findElements(checkbox);
        		
       			for(int i=1; i<checkboxEnable.size(); i++) {
    				if ( checkboxEnable.get(i).isEnabled()) {
       					checkboxEnable.get(i).click();
       					checkboxEnable.get(i).click();
       				}
       				}
    		
       			if(enable.size()>0) {
        			enable.get(0).click();
        		}
        		else if (disable.size()>0) {
        			//LoggerLoad.info("No more Pages");
        			System.out.println("No more Pages");
        			break;
        			}
       			}
    	}
    		
    	
    	
    	
    	public void rowsEditButtonEnable() {
    			
    		List<WebElement> checkboxEnable=driver.findElements(editButton);
    		while(true) {
        		List<WebElement> enable=driver.findElements(enable_pageBtn);
        		List<WebElement> disable=driver.findElements(disable_pageBtn);
        		
        		 checkboxEnable=driver.findElements(editButton);
        		
        		 for(int i=1; i<checkboxEnable.size(); i++) {
     				if ( checkboxEnable.get(i).isEnabled()==true) {
     					//LoggerLoad.info("Edit Button Enable");
        					System.out.println("Edit Button Enable");
        				}
     				else {
     					//LoggerLoad.info("Not Enable");
     					System.out.println("Not Enable");
     				}
        			}
                       if(enable.size()>0) {
        			enable.get(0).click();
        		}
        		else if (disable.size()>0) {
        			//LoggerLoad.info("No more Pages");
        			System.out.println("No more Pages");
        			break;
        		}
    		}
    	}
    	
    	
    	public void rowsDeleteButtonEnable() {
    		
    		List<WebElement> checkboxEnable=driver.findElements(deleteButton);
    		while(true) {
        		List<WebElement> enable=driver.findElements(enable_pageBtn);
        		List<WebElement> disable=driver.findElements(disable_pageBtn);
        		
        		 checkboxEnable=driver.findElements(deleteButton);
        		
        		 for(int i=1; i<checkboxEnable.size(); i++) {
     				if ( checkboxEnable.get(i).isEnabled()==true) {
     					
     					//LoggerLoad.info("Delete Button Enable");
        					System.out.println("Delete Button Enable");
        				}
     				else {
     					//LoggerLoad.info("Not Enable");
     					System.out.println("Not Enable");
     				}
        			}
                       if(enable.size()>0) {
        			enable.get(0).click();
        		}
        		else if (disable.size()>0) {
        			//LoggerLoad.info("No more Pages");
        			System.out.println("No more Pages");
        			break;
        		}
    		}
       			
    	}
    	
    	public boolean deleteRowLevelAlertAppears() {
    		boolean status=false;
    	
    	List<WebElement> checkboxEnable=driver.findElements(deleteButton);
		while(true) {
    		List<WebElement> enable=driver.findElements(enable_pageBtn);
    		List<WebElement> disable=driver.findElements(disable_pageBtn);
    		
    		 checkboxEnable=driver.findElements(deleteButton);
    		 
    		
    		 for(int i=1; i<checkboxEnable.size(); i++) {
 				if ( checkboxEnable.get(i).isEnabled()==true) {
 					
 					//LoggerLoad.info("Alert Appears");
    					System.out.println("Alert Appears");
    					
    					checkboxEnable.get(i).click();
    					
    					for (String currentWindow : driver.getWindowHandles())
    		    			driver.switchTo().window(currentWindow);
    		    		{
    					driver.findElement(clickDeleteNo).click();
    					try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    		    		}
    				}
 				else {
 					
 					//LoggerLoad.info("Delete Not Enable");
 					System.out.println("Delete Not Enable");
 				}
    			}
                   if(enable.size()>0) {
    			enable.get(0).click();
    		}
    		else if (disable.size()>0) {
    			//LoggerLoad.info("No more Pages");
    			System.out.println("No more Pages");
    			break;
    		}
		}
		return true;
    	}
    	
    	
    	public void clickNewBatch() {
    		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
    				              .withTimeout(Duration.ofSeconds(10))
    				              .pollingEvery(Duration.ofMillis(100))
    				              .ignoring(ElementClickInterceptedException.class)
    				              .ignoring(NoSuchElementException.class);
    		
    		WebElement batchAdd=wait.until(ExpectedConditions.elementToBeClickable(addBatch));// driver.findElement(addBatch);
    	
    	batchAdd.click();
    	try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	
    	
    		public void popUpValidationBatchTitle() {
    		for (String currentWindow : driver.getWindowHandles())
    			driver.switchTo().window(currentWindow);
    		{
    			WebElement title=driver.findElement(popUpBatchDetails);
    			
    			System.out.println(title.getText());
    			
    		}
    		
    			}
    		
    		
    		
    	public void popUpFeildsValidtion() {
    		for (String currentWindow : driver.getWindowHandles())
    			driver.switchTo().window(currentWindow);
    		{
    			
    		
    		
    String nameText=driver.findElement(popUpBatchName).getAttribute("type");
    		
    		if("text".equals(nameText)) {
    			//LoggerLoad.info("Name is a TextBox");
    		System.out.println("Name is a TextBox");
    		}
    		else {
    			//LoggerLoad.info("Name is not a text box");
    			System.out.println("Name is not a text box");
    		}
    		
    		String batchDsc=driver.findElement(popUpBatchDesc).getAttribute("type");
    		
    		if("text".equals(batchDsc)) {
    			//LoggerLoad.info("BatchDescription is a TextBox");
    			System.out.println("BatchDescription is a TextBox");
    		}
    		else {
    			//LoggerLoad.info("BatchDescription is not a text box");
    			System.out.println("BatchDescription is not a text box");
    		}
    		 String dropDown= driver.findElement(popUpProgramNamemDropDown).getAttribute("aria-haspopup");
    	      if("listbox".equals(dropDown)) {
    	    	 // LoggerLoad.info("Program Name is DropDown");
    	    	  System.out.println("Program Name is DropDown");
    	    	  
    	      }
    	      else {
    	    	 // LoggerLoad.info("Program Name is not DropDown");
    	    	  System.out.println("Program Name is not DropDown");
    	      }
    			
    	WebElement stsRadio=driver.findElement(popUpstatus);

    	   System.out.println(stsRadio.getText());
    			
    			     String numCls=driver.findElement(popUpNoOfClasses).getAttribute("type");
    			
    			if("number".equals(numCls)) {
    				//LoggerLoad.info("NoOfClasses is a TextBox");
    				System.out.println("NoOfClasses is a TextBox");
    			}
    			else {
    				//LoggerLoad.info("NoOfClasses is not a TextBox");
    				System.out.println("NoOfClasses is not a text box");
    			}
    	}
    	}
    	
    	//************* creating batch with empty field of description ***************
    	public boolean enterFeildsExpectDesc() throws InterruptedException {
    		for (String currentWindow : driver.getWindowHandles())
    			driver.switchTo().window(currentWindow);
    		{
    			driver.findElement(popUpBatchName).sendKeys("SDET1377");
    			//driver.findElement(popUpBatchDesc).sendKeys("Testing");
    			//driver.findElement(programName).sendKeys("SeleniumJavaOOps");
    			//driver.findElement(popUpProgramNamemDropDown).click();
    			
    			//driver.findElement(By.xpath("//span[text()='LMSprogram']")).click();
    			    			
                
    			driver.findElement(ActiveRadioButton).click();
    			driver.findElement(popUpNoOfClasses).sendKeys("2");
    			driver.findElement(saveButton).click();
    			
    			boolean errorDesc=driver.findElement(errorMessageOfBatchDescp).isDisplayed();
    			//Thread.sleep(20);
    			System.out.println(wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMessageOfBatchDescp))).getText());
    			
    			if(errorDesc==true) {
    				//LoggerLoad.info("Batch Description is required");
    				System.out.println("Batch Description is required.");
    				return false;
    			}
    			else {
    				return true;
    			}
    		}
    	}
    			
    		
			
			
    		
    	
    	
    	// ********* batch creation with invalid batch name*********
    	public boolean batchCreateInvalidBatchName() throws InterruptedException {
    		for (String currentWindow : driver.getWindowHandles())
    			driver.switchTo().window(currentWindow);
    		{
    			driver.findElement(popUpBatchName).sendKeys("@@@@");
    			//driver.findElement(popUpBatchDesc).sendKeys("Testing");
    			//driver.findElement(programName).sendKeys("SeleniumJavaOOps");
    			//driver.findElement(popUpProgramNamemDropDown).click();
    			
    			//driver.findElement(By.xpath("//span[text()='LMSprogram']")).click();
    			    			
                
    			driver.findElement(ActiveRadioButton).click();
    			driver.findElement(popUpNoOfClasses).sendKeys("2");
    			driver.findElement(saveButton).click();
    			boolean errorDesc=driver.findElement(errorMessageBatchName).isDisplayed();
    			System.out.println(wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMessageOfBatchDescp))).getText());
    			
    			if(errorDesc==true) {
    				System.out.println("This field should start with an alphabet and min 2 character.");
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
    	}
    			
    	//********* batch creation without program name*******
    	public boolean batchCreateWithoutProgramName()  {
    		for (String currentWindow : driver.getWindowHandles())
    			driver.switchTo().window(currentWindow);
    		{
    			driver.findElement(popUpBatchName).sendKeys("SDET");
    			//driver.findElement(popUpBatchDesc).sendKeys("Testing");
    			//driver.findElement(programName).sendKeys("SeleniumJavaOOps");
    			//driver.findElement(popUpProgramNamemDropDown).click();
    			
    			    			
                
    			driver.findElement(ActiveRadioButton).click();
    			driver.findElement(popUpNoOfClasses).sendKeys("2");
    			driver.findElement(saveButton).click();
    			boolean errorDesc=driver.findElement(errorMessageProgramName).isDisplayed();
    			System.out.println(wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMessageOfBatchDescp))).getText());
    			
    			if(errorDesc==true) {
    				System.out.println("Program Name is required.");
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
    	}
    		
    	//*******edit batch with valid data********
public boolean editBatchWithValidData() {
	
	driver.findElement(searchButton).sendKeys("ci/cd");
	driver.findElement(editButton).click();

	for (String currentWindow : driver.getWindowHandles())
		driver.switchTo().window(currentWindow);
	{
		driver.findElement(popUpBatchDesc).sendKeys("SDET");
		driver.findElement(popUpNoOfClasses).sendKeys("2");
		driver.findElement(saveButton).click();


	 return true;
	}
    	}
//*******  batch edit with invalid description******
    		
public WebElement editBatchWithInvalidDesc() throws InterruptedException {
	
	driver.findElement(searchButton).sendKeys("ci/cd");
	driver.findElement(editButton).click();

	for (String currentWindow : driver.getWindowHandles())
		driver.switchTo().window(currentWindow);
	{
		WebElement editDesc=driver.findElement(popUpBatchDesc);
		editDesc.clear();
		editDesc.sendKeys("@@@@");
		driver.findElement(popUpNoOfClasses).sendKeys("2");
		driver.findElement(saveButton).click();
		
		//WebElement errorMessageForDesc=driver.findElement(errorMessageBatchDescEdit1);
		
		
		WebElement errorMessageForDesc=null;
		int repeat=0;
		while(repeat<=3) {
			try {
				errorMessageForDesc=driver.findElement(errorMessageBatchDescEditAndNoOfClasses);
				errorMessageForDesc.isDisplayed();
				break;
				
			}
			catch(StaleElementReferenceException exe) {
				exe.printStackTrace();
			}
			repeat++;
		}
	
		
		if(errorMessageForDesc==null) {
			throw new NotFoundException("the webelement was not located");
		
		}
	 return errorMessageForDesc;
		
		
    	}
		
}


//********** batch edit with NoOfClasses empty field *****************

public WebElement editBatchWithEmptyNoOfClasses() throws InterruptedException {
	
	driver.findElement(searchButton).sendKeys("ci/cd");
	driver.findElement(editButton).click();

	for (String currentWindow : driver.getWindowHandles())
		driver.switchTo().window(currentWindow);
	{
		WebElement editDesc=driver.findElement(popUpBatchDesc);
		editDesc.clear();
		editDesc.sendKeys("Testing");
		WebElement editNoOfClasses=driver.findElement(popUpNoOfClasses);
		editNoOfClasses.clear();
		//Thread.sleep(20);
		//editNoOfClasses.sendKeys("");
		driver.findElement(saveButton).click();
		
		//WebElement errorMessageForDesc=driver.findElement(errorMessageBatchDescEdit1);
		
		
		WebElement errorMessageForDesc=null;
		int repeat=0;
		while(repeat<=3) {
			try {
				errorMessageForDesc=driver.findElement(errorMessageBatchDescEditAndNoOfClasses);
				errorMessageForDesc.isDisplayed();
				break;
				
			}
			catch(StaleElementReferenceException exe) {
				exe.printStackTrace();
			}
			repeat++;
		}
	
		
		if(errorMessageForDesc==null) {
			throw new NotFoundException("the webelement was not located");
		
		}
	 return errorMessageForDesc;
		
		
    	}
		
}

    	//********* edit batch with empty desccription field*********

public WebElement editBatchWithEmptyDesc() throws InterruptedException {
	
	driver.findElement(searchButton).sendKeys("ci/cd");
	driver.findElement(editButton).click();

	for (String currentWindow : driver.getWindowHandles())
		driver.switchTo().window(currentWindow);
	{
		WebElement editDesc=driver.findElement(popUpBatchDesc);
		editDesc.clear();
		//Thread.sleep(20);
		//editDesc.sendKeys("");
		WebElement editNoOfClasses=driver.findElement(popUpNoOfClasses);
		editNoOfClasses.clear();
		//Thread.sleep(20);
		editNoOfClasses.sendKeys("2");
		driver.findElement(saveButton).click();
		
		//WebElement errorMessageForDesc=driver.findElement(errorMessageBatchDescEdit1);
		
		
		WebElement errorMessageForDesc=null;
		int repeat=0;
		while(repeat<=3) {
			try {
				errorMessageForDesc=driver.findElement(errorMessageBatchDescEditAndNoOfClasses);
				errorMessageForDesc.isDisplayed();
				break;
				
			}
			catch(StaleElementReferenceException exe) {
				exe.printStackTrace();
			}
			repeat++;
		}
	
		
		if(errorMessageForDesc==null) {
			throw new NotFoundException("the webelement was not located");
		
		}
	 return errorMessageForDesc;
		
		
    	}
		
}



    	//******search********
    		
    	public boolean searchEditedBatch() {
    		
			driver.findElement(searchButton).sendKeys("ci/cd");
			WebElement createdBatch=driver.findElement(By.xpath("//tr/td[2]"));
			
			if(createdBatch.isDisplayed()) {
				return true;
			}
			else {
				return false;
			}

    	}
    	
    		
    	
    	
    	
    	public void clickDeleteButton() {
    		
    		driver.findElement(searchButton).sendKeys("assert");
   		 driver.findElement(checkbox).click();
   		 driver.findElement(deleteButton).click();
    		
    	}
    	public void clickDeleteYes() {
   		 driver.findElement(yesDeleteButton).click();
   		String message= driver.switchTo().activeElement().getText();

		System.out.println(message);

    	}
    	
    	
    	public void validateAcceptAlert() {

        String messageAfterDelete= driver.switchTo().activeElement().getText();
        
    		try {
    			Thread.sleep(20);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		System.out.println(messageAfterDelete);
    	}
    	
    	
    	
    	public boolean acceptAlertForDeleteWithCheck() {
    		
    		WebElement checkboxsingle=driver.findElement(By.xpath("//tbody/tr/td"));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(checkboxsingle.getAttribute("selected") == null) {
				checkboxsingle.click();
			}
    		
    	//ReUsableMethods del = new ReUsableMethods();
		//del.singleCheck(By.xpath("//tbody/tr/td"),driver);
		driver.findElement(deleteButton).click();
  		 driver.findElement(yesDeleteButton).click();
  		String message= driver.switchTo().activeElement().getText();

  		System.out.println(message);
  		
  		String messageAfterDelete= driver.switchTo().activeElement().getText();
  		try {
  			Thread.sleep(10);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}

  		System.out.println(messageAfterDelete);
   	
		return true;
    	}
		
    	
    	
    	public void acceptAlertForDelete() throws InterruptedException {
    		
    		driver.findElement(searchButton).sendKeys("BatchTribe2110");
    		Thread.sleep(2000);
   		 driver.findElement(checkbox).click();
   		 driver.findElement(deleteButton).click();
   		 driver.findElement(yesDeleteButton).click();
   		String message= driver.switchTo().activeElement().getText();

   		System.out.println(message);
   		
   		String messageAfterDelete= driver.switchTo().activeElement().getText();
   		try {
   			Thread.sleep(10);
   		} catch (InterruptedException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}

   		System.out.println(messageAfterDelete);
    	}
    	
    	
public boolean rejectAlertForDelete() throws InterruptedException {
	

	WebElement checkboxsingle=driver.findElement(By.xpath("//tbody/tr/td"));
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(checkboxsingle.getAttribute("selected") == null) {
		checkboxsingle.click();
	}
    		
	//ReUsableMethods del = new ReUsableMethods();
	//del.singleCheck(By.xpath("//tbody/tr/td"),driver);
	driver.findElement(deleteButton).click();
		 driver.findElement(NoDeleteButton).click();
		String message= driver.switchTo().activeElement().getText();

		System.out.println(message);
		
		String messageAfterDelete= driver.switchTo().activeElement().getText();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(messageAfterDelete);
	
   		return true;
    	}

           //************ single batch delete ***************
    	
    	public boolean singleBatchDelete() throws InterruptedException {
    		
    		
    		WebElement clearText=driver.findElement(searchButton);
    		clearText.clear();
    		Thread.sleep(10);
    		clearText.sendKeys("ci/cd");
		driver.findElement(By.xpath("//tr/td[2]")).isDisplayed();
		driver.findElement(deleteButton).click();
		driver.findElement(yesDeleteButton).click();
		return true;
    	}
    	
    	//*********multiple batch delete*******
    	
    	public void multipleBatchDelete() {
    		
    		
    		
    		List<WebElement> checkbox= driver.findElements(By.xpath("//div[@role='checkbox']")) ;
    		try {
    			Thread.sleep(10);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    				for(int i=1; i<checkbox.size(); i+=2) {
    					System.out.println("Selected checkbox is :"+checkbox.get(i).getAttribute("selected"));
    					
    					if(checkbox.get(i).getAttribute("selected") == null) {
    						checkbox.get(i).click();
    						driver.findElement(delete).click();
    						
    					}
    				}
    	}
    	
    	
    	
}


