package com.proj.pageobjects;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proj.constants.PageObjects;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class HomePage {
	
	 //WebDriver driver;
//	 public HomePage(WebDriver driver){
//
//	       // this.driver = driver;
//	        PageFactory.initElements(driver, this);
//	        
//	    }
	
	 
//region WebElement declaration
	 
	  @FindBy(name="title")
	    WebElement pageTitle;
	  
	    @FindBy(id="booking-form--flight-tab")
	    WebElement tabName;
   
	    @FindBy(id="trip-type-round-trip")
	    WebElement radio_tripType;
   
	    @FindBy(id="air-city-departure")
	    WebElement cityDeparture;

	    @FindBy(id="air-city-arrival")
	    WebElement cityArrival;

	    @FindBy(id="air-date-departure")
	    WebElement txt_dateDepart;
	    
	    @FindBy(id="air-date-return")
	    WebElement txt_dateReturn;

	    @FindBy(id="air-pax-count-adults")
	    WebElement txt_countAdults;
	    
	    @FindBy(id="air-pax-count-seniors")
	    WebElement txt_countSenior;
	    
	    @FindBy(id="jb-booking-form-submit-button")
	    WebElement btn_flightSearch;

	    @FindBy(id="outbound_results")
	    WebElement search_results;
	    
	    @FindBy(id="Out1C")
	    WebElement outbound_flight;
	    
	    @FindBy(id="In1C")
	    WebElement inbound_flight;
	    
	    @FindBy(id="priceItinerarySubmit")
	    WebElement flight_continue;
	    
	    @FindBy(id="page_title")
	    WebElement final_page_title;
	    
	    @FindBy(css=PageObjects.FLIGHT_PRICE)
	    WebElement flight_price;
	    
	   
	    public String get_final_page_title() {
	    	return final_page_title.getText();
		}
	    
	    
	    
	    public String get_flight_price() {
			 return flight_price.getText();
		}

		/**
		 * @return the outbound_flight
		 */
		public void Outbound_flight() {
			 outbound_flight.click();
		}

		/**
		 * @param outbound_flight the outbound_flight to set
		 */
		public void setOutbound_flight(WebElement outbound_flight) {
			this.outbound_flight = outbound_flight;
		}

		/**
		 * @return the inbound_flight
		 */
		public void Inbound_flight() {
			 inbound_flight.click();
		}

		/**
		 * @param inbound_flight the inbound_flight to set
		 */
		public void setInbound_flight(WebElement inbound_flight) {
			this.inbound_flight = inbound_flight;
		}

		/**
		 * @return the flight_continue
		 */
		public void Flight_continue() {
			 flight_continue.click();
		}

		/**
		 * @param flight_continue the flight_continue to set
		 */
		public void setFlight_continue(WebElement flight_continue) {
			this.flight_continue = flight_continue;
		}

		/**
		 * @return the search_results
		 */
		public WebElement getSearch_results() {
			return search_results;
		}

		/**
		 * @param search_results the search_results to set
		 */
		public void setSearch_results(WebElement search_results) {
			this.search_results = search_results;
		}

//endregion

 //region method definition
	   

	    /**
		 * @return the pageTitle
		 */
		public WebElement getPageTitle() {
			return pageTitle;
		}

		/**
		 * @param pageTitle the pageTitle to set
		 */
		public void setPageTitle(WebElement pageTitle) {
			this.pageTitle = pageTitle;
		}

		
//		//verify the page title to confirm 
//	    public String verifyPagetitle()
//	    {
//	    	return pageTitle.getText();
//	    }
	    
	    /**
		 * @return the tabName
		 */
		public WebElement getTabName() {
			return tabName;
		}

		/**
		 * @param tabName the tabName to set
		 */
		public void setTabName(WebElement tabName) {
			this.tabName = tabName;
		}

		//Set departure city 
	    public void setCityDeparture(String strDepatureCity)
	    {
	    	cityDeparture.sendKeys(strDepatureCity);
	    }
	    
	    //Set arrival city name 
	    public void setCityArrival(String strReturnCity)
	    {
	    	cityArrival.sendKeys(strReturnCity);
	    }
	    
	  
	    public void setDepatureDate(String depaturedate)
	    {
	    	txt_dateDepart.clear();
	    	txt_dateDepart.sendKeys(depaturedate);
	    }
	    
	    public void setReturnDate(String returnDate)
	    {
	    	txt_dateReturn.clear();
	    	txt_dateReturn.sendKeys(returnDate);
	    	//dateReturn.stoString(date);
	    }
	    
	    
	    public void searchFlight()
	    {
	    	
	    	btn_flightSearch.submit();
	     }
	    
	    public void waitForElement(String input, WebDriver driver)
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
	    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(input)));	
	    }
	    
	    
	    
//endregion 
	    
}