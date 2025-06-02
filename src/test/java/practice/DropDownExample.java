package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownExample {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement fruitDropdown = driver.findElement(By.id("fruits"));
		Select s1=new Select(fruitDropdown);
		boolean dropdownType = s1.isMultiple();
		System.out.println("S1 ismultiple?: "+dropdownType);
		
		s1.selectByVisibleText("Mango");
		s1.selectByValue("header");
		s1.selectByContainsVisibleText("App");
		WebElement option1 = s1.getFirstSelectedOption();
		System.out.println("first selected option in s1 is "+option1.getText());
		
		List<WebElement> allfruitDropdown = s1.getOptions();
		
		for(WebElement oneFruit:allfruitDropdown) {
			System.out.println(oneFruit.getText());
		}
		//s1.deSelectByContainsVisibleText("App");  // java.lang.UnsupportedOperationException: You may only deselect options of a multi-select
		//s1.deselectAll();
		
		System.out.println("===============================================");
		
		WebElement superHerodropDown = driver.findElement(By.id("superheros"));
		Select s2=new Select(superHerodropDown);
		boolean type2 = s2.isMultiple();
		System.out.println("s2 is multiple?:"+type2);
		//s2.selectByVisibleText("Aquaman");
		s2.selectByIndex(1);
		
		s2.selectByContainsVisibleText("The");
		s2.selectByValue("ca");
		s2.selectByValue("aq");
		WebElement option2 = s2.getFirstSelectedOption();
		System.out.println("first selected option in s1"+option2.getText());
		
		s2.deselectByIndex(2);
		s2.deselectAll();
		
		List<WebElement> allOptionElement = s2.getOptions();
		
		Iterator<WebElement> itr = allOptionElement.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
	}

}
