public Mono<User> getUserById(String userId) {
    return webClientBuilder.build()
            .get()
            .uri("/users/{id}", userId)
            .retrieve()
            .onStatus(status -> status.isError(),
                     response -> response.bodyToMono(String.class)
                                         .flatMap(errorMessage -> Mono.error(new RuntimeException("API error: " + errorMessage))))
            .bodyToMono(User.class);
}
