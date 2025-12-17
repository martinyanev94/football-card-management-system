public Match createMatch(Match match) {
    return restTemplate.postForObject(API_URL, match, Match.class);
}
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@PostMapping
public Match createMatch(@RequestBody Match match) {
    return matchService.createMatch(match);
}
