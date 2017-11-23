package com.general.scripting;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Question2a extends BeforeAfter {
	
	@Test
	public void getSpecificValues(){
		
		WebElement element3 = driver.findElement(By.xpath("html/body/div[1]/span[5]"));
		String thirdItem = element3.getText();
		System.out.println("Third Item = "+thirdItem);
		
		WebElement element5 = driver.findElement(By.xpath("html/body/div[1]/span[9]"));
		String fifthItem = element5.getText();
		System.out.println("Third Item = "+fifthItem);
	}
}