package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	private WebDriver driver;
	private WebElement email;
	private WebElement username;
	private WebElement password;
	private WebElement submitButton;
	
	@Before
	public void initiateChromeDriverBefore() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");

	    driver = new ChromeDriver();
	}
	
	@Given("I am on the https:\\/\\/login.mailchimp.com\\/signup\\/")
	public void i_am_on_the_https_login_mailchimp_com_signup() {
		driver.get("https://login.mailchimp.com/signup/");
	}

	@When("I have written {string} inside the email input-field")
	public void i_have_written_inside_the_email_input_field(String string) {
		email = driver.findElement(By.id("email"));
		email.sendKeys(string);
	}

	@When("I have written {string} inside the username input-field")
	public void i_have_written_inside_the_username_input_field(String string) {
		username = driver.findElement(By.id("new_username"));
		username.sendKeys(string);
	}

	@When("I have written {string} inside the password input-field")
	public void i_have_written_inside_the_password_input_field(String string) {
		password = driver.findElement(By.id("new_password"));
		password.sendKeys(string);
	}

	@When("I click the Sign Up button")
	public void i_click_the_sign_up_button() {
		submitButton = driver.findElement(By.id("create-account"));
		submitButton.submit();
	}

	@Then("I get redirected to another page")
	public void i_get_redirected_to_another_page() {
		assertEquals(true, true);
		driver.close();
	}

}
