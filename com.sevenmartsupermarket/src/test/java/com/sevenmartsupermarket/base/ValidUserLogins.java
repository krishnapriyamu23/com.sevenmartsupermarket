package com.sevenmartsupermarket.base;

import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.ExcelRead;

public class ValidUserLogins {
	ExcelRead excelread =new ExcelRead();
	@DataProvider(name="Valid User Credentials")
	public Object[][] Credentials()
	{
		return new Object [][] {{"pinky"," selenium"},{"Shameena"," Batch5"},{"ShameenaPS"," Batch5"}}; 
	}
	@DataProvider(name= "User Credential_Excel")
	public Object[][] User Credentials()
	{
		excelread.setExcelFile("LoginData", "LoginCredentials");
		Object data[][]=excelread.getMultidimentionalData(3, 2);
		return data;
	}
}
