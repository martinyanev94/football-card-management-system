@Test
public void testGetFootballData() throws Exception {
    wireMockRule.stubFor(get(urlEqualTo("/football/matches"))
            .willReturn(aResponse()
                    .withHeader("Content-Type", "application/json")
                    .withBody("{ \"matches\": [{ \"id\": \"1\", \"teamA\": \"Team A\", \"teamB\": \"Team B\" }] }")));

    mockMvc.perform(get("/api/football/matches"))
            .andExpect(status().isOk())
            .andExpect(result -> {
                String jsonResponse = result.getResponse().getContentAsString();
                assertTrue(jsonResponse.contains("\"id\":\"1\""));
                assertTrue(jsonResponse.contains("\"teamA\":\"Team A\""));
                assertTrue(jsonResponse.contains("\"teamB\":\"Team B\""));
            });
}
