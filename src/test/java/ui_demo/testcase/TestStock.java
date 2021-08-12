package ui_demo.testcase;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ui_demo.pages.App;
import ui_demo.pages.StockPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestStock {
    private static StockPage stockPage;
    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.before();
        stockPage= App.getInstance().toStocks();

    }
    @BeforeEach
    public void beforeEach(){

    }
    @Order(100)
    @Test
    public void addDefaultSelectedStocks(){
        if(stockPage.getAllStocks().size()>=1){
            stockPage.deleteAll();
        }
        //assertThat(stockPage.addDefaultSelectedStocks().getAllStocks().size(), greaterThanOrEqualTo(0));
    }

    @Order(200)
    @ParameterizedTest
//    @ValueSource(strings = { "pdd", "xiaomi"})
    @MethodSource("data")
    public void addStock(String code, String name) throws IOException {
        stockPage.toSearch().search(code).select().quit();
        assertThat(stockPage.getAllStocks(), hasItem(name));

    }

    public static Stream<Arguments> data(){
        return Stream.of(
                arguments("pdd", "拼多多")
        );
    }

}
