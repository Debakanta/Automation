package com.definations;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.utils.HelperClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 
public class Hooks {
 
    @Before
    public static void setUp() {
 
       HelperClass.setUpDriver();
    }
 
    @After
    public static void tearDown(Scenario scenario) {
 
        //validate if scenario has failed take the screenshot
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
        }   
         
        HelperClass.tearDown();
    }
}