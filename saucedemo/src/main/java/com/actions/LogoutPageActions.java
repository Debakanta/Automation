package com.actions;
import com.locators.LogoutPageLocators;
import com.utils.HelperClass;
import org.openqa.selenium.support.PageFactory;

public class LogoutPageActions {
	LogoutPageLocators logoutPageLocators = null;
	 
    public LogoutPageActions() {
 
        this.logoutPageLocators = new LogoutPageLocators();
 
        PageFactory.initElements(HelperClass.getDriver(),logoutPageLocators);
    }
 
    public void logout() {
 
        // Click Logout button
        logoutPageLocators.logout.click();
    }
}
