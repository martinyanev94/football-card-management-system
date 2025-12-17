public class ApiError {
    private String message;
    private int status;
    private long timestamp;

    public ApiError(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters
}
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex) {
    ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
}
