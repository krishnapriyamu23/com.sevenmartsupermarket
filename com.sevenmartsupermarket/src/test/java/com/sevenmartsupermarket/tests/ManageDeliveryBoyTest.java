package com.sevenmartsupermarket.tests;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenmartsupermarket.utilities.ExcelReadUtility;

public class ManageDeliveryBoyTest extends Base {

	ManageDeliveryBoyPage manageDeliveryBoyPage;
	LoginPage loginPage;
	ExcelReadUtility excelRead=new ExcelReadUtility();
	SoftAssert softassert=new SoftAssert();
	
	@Test(groups="smoke")
	
	public void verifyDeliveryBoyHeading() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		String expectedHeading = "List Delivery Boy";
		String actualHeading = manageDeliveryBoyPage.getHeading();	
		softassert.assertEquals(actualHeading, expectedHeading);
	}
	
	@Test
	public void verifyDeliveryBoyHomeButton() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.clickOnHomeButton();
		String expectedURL = "https://groceryapp.uniqassosiates.com/admin/home";
		String actualURL= driver.getCurrentUrl();
		softassert.assertEquals(actualURL, expectedURL);
	}

	@Test
	public void verifyDeliverBoyEdit() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.editDeliveryBoy("ShameenaPS");
		manageDeliveryBoyPage.enterName("Rahul");
		manageDeliveryBoyPage.clickOnUpdateButton();
//		
	}

//	@Test(groups={"smoke","regression"})
//
//	public void verifyCreatingNewDeliveryBoy() {
//		loginPage=new LoginPage(driver);
//		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
//		loginPage.login();
//		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
//		manageDeliveryBoyPage.clickOnCreateNewDeliveryBoy();
//		excelRead.setExcelFile("CreateDeliveryBoy", "Valid Delivery Boy");
//		String name=excelRead.getCellData(8, 0);
//		String email=excelRead.getCellData(8, 1);
//		String phone=excelRead.getCellData(8, 2);
//		String address=excelRead.getCellData(8, 3);
//		String username=excelRead.getCellData(8, 4);
//		String password=excelRead.getCellData(8, 5);
//		manageDeliveryBoyPage.sendDeliveryBoyData(name, email, phone, address, username, password);
//		List<String> actualData=manageDeliveryBoyPage.getDeliveryBoyDetails();
//		softassert.assertEquals(actualData.get(0), name);
//		softassert.assertEquals(actualData.get(1), email);
//		softassert.assertEquals(actualData.get(2), phone);
//		softassert.assertEquals(actualData.get(3), address);
//		softassert.assertEquals(actualData.get(4), username);
//		softassert.assertTrue(manageDeliveryBoyPage.isSuccessMessageAlertDisplayed());
//		softassert.assertAll();
	}
}
