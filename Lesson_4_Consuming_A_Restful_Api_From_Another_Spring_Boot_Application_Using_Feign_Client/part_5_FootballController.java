import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FootballController {
    
    private final FootballService footballService;

    @Autowired
    public FootballController(FootballService footballService) {
        this.footballService = footballService;
    }

    @GetMapping("/api/matches")
    public List<MatchDTO> getMatches() {
        return footballService.fetchMatches();
    }
}
