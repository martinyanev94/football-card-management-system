public class ErrorResponse {
    private String message;
    private int status;

    // Constructors, getters, and setters
}
@GetMapping("/{id}")
public ResponseEntity<?> getTeam(@PathVariable String id) {
    Team team = teamService.findById(id);
    if (team == null) {
        ErrorResponse errorResponse = new ErrorResponse("Team not found", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    return ResponseEntity.ok(team);
}
