import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class xpath {

	public static void main(String[] args) throws InterruptedException {
		
		String country1="India";
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.amazon.com");
		System.out.println("hello");
		//Starting with Xpath
		try {
		WebElement locmodal=driver.findElement(By.xpath("//*[@id='nav-global-location-popover-link']")); //tag[@attr='value']
		locmodal.click();
		System.out.println("modal opened");
//		Thread.sleep(Duration.ofSeconds(10));
		System.out.println(driver.findElement(By.xpath("//h4[text()='Choose your location']")));
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='GLUXCountryList']")));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Choose your location']")));// (driver.findElement());

		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("a-popover-1")));
		//System.out.println(driver.switchTo().activeElement().getText());
		//popup
		//driver.switchTo().frame("a-popover-1");
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='GLUXCountryList']"));
		
		//drop down

		Select select=new Select(dropdown);
		select.selectByVisibleText("India");
		
		WebElement donebutton=driver.findElement(By.xpath("//*[@name='glowDoneButton']"));
		
		
		WebElement value=driver.findElement(By.xpath("//span[text()='India']"));
		if(value.getText().equals(country1))
			donebutton.click();
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		
		
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		
	}

}
