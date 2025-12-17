@Service
public class ProductService {

    @Autowired
    private ProductClient productClient;

    public Product findProductById(Long id) {
        return productClient.getProductById(id);
    }
}
