package seacher;

import java.util.List;

public class NameBasedBookSearcher implements BookSearch {

    private final String bookName;

    public NameBasedBookSearcher(String bookName){
        this.bookName = bookName;
    }

    @Override
    public List<BookCopy> search() {
        return null;
    }

}
