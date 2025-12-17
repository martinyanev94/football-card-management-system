@Test
public void testFindProductById_whenRemoteServiceFails() {
    when(productClient.getProductById(1L)).thenThrow(new RuntimeException("Service not available"));

    Exception exception = assertThrows(RuntimeException.class, () -> {
        productService.findProductById(1L);
    });

    assertEquals("Service not available", exception.getMessage());
}
