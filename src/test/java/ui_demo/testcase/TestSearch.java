package ui_demo.testcase;

import ui_demo.pages.App;
import ui_demo.pages.SearchPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class TestSearch {

    public static SearchPage searchPage;


    @BeforeAll
    public static void start() {
        App.before();

    }

    @BeforeEach
    public void before() {
        searchPage = App.toSearch();
    }


    @ParameterizedTest
    @MethodSource("stockPrice")
    public void testSearch(String stock,double price) {
        assertThat(new Double(searchPage.search(stock).getPrice()), greaterThan(price));

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
