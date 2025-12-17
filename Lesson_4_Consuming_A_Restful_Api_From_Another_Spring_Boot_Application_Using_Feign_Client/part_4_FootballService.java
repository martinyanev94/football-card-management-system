import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FootballService {
    
    private final FootballApiClient footballApiClient;

    @Autowired
    public FootballService(FootballApiClient footballApiClient) {
        this.footballApiClient = footballApiClient;
    }

    public List<MatchDTO> fetchMatches() {
        return footballApiClient.getMatches();
    }
}
