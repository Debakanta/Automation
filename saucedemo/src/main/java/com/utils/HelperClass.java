package com.utils;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
public class HelperClass {
	private static HelperClass helperClass;
    
    private static WebDriver driver;
    public final static int TIMEOUT = 4;
       
     private HelperClass() {
            
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
     }      
               
    public static void openPage(String url) {
        driver.get(url);
    }
           
    public static WebDriver getDriver() {
        return driver;              
    }
       
    public static void setUpDriver() {
           
        if (helperClass==null) {
               
            helperClass = new HelperClass();
        }
    }
       
    public static void tearDown() {
            
        if(driver!=null) {
             driver.close();
             driver.quit();
        }
            
       helperClass = null;
   } 
}
