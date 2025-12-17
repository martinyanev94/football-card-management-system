@JsonIgnoreProperties({"password", "createdDate"})
public class UserDTO {
    private Long id;
    private String username;

    // Getters and Setters
}
