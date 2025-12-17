@Test
public void testGetUserFound() throws Exception {
    User user = new User(1L, "John Doe", "johndoe@example.com");
    when(userService.getUserById(1L)).thenReturn(user);

    mockMvc.perform(get("/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("John Doe"))
            .andExpect(jsonPath("$.email").value("johndoe@example.com"));
}

@Test
public void testGetUserNotFound() throws Exception {
    when(userService.getUserById(1L)).thenReturn(null);

    mockMvc.perform(get("/users/1"))
            .andExpect(status().isNotFound());
}
