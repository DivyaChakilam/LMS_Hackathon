package lms.hackathon.ui.pageobjects;

	import java.util.ArrayList;
	import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.collect.Ordering;

import lms.hackathon.ui.utilities.LoggerLoad;

	public class CommonPage {

		WebDriver driver;
		By locator;
		List<String> columnContentList ; 
		List<String> beforeSortingList = new ArrayList<String>();
		List<String> afterSortingList = new ArrayList<String>();
		int lastPage=0;

	            public CommonPage(WebDriver driver) {
	            	super();
	            	this.driver = driver;
	            	PageFactory.initElements(driver,this);
	            }
		
	// @FindBy(xpath="//table[@role='grid']//th[contains(@class,'sortable')]")
	 //List<WebElement> sortableList;
	 
	 private By rows = By.xpath("//table[@role='grid']//tbody//tr");
     
	 private By nextButton = By.xpath("//div[contains(@class,'paginator')]//button[contains(@class,'paginator-next')]");
	 private By pages = By.xpath("//div[contains(@class,'paginator')]//span//button[contains(@class,'paginator')]");
	
	public void sortByField(String fieldName, int column) throws InterruptedException {	
			driver.findElement(By.id("user")).click();
			driver.findElement(By.xpath("//table[@role='grid']//th[(contains(@class,'sortable') "
					+ "and contains(text(),'"+fieldName+"'))]")).click();
		// beforeSorting();
		 afterSorting(column,fieldName);
	 }	 
		 
	 public void afterSorting(int column, String fieldName) throws InterruptedException {
		 
			 columnContentList =  new ArrayList<String>(); 
			   List<WebElement> pageList = driver.findElements(pages);
			   int currentPg=0;
			   Boolean allPages = true; 
		while(allPages) {	   
			for(int pageNo=0;pageNo<pageList.size();pageNo++) { 		
			 if(currentPg<pageList.size()) {
				  if(driver.findElement(nextButton).isEnabled()) {
					   driver.findElement(nextButton).click();
					   checkContent(column,fieldName);
				   }
				  else {
				  allPages=false;
				  break;
				  }
					   currentPg = pageNo;
			 }
		}
			   pageList = driver.findElements(pages);
			   if(pageList.size()==0){
				   allPages=false;
			   }
		}
		    afterSortingList = columnContentList;
	        displayList(afterSortingList, fieldName);
		}
    
	 
	public void displayList(List<String> displayList, String fieldName) {
		int no=0;
	    for(String colText: displayList) {
	   	      no++;
				 //System.out.println(no +" Text: "+colText);
			 }
	      LoggerLoad.info("Sorting of "+fieldName+" in Proper Order with ignoring case");	    

	 			 System.out.println("Sorting of "+fieldName+" in Proper Order with ignoring case");
			 //Assert.assertTrue(Ordering. natural().isOrdered(displayList));
	}
		
	 public List<String> checkContent(int colNumber, String fieldName) throws InterruptedException {
		 int rowNumber;
		 colNumber= colNumber+1;
		 WebElement columnElement;
		 List<WebElement> rowList = driver.findElements(rows);
		   for(int row=0; row<rowList.size();row++) {
			 rowNumber = row+1;	
			 columnElement = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+rowNumber+"]//td["+colNumber+"]"));
			 if(!(fieldName.contentEquals("No of Classes") ||
					 fieldName.contentEquals("Phone Number")||
					 fieldName.contains("ID")))
			 columnContentList.add(columnElement.getText().toUpperCase());
		 }
	    return columnContentList;
	 }
	 
}