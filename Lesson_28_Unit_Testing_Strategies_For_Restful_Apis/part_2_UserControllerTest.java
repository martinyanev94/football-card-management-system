@Test
public void getUserById_InvalidId_ReturnsNotFound() throws Exception {
    when(userService.getUserById(99)).thenThrow(new UserNotFoundException());

    mockMvc.perform(get("/users/99")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("User not found"));
}
