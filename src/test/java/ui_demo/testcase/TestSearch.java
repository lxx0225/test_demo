package ui_demo.testcase;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import ui_demo.pages.App;
import ui_demo.pages.SearchPage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class TestSearch {

    public static SearchPage searchPage;


    @BeforeAll
    public static void start() {
        App.before();

    }

    @BeforeEach
    public void before() {

        searchPage = App.getInstance().toSearch();
    }

    @ParameterizedTest
   @MethodSource("stockPrice")

    public void testSearch(String stock,double price) throws IOException {
        //assertThat(new Double(searchPage.search(stock).getPrice()), greaterThan(price));
        assertThat(new Double(searchPage.search(stock).getPrice()), greaterThanOrEqualTo(price));


    }

    static Stream<Arguments> stockPrice() {
        return Stream.of(
                Arguments.of("pdd", 1.0),
                Arguments.of("xiaomi", 2.0)
        );
    }
    @AfterEach
    public void after(){
        searchPage.quit();
    }
}
