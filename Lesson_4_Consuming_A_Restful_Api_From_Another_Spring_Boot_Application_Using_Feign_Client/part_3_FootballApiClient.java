import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "football-api", url = "https://api.football.com")
public interface FootballApiClient {
    
    @GetMapping("/matches")
    List<MatchDTO> getMatches();
}
public class MatchDTO {
    private Long id;
    private String homeTeam;
    private String awayTeam;
    private String score;

    // Getters and Setters
}
