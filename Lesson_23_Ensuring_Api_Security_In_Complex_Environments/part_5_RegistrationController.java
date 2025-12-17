@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
        if (userService.usernameExists(request.getUsername())) {
            throw new UserAlreadyExistsException("Username is already taken");
        }
        userService.registerNewUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
    }
}
