package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;

public class Selenium {
  @Test
  public void testGoogleSearch() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "chromedriver");

    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com/");
    Thread.sleep(5000);
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("ChromeDriver");
    searchBox.submit();
    Thread.sleep(5000);
    driver.quit();
  }
}