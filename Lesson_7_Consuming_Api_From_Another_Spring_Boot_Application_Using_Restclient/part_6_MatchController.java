public void updateMatch(Long id, Match match) {
    restTemplate.put(API_URL + "/" + id, match);
}
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@PutMapping("/{id}")
public void updateMatch(@PathVariable Long id, @RequestBody Match match) {
    matchService.updateMatch(id, match);
}
public void deleteMatch(Long id) {
    restTemplate.delete(API_URL + "/" + id);
}
import org.springframework.web.bind.annotation.DeleteMapping;

@DeleteMapping("/{id}")
public void deleteMatch(@PathVariable Long id) {
    matchService.deleteMatch(id);
}
