@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void getBookById_ReturnsBook() throws Exception {
        Book book = new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        mockMvc.perform(get("/api/books/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.title").value("The Great Gatsby"))
               .andExpect(jsonPath("$.author").value("F. Scott Fitzgerald"));
    }
}
