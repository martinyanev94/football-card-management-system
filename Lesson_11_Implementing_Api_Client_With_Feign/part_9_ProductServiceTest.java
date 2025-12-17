@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductClient productClient;

    @Autowired
    private ProductService productService;

    @Test
    public void testFindProductById() {
        Product mockProduct = new Product(1L, "Laptop", 999.99);
        when(productClient.getProductById(1L)).thenReturn(mockProduct);

        Product result = productService.findProductById(1L);
        assertEquals("Laptop", result.getName());
    }
}
