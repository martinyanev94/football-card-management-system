@Test
public void testGlobalExceptionHandler() throws Exception {
    // Simulate a situation that causes an unexpected error
    mockMvc.perform(get("/api/users/{id}", 9999) // Assuming 9999 triggers an exception
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isInternalServerError())
            .andExpect(MockMvcResultMatchers.content().string(containsString("An unexpected error occurred")));
}
