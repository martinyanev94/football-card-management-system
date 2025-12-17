@Test
public void testCreateTeamValidation() throws Exception {
    mockMvc.perform(post("/api/teams")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"\", \"league\": \"\", \"points\": -10}"))
        .andExpect(status().isBadRequest());
}
