import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import elements.LoginElements;

public class Elements {

	static WebDriver driver;
	static LoginElements loginElements;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setHeadless(true);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.login();
	}

}
