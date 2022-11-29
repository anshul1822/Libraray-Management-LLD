package lib;

import Book.BookCopy;
import dataaccessor.DBAccessor;

public class Library {

    public void addBookCopy (BookCopy bookCopy){

        if(bookCopy == null){
            //......
        }
        DBAccessor.insertBookCopy(bookCopy)''
    }

    public synchronized void deleteBookCopy (BookCopy bookCopy){



    }

    public void blockMember(Member member){

    }

    public void issueBook(BookCopy bookCopy, Member member){

    }

    public void submitBook(BookCopy bookCopy, Member member){

    }

    public Member getBorrower(BookCopy bookCopy){

    }

    public List<BookCopy> getBorrowedBooks (Member member){

    }
}
