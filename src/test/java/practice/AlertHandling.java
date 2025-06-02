package practice;

import java.awt.SecondaryLoop;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/alerts");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;  //JavascriptExecutor is Interface
		js.executeScript("window.scrollBy(0,350)");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("alertButton")).click();
		
		Alert alert = driver.switchTo().alert();          //Alert is Interface
		
		Thread.sleep(3000);
		String str=alert.getText();
		alert.accept();
		
		System.out.println(str);
		
		driver.findElement(By.id("timerAlertButton")).click();
		
		//WebElement ele = driver.findElement(By.id("timerAlertButton"));

		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert timealert = wait.until(ExpectedConditions.alertIsPresent());
		
		//WebElement ele1 = wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		String timealertText = timealert.getText();
		timealert.accept();
		
		System.out.println(timealertText);
		
		driver.findElement(By.id("confirmButton")).click();
		
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.id("promtButton")).click();
		
		driver.switchTo().alert().sendKeys("I am om");
		
		driver.switchTo().alert().accept();
		
		String txt = driver.findElement(By.id("promptResult")).getText();
		
		System.out.println(txt);
		
		driver.get("https://demoqa.com/frames");
		
		driver.switchTo().frame("frame1");	
		
		//git practice - System.out.println("added 76th line");
		//System.out.println("added 77th line");
	}

}
