@PostMapping
public ResponseEntity<BookDTO> createBook(@RequestBody Book book) {
    Book savedBook = bookRepository.save(book);
    BookDTO bookDTO = new BookDTO(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor());
    return ResponseEntity.created(URI.create("/api/books/" + savedBook.getId())).body(bookDTO);
}
