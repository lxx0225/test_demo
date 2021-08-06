package UI_Demo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static AppiumDriver driver;

    public static WebElement findElement( String ele) {
        try
        {
            System.out.println(ele);
            //System.out.println(driver);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            return driver.findElement(By.id(ele));

        } catch (Exception e) {
            System.out.println(ele + "is not exit ");

        }
        return driver.findElement(By.id(ele));
    }

    }

