package ui_demo.pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class StockPage extends BasePage {
    public StockPage deleteAll(){
        click(By.id("com.xueqiu.android:id/edit_group"));
        click(By.id("com.xueqiu.android:id/check_all"));
        click(By.id("com.xueqiu.android:id/cancel_follow"));
        click(By.id("com.xueqiu.android:id/tv_right"));
        click(By.id("com.xueqiu.android:id/action_close"));


        return this;
    }

    public List<String> getAllStocks(){

        handleAlert();

        List<String> stocks=new ArrayList<>();
        findElements(By.id("com.xueqiu.android:id/portfolio_stockName")).forEach(element ->
        {
            stocks.add(element.getText());
        });
        System.out.println(stocks);
        return stocks;
    }

    public StockPage addDefaultSelectedStocks(){
        click(By.id("com.xueqiu.android:id/add_to_portfolio_stock"));
        return this;
    }

    public SearchPage toSearch(){
        click(By.id("com.xueqiu.android:id/action_search"));
        return new SearchPage();
    }
}