@Component
public class ProductClientFallback implements ProductClient {

    @Override
    public Product getProductById(Long id) {
        return null; // return an empty product or throw a custom exception
    }

    @Override
    public Product createProduct(Product product) {
        return null; // handle error gracefully
    }
}
@FeignClient(name = "productService", url = "${product.service.url}", fallback = ProductClientFallback.class)
public interface ProductClient {
    ...
}
