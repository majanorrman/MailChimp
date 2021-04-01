package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generators.RandomGenerator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	RandomGenerator randomGenerator = new RandomGenerator();
	private String url = "https://login.mailchimp.com/signup";
	private String urlSuccess = "https://login.mailchimp.com/signup/success";
	private WebDriver driver;
	private WebElement emailElement;
	private WebElement usernameElement;
	private WebElement passwordElement;
	private WebElement submitButtonElement;
	private WebElement validationError;

	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		driver = new ChromeDriver();

		RandomGenerator randomGenerator = new RandomGenerator();
	}

	@After
	public void after() {
		driver.quit();
	}

	@Given("I am on the registration page")
	public void i_am_on_the_registration_page() {
		driver.get(url);
	}

	@When("I have written {string} inside the email input-field with {int} random characters")
	public void i_have_written_inside_the_email_input_field_with_random_characters(String emailString,
			Integer randomLength) {
		String email = randomGenerator.getRandomString(randomLength) + emailString;

		emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys(email);
	}

	@When("I have written {string} inside the username input-field {int} random characters")
	public void i_have_written_inside_the_username_input_field_random_characters(String usernameString,
			Integer randomLength) {
		String username = randomGenerator.getRandomString(randomLength) + usernameString;

		usernameElement = driver.findElement(By.id("new_username"));
		usernameElement.sendKeys(username);
	}

	@When("I have written {string} inside the password input-field {int} random characters")
	public void i_have_written_inside_the_password_input_field_random_characters(String passwordString,
			Integer randomLength) {
		passwordElement = driver.findElement(By.id("new_password"));
		passwordElement.sendKeys(passwordString);
	}

	@When("I click the Sign Up button")
	public void i_click_the_sign_up_button() {
		submitButtonElement = driver.findElement(By.id("create-account"));
		submitButtonElement.submit();
	}

	@Then("I get redirected to another page")
	public void i_get_redirected_to_another_page() {
		String currentUrl = driver.getCurrentUrl();

		assertEquals(currentUrl.contains(urlSuccess), true);
	}

	@Then("I get a validation error that says that the username is too long")
	public void i_get_a_validation_error_that_says_that_the_username_is_too_long() {
		validationError = driver.findElement(By.className("invalid-error"));

		boolean hasValidationError = validationError.getText().equals("Enter a value less than 100 characters long");

		assertEquals(hasValidationError, true);
	}
	
	@Then("I get a validation error that says that the email is missing")
	public void i_get_a_validation_error_that_says_that_the_email_is_missing() {
		validationError = driver.findElement(By.className("invalid-error"));

		boolean hasValidationError = validationError.getText().equals("Please enter a value");

		assertEquals(hasValidationError, true);
	}
}
