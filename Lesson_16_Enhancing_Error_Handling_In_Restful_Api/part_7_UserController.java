@PostMapping
public User createUser(@Valid @RequestBody User user) {
    return userService.createUser(user);
}
@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    List<String> errors = ex.getFieldErrors().stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.toList());
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
}
