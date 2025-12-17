@After
public void tearDown() {
    wireMockRule.resetAll();
}
@Test
public void testGetFootballData_InternalServerError() throws Exception {
    wireMockRule.stubFor(get(urlEqualTo("/football/matches"))
            .willReturn(aResponse()
                    .withStatus(500)));

    mockMvc.perform(get("/api/football/matches"))
            .andExpect(status().isInternalServerError());
}
