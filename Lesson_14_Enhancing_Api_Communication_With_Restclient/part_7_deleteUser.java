public void deleteUser(Long userId) {
    String url = BASE_URL + userId;
    restTemplate.delete(url);
}
