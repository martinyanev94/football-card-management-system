@Test
public void testGetBookById_NotFound() throws Exception {
    when(bookRepository.findById(anyLong())).thenReturn(Optional.empty());

    mockMvc.perform(get("/api/books/99"))
           .andExpect(status().isNotFound())
           .andExpect(jsonPath("$.message").value("Book not found with id: 99"))
           .andExpect(jsonPath("$.status").value(404));
}
