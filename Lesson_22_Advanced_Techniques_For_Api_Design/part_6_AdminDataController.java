@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/admin/data")
public ResponseEntity<List<AdminData>> getAdminData() {
    List<AdminData> data = adminDataService.getAllData();
    return ResponseEntity.ok(data);
}
