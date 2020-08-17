package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Subscribenewsletter {
	
	WebDriver driver=null;
	JavascriptExecutor js;


	@Given("user want to subscribe for Newsletter")
	public void user_want_to_subscribe_for_newsletter()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\swati\\eclipse-workspace\\room5.trivago.com\\src\\test\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://magazine.trivago.com");
		driver.manage().window().maximize();

		System.out.println("User is about to subscribe NewsLetter ");
	}
	
	@When("user enters e-mail address")
	public void user_enters_e_mail_address() {
		js = (JavascriptExecutor) driver;
		WebElement el = driver.findElement(By.name("email"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
		el.sendKeys("swati251291@gmail.com");

	}

	@And("user clicks on Inspire Me button")
	public void user_clicks_on_inspire_me_button() {
		js = (JavascriptExecutor) driver;
		WebElement inspireme = driver.findElement(By.className("submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inspireme);
		inspireme.click();
	}

	@Then("Message will be displayed as You are now checked-in!")
	public void message_will_be_displayed_as_you_are_now_checked_in() {
		js = (JavascriptExecutor) driver;
		WebElement message = driver.findElement(By.xpath("//p[text()= 'You are now checked-in!']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", message);
		String newslettermessage =  message.getText();
//		Assert.assertEquals(newslettermessage, "You are now checked-in!");

	}
}
