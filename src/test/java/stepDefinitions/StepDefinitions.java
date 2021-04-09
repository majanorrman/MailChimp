package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private WebDriverWait wait;
	private WebDriver driver;
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, 20);
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
		String email = "";
		
		if (emailString.length() > 0)
			email = randomGenerator.getRandomString(randomLength) + emailString;

		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys(email);
	}

	@When("I have written {string} inside the username input-field {int} random characters")
	public void i_have_written_inside_the_username_input_field_random_characters(String usernameString,
			Integer randomLength) {
		String username = "";
		
		if (usernameString.length() > 0)
			username = randomGenerator.getRandomString(randomLength) + usernameString;

		wait.until(ExpectedConditions.elementToBeClickable(By.id("new_username")));
		
		WebElement usernameElement = driver.findElement(By.id("new_username"));
		usernameElement.sendKeys(username);
	}

	@When("I have written {string} inside the password input-field {int} random characters")
	public void i_have_written_inside_the_password_input_field_random_characters(String passwordString,
			Integer randomLength) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("new_password")));
		
		WebElement passwordElement = driver.findElement(By.id("new_password"));
		passwordElement.sendKeys(passwordString);
	}

	@When("I click the Sign Up button")
	public void i_click_the_sign_up_button() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-account")));
		
		WebElement submitButtonElement = driver.findElement(By.id("create-account"));
		submitButtonElement.submit();
	}

	@Then("I get successfully redirected to the confirmation page")
	public void i_get_successfully_redirected_to_the_confirmation_page() {
		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.contains(urlSuccess)) {
			assertEquals(currentUrl.contains(urlSuccess), true);

			return;
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));

		WebElement emailElement = driver.findElement(By.id("email"));
		
		if (emailElement.getAttribute("value").length() == 0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']/following-sibling::span[1][@class='invalid-error']")));
			
			WebElement emailEmptyValidationError = driver.findElement(By.xpath("//*[@id='email']/following-sibling::span[1][@class='invalid-error']"));

			boolean hasEmailEmptyValidationError = emailEmptyValidationError.isDisplayed();

			assertEquals(hasEmailEmptyValidationError, true);
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.id("new_username")));

		WebElement usernameElement = driver.findElement(By.id("new_username"));
		
		if (usernameElement.getAttribute("value").length() > 100) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='new_username']/following-sibling::span[1][@class='invalid-error']")));
			
			WebElement usernameLongValidationError = driver.findElement(By.xpath("//*[@id='new_username']/following-sibling::span[1][@class='invalid-error']"));

			boolean hasUsernameLongValidationError = usernameLongValidationError.isDisplayed();

			assertEquals(hasUsernameLongValidationError, true);
		}
		
		if (usernameElement.getAttribute("value") == "johndoe") {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='new_username']/following-sibling::span[1][@class='invalid-error']")));
			
			WebElement usernameExistValidationError = driver.findElement(By.xpath("//*[@id='new_username']/following-sibling::span[1][@class='invalid-error']"));

			boolean hasUsernameExistValidationError = usernameExistValidationError.isDisplayed();

			assertEquals(hasUsernameExistValidationError, true);
		}
	}
}
