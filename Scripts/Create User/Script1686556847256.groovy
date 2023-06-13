
String firstname = 'James'
String lastname = 'Bond'

CustomKeywords.'com.patron.Common.openBrowserAndLogin'()
CustomKeywords.'com.patron.AddDeletePimUser.addUser'(firstname, lastname)
CustomKeywords.'com.patron.DirectoryCheck.findUserDirectory'(firstname)
CustomKeywords.'com.patron.AddDeletePimUser.deleteUser'(firstname, lastname)
CustomKeywords.'com.patron.Common.closeBrowser'()

