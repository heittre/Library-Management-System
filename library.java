package library;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.ChronoUnit;
public class library {

    //define an array books to store book objects
    private book[] books;

    private int noOfBooks;   //no of books in the array
    private int arrSize;
    private int membArrSize;


    private member[] members;
    private borrowedBooks[] borrowedBooks;
    private int noOfMembers;
    private int noOfBorrowedBooks;
    Scanner scanner = new Scanner(System.in);

    //constructor               arrsize is the maximum size of the array
    public library(int arrSize){
            this.arrSize = arrSize;
            membArrSize=200;    //there can be 200 members in the library
            books = new book[arrSize];  //initialise the books array
            noOfBooks = 0;
            noOfMembers = 0;
            noOfBorrowedBooks=0;
            borrowedBooks = new borrowedBooks[arrSize];
            members = new member[membArrSize];

    }

    public borrowedBooks[] getBorrowedBooks() {
        return borrowedBooks;
    }


    public int getNoOfBorrowedBooks() {
        return noOfBorrowedBooks;
    }

    public void setNoOfBorrowedBooks(int noOfBorrowedBooks) {
        this.noOfBorrowedBooks = noOfBorrowedBooks;
    }

    public void setBorrowedBooks(borrowedBooks[] borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void setBooks(book[] books){
        this.books = books;
    }
    public book[] getBooks(){
        return books;
    }
    public void setMembers(member[] members){
        this.members = members;
    }
    public member[] getMembers(){
        return members;
    }


    public void setMembArrSize(int membArrSize){
        this.membArrSize = membArrSize;
    }
    public int getMembArrSize(){
        return membArrSize;
    }
    public void registerMembers(){


        //store member information and call member function
        System.out.println("enter member name:");
        String name = scanner.nextLine();
        System.out.println("enter member ID:");
        int membID = scanner.nextInt();



            if(noOfMembers<getMembArrSize()){
                members[noOfMembers] = new member("",0);
                getMembers()[noOfMembers].setName(name);
                getMembers()[noOfMembers].setMembID(membID);
                noOfMembers++;
                System.out.println("member registered.");

            }



    }

    public void addBooks(){

//        scanner.nextLine();
        int ID=0;
        String title="";
        String author="";

//        for(int i=1;i<noOfBooks;i++) {

            if(noOfBooks<arrSize){

                System.out.println("enter book id");
                ID = scanner.nextInt();
                scanner.nextLine();
                System.out.println("enter book title:");
                title = scanner.nextLine();
                System.out.println("enter author name");
                author = scanner.nextLine();

                //unless the array size is full
                book newBook = new book("",0,"");
                books[noOfBooks] = newBook;   //book object as the last array item
                newBook.setAuthor(author);
                newBook.setID(ID);
                newBook.setTitle(title);
                noOfBooks++;
                System.out.println("Number of books in the library: " + noOfBooks);

            }
            else{
                System.out.println("the library is full, can not add more books");
            }




    }





    public void removeBooks(String title) {

        boolean bookFound = false;

        for (int k = 0; k < noOfBooks; k++) {   //enter the books array and access its books

            if (books[k].getTitle().equals(title)) {    //check whether the titles are equal
                //shift elements to the left

                for (int j = k; j < noOfBooks - 1; j++) {
                    books[j] = books[j + 1]; //shift the books' elements by 1 to the left

                }
                System.out.println("the book is found and removed.");
                //set the last element to null
                bookFound = true;
                noOfBooks--;
                break;


            }
        }

        if(bookFound == false){
            System.out.println("book not found");
        }
    }


    public void removeMembers(String memberName) {
        boolean memberFound =false;
        for (int k = 0; k < noOfMembers; k++) {

            if (members[k].getName().equals(memberName)) {
                //shift elements to the left

                for (int j = k; j < noOfMembers - 1; j++) {
                    members[j] = members[j + 1];

                }
                System.out.println("the member was removed.");
                memberFound = true;
                noOfMembers--;
                break;


            }
        }

        if(memberFound == false){
            System.out.println("member not found");
        }
    }

    public void displayBooks() {
        if (books != null && noOfBooks > 0) {
        System.out.println("Number of books in the library: " + noOfBooks); // Debug line

        for (int j = 0; j < noOfBooks; j++) {
            System.out.println("now i am going to display the books");
            System.out.println("the name of the ID is:" + getBooks()[j].getID());
            System.out.println("the name of the title is:" + getBooks()[j].getTitle());
            System.out.println("the name of the author is:" + getBooks()[j].getAuthor());

        }
    }
        else {
            System.out.println("There are no books in the library.");
        }
    }

    public void displayMembers() {
        if (members != null && noOfMembers > 0) {
            System.out.println("Number of Members in the library: " + noOfMembers); // Debug line

            for (int j = 0; j < noOfMembers; j++) {
                System.out.println("the id of the member is:" + getMembers()[j].getMembID());
                System.out.println("the name of the member is:" + getMembers()[j].getName());
            }
        }
        else {
            System.out.println("There are no members in the library.");
        }
    }



    public void searchBooks(String title){
        boolean bookFound = false;
        for(int m=0;m<noOfBooks;m++){
            if(getBooks()[m].getTitle().equals(title)){
//                System.out.println("book found entered title equals loop");
                System.out.println("the book title is:"+getBooks()[m].getTitle());
                System.out.println("the book ID is:"+getBooks()[m].getID());
                System.out.println("the book author is:"+getBooks()[m].getAuthor());
                bookFound=true;
                break;
            }

        }
        if(bookFound==false){
            System.out.println("No book was found with that name");
        }
    }


    //check if a a person is a
//    public boolean isABook(String bookTitle){
//
//    }
    public boolean isAMember(String personName){
        for(int i=0;i<noOfMembers;i++){
            if(getMembers()[i].getName().equals(personName)){
                return true;
            }

        }
        return false;
    }


    public boolean hasBorrowed(String title){
        for(int i=0;i<noOfBorrowedBooks;i++){
            if(borrowedBooks[i].getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    public boolean hasBorrowedMember(String membName){
        for(int i=0;i<noOfBorrowedBooks;i++){
            if(borrowedBooks[i].getBorrowedBy().equals(membName)){
                return true;
            }
        }
        return false;
    }


    public void lendBooks(String membName, String title){
            boolean bookFound = false;
//        LocalDate currentDate = LocalDate.now();
//        System.out.println("debug line:"+currentDate);
        //lend the book to the member.check if the person lending is a member or not
        //make a isamember function
        if(isAMember(membName)){
            System.out.println("member found.");
            for(int k=0;k<noOfBooks;k++){
                if(books[k].getTitle().equals(title)){
//                    System.out.println("the book is found in store");
                    if(!hasBorrowed(title)){
                        System.out.println("the book is available");

                        if (borrowedBooks == null) {
                            borrowedBooks = new borrowedBooks[0];
                        }


                        borrowedBooks newborrowedBook = new borrowedBooks("","");
                        borrowedBooks[noOfBorrowedBooks]= newborrowedBook;
                        newborrowedBook.setBorrowedBy(membName);
                        newborrowedBook.setTitle(title);
                        noOfBorrowedBooks++;
                        System.out.println("no of borrowed books ="+noOfBorrowedBooks);
                        bookFound = true;
                        break;
                    }
                    System.out.println("sorry,the book has been borrowed. Check again later.");
                }


            }
            if(bookFound==false){
                System.out.println("sorry, no such book exist in the library.");
            }
        }
        else {
            System.out.println("you must register in the library to borrow a book.");

        }
        }


        void returnBooks(){
        boolean flag = false;
            System.out.println("enter member name:");
            String returningMember = scanner.next();
            if(hasBorrowedMember(returningMember)) {
                System.out.println("enter book name:");
                String returnBook = scanner.next();
                for (int i = 0; i < noOfBorrowedBooks; i++) {
                    if (borrowedBooks[i].getTitle().equals(returnBook)) {
                        flag=true;
                        for (int j = i; j < noOfBorrowedBooks - 1; j++) {
                            borrowedBooks[j] = borrowedBooks[j + 1];
                        }
                        noOfBorrowedBooks--;
                        System.out.println("thank you! The book has been returned!");
                    }
                }
                if(flag==false){
                    System.out.println("invalid book, try again!");
                }
            }
            else {
                System.out.println("Sorry, there's no borrowed book under this name");

            }
            }




            public void viewLendingInfo(){
        boolean flag = false;
                System.out.println("enter name to get lending information of the member:");
                String lenderName = scanner.next();
//                System.out.println("enter book title to get the lending history of the book");
//                String bookName = scanner.nextLine();
                if(isAMember(lenderName)){
                    if (borrowedBooks.length > 0) {
                        for (int i = 0; i < noOfBorrowedBooks; i++) {
                            if (borrowedBooks[i].getBorrowedBy().equals(lenderName)) {
                                System.out.println("book name:"+borrowedBooks[i].getTitle());
                                System.out.println("the member borrowed:" + borrowedBooks[i].getBorrowedBy());
                                System.out.println("the date borrowed:" + borrowedBooks[i].getBorrowedDate());
                                System.out.println("the due date:" + borrowedBooks[i].getDueDate());
                                flag=true;

                            }
                        }
                        if(flag==false){
                            System.out.println("the member does not have any borrowed books");
                        }
                    }
                    else{
                        System.out.println("no books have been borrowed");
                    }

                }
                else{
                    System.out.println("the member not found");
                }
            }


            public void viewOverDueBooks(){
                System.out.println("enter to name to see over due books:");
                String lenderName = scanner.next();
                if(isAMember(lenderName)){
                    for(int i=0;i<noOfBorrowedBooks;i++){
                        if(borrowedBooks[i].getBorrowedBy().equals(lenderName)){
                            if(borrowedBooks[i].isOverDue()){
                                System.out.println("book title "+borrowedBooks[i].getTitle());
                                System.out.println("borrowed by:"+borrowedBooks[i].getBorrowedBy());
                                System.out.println("borrowed Date:"+borrowedBooks[i].getBorrowedDate());
                                System.out.println("Due date:"+borrowedBooks[i].getDueDate());
                            }
                            else{
                                System.out.println("no overdue books under your name.");
                            }
                        }
                    }
                }
                else{
                    System.out.println("you are not a member");
                }
            }

            public void calculateFine(){

                    double fine = 0.0;
                    LocalDate currentDate = LocalDate.now();
                    LocalDate dueDate;
                    System.out.println("enter name of the member to calculate your fines:");
                    String lenderName = scanner.next();

                    for(int i=0; i<noOfBorrowedBooks;i++) {
                        if (borrowedBooks[i].getBorrowedBy().equals(lenderName)) {


                            if(borrowedBooks[i].isOverDue()){
                                System.out.println("debug line entered is over due");
                                dueDate = borrowedBooks[i].getDueDate();

                                if(dueDate.plusWeeks(1).isAfter(currentDate)) {

//                                    System.out.println("debug line:current date<due date+7");
                                    long daysInBetween = ChronoUnit.DAYS.between(dueDate,currentDate);
                                    int daysBetween = (int)daysInBetween; //explicit casting
                                            fine = 50.0*daysBetween;
//                                    System.out.println("your fine is:"+fine);

                                }
                                else{
//                                    System.out.println("debug line:current date>due date+7");
                                    LocalDate startOfSecondWeek = dueDate.plusWeeks(1);
                                    long secondWeek = ChronoUnit.DAYS.between(startOfSecondWeek, currentDate);
                                    int daysInSecondWeek = (int) secondWeek;
                                    fine = (50.0*7) + daysInSecondWeek*100;
//                                    System.out.println("your fine is");
                                }

                                System.out.println("your fine is:"+fine);
                            }
                            else{
                                System.out.println("the book is not overdue");
                            }
                        }
                        else{
                            System.out.println("you have not borrowed any book");
                        }
                    }

    }
        }








