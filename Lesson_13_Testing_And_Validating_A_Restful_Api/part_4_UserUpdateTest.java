@Test
public void testUpdateUser() throws Exception {
    User updatedUser = new User(1L, "Jane Doe", "janedoe@example.com");
    when(userService.updateUser(eq(1L), any(User.class))).thenReturn(updatedUser);

    mockMvc.perform(put("/users/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(updatedUser)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Jane Doe"));

    verify(userService).updateUser(eq(1L), any(User.class));
}

@Test
public void testUpdateUserNotFound() throws Exception {
    when(userService.updateUser(eq(1L), any(User.class))).thenReturn(null);

    mockMvc.perform(put("/users/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(new User())))
            .andExpect(status().isNotFound());
}
