package com.library.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * getDriver()
 * quitDriver()
 */

public class Driver {

    private static WebDriver obj ;

    private Driver(){ }

    public static WebDriver getDriver(){

        String browserName = "chrome";
                //ConfigReader.read("browser");//get browser type from properties file

        if(obj == null){

            switch (browserName.toLowerCase() ){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    obj = new SafariDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    break;
                // other browsers omitted
                default:
                    obj = null ;
                    System.out.println("UNKNOWN BROWSER TYPE!!! " + browserName);
            }

        }else{
            return obj;
        }

        return obj ;
    }


    public static void quitBrowser(){

        if(obj != null){
            obj.quit();
            obj = null;
        }

    }


}
