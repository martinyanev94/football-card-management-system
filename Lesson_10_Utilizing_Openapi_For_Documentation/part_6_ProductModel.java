@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Product model")
public class Product {
    @Schema(description = "Unique identifier of the product", example = "1")
    private Long id;

    @Schema(description = "Name of the product", example = "Laptop")
    private String name;

    @Schema(description = "Price of the product", example = "999.99")
    private Double price;
}
