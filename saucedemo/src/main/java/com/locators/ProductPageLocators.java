package com.locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageLocators {
	@FindBy(xpath = "//*[contains(@class,'title')]")
    public  WebElement productPageTitle;
	
	@FindBy(xpath = "//*[contains(@id,'react-burger-menu-btn')]")
    public  WebElement burgerMenu;
	
}
