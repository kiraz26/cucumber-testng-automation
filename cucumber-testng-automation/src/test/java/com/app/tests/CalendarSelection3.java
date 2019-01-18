package com.app.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.utilities.Driver;

import oracle.sql.DATE;

public class CalendarSelection3 {
	private WebDriver driver;
	private String baseUrl;
	private String today;

	@BeforeClass
	public void setUp() throws Exception {
		driver = Driver.getDriver();
		baseUrl = "http://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//span[@class='uitk-icon uitk-icon-flights']")).click();
		WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
		departingField.click();

		// Here is the code to deal with <li> type date
		// WebElement calMonth =
		// driver.findElement(By.xpath("//*[@class='datepicker-cal-month'][1]//tbody/tr"));
		// ->we don't need this code(finding element)
		List<WebElement> allDates = driver.findElements(By.xpath("//*[@class='datepicker-cal-month'][1]//tbody/tr/td")); // all
																															// dates
																															// are
																															// from
																															// relative
																															// xpath
																															// it
																															// collected
																															// whole
																															// table
																															// of
																															// December

		/*
		 * we need to eliminate disabled data from table. if you look at the HTML tree
		 * there is span tag inside the table. if date is invalid or disabled, span says
		 * "date disabled"
		 */

		// We need a condition for handling invalid dates

		for (WebElement date : allDates) {
			// System.out.println(date.getText());// prints whole list
			if (!date.getText().contains("date disabled") && !date.getText().contains("empty")) {

				System.out.println(date.getText());// prints valid date list

			}
			if (date.getText().equals("31")) { // -> its meaning if day of the date is 31 quit from table there is not
												// 32. day
				date.click();
				System.out.println(date.getText());
				break;
			}
		}

		// My question is how to distiguish valid and invalid(greyd-out) dates if they
		// are the same <td> tags?

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
