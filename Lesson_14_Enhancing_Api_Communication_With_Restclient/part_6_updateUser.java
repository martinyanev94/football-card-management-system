public void updateUser(Long userId, User updatedUser) {
    String url = BASE_URL + userId;
    restTemplate.put(url, updatedUser);
}
