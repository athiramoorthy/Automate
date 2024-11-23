import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL="https://www.rediff.com/";
		String NSE="//span[text()='NSE' and @class='sensex']";
		//System.setProperty("webdriver.chrome.driver","/Users/athiramoorthy/Downloads/chromedriver-mac-arm64/chromedriver");
		WebDriverManager.safaridriver().setup();

		WebDriver driver=new SafariDriver();
		driver.get(URL);
		try {
			System.out.println(driver.findElements(By.tagName("iframe")).size());
			System.out.println(driver.findElements(By.tagName("a")).size());

			driver.switchTo().frame("moneyiframe");

			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			//WebElement nsetext=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(NSE))));
			WebElement nsevalue=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[@id='nseindex']"))));
			
			
			System.out.println(driver.findElement(By.xpath(NSE)).getText());
			System.out.println(driver.findElement(By.id("nseindex")).getText());
			
			//div[contains(text(),'TOP STORIES')]/../following-sibling::div[@id='topdiv_0']//a[starts-with(@title,'LIVE')]  LIVE NEWS
			////div[@id='topdiv_0']/h2[position()=3]
			//div[@id='topdiv_0']/h2[position()=last()]
			//div[@id='topdiv_0']/h2[position()=last()-1]/preceding-sibling::h2
			//*[@id="topdiv_0"]/h2[1]/ancestor::div
			//div[@id="gcc_q7g0Z_b0DtHP9fwPx5my4A4"]//following-sibling::div[1]//div[@id='abgb']//*[name()='svg']
		}
		catch(NoSuchElementException e) {
			e.getLocalizedMessage();
		}
		finally {
			driver.quit();

		}

	}

}
