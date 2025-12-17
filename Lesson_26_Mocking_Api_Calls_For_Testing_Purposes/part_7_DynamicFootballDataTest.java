@Test
public void testDynamicFootballData() {
    stubFor(get(urlPathEqualTo("/api/football"))
            .withQueryParam("league", equalTo("Premier League"))
            .willReturn(aResponse()
                    .withHeader("Content-Type", "application/json")
                    .withBody("{ \"league\": \"Premier League\", \"team\": \"Liverpool\", \"points\": 85 }")));

    String response = restTemplate.getForObject("http://localhost:8089/api/football?league=Premier League", String.class);
    assertEquals("{\"league\":\"Premier League\",\"team\":\"Liverpool\",\"points\":85}", response);
}
