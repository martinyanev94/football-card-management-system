@PostMapping
public ResponseEntity<Object> createProduct(@RequestBody Product product) {
    if (product.getName() == null) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Product name is required");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Other logic here...
}
