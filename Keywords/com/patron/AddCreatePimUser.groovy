package com.patron

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class AddDeletePimUser {
	TestObject searchInput = findTestObject('Object Repository/Main Page/input_Admin_oxd-input oxd-input--focus')
	TestObject pimSpan = findTestObject('Object Repository/AddDeletePimUser/span_PIM')
	TestObject addEmployeeLink = findTestObject('Object Repository/AddDeletePimUser/a_Add Employee')
	TestObject listEmployeeLink = findTestObject('Object Repository/AddDeletePimUser/a_Employee List')
	TestObject firstnameInput = findTestObject('Object Repository/AddDeletePimUser/input_Employee Full Name_firstName')
	TestObject lastnameInput = findTestObject('Object Repository/AddDeletePimUser/input_Employee Full Name_lastName')
	TestObject saveButton = findTestObject('Object Repository/AddDeletePimUser/button_Save')
	TestObject searchEmployeeInput = findTestObject('Object Repository/AddDeletePimUser/inputSearchPim')
	TestObject searchButtonPim = findTestObject('Object Repository/AddDeletePimUser/button_Search')
	TestObject foundUserDiv = findTestObject('Object Repository/AddDeletePimUser/div_0321James Bond')
	TestObject deleteFoundUserDiv = findTestObject('Object Repository/AddDeletePimUser/i_Bond_oxd-icon bi-trash')
	TestObject deleteComfirmationDiv = findTestObject('Object Repository/AddDeletePimUser/i_Yes, Delete_oxd-icon bi-trash oxd-button-icon')

	@Keyword
	def addUser = { String firstname, String lastname ->
		WebUiCommonHelper.findWebElement(searchInput, 1).sendKeys('PIM')
		WebUiCommonHelper.findWebElement(pimSpan, 1).click()
		WebUiCommonHelper.findWebElement(addEmployeeLink, 1).click()
		WebUiCommonHelper.findWebElement(firstnameInput, 1).sendKeys(firstname)
		WebUiCommonHelper.findWebElement(lastnameInput, 1).sendKeys(lastname)
		WebUiCommonHelper.findWebElement(saveButton, 1).click()
		WebUI.delay(3)
		WebUiCommonHelper.findWebElement(listEmployeeLink, 1).click()
		WebUiCommonHelper.findWebElement(searchEmployeeInput, 1).sendKeys(firstname,' ',  lastname)
		WebUiCommonHelper.findWebElement(searchButtonPim, 1).click()
		WebUI.verifyElementPresent(foundUserDiv, 1)
	}

	@Keyword
	def deleteUser = { String firstname, String lastname ->
		WebUiCommonHelper.findWebElement(searchInput, 1).sendKeys('PIM')
		WebUiCommonHelper.findWebElement(pimSpan, 1).click()
		WebUiCommonHelper.findWebElement(listEmployeeLink, 1).click()
		WebUiCommonHelper.findWebElement(searchEmployeeInput, 1).sendKeys(firstname,' ',  lastname)
		WebUiCommonHelper.findWebElement(searchButtonPim, 1).click()
		try {
			while (WebUiCommonHelper.findWebElement(foundUserDiv, 1).isDisplayed()) {
				WebUiCommonHelper.findWebElement(deleteFoundUserDiv, 1).click()
				WebUI.delay(3)
				WebUiCommonHelper.findWebElement(deleteComfirmationDiv, 1).click()
				WebUI.delay(3)
		}
		}catch(Exception e) {
			WebUI.verifyElementNotPresent(foundUserDiv, 1)
		}
	
/*
		//impossible >:| known issue from '19 https://forum.katalon.com/t/webui-verify-element-present/16622/3
		try {
			WebUI.verifyElementNotPresent(foundUserDiv, 1)
		}catch (Exception e) {
			WebUI.verifyEqual(true, true)
		}
*/
	}


}
