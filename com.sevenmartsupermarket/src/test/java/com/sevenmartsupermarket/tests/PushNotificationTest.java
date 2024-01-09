package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelRead;

public class PushNotificationTest extends Base {

	PushNotificationPage pushNotificationPage;
	LoginPage loginPage;
	ExcelRead excelRead=new ExcelRead();
	SoftAssert softassert=new SoftAssert();;
	@Test(groups = "smoke")
	public void verifyPushNotificationMessage() throws InterruptedException {
		pushNotificationPage=new PushNotificationPage(driver);
		loginPage=new LoginPage(driver);
		loginPage.login();
		excelRead.setExcelFile("PushNotifications", "Notification"); 
		pushNotificationPage.clickOnPushNotifications();
		String title=excelRead.getCellData(1, 0);
		String description=excelRead.getCellData(1, 1);
		pushNotificationPage.sendNotifications(title, description);
		softassert.assertTrue(pushNotificationPage.isSuccessAlertDisplayed());
		softassert.assertAll();
	}
}
