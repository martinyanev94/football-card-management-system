import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

public class UserService {

    // ... existing code ...

    public User getUserById(Long userId) {
        try {
            ResponseEntity<User> response = restTemplate.getForEntity(BASE_URL + userId, User.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                // Handle non-2xx HTTP responses
                throw new RuntimeException("Error retrieving user: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            // Handle connection errors or response mapping issues
            throw new RuntimeException("Error communicating with the remote API", e);
        }
    }
}
