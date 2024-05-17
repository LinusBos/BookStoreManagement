package org.example;

public class AddBookCommand implements Command{
    private BookLibrary bookLibrary;
    private Book book;
    public AddBookCommand(BookLibrary bookLibrary, Book book) {
        this.bookLibrary = bookLibrary;
        this.book = book;
    }

    @Override
    public void execute() {
        bookLibrary.addProduct(book);

    }

    @Override
    public void undo() {
        bookLibrary.removeProduct(book);
    }
}
