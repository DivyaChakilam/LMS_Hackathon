package lms.hackathon.ui.pageobjects;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	private lms.hackathon.ui.configs.CommonConfigs commonConfigs;
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public BatchPage batchPage;
	public ProgramPage programPage;
	public UserPage userPage;
	public CommonPage commonPage;
	
	public PageObjectManager(WebDriver driver, lms.hackathon.ui.configs.CommonConfigs commonConfigs ) {
		this.driver = driver;
		this.commonConfigs = commonConfigs;
	}

	public LoginPage getLoginPage() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}

	public DashboardPage getDashboardPage() {
		dashboardPage = new DashboardPage(driver);
		return dashboardPage;
	}

	public BatchPage getBatchPage() {
		batchPage = new BatchPage(driver);
		return batchPage;
	}

	public ProgramPage getProgramPage() {
		programPage = new ProgramPage(driver);
		return programPage;
	}

	public UserPage getUserPage() {
		userPage = new UserPage(driver);
		return userPage;
	}
	public CommonPage getCommonPage() {
		commonPage = new CommonPage(driver);
		return commonPage;
	}
	
}

