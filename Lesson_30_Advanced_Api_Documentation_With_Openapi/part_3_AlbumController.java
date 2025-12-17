import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {

    @Operation(summary = "Get all albums", 
               description = "Retrieve a list of all albums available in the database.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of albums retrieved successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/albums")
    public List<Album> getAllAlbums() {
        // Your logic to retrieve albums
    }
}
