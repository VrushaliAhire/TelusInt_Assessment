package Telus.Assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class UIAutomation {
	
	String chromedriverpath = "E:/Vrushali/Assessment/Driver/chromedriver.exe";
	String firefoxdriverpath = "E:/Vrushali/Assessment/Driver/geckodriver.exe";
	String edgedriverpath = "E:/Vrushali/Assessment/Driver/msedgedriver.exe";
	//String url = "file:///E:/Vrushali/RegistrationForm/RegistrationForm.html";
	 WebDriver driver;
	
	
	@Test
	public void openbrowser() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Vrushali\\Assessment\\src\\test\\java\\Data.properties");
		prop.load(fis);
		
		if (prop.getProperty("browser").equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		}
		else 
			{
			if (prop.getProperty("browser").equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", firefoxdriverpath);
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			}
					
			System.setProperty("webdriver.edge.driver", edgedriverpath);
			driver = new EdgeDriver();
			driver.get(prop.getProperty("url"));
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
	            FileUtils.copyFile(screenshot, new File("E:\\Vrushali\\Assessment\\Screenshot\\homePageScreenshot.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
					
		}
		
		
	}

	@Test (dependsOnMethods = { "openbrowser" })
	public void checknull()
	{
		driver.findElement(By.id("btnSubmit")).click();
		String ExpText = "Please enter your full name,between 3 to 100 characters ";
		String ActText = driver.switchTo().alert().getText();
		try
		{
			Assert.assertEquals(ExpText, ActText);
		}
		catch (Throwable t)
		{
			System.out.println("incorrectmessage(checknull");
		}
		
		driver.switchTo().alert().accept();
		
		
	}
	
	@Test (dependsOnMethods = { "checknull" })
	public void enter2char()
	{
		driver.findElement(By.id("txtName")).clear();		
		driver.findElement(By.id("txtName")).sendKeys("ab");
		driver.findElement(By.id("checkbox")).click();
		driver.findElement(By.id("btnSubmit")).click();
		String ExpText = "Please enter your full name,between 3 to 100 characters ";
		String ActText = driver.switchTo().alert().getText();
		try
		{
			Assert.assertEquals(ExpText, ActText);
		}
		catch (Throwable t)
		{
			System.out.println("incorrectmessage(enter2char");
			
		}
		
		driver.switchTo().alert().accept();
		
	}
	
	@Test (dependsOnMethods = { "enter2char" })
	public void enter101char()
	{
		driver.findElement(By.id("txtName")).clear();
		driver.findElement(By.id("txtName")).sendKeys("For the above form a a a a a a a a a a a a a a a aaaaaaaaa a aaaaa aaaa aaaa aaaa aaaa aaaa aaaa a a ");
		driver.findElement(By.id("checkbox")).click();
		driver.findElement(By.id("btnSubmit")).click();
		String ExpText = "Please enter your full name,between 3 to 100 characters ";
		String ActText = driver.switchTo().alert().getText();
		try
		{
			Assert.assertEquals(ExpText, ActText);
		}
		catch (Throwable t)
		{
			System.out.println("incorrectmessage");
		}
		
		driver.switchTo().alert().accept();
		
	}
	
	
}
