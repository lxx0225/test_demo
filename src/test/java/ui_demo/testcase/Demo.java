package ui_demo.testcase;
import io.appium.java_client.AppiumDriver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static AppiumDriver driver;

    @BeforeAll
    public static  void before() throws MalformedURLException {
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
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

@Test
    public void test()  {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
    }

    @AfterAll
    public static void after(){
        driver.quit();
    }
}
