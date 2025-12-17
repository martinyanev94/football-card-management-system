import io.swagger.v3.oas.annotations.media.Schema;

@PostMapping("/albums")
public ResponseEntity<Album> createAlbum(
        @Parameter(description = "Album object to be created") 
        @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = Album.class))))
        @RequestBody Album album) {
    // Logic to save the album
}
