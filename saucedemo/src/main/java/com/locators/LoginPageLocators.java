package com.locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	@FindBy(name = "user-name")
    public WebElement userName;
  
    @FindBy(name = "password")
    public WebElement password;
     
    @FindBy(name = "login-button")
    public WebElement login;
  
    @FindBy(xpath = "//*[contains(@id,'login_button_container')]/div/form/div[3]/h3")
    public  WebElement errorMessage;

}
