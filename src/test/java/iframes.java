import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iframes {

	public static void main(String[] args) throws InterruptedException {
		
		String url="https://codepen.io/";
		String frame1="iframe[src='https://codepen.io/dp_lewis/fullcpgrid/QWezBRm']";
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(5000);
		try {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(frame1)));
		System.out.println("Switched to frame");
		
//		WebElement iframe=driver.findElement(By.cssSelector());
		
		}
		catch(Exception e) {
			System.out.println("Iframe didn't load on time"+e.getMessage());
		
		}
		finally {
		driver.quit();
		}
		
		
	}

}
