package com.proj.javalearnings;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	utils webutil = new utils();
	
	
	//HomePage homePage;
	
	//String url="https://www.southwest.com/";
	 @BeforeTest
	 public void setup() throws IOException{
	    driver = selectBrowser("chrome",Constants.HOMEPAGE_URL);
	  //This initElements method will create all WebElements
	 

	 
        
	    }
	

	    @Test
	    public void test_Home_Page()
	    {
	    	//Create home Page object
	    	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		 //homePage = new HomePage(driver);	
	    	//Verify login page title
	    //String homePageTitle = homePage.getPageTitle().getText();
	    //System.out.println("The page title is:"+homePageTitle);
	    //Assert.assertTrue(homePageTitle.contains("Southwest"));
	    System.out.println(homePage.getTabName().getText());
	    
	    //setting depature location
	    homePage.setCityDeparture(Constants.DEPARTURE_LOC);
	    
	    //setting arrival location
	    homePage.setCityArrival(Constants.ARRIVAL_LOC);
	    
	    //set current date
	    homePage.setDepatureDate(webutil.dateNow());
	    
	    //set return date
	    homePage.setReturnDate(webutil.datePlusWeek());
	    
//	    String departureCity = "IAD";
//	    homePage.setCityDeparture(departureCity);
//	    
//	    String arrivalCity = "LAX";
//	    homePage.setCityDeparture(arrivalCity);
//	       
//	    
	 	homePage.searchFlight();
	 	
	 	homePage.waitForElement("outbound_results", driver);
	 	

	 	
	 	
	 	
	 	// Validate Search Results
	 	
	 	System.out.println(homePage.getSearch_results().getText());
	 	Assert.assertTrue(homePage.getSearch_results().getText().contains("Austin, TX to New York/Newark, NJ"));
	 	
	 	homePage.waitForElement("Out1C", driver);
	 	
	 	//select inbound flight
	 	homePage.Outbound_flight();
	 	//select outbounf flight
	 	homePage.Inbound_flight();
	 	//select further continue
	 	homePage.Flight_continue();
	 	
	 	webutil.sendEmail(homePage.get_final_page_title(), homePage.get_flight_price());
	 	
	    
	    }
	    
	    
	  
}
