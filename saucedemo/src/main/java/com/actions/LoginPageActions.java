package com.actions;
import com.locators.LoginPageLocators;
import com.utils.HelperClass;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions {
	LoginPageLocators loginPageLocators = null;
	 
    public LoginPageActions() {
 
        this.loginPageLocators = new LoginPageLocators();
 
        PageFactory.initElements(HelperClass.getDriver(),loginPageLocators);
    }
 
    // Get the Error Message
    public String getErrorMessage() {
        return loginPageLocators.errorMessage.getText();
    }
 
    public void login(String strUserName, String strPassword) {
 
        // Fill user name
        loginPageLocators.userName.sendKeys(strUserName);
 
        // Fill password
        loginPageLocators.password.sendKeys(strPassword);
 
        // Click Login button
        loginPageLocators.login.click();
    }
    //Get Login page btn title after user logout
    public String getLoginPageText() {
        return loginPageLocators.login.getAttribute("value");
    }
}
