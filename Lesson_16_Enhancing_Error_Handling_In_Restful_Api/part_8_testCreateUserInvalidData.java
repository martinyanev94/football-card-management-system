@Test
public void testCreateUser_InvalidData() throws Exception {
    String invalidUserJson = "{ \"username\": \"\", \"email\": \"invalid-email\" }";
    
    mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidUserJson))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("username: Username must not be empty"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("email: Email should be valid"));
}
