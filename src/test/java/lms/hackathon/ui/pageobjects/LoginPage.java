package lms.hackathon.ui.pageobjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	/*************variables***********/
	public WebDriver driver;
	public String loginMessage;
	public int textFieldsCount;
	public String firstFieldName;
	public String secondFieldName;
	public String symbol;
	public String textColor;
	public String actualColor;
	public String userFieldColor;
	public String passwordFieldColor;
	public boolean loginBtnVisibility;
	public boolean logoutBtnVisibility;
	public String errorMessage;
	public String[] nullErrorMessage;
	WebElement usernameElement;
	WebElement passwordElement;
	WebElement loginBtnElement;
	WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	Actions action ;

	/**********By Locators***********/
	private By loginMessLoc = By.tagName("p") ;
	private By textFields = By.xpath("//form/mat-form-field");
	private By firstField = By.xpath("//form/mat-form-field[1]//span[contains(@class,'ng-star-inserted')][1]");
	private By secondField = By.xpath("//form/mat-form-field[2]//span[contains(@class,'ng-star-inserted')][1]");
	private By loginButtonLoc = By.xpath("//button[@id='login']");
	private By userLoc = By.id("username");
	private By passwordLoc = By.id("password");
	private By logoutButtonLoc = By.id("logout");
	private By errorMessageLoc = By.tagName("mat-error");
	private By userAstrikLoc = By.xpath("//*[@id='mat-form-field-label-1']/span[2]");
	private By passwordAstrikLoc = By.xpath("//*[@id=\"mat-form-field-label-3\"]/span[2]");
	private By nullUserErrorMessLoc = By.xpath("//mat-error[@id='mat-error-0']");
	private By nullPwdErrorMessLoc = By.xpath("//mat-error[@id='mat-error-1']");
	private By nullPwdFieldLoc = By.xpath("//label[@id='mat-form-field-label-3']");
	private By inputFieldFormLoc = By.xpath("//form[contains(@class,'ng-pristine')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleName() {
		return driver.getTitle();
	}

	public String getLoginMess()
	{
		loginMessage = driver.findElement(loginMessLoc).getText();
		System.out.println("Message seen on the page: " + loginMessage);
		return loginMessage;
	}

	public int getTextFieldsCount()
	{
		textFieldsCount = driver.findElements(textFields).size();
		System.out.println("Number of Text Fields on the home page: " + textFieldsCount);
		return textFieldsCount;
	}

	public String getFirstField() {
		firstFieldName = driver.findElement(firstField).getText();
		System.out.println("First field on the home page: " + firstFieldName);
		return firstFieldName;
	}

	public String getSecondField() {
		secondFieldName = driver.findElement(secondField).getText();
		System.out.println("Second field on the home page: " + secondFieldName);
		return secondFieldName;
	}

	public boolean loginButtonVisibility()
	{
		loginBtnVisibility = driver.findElement(loginButtonLoc).isDisplayed();
		System.out.println("Login Button visibility on the home page: " + loginBtnVisibility);
		return loginBtnVisibility;
	}

	public boolean logoutButtonVisibility()
	{
		logoutBtnVisibility = driver.findElement(logoutButtonLoc).isDisplayed();
		System.out.println("Logout Button visibility on the home page: " + logoutBtnVisibility);
		return logoutBtnVisibility;
	}

	public void enterUsername(String username) {
		driver.findElement(userLoc).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLoc).sendKeys(password);
	}

	public void submitLogin() {
		driver.findElement(loginButtonLoc).click();
	}

	public String errorMeassageValidation()
	{
		errorMessage = driver.findElement(errorMessageLoc).getText();
		System.out.println("Error message when invalid credentials given: " + errorMessage);
		return errorMessage;
	}

	public String nullUserErrorValidationMess(int rowNum) {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(nullUserErrorMessLoc));
		if(rowNum==5)
			errorMessage = driver.findElement(nullUserErrorMessLoc).getText();
		else if(rowNum==4)
			errorMessage = driver.findElement(nullPwdErrorMessLoc).getText();
		return errorMessage;
	}

	public void verifyNullPwdFieldColor() {
		textColor = driver.findElement(passwordLoc).getCssValue("color");
		passwordFieldColor = findTextColor(textColor);   
	}

	public void loginActionUsingKeyboard
	(String username, String password) throws InterruptedException {
		action = new Actions(driver);
		//sending username using keyboard actions
		usernameElement = driver.findElement(userLoc);
		action.moveToElement(usernameElement)
		.click()
		.sendKeys(usernameElement, username).build().perform();
		//sending password using keyboard actions
		passwordElement = driver.findElement(passwordLoc);
		action.moveToElement(passwordElement)
		.click()
		.sendKeys(passwordElement, password).build().perform();
		Thread.sleep(200);
		//clicking login button using keyboard actions
		loginBtnElement = driver.findElement(loginButtonLoc);
		action.moveToElement(loginBtnElement)
		.click().perform();

	}

	public void loginActionUsingMouse() {
		action = new Actions(driver);
		loginBtnElement = driver.findElement(loginButtonLoc);
		action.moveToElement(loginBtnElement).click().perform();
	}

	@SuppressWarnings("deprecation")
	public int actualResponseCode() throws MalformedURLException, IOException {
		String httpURL = driver.getCurrentUrl();	        
		// Send HTTP GET request to the current URL
		HttpURLConnection connection = (HttpURLConnection) new URL(httpURL).openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int responseCode = connection.getResponseCode();
		System.out.println("URL:" +httpURL+" " +" Response Code:"+responseCode);
		return responseCode;
	}

	public String verifyUserAstrik() {
		String symbol = driver.findElement(userAstrikLoc).getText();
		System.out.println("symbol next to user : "+ symbol);
		return symbol;
	}

	public String verifyPasswordAstrik() {
		String symbol = driver.findElement(passwordAstrikLoc).getText();
		System.out.println("symbol next to password : "+ symbol);
		return symbol;
	}

	public void verifyUserFieldColor() {
		textColor = driver.findElement(userLoc).getCssValue("color");
		userFieldColor = findTextColor(textColor);  
	}

	public void verifyPasswordFieldColor() {
		textColor = driver.findElement(passwordLoc).getCssValue("color");
		passwordFieldColor = findTextColor(textColor);   
	}

	public String findTextColor(String textColor2)
	{
		System.out.println("Text color " + textColor);
		Color color = Color.fromString(textColor);
		actualColor = color.asHex();
		System.out.println("hex value = " + color.asHex());
		return actualColor;
	}

	public void verifyInputFieldAlignment() {

		WebElement element = driver.findElement(inputFieldFormLoc);
		getAlignment(element);
	}

	public void verifyLoginButtonAlignment() {
		WebElement element = driver.findElement(loginButtonLoc);
		getAlignment(element);
	}

	public void getAlignment(WebElement element)
	{
		Dimension windowSize = driver.manage().window().getSize();
		int windowWidth = windowSize.getWidth();
		int windowHeight = windowSize.getHeight();
		// Calculate the center coordinates
		int centerX = windowWidth / 2;
		int centerY = windowHeight / 2;
		// Find an element at the center 
		Point elementLocation = element.getLocation();
		// Compare element position with center coordinates
		if (elementLocation.getX() == centerX && elementLocation.getY() == centerY) {
			System.out.println("Element found at the center!");
		} else {
			System.out.println("Element not at the center.");
		}

	}

	public void fieldsSpellCheck() throws IOException {
		// Identify all input fields
		List<WebElement> inputFields = driver.findElements(By.tagName("input"));
		// Initialize spell checker
		JLanguageTool langTool = new JLanguageTool(new AmericanEnglish());
		// Loop through each input field
		for (WebElement field : inputFields) {
			// Extract text from the field
			String text = field.getAttribute("value");
			// Check spelling
			List<RuleMatch> mistakes = langTool.check(text);
			// Report any spelling mistakes
			if (!mistakes.isEmpty()) {
				System.out.println("Spelling mistakes found in field with ID: " + field.getAttribute("id"));
				for (RuleMatch mistake : mistakes) {
					System.out.println("Mistake: " + mistake);
				}
			} else {
				System.out.println("No Spelling mistakes found in field with ID: " + field.getAttribute("id"));

			}
		}
	}

}