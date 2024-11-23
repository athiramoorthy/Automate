import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait {

	public static void main(String[] args) {
			
			//WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.amazon.com");
			
			     //implicit wait
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Deprecated
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("Title:"+driver.getTitle());
			
			     //explicit wait
		  //WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			WebElement search=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
			search.sendKeys("gift cards");
			search.submit();
			
			    //fluent wait--------------------------
			FluentWait<WebDriver> wait1= new FluentWait<>(driver)
					.withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(3))
					.ignoring(NoSuchElementException.class);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'result')]")));
//			wait1.until(ExpectedConditions.elementToBeClickable(null);
//			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(null);
//			wait1.until(ExpectedConditions.titleContains(null);
//			wait1.until(ExpectedConditions.presenceOfElementLocated(null);

			    //    ---------- 
		
			System.out.println("URL:"+driver.getCurrentUrl());

			driver.quit();
			
			
		}


}
