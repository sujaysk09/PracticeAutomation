package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonLanguageSelection {
	
	public static void selectLanguage(String language,WebDriver driver) {
		WebElement element1 = driver.findElement(By.xpath("//span[@aria-label='India']"));
		Actions action=new Actions(driver);
		action.moveToElement(element1).perform();
		WebElement element2 = driver.findElement(By.xpath("(//span[@class='nav-text']//span[text()='"+language+"'])[1]"));
		action.moveToElement(element2).click().build().perform();
	}

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		selectLanguage("MR", driver);
	}
	
	//added 29th line
	//added 30th line
	//added 31th line
	

}
