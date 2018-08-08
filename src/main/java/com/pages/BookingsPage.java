package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tools.entities.Booking;
import com.tools.entities.Item;
import com.tools.entities.User;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class BookingsPage extends AbstractPage {
	@FindBy(css = "ul[class*='bookings-listing']")
	WebElementFacade itemBookingsContainer;
	@FindBy(css = "button#item-return-item")
	WebElementFacade returnItemConfirmationPopup;
	
	@FindBy(css  = "ul[class*='nav nav-tabs'] a")
	private List<WebElement> bookingsTabsList;
	
	public void selectBookingTab(String tabName) {
		for(WebElement tab : bookingsTabsList) {
			if(tab.getText().equalsIgnoreCase(tabName)) {
				tab.click();
				break;
			}
		}
	}

	// TODO la metodele astea nu as da parametru tot oboectul, si doar un string
	// care sa reprezinte textul dupa care cauti. Nu e nici gresit daca nu
	// folsoesti metoda ca step, daca era step aparea rau in raport
	// TODO la elemente cum is localizate nu ma uit
	// TODO la astea 2 metode faceti o metoda care returneaza un obiectul de
	// booking care ne intereseaza, si folositi in ambele metode metoda creata
	public void returnItem(Booking b) {
		List<WebElementFacade> bookings = itemBookingsContainer
				.thenFindAll(By.cssSelector("div[class*='item-booking-container']"));
		for (WebElementFacade booking : bookings) {
			String actualItemName = booking
					.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a")).getText()
					.trim();
			String from = booking.find(
					By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(2)"))
					.getText();
			if (actualItemName.contentEquals(b.getItem().getTitle()) && from.contentEquals(b.getStartDate())) {
				booking.find(By.cssSelector("button[class*='return-item']")).click();
				returnItemConfirmationPopup.click();
				break;
			}
		}
	}

	// TODO la metodele astea nu as da parametru tot obiectul, si doar un string
	// care sa reprezinte textul dupa care cauti. Nu e nici gresit daca nu
	// folsoesti metoda ca step, daca era step aparea rau in raport
	// TODO la elemente cum is localizate nu ma uit
	// TODO la astea 2 metode faceti o metoda care returneaza un obiectul de
	// booking care ne intereseaza(puneti si un assert sa crape in cazul in care
	// nu e gasit bookingul), si folositi in ambele metode metoda creata

	public Booking getBookingModel(Booking b) {
		Booking bookingModel = new Booking();
		List<WebElementFacade> bookings = itemBookingsContainer
				.thenFindAll(By.cssSelector("div[class*='item-booking-container']"));
		for (WebElementFacade booking : bookings) {
			String actualItemName = booking
					.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a")).getText()
					.trim();
			String from = booking.find(
					By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(2)"))
					.getText();
			if (actualItemName.contentEquals(b.getItem().getTitle()) && from.contentEquals(b.getStartDate())) {
				String to = booking
						.find(By.cssSelector(
								"div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(4)"))
						.getText();
				String userName = booking
						.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(3) a")).getText()
						.trim();
				User user = new User();
				user.setName(userName);
				Item item = new Item();
				item.setTitle(actualItemName);
				bookingModel.setBookingStatus(booking.find(By.cssSelector(".status-label")).getText());
				bookingModel.setStartDate(from);
				bookingModel.setEndDate(to);
				bookingModel.setUser(user);
				bookingModel.setItem(item);
				break;
			}
		}

		return bookingModel;
	}
}
