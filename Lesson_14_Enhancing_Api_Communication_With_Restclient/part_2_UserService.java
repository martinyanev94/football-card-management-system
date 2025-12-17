import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://api.example.com/users/";

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserById(Long userId) {
        return restTemplate.getForObject(BASE_URL + userId, User.class);
    }
}
public class User {
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
}
