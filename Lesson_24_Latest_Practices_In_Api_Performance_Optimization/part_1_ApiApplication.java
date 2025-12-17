@SpringBootApplication
@EnableCaching
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Cacheable("users")
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
