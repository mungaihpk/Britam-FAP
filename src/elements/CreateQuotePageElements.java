package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateQuotePageElements {
	private WebElement create_quote_button;
	private WebElement line_of_business_dropdown;
	private WebElement insured_dob_input;
	private WebElement start_date_input;
	private WebElement category_dropdown;
	private WebElement product_dropdown;
	private WebElement existing_customer_radio;
	private WebElement new_customer_radio;
	private WebElement nationalid_input;
	private WebElement search_id_button;
	private WebElement reset_id_button;

	private WebElement birth_certificate_input;
	private WebElement surname_input;
	private WebElement search_birth_certificate_button;
	private WebElement reset_birth_certificate_button;

	private WebElement firstname_input;
	private WebElement middlename_input;
	private WebElement lastname_input;
	private WebElement country_code_dropdown;
	private WebElement phonenumber_input;
	private WebElement email_input;
	private WebElement dob_input;
	private WebElement gender_dropdown;
	private WebElement smoker_yes_radio;
	private WebElement smoker_no_radio;
	private WebElement occupation_dropdown;

	private WebElement premium_input;
	private WebElement frequency_dropdown;
	private WebElement terms_dropdown;

	private WebElement add_member_button;

	private WebElement sum_insured_input;
	
	private WebElement get_benefits_button;
	
	WebDriver driver;

	public CreateQuotePageElements(WebDriver driver) {
		this.driver = driver;
		create_quote_button = driver.findElement(By.xpath("//a[text()='Create Quote']"));
		line_of_business_dropdown = driver
				.findElement(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_lob']"));
		insured_dob_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_main-dob']"));
		start_date_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_main-start-date']"));
		category_dropdown = driver
				.findElement(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_category']"));
		product_dropdown = driver
				.findElement(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_product']"));
		existing_customer_radio = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_exitsing-customer']"));
		new_customer_radio = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_new-customer']"));
		nationalid_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_nationalId_insured']"));
		search_id_button = driver.findElement(
				By.xpath("//button[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_search_nationalId_insured']"));
		reset_id_button = driver.findElement(By.xpath(
				"//button[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_reset_search_insured' and @onclick=\"resetNationalSearch('_insured');\"]"));

		birth_certificate_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_certiNumer_insured']"));
		surname_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_surname_insured']"));
		search_birth_certificate_button = driver.findElement(
				By.xpath("//button[@id=\"_QuoteCalculator_INSTANCE_ms03ctkSkfxq_search_birthCerti_insured\"]"));
		reset_birth_certificate_button = driver.findElement(By.xpath(
				"//button[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_reset_search_insured' and @onclick=\"resetNationalSearch('_insured');\"]"));

		firstname_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_firstName_insured']"));
		middlename_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_middleName_insured']"));
		lastname_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_lastName_insured']"));
		country_code_dropdown = driver
				.findElement(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_countryCode_insured']"));
		phonenumber_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_mobileNo_insured']"));
		email_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_emailId_insured']"));
		dob_input = driver.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_dob_insured']"));
		gender_dropdown = driver
				.findElement(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_gender_insured']"));
		smoker_yes_radio = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_smoker_ys_insured']"));
		smoker_no_radio = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_smoker_no_insured']"));
		occupation_dropdown = driver
				.findElement(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_occupation_insured']"));
		sum_insured_input = driver
				.findElement(By.xpath("//input[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_premium']"));
		frequency_dropdown = driver
				.findElement(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_frequency']"));
		terms_dropdown = driver.findElement(By.xpath("//select[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_terms']"));
		add_member_button = driver
				.findElement(By.xpath("//button[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_add_insured']"));
	}

	public WebElement getCreateQuoteButton() {
		return create_quote_button;
	}

	public WebElement getLineOfBusinessDropdown() {
		return line_of_business_dropdown;
	}

	public WebElement getInsuredDob() {
		return insured_dob_input;
	}

	public WebElement getStartDateInput() {
		return start_date_input;
	}

	public WebElement getCategoryDropdown() {
		return category_dropdown;
	}

	public WebElement getProductDropdown() {
		return product_dropdown;
	}

	public WebElement getNationalidInput() {
		return nationalid_input;
	}

	public WebElement getNewCustomerRadio() {
		return new_customer_radio;
	}

	public WebElement getSearchIdButton() {
		return search_id_button;
	}

	public WebElement getResetIdButton() {
		return reset_id_button;
	}

	public WebElement getExistingCustomerRadio() {
		return existing_customer_radio;
	}

	public WebElement getBirthCertificateInput() {
		return birth_certificate_input;
	}

	public WebElement getSurnameInput() {
		return surname_input;
	}

	public WebElement getSearchBirthCertificateButton() {
		return search_birth_certificate_button;
	}

	public WebElement getResetBirthCertificateButton() {
		return reset_birth_certificate_button;
	}

	public WebElement getFirstnameInput() {
		return firstname_input;
	}

	public WebElement getLastnameInput() {
		return lastname_input;
	}

	public WebElement getCountryCodeDropdown() {
		return country_code_dropdown;
	}

	public WebElement getPhonenumberInput() {
		return phonenumber_input;
	}

	public WebElement getEmailInput() {
		return email_input;
	}

	public WebElement getDobInput() {
		return dob_input;
	}

	public WebElement getGenderDropdown() {
		return gender_dropdown;
	}

	public WebElement getSmokerYesRadio() {
		return smoker_yes_radio;
	}

	public WebElement getSmokerNoRadio() {
		return smoker_no_radio;
	}

	public void setSmoker_no_radio(WebElement smoker_no_radio) {
		this.smoker_no_radio = smoker_no_radio;
	}

	public WebElement getOccupationDropdown() {
		return occupation_dropdown;
	}

	public void setOccupation_dropdown(WebElement occupation_dropdown) {
		this.occupation_dropdown = occupation_dropdown;
	}

	public WebElement getAddMemberButton() {
		return add_member_button;
	}

	public WebElement getPremiumInput() {
		return premium_input;
	}

	public WebElement getFrequencyDropdown() {
		return frequency_dropdown;
	}

	public WebElement getTermsDropdown() {
		return terms_dropdown;
	}

	public WebElement getSumInsuredInput() {
		return sum_insured_input;
	}

	public WebElement getMiddlenameInput() {
		return middlename_input;
	}

	public WebElement getGetBenefitsButton() {
		get_benefits_button = driver.findElement(By.xpath("//button[@id='_QuoteCalculator_INSTANCE_ms03ctkSkfxq_get_riders']"));
		return get_benefits_button;
	}

}
