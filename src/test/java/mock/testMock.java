package mock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class testMock {
    void mock(){
        stubFor(get(urlMatching(".*")).atPriority(10)
                .willReturn(aResponse().proxiedFrom("http://otherhost.com")));
    }
}
