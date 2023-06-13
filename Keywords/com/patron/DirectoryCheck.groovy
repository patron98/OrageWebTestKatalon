package com.patron

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


import internal.GlobalVariable

public class DirectoryCheck {
	TestObject searchInput = findTestObject('Object Repository/Main Page/input_Admin_oxd-input oxd-input--focus')
	TestObject directoryDiv = findTestObject('Object Repository/Directory Check/a_Directory')
	TestObject searchEmployee = findTestObject('Object Repository/Directory Check/input')
	TestObject dropDownSelection = findTestObject('Object Repository/Directory Check/span_James  Bond')
	TestObject searchButton = findTestObject('Object Repository/Directory Check/button_Search')
	TestObject employeeCheckDiv = findTestObject('Object Repository/Directory Check/div_James  Bond')
	
	@Keyword
	def findUserDirectory = { String firstname ->
		WebUiCommonHelper.findWebElement(searchInput, 1).sendKeys('Directory')
		WebUiCommonHelper.findWebElement(directoryDiv, 1).click()
		WebUiCommonHelper.findWebElement(searchEmployee, 1).sendKeys(firstname)
		WebUiCommonHelper.findWebElement(dropDownSelection, 1).click()
		WebUiCommonHelper.findWebElement(searchButton, 1).click()
		
		WebUI.verifyElementPresent(employeeCheckDiv, 1)
	}
	
}
