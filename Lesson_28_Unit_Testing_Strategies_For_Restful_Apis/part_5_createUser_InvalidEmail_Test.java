@Test
public void createUser_InvalidEmail_ReturnsBadRequest() throws Exception {
    String invalidUserJson = "{\"name\":\"Jane Doe\", \"email\":\"notAnEmail\", \"password\":\"password123\"}";

    mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidUserJson))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Invalid email format"));
}
