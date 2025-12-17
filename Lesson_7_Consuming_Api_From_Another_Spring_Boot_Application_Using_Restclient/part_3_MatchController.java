import com.fasterxml.jackson.annotation.JsonProperty;

public class Match {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("homeTeam")
    private String homeTeam;

    @JsonProperty("awayTeam")
    private String awayTeam;

    @JsonProperty("score")
    private String score;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHomeTeam() { return homeTeam; }
    public void setHomeTeam(String homeTeam) { this.homeTeam = homeTeam; }

    public String getAwayTeam() { return awayTeam; }
    public void setAwayTeam(String awayTeam) { this.awayTeam = awayTeam; }

    public String getScore() { return score; }
    public void setScore(String score) { this.score = score; }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public Match[] getAllMatches() {
        return matchService.getAllMatches();
    }
}
