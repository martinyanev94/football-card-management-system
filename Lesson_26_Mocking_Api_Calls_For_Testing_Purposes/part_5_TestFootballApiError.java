@Test
public void testFootballApiError() {
    stubFor(get(urlEqualTo("/api/football"))
            .willReturn(aResponse()
                    .withStatus(500)
                    .withBody("Internal Server Error")));

    String response = restTemplate.getForObject("http://localhost:8089/api/football", String.class);

    assertEquals("Internal Server Error", response);
}
