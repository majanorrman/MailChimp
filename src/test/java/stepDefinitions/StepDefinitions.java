package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	private String url = "https://login.mailchimp.com/signup/";
	private String randomText;
	private WebDriver driver;
	private WebElement emailElement;
	private WebElement usernameElement;
	private WebElement passwordElement;
	private WebElement submitButtonElement;

	@Before
	public void initiateChromeDriverBefore() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");

	    driver = new ChromeDriver();
	    
	    Random rand = new Random();
	    
	    randomText = Integer.toString(rand.nextInt(Integer.MAX_VALUE));
	}
	
	@Given("I am on the registration page")
	public void i_am_on_the_registration_page() {
		driver.get(url);
	}

	@When("I have written {string} inside the email input-field")
	public void i_have_written_inside_the_email_input_field(String string) {
		String email = string + randomText + "@gmail.com";
		
		emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys(email);
	}

	@When("I have written {string} inside the username input-field")
	public void i_have_written_inside_the_username_input_field(String string) {
		String username = string + randomText;
		
		usernameElement = driver.findElement(By.id("new_username"));
		usernameElement.sendKeys(username);
	}

	@When("I have written {string} inside the password input-field")
	public void i_have_written_inside_the_password_input_field(String string) {
		passwordElement = driver.findElement(By.id("new_password"));
		passwordElement.sendKeys(string);
	}

	@When("I click the Sign Up button")
	public void i_click_the_sign_up_button() {
		submitButtonElement = driver.findElement(By.id("create-account"));
		submitButtonElement.submit();
	}

	@Then("I get redirected to another page")
	public void i_get_redirected_to_another_page() {
		String currentUrl = driver.getCurrentUrl();
		
		assertNotEquals(url, currentUrl);

		driver.quit();
	}

}
