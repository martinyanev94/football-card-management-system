// In the UserService class
public User getUserById(Long userId) {
    return restTemplate.getForObject(BASE_URL + userId, User.class);
}

// In the UserController class
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
}
@Test
public void testGetUserById_NotFound() {
    when(userService.getUserById(2L)).thenReturn(null);
    
    ResponseEntity<User> response = userController.getUserById(2L);
    
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
}
