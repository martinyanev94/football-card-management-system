import io.swagger.v3.oas.annotations.Parameter;

@GetMapping("/albums")
public List<Album> getAllAlbums(
        @Parameter(description = "Filter albums by genre") 
        @RequestParam(required = false) String genre) {
    // Your logic to retrieve albums by genre
}
