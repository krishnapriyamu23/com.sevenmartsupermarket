package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationsPage;
import com.sevenmartsupermarket.utilities.ExcelReadUtility;

public class PushNotificationsTest extends Base {

	PushNotificationsPage pushNotificationsPage;
	LoginPage loginPage;
	ExcelReadUtility excelRead=new ExcelReadUtility();
	SoftAssert softassert=new SoftAssert();;
	@Test
	public void verifyPushNotificationMessage() throws InterruptedException {
		pushNotificationsPage=new PushNotificationsPage(driver);
		loginPage=new LoginPage(driver);
		loginPage.login();
		excelRead.setExcelFile("PushNotifications", "Notification"); 
		pushNotificationsPage.clickOnPushNotifications();
		String title=excelRead.getCellData(1, 0);
		String description=excelRead.getCellData(1, 1);
		pushNotificationsPage.sendNotifications(title, description);
		softassert.assertTrue(pushNotificationsPage.isSuccessAlertDisplayed());
		softassert.assertAll();
	}
	
}
