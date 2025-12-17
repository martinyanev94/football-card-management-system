@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void registerUser_Success() throws Exception {
        String newUserJson = "{\"name\":\"Alice\", \"email\":\"alice@example.com\", \"password\":\"password\"}";

        mockMvc.perform(post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newUserJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Alice"));

        assertEquals(1, userRepository.count());
    }
}
