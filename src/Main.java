import Book.BookCopy;
import Book.BookDetails;
import auth.UserAuthenticator;
import id.IDGenerator;
import lib.Library;
import seacher.*;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

public class Main {

    public List<BookCopy> searchBooksByBookName(String bookName){

        if(bookName == null)
            throw new IllegalArgumentException("Book Name can't be null");
        BookSearch bookSearch = new NameBasedBookSearcher(bookName);
        return bookSearch.search();

    }
    public List<BookCopy> searchBooksByauthorNames(List<String> authorNames){

        if(authorNames == null || authorNames.size() == 0)
            throw new IllegalArgumentException("authorNames can't be null or empty");

        BookSearch bookSearch = new AuthorBasedBookSearcher(authorNames);
        return bookSearch.search();

    }
    public List<Memeber> searchBooksByMemeberName(String memberName, String adminToken) throws IllegalAccessException{
            // authentication and auth

        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }

        MemberSeacher memberSeacher = new NameBasedMemberSeacher(memberName);
        return memberSeacher.search();
    }

    public void addBook(String bookName, Date publicationDate, List<String> authors, String adminToken) throws  IllegalAccessException{

        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }

        BookCopy bookCopy =  new BookCopy (new BookDetails(bookName, publicationDate, authors), IDGenerator.getUniqueId());
        new Library().addBookCopy(bookCopy);

    }

    public void deleteBook(int bookCopyId, String adminToken){

        if(bookCopyId <=0 || adminToken == null || adminToken.length() == 0){
            throw new IllegalArgumentException("bookCopyID/adminToken cannot be NULL or empty");
        }
        BookSearch bookSearch = new IdBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies = bookSearch.search();

        if(bookCopies == null || bookCopies.size() == 0){
            throw new RuntimeException("No book copies retrieved for given ID");
        }

        new Library().deleteBookCopy(bookCopies.get(0));
    }

    public void blockMember(int memberId, String adminToken){

        if(memberId < 0 || adminToken == null || adminToken.length() == 0 ){
            //
        }

        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalArgumentException("Operation forbidden");
        }

        MemberSeacher memberSeacher = new IdBasedMemberSearcher(memberId);
        List<Member> members = memberSeacher.search();

        if(members == null || members.size() == 0){
            throw new RuntimeException("No member retrived for given Id");
        }

        new Library().blockMember(members.get(0));
    }

    public void issueBook(int bookCopyId, int memberId, String adminToken){
        //params validation
        //auth

        BookSearch bookSearch = new IdBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies = bookSearch.search();

        if(bookCopies == null || bookCopies.size() == 0){
            throw new RuntimeException("No book copies retrieved for given Id")
        }

        MemberSeacher memberSeacher = new IdBasedMemberSearcher(memberId);
        List<Member> members = memberSeacher.search();

        if(members == null || members.size() == 0){
            throw new RuntimeException("No members retrieved for given Id");
        }

        new Library().issueBook(bookCopies.get(0), members.get(0));
    }

    public void submitBook(int bookCopyId, int memberId, String adminToken){

    }

    public Member getBorrowerOfBook(int bookCopyId, String adminToken){

    }

    public List<BookCopy> getBooksBorrrowedByMember(int memberId, String adminToken){

    }

    public static void main(String[] args) {

        System.out.println("Hello world!");

    }
}