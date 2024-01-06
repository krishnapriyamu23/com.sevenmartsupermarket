package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageUtility;
	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']//li[13]")
	WebElement manageDeliveryBoyElement;
	@FindBy(xpath= "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> nameElements;
	@FindBy(xpath = "//input[@id='name']")
	WebElement nameInput;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement updateButton;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageDeliveryBoy() {
		manageDeliveryBoyElement.click();
	}
	public void clickOnEditButton() {
		editButton.click();
	}

	public void editDeliveryBoy(String deliveryBoyName) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		int index = 0;
		List<String> names = new ArrayList<String>();
		names = generalUtility.getTextOfElements(nameElements);
//		for(String name:names) {
//			System.out.println(name);
//		}
		for (index = 0; index < names.size(); index++) {
			if (deliveryBoyName.equals(names.get(index))) {
				index++;
				break;
			}
		}
		WebElement editDeliveryBoyElement = driver.findElement(By.xpath(
				"//table[@class='table table-bordered table-hover table-sm']//tbody/tr[" + index + "]/td[8]//a[1]"));
		pageUtility.scroll_AndClick(editDeliveryBoyElement);
	}
	public void enterName(String name) {
		nameInput.sendKeys();
	}
	public void clickOnUpdateButton() {
		updateButton.click();
	}
}
