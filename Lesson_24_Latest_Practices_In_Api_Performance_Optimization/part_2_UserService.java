@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable("users")
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "users", key = "#user.id")
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
