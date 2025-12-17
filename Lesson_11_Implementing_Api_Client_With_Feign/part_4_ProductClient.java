@FeignClient(name = "productService", url = "${product.service.url}")
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
product.service.url=http://localhost:8080
