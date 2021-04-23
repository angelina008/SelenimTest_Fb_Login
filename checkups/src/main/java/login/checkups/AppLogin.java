package login.checkups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppLogin{
	public static String login(String email, String pass) {
		System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login");
		
		driver.findElement(By.id("email")).sendKeys(email);
		//WebElement username=driver.findElement(By.id("email"));
		driver.findElement(By.id("pass")).sendKeys(pass);;
		//WebElement password=driver.findElement(By.id("pass"));
		driver.findElement(By.id("loginbutton")).click();	
		
        try {
        	
        	WebElement errorPage2 = driver.findElement(By.cssSelector("#email_container > div._9ay7"));
        	if (errorPage2.isDisplayed())
        		return errorPage2.getText();
        }
        catch (Exception e) {
        	try {
            	WebElement errorPage1 = driver.findElement(By.cssSelector("#loginform > div:nth-child(15) > div._9ay7"));
            	
            	if (errorPage1.isDisplayed())
            		return errorPage1.getText();
            
            }
            catch (Exception e1) {
            	String expectedUrl= driver.getCurrentUrl();
            	return "Succesful Login" + " " + expectedUrl;
            }
        }
            
		return pass;
}
	
	public static void main (String [] args) {
		
		String email = "valid_email@gmail.com";
		String pass = "ValidPass12#";
		System.out.print(login(email,pass));
		
	}
}