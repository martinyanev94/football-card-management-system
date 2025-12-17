import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
public class TeamControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @Test
    public void testGetTeam() throws Exception {
        Team mockTeam = new Team("1", "Arsenal", "Premier League", 75);
        when(teamService.findById("1")).thenReturn(mockTeam);

        mockMvc.perform(get("/api/teams/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value("1"))
            .andExpect(jsonPath("$.name").value("Arsenal"))
            .andExpect(jsonPath("$.league").value("Premier League"))
            .andExpect(jsonPath("$.points").value(75));
    }
}
