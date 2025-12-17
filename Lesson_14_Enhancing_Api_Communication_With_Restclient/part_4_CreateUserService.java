public User createUser(User newUser) {
    return restTemplate.postForObject(BASE_URL, newUser, User.class);
}
public User createUser(User newUser) {
    try {
        return restTemplate.postForObject(BASE_URL, newUser, User.class);
    } catch (RestClientException e) {
        // Handle potential errors during user creation
        throw new RuntimeException("Failed to create user", e);
    }
}
