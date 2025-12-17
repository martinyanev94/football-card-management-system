@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<UserDTO> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(user -> new UserDTO(user.getId(), user.getUsername()));
    }
}
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getUsers(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userService.getUsers(pageable));
    }
}
