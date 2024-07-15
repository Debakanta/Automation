package com.definations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.actions.ProductPageActions;
import com.actions.LoginPageActions;
import com.actions.LogoutPageActions;
import com.utils.HelperClass;
import org.testng.Assert;
 
public class LoginPageDefinitions {
 
    LoginPageActions loginPage = new LoginPageActions();
    ProductPageActions productPage = new ProductPageActions();
    LogoutPageActions logoutPage = new LogoutPageActions();
    
 
    @Given("User is on Saucedemo Page {string}")
    public void loginTest(String url) {
 
        HelperClass.openPage(url);
 
    }
 
    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {
 
        // Login to the application
    	loginPage.login(userName.trim(), passWord.trim());
 
        // Go to Product Page
 
    }
    @Then("User should be able to redirect to the Product page")
    public void verifyLogin() {
 
        // Verify Product page loading with label as Product
        Assert.assertTrue(productPage.getProuctPageText().contains("Product"));
 
    }
    @When("User click on Logout link")
    public void gobackToLoginPage() {
    	productPage.getBurgerMenu().click();
        // Redirect back to the login page
    	logoutPage.logout();
 
    }
    @Then("User should redirect back to the Login page")
    public void verifyLoginAfterLogout() {
    	
        // Verify Loginbutton text after logout
        Assert.assertTrue(loginPage.getLoginPageText().contains("Login"));
 
    }
    @Then("User should stay on same page with error msg as {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
 
        // Verify error message for invalid credentials
        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage);
 
    }
    
}