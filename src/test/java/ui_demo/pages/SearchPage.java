package ui_demo.pages;

public class SearchPage extends App {

    public SearchPage search(String keyworlds){
        findElement("com.xueqiu.android:id/search_input_text").sendKeys(keyworlds);
        findElement("com.xueqiu.android:id/name").click();
        return this ;
    }

    public App  quit(){
        findElement("com.xueqiu.android:id/action_close").click();
        return  new App();

    }
    public Float getPrice(){
        //将获取的数值转换成浮点数
       Float price= Float.parseFloat( findElement("com.xueqiu.android:id/current_price").getText());
        System.out.println(price);
        return price;
    }


}
