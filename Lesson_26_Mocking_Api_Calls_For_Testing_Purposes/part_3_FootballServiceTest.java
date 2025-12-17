import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class FootballServiceTest extends BaseWireMockTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGetFootballData() {
        stubFor(get(urlEqualTo("/api/football"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"league\": \"Premier League\", \"team\": \"Arsenal\", \"points\": 75 }")));

        String response = restTemplate.getForObject("http://localhost:8089/api/football", String.class);
        assertEquals("{\"league\":\"Premier League\",\"team\":\"Arsenal\",\"points\":75}", response);
    }
}
