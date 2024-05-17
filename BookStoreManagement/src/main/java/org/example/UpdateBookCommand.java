package org.example;

public class UpdateBookCommand implements Command {
    private BookLibrary bookLibrary;
    private Book oldBook;
    private Book newBook;

    public UpdateBookCommand(BookLibrary bookLibrary, Book oldBook, Book newBook) {
        this.bookLibrary = bookLibrary;
        this.oldBook = oldBook;
        this.newBook = newBook;
    }
    @Override
    public void execute() {
        bookLibrary.updateProduct(oldBook, newBook);
    }

    @Override
    public void undo() {
        bookLibrary.updateProduct(newBook, oldBook);
    }
}
