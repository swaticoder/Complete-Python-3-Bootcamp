package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class contactform 

{
	
	public static WebDriver driver;
	JavascriptExecutor js;


	@Given("user is already on home page")
	public void user_is_already_on_home_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\swati\\eclipse-workspace\\room5.trivago.com\\src\\test\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://magazine.trivago.com");
		driver.manage().window().maximize();

		System.out.println("User is on Contact+Home page");
	}
	
	@When("user want to submit the contact form")
	public void user_want_to_submit_the_contact_form() {
		System.out.println("User will enter the contact details");
	}

	@Then("user enters  message and full Name and Email")
	public void user_enters_message_and_full_name_and_email() {
		js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		driver.get("https://magazine.trivago.com.au/contact/");
		String windowHandle = driver.getWindowHandle();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(0));
		driver.findElement(By.className("contact-msg")).sendKeys("My message");
		driver.findElement(By.className("contact-input")).sendKeys("Firstname");
		driver.findElement(By.id("contact-email")).sendKeys("Swati123@hh.com");
//		driver.findElement(By.className("contact-submit")).click();


	}

	@And("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		System.out.println("User clicks on submit button");
		WebElement check = driver.findElement(By.id("confirm"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", check);
		check.click();
		WebElement el = driver.findElement(By.className("contact-submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
		el.click();
	}

	@Then("Message Sent Successfully")
	public void message_sent_successfully() {
		System.out.println("message_sent_successfully");
		//driver.quit();

	}

	
	
	
}
