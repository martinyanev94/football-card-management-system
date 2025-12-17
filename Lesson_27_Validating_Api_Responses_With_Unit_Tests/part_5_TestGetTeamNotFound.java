@Test
public void testGetTeamNotFoundResponseStructure() throws Exception {
    when(teamService.findById("2")).thenReturn(null);

    mockMvc.perform(get("/api/teams/2"))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value("Team not found"))
        .andExpect(jsonPath("$.status").value(404));
}
