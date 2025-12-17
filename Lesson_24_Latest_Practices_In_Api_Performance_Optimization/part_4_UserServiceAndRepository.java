@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
public interface UserRepository extends JpaRepository<User, Long> {
}
