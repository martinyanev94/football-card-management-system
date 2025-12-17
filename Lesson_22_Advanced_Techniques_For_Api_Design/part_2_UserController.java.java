@RestController
@RequestMapping("/api/v1/users")
public class UserV1Controller {
    @GetMapping
    public List<User> getUsers() {
        // logic for version 1
        return userService.getAllUsersV1();
    }
}

@RestController
@RequestMapping("/api/v2/users")
public class UserV2Controller {
    @GetMapping
    public List<UserDTO> getUsers() {
        // returns data in a new structure for version 2
        return userService.getAllUsersV2();
    }
}
