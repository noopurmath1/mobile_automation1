package mobile_test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import mobile_test.Setup;

public class TestClass1 {

	public static Setup set = new Setup();

	@Test
	public void calcTest() throws IOException{
	
	WebDriver driver = set.launch();
	add(driver);
		
	}

	public void add(WebDriver driver) {
		driver.findElement(By.id(set.getProp("seven"))).click();
		driver.findElement(By.id(set.getProp("plus"))).click();
		driver.findElement(By.id(set.getProp("five"))).click();
		driver.findElement(By.id(set.getProp("equals"))).click();
		System.out.println("Done!!!");
	}
	
}
