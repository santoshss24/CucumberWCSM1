package stepDefinitionFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {

	WebDriver driver;
	@Before
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Given("user navigates to login page.")
	public void user_navigates_to_login_page() {
	
		driver.get("https://demo.actitime.com/login.do");
	}

	@And("^user enters (.*) in username textField.$")
	public void user_enters_admin_in_username_text_field(String username) {
	
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And("^user enters (.*) in password textField.$")
	public void user_enters_manager_in_password_text_field(String password) {
		
		driver.findElement(By.name("pwd")).sendKeys(password);
	}

	@When("user clicks on login Button.")
	public void user_clicks_on_login_button() {
	
		driver.findElement(By.id("loginButton")).click();
	}

	@Then("user should be able to successfully logged into homepage.")
	public void user_should_be_able_to_successfully_logged_into_homepage() {
	
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		
		String actualTitle=driver.getTitle();
		String expectedTitle="actiTIME - Enter Time-Track";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
