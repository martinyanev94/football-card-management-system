@PostMapping
public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    if (product.getName() == null || product.getPrice() == null) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Product createdProduct = productService.saveProduct(product);
    return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
}
