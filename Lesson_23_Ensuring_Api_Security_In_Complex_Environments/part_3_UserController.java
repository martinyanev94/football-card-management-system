@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found for this id :: " + id);
        }
        if (!userService.isAuthenticated()) {
            throw new UnauthorizedAccessException("User not authenticated for this resource");
        }
        return ResponseEntity.ok(user);
    }
}
