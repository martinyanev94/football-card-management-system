import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public User createUser(User newUser) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer your_token_here");
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<User> request = new HttpEntity<>(newUser, headers);

    try {
        return restTemplate.postForObject(BASE_URL, request, User.class);
    } catch (RestClientException e) {
        throw new RuntimeException("Failed to create user", e);
    }
}
