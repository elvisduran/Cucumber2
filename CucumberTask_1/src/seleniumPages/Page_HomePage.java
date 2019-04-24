package seleniumPages;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import common.Page_BasePage;

public class Page_HomePage extends Page_BasePage {
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:/GeckoDriver/geckodriver.exe");

		//Create an object for Manage Firefox
		driver=new FirefoxDriver();
	}
	public void openURL() {
		driver.get("http://newtours.demoaut.com/");
	}
	public void gotoURLRegister() {
		driver.findElement(By.linkText("REGISTER")).click();
	}
	public void WaitAMoment() throws InterruptedException {
		Thread.sleep(2000);
	}
	public void InsertUser(String arg1) {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}
	public void InsertPassword(String arg1) {
		driver.findElement(By.name("password")).sendKeys(arg1); 
		driver.findElement(By.name("confirmPassword")).sendKeys(arg1);

	}
	public void RegisterUser() {
		driver.findElement(By.name("register")).click();		
	}
	public void verifyWelcomMsg() {
		
		
			//Store the URL on string Variable
			String url="http://newtours.demoaut.com/create_account_success.php";
			//Take the current page for comparing with the original page. 
			String currentURL=driver.getCurrentUrl();
			
			if (currentURL.equals(url))
			{
				System.out.println("Verification is OK");	
			}
			else
			{
				System.out.println("Something was wrong");
			}
	}
	public void GetOut() {
	
		driver.quit();
	}
	
}
