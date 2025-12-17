@OpenAPIDefinition(info = @Info(title = "Product API", version = "1.0", description = "API for managing products"),
    security = @SecurityRequirement(name = "bearerAuth"))
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
