@Test
public void testRealFootballServiceCall() throws Exception {
    mockMvc.perform(get("/api/football/matches"))
            .andExpect(status().isOk());
}
