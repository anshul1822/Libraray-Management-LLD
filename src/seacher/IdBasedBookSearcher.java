package seacher;

import Book.BookCopy;

import java.util.List;

public class IdBasedBookSearcher implements BookSearch{
    private final int id;

    public IdBasedBookSearcher(int id) {
        this.id = id;
    }
    @Override
    public List<BookCopy> search(){
        return null;
    }
}
