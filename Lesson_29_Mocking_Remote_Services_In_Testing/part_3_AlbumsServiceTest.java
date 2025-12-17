import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AlbumsServiceTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void fetchAlbumDetails_ShouldReturnAlbumWithFootballResponse() throws Exception {
        stubFor(get(urlEqualTo("/football/match"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"matchId\":\"12345\",\"teamA\":\"Team A\",\"teamB\":\"Team B\"}")
                        .withStatus(200)));

        mockMvc.perform(get("/albums/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
