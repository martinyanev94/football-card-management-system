@Test
public void fetchAlbumDetails_FootballServiceDown_ShouldReturnError() throws Exception {
    stubFor(get(urlEqualTo("/football/match"))
            .willReturn(aResponse()
                    .withStatus(500)));

    mockMvc.perform(get("/albums/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isInternalServerError());
}
