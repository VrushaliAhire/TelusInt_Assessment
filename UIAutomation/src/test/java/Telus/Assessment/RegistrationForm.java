package Telus.Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegistrationForm {
	
	
	String driverpath = "E:/Vrushali/Assessment/Driver/chromedriver.exe";
	String url = "file:///E:/Vrushali/RegistrationForm/RegistrationForm.html";

	@Test(priority=1)
	public void ValidatingEmail()
	{
		System.setProperty("webdriver.chrome.driver", driverpath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("txtName")).sendKeys("Vrushali");
		driver.findElement(By.id("txtEmail")).sendKeys("abc@abc");
		driver.findElement(By.id("btnSubmit")).click();
		//driver.switchTo().alert().accept();
		//driver.close();
		
	}
	
	@Test(priority=2)
	public void CheckAvailability()
	{
		System.setProperty("webdriver.chrome.driver", driverpath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("txtName")).sendKeys("Vrushali");
		driver.findElement(By.id("txtEmail")).sendKeys("abc@abc.com");
		driver.findElement(By.id("numavailability")).sendKeys("xyz");
		driver.findElement(By.id("btnSubmit")).click();
		//driver.switchTo().alert().accept();
		//driver.close();
	}

}
