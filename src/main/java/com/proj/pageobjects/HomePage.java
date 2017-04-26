package com.proj.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	// region WebElement declaration

	@FindBy(id = "booking-form--flight-tab")
	WebElement tabName;

	@FindBy(id = "trip-type-round-trip")
	WebElement radio_tripType;

	@FindBy(id = "air-city-departure")
	WebElement cityDeparture;

	@FindBy(id = "air-city-arrival")
	WebElement cityArrival;

	@FindBy(id = "air-date-departure")
	WebElement txt_dateDepart;

	@FindBy(id = "air-date-return")
	WebElement txt_dateReturn;

	@FindBy(id = "air-pax-count-adults")
	WebElement txt_countAdults;

	@FindBy(id = "air-pax-count-seniors")
	WebElement txt_countSenior;

	@FindBy(id = "jb-booking-form-submit-button")
	WebElement btn_flightSearch;

	// endregion

	// region method definition

	/**
	 * @return the tabName
	 */
	public WebElement getTabName() {
		return tabName;
	}

	/**
	 * @param tabName
	 *            the tabName to set
	 */
	public void setTabName(WebElement tabName) {
		this.tabName = tabName;
	}

	// Set departure city
	public void setCityDeparture(String strDepatureCity) {
		cityDeparture.clear();
		cityDeparture.sendKeys(strDepatureCity);
	}

	// Set arrival city name
	public void setCityArrival(String strReturnCity) {
		cityArrival.clear();
		cityArrival.sendKeys(strReturnCity);
	}

	public void setDepatureDate(String depaturedate) {
		txt_dateDepart.clear();
		txt_dateDepart.sendKeys(depaturedate);
	}

	public void setReturnDate(String returnDate) {
		txt_dateReturn.clear();
		txt_dateReturn.sendKeys(returnDate);

	}

	public boolean searchFlight() {
		try {
			if (cityDeparture.getText() != null && cityArrival.getText() != null)
				btn_flightSearch.submit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// endregion

}