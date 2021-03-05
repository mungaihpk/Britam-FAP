package executables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.HomePageElements;
import elements.LoginPageElements;

public class MainDriverClass {

	static WebDriver driver;
	static WebDriverWait wait;
	static LoginPageElements loginPageElements;
	static Login login;
	static HomePageElements homePageElements;
	static Proposals proposals;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//options.setHeadless(true);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver,10,1);
		
		//testLogin();
		testRetrieveProposals();
	}
	
	public static void testLogin() {
		login = new Login(driver);
		login.login();
	}
	
	public static void testRetrieveProposals() {
		testLogin();
		proposals = new Proposals(driver);
		proposals.retrieveProposals();
	}
}
