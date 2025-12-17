@GetMapping("/{id}")
public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    BookDTO bookDTO = new BookDTO(book.getId(), book.getTitle(), book.getAuthor());
    return ResponseEntity.ok(bookDTO);
}
