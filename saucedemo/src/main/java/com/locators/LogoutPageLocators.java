package com.locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPageLocators {
	@FindBy(xpath = "//*[contains(@id,'logout_sidebar_link')]")
    public WebElement logout;
}
