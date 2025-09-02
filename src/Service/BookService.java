package Service;

import Model.Book;
import Repository.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(int id, String title, String author, int year) {
        Book b = new Book(id, title, author, year);
        bookRepository.save(b);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id);
    }

    public boolean deleteBookById(int id){
        return bookRepository.deleteById(id);
    }

    public List<Book> getBooksByAuthor(String author){
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList();
    }
}
