package com.general.scripting;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Question2b extends BeforeAfter {

	@Test
	public void getFoodAndServings() {
		List<WebElement> food = driver.findElements(By.className("title"));
		List<WebElement> serving = driver.findElements(By.className("description"));
		
		System.out.println("All the food and their servings are printed below:");
		System.out.println("");
		for (int i = 0; i < food.size(); i++) {

			String elementFood = food.get(i).getText();
			String elementServing = serving.get(i).getText();
			System.out.println(elementFood + " : " + elementServing);
		}
	}
}
