package executables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.HomePageElements;
import elements.ProposalsPageElements;

public class Proposals {
	ProposalsPageElements proposalsPageElements;
	HomePageElements homePageElements;
	WebElement proposals_link;
	WebDriver driver;
	
	public Proposals(WebDriver driver) {
		this.driver = driver;
		homePageElements = new HomePageElements(driver);
	}
	
	public void retrieveProposals() {
		//proposals_link = driver.findElement(By.xpath(
		//		"//div[@class='navbar' and @id='navbar_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet']/ul[@role='menubar']/li/a/span[text()=' Proposals ']"));
		homePageElements.getProposalsLink().click();
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/div/button[@id='_QuoteProposal_INSTANCE_AgH3Csq73s0c_searchProposalBtn']")));
		
		System.out.println("Proposals page loaded");
		
		proposalsPageElements = new ProposalsPageElements(driver);
		//proposalsPageElements.getStartDateInput().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='datepicker1']")));
		
		proposalsPageElements.getStartDateDropdown().click();
		proposalsPageElements.getStartDateDatepicker().click();
		proposalsPageElements.getSearchButton().click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='_QuoteProposal_INSTANCE_AgH3Csq73s0c_proposal_result_table']/tbody/tr")));
		
		System.out.println("Proposals retrieved");
	}
}
