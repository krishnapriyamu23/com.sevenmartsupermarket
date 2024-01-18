package com.sevenmartsupermarket.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 4;

	@Override
	public boolean retry(ITestResult result) {
		//need one more condtn//
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
}