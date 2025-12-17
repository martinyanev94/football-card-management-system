import io.swagger.v3.oas.annotations.RequestBody;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@PostMapping("/users")
@Operation(summary = "Create a new user", description = "Create a user by providing user details")
public ResponseEntity<User> createUser(
    @RequestBody(description = "User object that needs to be added", required = true) User user) {
    // Implementation for saving user
}
