import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class drivers {

	public static void main(String[] args) {
		//Chrome driver
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
//		try {
//			driver.get("https://thinking-tester-contact-list.herokuapp.com/");
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		driver.navigate().to("https://www.google.com");
		//implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		//for disabling sign popups
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
		//Navigataing to flipkart
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("https://www.flipkart.com/");
		search.submit(); //driver.findElement(By.name("btnK")).click();
		
		//dialog box which doesn't appear always
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@tabindex='-1' and @jsname='KLUVH']\n")));
			WebElement notnow= driver.findElement(By.xpath("//div[text()='Not now']"));
			notnow.click();
		}catch(NoSuchElementException e){
            System.out.println("Dialog box did not appear. Continuing without interaction.");
		}
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		



	}

}
