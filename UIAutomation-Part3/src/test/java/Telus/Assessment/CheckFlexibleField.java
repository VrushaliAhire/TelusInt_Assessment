package Telus.Assessment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class CheckFlexibleField extends UIAutomation {
@Test (dependsOnMethods = { "enter101char" })


	public void checkedCheckbox()
	{
		driver.findElement(By.id("txtName")).clear();
		driver.findElement(By.id("txtName")).sendKeys("Vrushali");
		driver.findElement(By.id("checkbox")).click();
		driver.findElement(By.id("btnSubmit")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test (dependsOnMethods = { "checkedCheckbox" })
		public void Uncheckcheckbox()
		{
			driver.findElement(By.id("txtName")).clear();
			driver.findElement(By.id("txtName")).sendKeys("Vrushali");
			driver.findElement(By.id("checkbox")).click();
			driver.findElement(By.id("btnSubmit")).click();
			driver.switchTo().alert().accept();
		}
	
	@Test (dependsOnMethods = { "Uncheckcheckbox" })
	public void availabilityInCh()
	{
		driver.findElement(By.id("numavailability")).sendKeys("ABC");		
		driver.findElement(By.id("btnSubmit")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test (dependsOnMethods = {"availabilityInCh"})
	public void availabilityInNum()
	{
		driver.findElement(By.id("numavailability")).clear();
		driver.findElement(By.id("numavailability")).sendKeys("10");		
		driver.findElement(By.id("btnSubmit")).click();
		driver.switchTo().alert().accept();
	}
	
	
	
}


