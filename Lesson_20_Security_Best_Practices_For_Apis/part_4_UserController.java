import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
        String sanitizedUsername = sanitize(user.getUsername());
        user.setUsername(sanitizedUsername);
        // Proceed to save user to the database
        return user;
    }

    private String sanitize(String input) {
        return input.replaceAll("[<>]", ""); // Simple XSS protection
    }
}
