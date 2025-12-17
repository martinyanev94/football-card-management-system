import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FootballServiceTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080); // Start WireMock on port 8080

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetFootballData() throws Exception {
        wireMockRule.stubFor(get(urlEqualTo("/football/matches"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"matches\": [{ \"id\": \"1\", \"teamA\": \"Team A\", \"teamB\": \"Team B\" }] }")));
        
        mockMvc.perform(get("/api/football/matches"))
                .andExpect(status().isOk());
    }
}
