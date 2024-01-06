package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class PushNotificationPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	@FindBy(xpath = "//a[@class=' nav-link']//p[contains(text(),'Push Notifications')]")
	WebElement PushNotificationElement;
	@FindBy(xpath = "//input[@id='title']")
	WebElement titleElement;
	@FindBy(xpath = "//input[@id='description']")
	WebElement descriptionElement;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButtton;

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnPushNotification() {
		PushNotificationElement.click();
	}

	public void enterTitle(String title) {
		titleElement.sendKeys(title);
	}

	public void enterDescription(String description) {
		descriptionElement.sendKeys(description);
	}

	public void submitPushNotification() {
		submitButtton.click();
	}

	public void enterPushNotification(String title, String description) {
		enterTitle(title);
		enterDescription(description);
		submitPushNotification();
	}
}

