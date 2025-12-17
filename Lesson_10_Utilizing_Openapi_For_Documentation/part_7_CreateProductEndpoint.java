@PostMapping
@Operation(summary = "Create a new product", description = "Adds a new product to the inventory")
@ApiResponse(responseCode = "201", description = "Product created successfully")
@ApiResponse(responseCode = "400", description = "Invalid input")
public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
    Product createdProduct = productService.saveProduct(product);
    return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
}
