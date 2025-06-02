package practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/browser-windows");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.id("tabButton")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();

		for (String window : allwindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
			}
		}

		String text = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();

		System.out.println(text);

		Thread.sleep(3000);

		driver.close();

		driver.switchTo().window(parentWindow);

		driver.findElement(By.id("windowButton")).click();

		Set<String> allNewWindows = driver.getWindowHandles();

		for (String newWindow : allNewWindows) {
			if (!newWindow.equals(parentWindow)) {
				driver.switchTo().window(newWindow);
			}
		}

		driver.manage().window().maximize();

		String text1 = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();

		System.out.println(text1);

		driver.close();

		driver.findElement(By.id("messageWindowButton")).click();

		Set<String> allNewWindows2 = driver.getWindowHandles();

		for (String newWindow : allNewWindows2) {
			if (!newWindow.equals(parentWindow)) {
				driver.switchTo().window(newWindow);
			}
		}

		driver.manage().window().maximize();

		String txt1 = driver.findElement(By.xpath("/html/body/text()")).getText();

		System.out.println(txt1);

	}

}
