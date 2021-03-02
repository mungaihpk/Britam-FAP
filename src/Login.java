import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.LoginElements;
import variables.Urls;

public class Login {
	WebDriver driver;
	Urls urls;
	
	WebElement username_textbox, password_textbox, login_btn;
	LoginElements loginElements;
	
	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		urls = new Urls();
		
	}
	
	public void login() {
		driver.get(urls.getLoginUrl());
		loginElements = new LoginElements(driver);
		
		username_textbox = loginElements.getUsernameTextbox();
		password_textbox = loginElements.getPasswordTextbox();
		login_btn = loginElements.getLoginButton();
		
		username_textbox.sendKeys("lmuchemi");
		password_textbox.sendKeys("Password1");
		login_btn.click();
	}

}
