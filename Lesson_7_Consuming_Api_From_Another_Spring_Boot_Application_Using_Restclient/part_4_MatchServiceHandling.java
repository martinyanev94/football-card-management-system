public class MatchServiceException extends RuntimeException {
    public MatchServiceException(String message) {
        super(message);
    }
}
import org.springframework.web.client.RestClientException;

public Match[] getAllMatches() {
    try {
        Match[] matches = restTemplate.getForObject(API_URL, Match[].class);
        return matches != null ? matches : new Match[0];
    } catch (RestClientException e) {
        throw new MatchServiceException("Failed to fetch matches: " + e.getMessage());
    }
}
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MatchServiceException.class)
    public ResponseEntity<String> handleMatchServiceException(MatchServiceException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
