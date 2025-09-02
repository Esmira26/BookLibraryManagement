package Repository;

import Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public void save(Book book){
        books.add(book);
    }

    public List<Book> findAll(){
        return books;
    }

    public Book findById(int id){
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean deleteById(int id){
        return books.removeIf(b -> b.getId() == id);
    }
}

