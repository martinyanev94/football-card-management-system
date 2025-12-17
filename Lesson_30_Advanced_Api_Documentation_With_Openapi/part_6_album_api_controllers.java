import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(title = "My Album API", version = "1.0", description = "API for managing albums")
)
@RestController
public class AlbumV1Controller { /* ... */ }

@OpenAPIDefinition(
    info = @Info(title = "My Album API", version = "2.0", description = "API for managing albums with improvements")
)
@RestController
public class AlbumV2Controller { /* ... */ }
