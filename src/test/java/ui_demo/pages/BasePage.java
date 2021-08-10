package ui_demo.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.HashMap;
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

    public static WebElement findElement( By by) {
        try
        {
            System.out.println(by);
            //System.out.println(driver);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            return driver.findElement(by);

        } catch (Exception e) {
            System.out.println(by + "is not exit ");

        }
        return driver.findElement(by);
    }

   public void parseSteps(String method)  throws  IOException{
       ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
       String path='/'+this.getClass().getCanonicalName().replace('.','/')+".yaml";
       TypeReference<HashMap<String, TestCaseSteps>> typeRef =new TypeReference<HashMap<String, TestCaseSteps>>(){};
       try{
           HashMap<String, TestCaseSteps> steps =mapper.readValue(
                   this.getClass().getResourceAsStream(path),typeRef
           );

           steps.get("search").getSteps().forEach(step->{
               WebElement element = null;
               String id=step.get("id");
               if (id!=null){
                   element=driver.findElement(By.id(id));
               }
               String xpath=step.get("xpath");
               if (xpath!=null){
                   element=driver.findElement(By.id(xpath));
               }
               String aid=step.get("aid");
               if (aid!=null){
                   element=driver.findElement(MobileBy.AccessibilityId(aid));
               }
               String send=step.get("send");
               if (send!=null){
                   element.sendKeys(send);
               }
               else{
                   element.click();
               }
           });
       }
       catch (IOException e){
           e.printStackTrace();
       }
   }
 @Test
    public void parseSteps() throws IOException {
        App.before();
        BasePage basePage =new BasePage();
        basePage.parseSteps("search");
 }
    }

