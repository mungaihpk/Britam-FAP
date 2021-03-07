package executables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.CreateQuotePageElements;
import variables.Quote;

public class CreateQuote {
	WebDriver driver;
	WebElement create_quote_button, get_benefits_button;
	WebElement insured_dob_input, firstname_input, middlename_input, lastname_input, phonenumber_input, email_input, date_of_birth_input, premium_input, sum_assured_input;
	WebElement smoker_yes_radio, smoker_no_radio, calculate_sum_assured_radio, calculate_premium_radio;
	Select line_of_business_dropdown, category_dropdown, product_dropdown, gender_dropdown, occupation_dropdown, frequency_dropdown, terms_dropdown;
	
	CreateQuotePageElements createQuotePageElements;
	Proposals proposals;

	public CreateQuote(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToCreateQuotePage() {
		proposals = new Proposals(driver);
		proposals.navigateToProposalsPage();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_lob']")));

	}

	public void createConventionalProduct() {
		navigateToCreateQuotePage();
		
		createQuotePageElements = new CreateQuotePageElements(driver);
		
		Quote quote = prepareQuote();
		line_of_business_dropdown = createQuotePageElements.getLineOfBusinessDropdown();
		line_of_business_dropdown.selectByVisibleText(quote.getLineOfBusiness());
		
		insured_dob_input = createQuotePageElements.getInsuredDob();
		insured_dob_input.clear();
		insured_dob_input.sendKeys(quote.getInsuredDateOfBirth());
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_category']")));
		
		category_dropdown = createQuotePageElements.getCategoryDropdown();
		category_dropdown.selectByVisibleText(quote.getCategory());
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_product']")));
		
		product_dropdown = createQuotePageElements.getProductDropdown();
		product_dropdown.selectByVisibleText(quote.getProduct());
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_get_riders']")));
		
		firstname_input = createQuotePageElements.getFirstnameInput();
		firstname_input.clear();
		firstname_input.sendKeys(quote.getFirstname());
		
		middlename_input = createQuotePageElements.getMiddlenameInput();
		middlename_input.clear();
		middlename_input.sendKeys(quote.getMiddleName());
		
		lastname_input = createQuotePageElements.getLastnameInput();
		lastname_input.clear();
		lastname_input.sendKeys(quote.getLastName());
		
		phonenumber_input = createQuotePageElements.getPhonenumberInput();
		phonenumber_input.clear();
		phonenumber_input.sendKeys(quote.getPhoneNumber());
		
		email_input = createQuotePageElements.getEmailInput();
		email_input.clear();
		email_input.sendKeys(quote.getEmail());
		
		date_of_birth_input = createQuotePageElements.getDobInput();
		date_of_birth_input.clear();
		date_of_birth_input.sendKeys(quote.getDateOfBirth());
		
		gender_dropdown = createQuotePageElements.getGenderDropdown();
		gender_dropdown.selectByVisibleText(quote.getGender());
		
		smoker_yes_radio = createQuotePageElements.getSmokerYesRadio();
		smoker_no_radio = createQuotePageElements.getSmokerNoRadio();
		
		boolean is_smoker = quote.getIsSmoker();
		
		if(is_smoker)
			smoker_yes_radio.click();
		else
			smoker_no_radio.click();
		
		occupation_dropdown= createQuotePageElements.getOccupationDropdown();
		occupation_dropdown.selectByVisibleText(quote.getOccupation());
		
		Double sum_assured = quote.getSumAssured();
		
		calculate_sum_assured_radio = createQuotePageElements.getCalculateSumAssuredRadio();
		calculate_premium_radio = createQuotePageElements.getCalculatePremiumRadio();
		
		if(sum_assured>0) {
			calculate_premium_radio.click();
			sum_assured_input = createQuotePageElements.getSumAssuredInput();
			sum_assured_input.clear();
			sum_assured_input.sendKeys(String.valueOf(sum_assured));
		} else {
			calculate_sum_assured_radio.click();
			premium_input = createQuotePageElements.getPremiumInput();
			premium_input.clear();
			premium_input.sendKeys(String.valueOf(quote.getPremium()));
		}
		
		frequency_dropdown = createQuotePageElements.getFrequencyDropdown();
		frequency_dropdown.selectByVisibleText(quote.getFrequency());
		
		terms_dropdown = createQuotePageElements.getTermsDropdown();
		terms_dropdown.selectByVisibleText(String.valueOf(quote.getTerms()));
		
		get_benefits_button = createQuotePageElements.getGetBenefitsButton();
		get_benefits_button.click();
	}

	public Quote prepareQuote() {
		String line = "";
		String split_by = ",";
		
		Quote quote = new Quote();
		BufferedReader bufferedReader;
		
		try {
			bufferedReader = new BufferedReader(new FileReader("files/quotes.csv"));
			line = bufferedReader.readLine();
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] quote_entry = line.split(split_by);
				quote.setLineOfBusiness(quote_entry[0]);
				quote.setInsuredDateOfBirth(quote_entry[1]);
				quote.setStartDate(quote_entry[2]);
				quote.setCategory(quote_entry[3]);
				quote.setProduct(quote_entry[4]);
				
				String is_new_customer = quote_entry[5].toLowerCase();
				
				if( is_new_customer.equalsIgnoreCase("y")) {
					quote.setIsNewCustomer(true);
				} else {
					quote.setIsNewCustomer(false);
				}
				
				quote.setFirstname(quote_entry[6]);
				quote.setMiddleName(quote_entry[7]);
				quote.setLastName(quote_entry[8]);
				quote.setPhoneNumber(quote_entry[9]);
				quote.setEmail(quote_entry[10]);
				quote.setDateOfBirth(quote_entry[11]);
				quote.setGender(quote_entry[12]);
				
				String is_smoker = quote_entry[13].toLowerCase();
				
				if( is_smoker.equalsIgnoreCase("y")) {
					quote.setIs_smoker(true);
				} else {
					quote.setIs_smoker(false);
				}
				
				quote.setOccupation(quote_entry[14]);
				quote.setSumAssured(Double.valueOf(quote_entry[15]));
				quote.setPremium(Double.valueOf(quote_entry[16]));
				quote.setFrequency(quote_entry[17]);
				quote.setTerms(Integer.valueOf(quote_entry[18]));
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return quote;
	}

}
