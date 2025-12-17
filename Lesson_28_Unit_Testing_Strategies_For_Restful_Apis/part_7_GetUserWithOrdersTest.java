@Test
public void getUserWithOrders_ReturnsUserAndOrders() throws Exception {
    User mockUser = new User(1, "John Doe", "john@example.com");
    List<Order> mockOrders = Arrays.asList(new Order(1, "Product 1"), new Order(2, "Product 2"));

    when(userService.getUserWithOrders(1)).thenReturn(new UserWithOrders(mockUser, mockOrders));

    mockMvc.perform(get("/users/1/orders")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.user.name").value("John Doe"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.orders[0].product").value("Product 1"));
}
