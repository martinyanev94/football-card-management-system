@ApiResponse(responseCode = "201", description = "Product created successfully", 
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
@ApiResponse(responseCode = "400", description = "Invalid input", 
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
@Data
@AllArgsConstructor
@Schema(description = "Error response model")
public class ErrorResponse {
    private String message;
    private int status;
    private long timestamp;
}
