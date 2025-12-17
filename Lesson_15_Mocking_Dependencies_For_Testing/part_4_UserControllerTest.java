// In the UserService class
public User getUserById(Long userId) {
    try {
        return restTemplate.getForObject(BASE_URL + userId, User.class);
    } catch (RestClientException e) {
        throw new RuntimeException("Could not fetch user data from remote API", e);
    }
}

// In the UserController class
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    try {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
@Test
public void testGetUserById_Exception() {
    when(userService.getUserById(anyLong())).thenThrow(new RuntimeException("Remote API failure"));

    ResponseEntity<User> response = userController.getUserById(1L);

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
}
