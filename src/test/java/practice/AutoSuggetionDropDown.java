package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AutoSuggetionDropDown {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("selenium");
		
		List<WebElement> allSuggestions = driver.findElements(By.xpath("//ul//li[@class='sbct PZPZlf']"));
		
		for(WebElement suggestion:allSuggestions) {
			if(suggestion.getText().equals("selenium webdriver")) {
				suggestion.click();
				break;
			}
		}

	}

}
