@Test
public void fetchAlbumDetails_CustomQueryParam_ShouldReturnCustomResponse() throws Exception {
    stubFor(get(urlPathEqualTo("/football/match"))
            .withQueryParam("team", equalTo("Team A"))
            .willReturn(aResponse()
                    .withHeader("Content-Type", "application/json")
                    .withBody("{\"matchId\":\"12345\",\"teamA\":\"Team A\",\"teamB\":\"Team B\"}")));

    mockMvc.perform(get("/albums/1?team=Team A")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
}
