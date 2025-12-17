@GetMapping
public ResponseEntity<List<BookDTO>> getAllBooks() {
    List<Book> books = bookRepository.findAll();
    List<BookDTO> bookDTOs = books.stream()
                                   .map(book -> new BookDTO(book.getId(), book.getTitle(), book.getAuthor()))
                                   .collect(Collectors.toList());
    return ResponseEntity.ok()
                         .header("X-Total-Count", String.valueOf(bookDTOs.size()))
                         .body(bookDTOs);
}
