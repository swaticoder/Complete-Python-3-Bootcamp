package stepDefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;



public class Homepagelink {
	
	WebDriver driver=null;

	
	

	@Given("User is on Trivago home page")
	public void user_is_on_trivago_home_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\swati\\eclipse-workspace\\room5.trivago.com\\src\\test\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("User is on chome page");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	
		driver.navigate().to("https://magazine.trivago.com/");

	}

	@When("user will find all the working link in home page")
	public void user_will_find_all_the_working_link_in_home_page() throws IOException,SocketTimeoutException  {
		
		List <WebElement> linkList= driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Size of full links and image ------>" +linkList.size());
    	List<WebElement> activeLinks= new ArrayList<WebElement>();
    	for (int i=0; i<linkList.size(); i++) {
    		System.out.println(linkList.get(i).getAttribute("href"));
    		if(linkList.get(i).getAttribute("href")!=null && (!linkList.get(i).getAttribute("href").contains("javascript"))){
    			activeLinks.add(linkList.get(i));
    			}
    	}
       System.out.println("Active links and images -------->" +activeLinks.size());
       for (int j = 0; j<activeLinks.size(); j++) {
    	 HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
         connection.connect();
         String response =connection.getResponseMessage();
     //    connection.disconnect();
         System.out.println(activeLinks.get(j).getAttribute("href") +"----->"+response);
       } 
		
	}

	@And("closed the browser")
	public void closed_the_browser() {
		driver.quit();
		System.out.println("Close the browser");
		
	}


}
