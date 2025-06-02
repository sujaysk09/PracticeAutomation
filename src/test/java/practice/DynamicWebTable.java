package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/webtables");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		// For Table Headers
//		List<WebElement> allHeaders = driver
//				.findElements(By.xpath("//div[@class='rt-table']/descendant::div[@class='rt-tr']/child::div"));
//
//		String headerName = null;
//		for (WebElement header : allHeaders) {
//			headerName = header.getText();
//			System.out.print(headerName+" | ");
//		}
//		
//
//		System.out.println();

		// for all table data
		List<WebElement> allTableElements = driver.findElements(
				By.xpath("//div[@class='rt-table']/descendant::div[@class='rt-tr-group']//div[@class='rt-td']"));

		String tableData=null;
		for (WebElement allTableData : allTableElements) {
			tableData = allTableData.getText();
			if(tableData.contains("Alden")) {
				System.out.print(tableData);
				break;
			}
			//System.out.print(tableData + " ");
		}
		
//		//fetch elements from specific row
//		int rowNumber=3;
//		List<WebElement> specificRowElements = driver.findElements(By.xpath("(//div[@class='rt-table']/descendant::div[@class='rt-tr-group'])["+rowNumber+"]//div[@class='rt-td']"));
//
//		for(WebElement specificRowData:specificRowElements) {
//			String desiredRowData = specificRowData.getText();
//			System.out.println(desiredRowData);
//		}
//	
//	}
	}
}
