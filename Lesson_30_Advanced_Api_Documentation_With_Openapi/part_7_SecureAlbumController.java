import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "API Key", paramName = "api_key", in = SecuritySchemeIn.HEADER)
@RestController
public class SecureAlbumController {
    
    @SecurityRequirement(name = "API Key")
    @GetMapping("/secure/albums")
    public List<Album> getSecureAlbums() {
        // Logic to get albums with secure access
    }
}
