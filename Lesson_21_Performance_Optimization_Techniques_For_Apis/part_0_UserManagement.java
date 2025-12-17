@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password; // Sensitive data
    private LocalDate createdDate;

    // Getters and Setters
}

public class UserDTO {
    private Long id;
    private String username;

    // Getters and Setters
}
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.example.demo.dto.UserDTO(u.id, u.username) FROM User u")
    List<UserDTO> findAllUsernames();
}
