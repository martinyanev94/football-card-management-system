import org.springframework.web.client.RestClientException;

public String getPosts() {
    try {
        return restTemplate.getForObject(API_URL, String.class);
    } catch (RestClientException e) {
        // Log the error (in production, consider using a logging framework)
        return "Error fetching posts: " + e.getMessage();
    }
}
