public Mono<User> getUserById(String userId) {
    return webClientBuilder.build()
            .get()
            .uri("/users/{id}", userId)
            .retrieve()
            .onStatus(status -> status.value() == 404,
                     response -> Mono.error(new UserNotFoundException("User not found")))
            .bodyToMono(User.class);
}
