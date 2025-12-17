@Test
public void getAllUsers_PerformanceTest() throws Exception {
    long startTime = System.currentTimeMillis();

    mockMvc.perform(get("/users")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());

    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    
    assertTrue("Performance test failed: Duration exceed limit", duration < 200); // Limit in milliseconds
}
