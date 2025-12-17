@GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Product product = productService.findById(id);
    
    if (product != null) {
        return ResponseEntity.ok()
                .header("X-Custom-Header", "HeaderValue")
                .body(product);
    }
    
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
