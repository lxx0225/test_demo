package ui_demo.pages;

import org.openqa.selenium.By;

public class SearchPage extends App {

    public SearchPage search(String keyworlds){
//        findElement("com.xueqiu.android:id/search_input_text").sendKeys(keyworlds);
//        findElement("com.xueqiu.android:id/name").click();
        parseSteps("/ui_demo/pages/SearchPage.yaml","search");
        return this ;
    }

    public App  quit(){
        //findElement("com.xueqiu.android:id/action_close").click();
        parseSteps("/ui_demo/pages/SearchPage.yaml","quit");
        return  new App();

    }
    public Float getPrice(){
        //将获取的数值转换成浮点数
       Float price= Float.parseFloat( findElement("com.xueqiu.android:id/current_price").getText());
        System.out.println(price);
        return price;
    }
    public SearchPage select(){
      click(By.id("com.xueqiu.android:id/follow_btn"));
       // parseSteps();
        return this;
    }


}
