@Test
public void testCreateTeam() throws Exception {
    Team newTeam = new Team("3", "Chelsea", "Premier League", 80);
    when(teamService.save(any(Team.class))).thenReturn(newTeam);

    mockMvc.perform(post("/api/teams")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\":\"3\", \"name\":\"Chelsea\", \"league\":\"Premier League\", \"points\":80}"))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value("3"))
        .andExpect(jsonPath("$.name").value("Chelsea"));
}
