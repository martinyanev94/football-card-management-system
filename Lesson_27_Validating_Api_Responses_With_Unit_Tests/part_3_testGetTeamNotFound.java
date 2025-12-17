@Test
public void testGetTeamNotFound() throws Exception {
    when(teamService.findById("2")).thenReturn(null);

    mockMvc.perform(get("/api/teams/2"))
        .andExpect(status().isNotFound());
}
