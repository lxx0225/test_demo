package mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;


public class demo {
    public static  WireMockServer wireMockServer;
    @Before
    public void before(){
        wireMockServer = new WireMockServer(options().port(8089));
        wireMockServer.start();
    }
    @Test
    public void exactUrlOnly() {
        configureFor("127.0.0.1", 8089);
        stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Hello world!")));

        given().when().log().all().get("http://127.0.0.1/some/thing")
                .then().log().all().body(containsString("stub"));
    }
    @After
    public void after(){
        wireMockServer.stop();

    }

}
