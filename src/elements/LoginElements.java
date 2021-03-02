package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElements {
	private WebElement username_textbox;
	private WebElement password_textbox;
	private WebElement login_button;
	
	public LoginElements(WebDriver driver){
		
		username_textbox = driver.findElement(By.xpath("//*/input[@id='_com_liferay_login_web_portlet_LoginPortlet_login']"));
		password_textbox = driver.findElement(By.xpath("//*/input[@id='_com_liferay_login_web_portlet_LoginPortlet_user-pwds']\r\n" + 
				""));
		login_button = driver.findElement(By.xpath("//*/button/span[normalize-space(text())='Sign In']" + 
				""));
	}
	
	public WebElement getUsernameTextbox() {
		return username_textbox;
	}
	
	public WebElement getPasswordTextbox() {
		return password_textbox;
	}
	
	public WebElement getLoginButton() {
		return login_button;
	}
}
