package com.proj.javalearnings;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.proj.commonsetup.BaseSetup;
import com.proj.pageobjects.HomePage;
import com.proj.pageobjects.SelectFlightAndPricePage;
import com.proj.constants.*;
import com.proj.utils.*;

public class BookingFlightTestCase extends BaseSetup {

	WebDriver driver;
	utils webUtil = new utils();

	@BeforeTest
	public void setup() throws IOException {
		driver = selectBrowser("chrome", Constants.HOMEPAGE_URL);
	}

	@Test
	public void test_Home_Page() {
		// Create home Page object
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		SelectFlightAndPricePage selectFlight = PageFactory.initElements(driver, SelectFlightAndPricePage.class);
		String currentPage = homePage.getTabName().getText();
		System.out.println("Current Location is" + currentPage);
		Assert.assertTrue(StringUtils.containsIgnoreCase(currentPage, "flight"));

		// setting depature location
		System.out.println("Selecting Depature City");
		homePage.setCityDeparture(Constants.DEPARTURE_LOC);

		// setting arrival location
		System.out.println("Selecting Arrival City");
		homePage.setCityArrival(Constants.ARRIVAL_LOC);

		// set current date
		System.out.println("Setting Departure Date");
		homePage.setDepatureDate(webUtil.dateNow());

		// set return date
		System.out.println("Setting Return Date");
		homePage.setReturnDate(webUtil.datePlusWeek());

		System.out.println("Look for flights details");
		homePage.searchFlight();

		// Validate Search Results
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		System.out.println("Look for flight selection page");
		System.out.println(selectFlight.getSearch_results().getText());
		Assert.assertTrue(selectFlight.getSearch_results().getText().contains("Select Departing Flight:"));

		// select OutBound flight
		System.out.println("selecting outbound flight");
		selectFlight.Outbound_flight();

		// select inbounds flight
		System.out.println("selecting inbound flight");
		selectFlight.Inbound_flight();

		// select further continue
		System.out.println("Confirmed the flight and click continue");
		selectFlight.Flight_continue();

		webUtil.sendEmail(selectFlight.get_final_page_title(), selectFlight.get_flight_price());

	}

}
