import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class MatchService {

    private final RestTemplate restTemplate;
    private static final String API_URL = "http://localhost:8081/api/matches";

    @Autowired
    public MatchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Match[] getAllMatches() {
        Match[] matches = restTemplate.getForObject(API_URL, Match[].class);
        return matches != null ? matches : new Match[0];
    }
}
