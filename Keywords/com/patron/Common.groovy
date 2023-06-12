package com.patron

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Common {
	
	String link = 'http://opensource-demo.orangehrmlive.com'
	
	TestObject usernameInput = findTestObject('Object Repository/LoginForm/input_Username_username')
	TestObject passwordInput = findTestObject('Object Repository/LoginForm/input_Password_password')
	TestObject buttonInput = findTestObject('Object Repository/LoginForm/button_Login')
	
	@Keyword
	def openBrowserAndLogin = {
		String username = 'admin'
		String password = 'admin123'
		WebUI.openBrowser('')
		WebUI.navigateToUrl(link)
		
		WebUiCommonHelper.findWebElement(usernameInput, 1).sendKeys(username)
		WebUiCommonHelper.findWebElement(passwordInput, 1).sendKeys(password)
		WebUiCommonHelper.findWebElement(buttonInput, 1).click()
	}
	
	@Keyword
	def closeBrowser = {
		WebUI.closeBrowser()
	}
}
