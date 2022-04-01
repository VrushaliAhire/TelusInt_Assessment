package Telus.Assessment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EmailValidation extends CheckFlexibleField {
	
	@Test (dependsOnMethods = { "availabilityInNum" })
	public void IncorrectEmailID()
	{
		driver.findElement(By.id("txtEmail")).sendKeys("Vrushali@ahire");
		driver.findElement(By.id("btnSubmit")).click();
		driver.switchTo().alert().accept();
	}

	
	@Test (dependsOnMethods = { "IncorrectEmailID" })
	public void correctEmailID()
	{
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtEmail")).sendKeys("Vrushali@ahire.com");
		driver.findElement(By.id("btnSubmit")).click();
		driver.switchTo().alert().accept();
	}

}
