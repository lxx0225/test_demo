package UI_Demo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage {


    public static void before(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //手机类型或模拟器类型
        capabilities.setCapability("deviceName", "DULJOB8DWOZTKR6H");
        //自动化测试引  capabilities.setCapability("automationName", "Appium");
        //手机操作系统iOS, Android, or FirefoxOS
        capabilities.setCapability("platformName", "Android");
        //手机操作系统版本号
        capabilities.setCapability("platformVersion", "7.1.1");
        //app包名
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        //app中启动的 Activity名称
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilities.setCapability("noReset", true);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            System.out.println(driver);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    public static SearchPage toSearch(){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        findElement("com.xueqiu.android:id/home_search").click();
        return new SearchPage();

    }
}
