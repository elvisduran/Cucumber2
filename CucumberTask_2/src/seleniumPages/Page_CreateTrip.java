package seleniumPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import common.Page_BasePage;

public class Page_CreateTrip extends Page_BasePage  {
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:/GeckoDriver/geckodriver.exe");

		//Create an object for Manage Firefox
		driver=new FirefoxDriver();
	}
	public void openURL() {
		driver.get("http://newtours.demoaut.com/");
	}
	public void WaitAMoment() throws InterruptedException {
		Thread.sleep(5000);
	}
	public void InsertUser(String arg1) {
		driver.findElement(By.name("userName")).sendKeys(arg1);
	}
	public void InsertPassword(String arg1) {
		driver.findElement(By.name("password")).sendKeys(arg1); 
	}
	
	public void GetConfirm() {
		WebElement confirm = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]"));
		System.out.println(confirm.getText()); 
	}
	
	public void FillNames() {
		for(int i = 0; i < 3; i++)

		{

			driver.findElement(By.name("passFirst" + i)).sendKeys("Wendy" + "_" + i);

			driver.findElement(By.name("passLast" + i)).sendKeys("Carter" + "_" + i);

			new Select(driver.findElement(By.name("pass." + i + ".meal"))).selectByVisibleText("Kosher");

		}
	}
	
	public void FillCreditCard() {

		new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText("MasterCard");
		driver.findElement(By.name("creditnumber")).sendKeys("11111111111");
		new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByIndex(1);
		new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByIndex(1);
		driver.findElement(By.name("cc_frst_name")).sendKeys("Elvis");
		driver.findElement(By.name("cc_mid_name")).sendKeys("Carlos");
		driver.findElement(By.name("cc_last_name")).sendKeys("Duran");
		
		driver.findElement(By.name("buyFlights")).submit();
	}
	
	
	public void SelectFly() {
		// For departing.
		List<WebElement> departFlights = driver.findElements(By.name("outFlight"));
		for(WebElement flight : departFlights)
		{
			if(flight.getAttribute("value").contains("Unified"))
			{
				flight.click();
				break;
			}
		}

		// For returning.
		List<WebElement> returnFlights = driver.findElements(By.name("inFlight"));
		for(WebElement flight : returnFlights)
		{
			if(flight.getAttribute("value").contains("Unified"))
			{
				flight.click();
				break;
			}
		}
		driver.findElement(By.name("reserveFlights")).submit();
	}
	
	public void SelectFrom() {

	}
	public void SelectTo() {
		
		
	}
	public void Sign_In() {
		driver.findElement(By.name("login")).click();
		
	}
	public void SelectOptionsTrip() throws InterruptedException {

 		List<WebElement> lstChecks =driver.findElements(By.name("tripType"));
 		
 		//I search by every element and found by value
 		for (int i=0;i<lstChecks.size();i++)
 		{
 			System.out.println(lstChecks.get(i).getAttribute("value"));
 			if (lstChecks.get(i).getAttribute("value").toString().equals("roundtrip"))
 			{
 				lstChecks.get(i).click();
 				break;
 			}
 		}
 		new Select(driver.findElement(By.name("toPort"))).selectByValue("Acapulco");
 		new Select(driver.findElement(By.name("fromPort"))).selectByValue("Paris");
		//Passengers
 		new Select(driver.findElement(By.name("passCount"))).selectByValue("3");
 		//On
 		new Select(driver.findElement(By.name("fromMonth"))).selectByValue("12");
 		new Select(driver.findElement(By.name("fromDay"))).selectByValue("19");

 		//Returning on
 		new Select(driver.findElement(By.name("toMonth"))).selectByValue("12");
 		new Select(driver.findElement(By.name("toDay"))).selectByValue("24");

 		//Service-Class
 		List<WebElement> lstServiceClass =driver.findElements(By.name("servClass"));
 		
 		//I search by every element and found by value
 		for (int i=0;i<lstServiceClass.size();i++)
 		{
 			System.out.println(lstServiceClass.get(i).getAttribute("value"));
 			if (lstServiceClass.get(i).getAttribute("value").toString().equals("First"))
 			{
 				lstServiceClass.get(i).click();
 				break;
 			}
 		}
 		new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Unified Airlines");
 		
 		

 		
		driver.findElement(By.name("findFlights")).click();
		
	}
    public void waitForLoad(String nameElement) throws InterruptedException {

        try{
            WebElement element = driver.findElement(By.name(nameElement));
        }catch (Exception exception){
     		System.out.println("Waiting...");
        	Thread.sleep(1000);
        	waitForLoad(nameElement);
        }
    }
    
}
