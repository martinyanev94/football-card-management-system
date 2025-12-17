@Test
public void fetchAlbumDetails_FootballServiceDelayed_ShouldReturnDelayedResponse() throws Exception {
    stubFor(get(urlEqualTo("/football/match"))
            .willReturn(aResponse()
                    .withFixedDelay(2000) // delay of 2 seconds
                    .withHeader("Content-Type", "application/json")
                    .withBody("{\"matchId\":\"12345\",\"teamA\":\"Team A\",\"teamB\":\"Team B\"}")));

    long startTime = System.currentTimeMillis();

    mockmvc.perform(get("/albums/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

    long elapsedTime = System.currentTimeMillis() - startTime;
    System.out.println("Elapsed time: " + elapsedTime + "ms");

    assertTrue(elapsedTime >= 2000);
}
