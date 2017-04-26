package com.proj.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.proj.constants.PageObjects;

public class SelectFlightAndPricePage {

	// region WebElement declaration

	@FindBy(id = "outbound_results")
	WebElement search_results;

	@FindBy(id = "Out1C")
	WebElement outbound_flight;

	@FindBy(id = "In1C")
	WebElement inbound_flight;

	@FindBy(id = "priceItinerarySubmit")
	WebElement flight_continue;

	@FindBy(id = "page_title")
	WebElement final_page_title;

	@FindBy(css = PageObjects.FLIGHT_PRICE)
	WebElement flight_price;

	// endregion

	// region methods
	/**
	 * @return the outbound_flight
	 */
	public void Outbound_flight() {
		outbound_flight.click();
	}

	/**
	 * @param outbound_flight
	 *            the outbound_flight to set
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
	 * @param inbound_flight
	 *            the inbound_flight to set
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
	 * @param flight_continue
	 *            the flight_continue to set
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
	 * @param search_results
	 *            the search_results to set
	 */
	public void setSearch_results(WebElement search_results) {
		this.search_results = search_results;
	}

	public String get_final_page_title() {
		return final_page_title.getText();
	}

	public String get_flight_price() {
		return flight_price.getText();
	}

	// endregion

}
