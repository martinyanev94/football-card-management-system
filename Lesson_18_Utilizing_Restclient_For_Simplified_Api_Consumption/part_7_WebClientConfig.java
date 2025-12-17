@Bean
public WebClient.Builder webClientBuilder() {
    return WebClient.builder()
                    .baseUrl("https://api.example.com")
                    .defaultHeader("Content-Type", "application/json")
                    .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create()
                                  .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                                  .responseTimeout(Duration.ofMillis(5000))));
}
