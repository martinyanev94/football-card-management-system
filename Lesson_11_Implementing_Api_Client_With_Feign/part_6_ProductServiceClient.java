@PostMapping("/api/products")
Product createProduct(@RequestBody Product product);
@FeignClient(name = "productService", url = "${product.service.url}")
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
    
    @PostMapping("/api/products")
    Product createProduct(@RequestBody Product product);
}
