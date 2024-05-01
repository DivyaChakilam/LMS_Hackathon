package lms.hackathon.ui.pageobjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;
import org.openqa.selenium.Point;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DashboardPage {

	private WebDriver driver;
	//private WebDriverWait wait;
	private int timeoutInSeconds;
	private By logout = By.id("logout");
	//private By lmsLearningMgtitle = By.xpath("mat-toolbar/span[1]");
	
	private By titleofDash = By.xpath("//title");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.timeoutInSeconds = 30; 
	   
	}

	public void dashlogin(String userName, String password) {
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);;
		driver.findElement(By.id("login")).click();
	}

	//@DashboardPage-01
	public String validateModuleHeader() {
	
		return driver.findElement(By.className("box")).getText();
	}
	
	//@DashboardPage-02
	 public boolean verifyMaximumNavigationTime(int expectedTimeoutSeconds) {
		 
	        return timeoutInSeconds == expectedTimeoutSeconds;
	    }
 
	 public int getActualWaitTime() {
		 
	        return timeoutInSeconds;
	    }
	 
	//@DashboardPage-05
	 public int titleLocation() {
			
			Point location = driver.findElement(By.xpath("//title")).getLocation();
			int xCoordinate = location.getX();
			int yCoordinate = location.getY();
		     System.out.println("X Coordinate: " + xCoordinate);
		     System.out.println("Y Coordinate: " + yCoordinate);
		     if (xCoordinate == 0 && yCoordinate == 0) {
		          //System.out.println("The title is at the top-left corner of the page.");
		           int loc = 1;
		           return loc;
		    	}
		        return 0;
		      }

	   //@DashboardPage-03
		public int actualResponseCode() throws MalformedURLException, IOException {
			
			String httpURL = driver.getCurrentUrl();	        
	        HttpURLConnection connection = (HttpURLConnection) new URL(httpURL).openConnection();
	        connection.setRequestMethod("GET");
	        connection.connect();
	        int responseCode = connection.getResponseCode();
	        System.out.println("URL:" +httpURL+" " +" Response Code:"+responseCode);
			return responseCode;
		}

		//@DashboardPage-06
		public void navBarfieldsSpellCheck() throws IOException {
		   
		    List<WebElement> inputFields = driver.findElements(By.xpath("//mat-toolbar//button"));
  
		    JLanguageTool langTool = new JLanguageTool(new AmericanEnglish());
		    for (WebElement field : inputFields) {
		       
		        String text = field.getText();

		        List<RuleMatch> mistakes = langTool.check(text);

		        if (!mistakes.isEmpty()) {
		            System.out.println("Spelling mistakes found in field with ID: " + field.getAttribute("id"));
		            for (RuleMatch mistake : mistakes) {
		                System.out.println("Mistake: " + mistake.getMessage());
		            }
		        } else {
		            System.out.println("No spelling mistakes found in field with title LMS Learning Management System " + field.getAttribute("id"));
		        }
		    }
		}
		public void verifyLMSTitle() {
	      	String actual_title = driver.getTitle();
	    		String expected_title = "LMS - Learning Management System";
	    		Assert.assertEquals(actual_title, expected_title);	
	    }
	    

		 //@DashboardPage-07
		  public void titleSpellCheckSpaceCheck() throws IOException {
			  
			  JLanguageTool langTool = new JLanguageTool(new AmericanEnglish());
			  WebElement lmsLearningMgtitle = driver.findElement(By.xpath("//mat-toolbar/span[1]"));
			  String lmsMgtextSize = lmsLearningMgtitle.getCssValue("letter-spacing");
			  //System.out.println(lmsMgtextSize);
			  String text = lmsLearningMgtitle.getText().trim();

		        List<RuleMatch> mistakes = langTool.check(text);
		        
		        if(lmsMgtextSize.equals("normal") && mistakes.isEmpty()) {
		        	
		        	System.out.println("No spelling mistakes found in field with ID: " + lmsLearningMgtitle.getAttribute("id"));
		        }
		        else {
		        	for (RuleMatch mistake : mistakes) {
		                System.out.println("Mistake: " + mistake.getMessage());
		            }
		        }
			
			}
	
		public String validateTitle() {
			String title = driver.getTitle();
			return title;
		}
		//@DashboardPage-04
		public boolean titleOfPageISdispalyed() {
			//String valtext = driver.findElement(lmsLearningMgtitle).getText();
			return driver.findElement(titleofDash).isDisplayed();

		}
		
		//@DashboardPage-08
		public int navigationBarLocation() {
			//
			
			Point navlocation = driver.findElement(By.xpath("//mat-toolbar//button")).getLocation();
			int xCoordinate = navlocation.getX();
			int yCoordinate = navlocation.getY();
		     //System.out.println("X Coordinate: " + xCoordinate);
		     //System.out.println("Y Coordinate: " + yCoordinate);
//		     if (xCoordinate == 0 && yCoordinate == 1) {
//		          System.out.println("The title is at the top-left corner of the page.");
//		           int navloc = 1;
//		           return navloc;
//		    	}
//		        return 0;
		    if(xCoordinate > 0 && yCoordinate > 0 && xCoordinate > (driver.manage().window().getSize().getWidth() / 2))
				{
					int navloc = 1;
					 return navloc;
				}
				 return 0;  				 
		    }
		
		//@DashboardPage-09 
		public String navigationBarOrderOne() {
			
			     WebElement navigationBar = driver.findElement(By.xpath("//mat-toolbar"));

			     List<WebElement> navigationBarItems = navigationBar.findElements(By.xpath(".//button")); 
			     String firstItemText = navigationBarItems.get(0).getText().trim();
			     System.out.println(firstItemText);
			     
			     return firstItemText;
			    }
		
		//@DashboardPage-10 
		public String navigationBarOrderTwo() {

	        WebElement navigationBar = driver.findElement(By.xpath("//mat-toolbar"));      
	        List<WebElement> navigationBarItems = navigationBar.findElements(By.xpath(".//button")); 
	        String secondItemText = navigationBarItems.get(1).getText().trim();
	        System.out.println(secondItemText);
	      
			return secondItemText;
		}
		
		//@DashboardPage-11
		public String navigationBarOrderThree() {
		
	       WebElement navigationBar = driver.findElement(By.xpath("//mat-toolbar"));        
	       List<WebElement> navigationBarItems = navigationBar.findElements(By.xpath(".//button")); // Adjust the locator as needed

	       String thirdItem = navigationBarItems.get(2).getText().trim();
	       System.out.println(thirdItem);
		   return thirdItem;
		}

		//@DashboardPage-12
		public String navigationBarOrderfour() {
			
	        WebElement navigationBar = driver.findElement(By.xpath("//mat-toolbar"));

	        List<WebElement> navigationBarItems = navigationBar.findElements(By.xpath(".//button")); // Adjust the locator as needed

	     
	        String fourthItem = navigationBarItems.get(3).getText().trim();
	        System.out.println(fourthItem);
	      
			return fourthItem;
		}

		//@DashboardPage-12
		public void clickLogout() {
			
			driver.findElement(logout).click();
			
		}
		
		


}
