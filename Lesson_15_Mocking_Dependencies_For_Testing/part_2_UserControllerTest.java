import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById() {
        User mockUser = new User(1L, "John Doe", "john@example.com");

        when(userService.getUserById(1L)).thenReturn(mockUser);

        User user = userController.getUserById(1L);

        verify(userService).getUserById(1L);
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
    }
}
