package library;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        library myLibrary = new library(500); //library can store 500 books
        Scanner obj = new Scanner(System.in);
        while(true){
            System.out.println(
                    "Menu:\n" +
                            "Enter -1 to exit\n" +
                            "Enter 1 to add books to the library\n" +
                            "Enter 2 to remove a book\n" +
                            "Enter 3 to display books\n" +
                            "Enter 4 to search books\n" +
                            "Enter 5 to lend a book\n" +
                            "Enter 6 to register a member\n" +
                            "Enter 7 to return a book\n" +
                            "Enter 8 to view overdue books\n" +
                            "Enter 9 to view lending information\n" +
                            "Enter 10 to view overdue books\n" +
                            "Enter 11 to calculate fine\n" +
                            "Enter 12 to remove a member\n" +
                            "Enter 13 to display members"
            );

            int choice = obj.nextInt();
            if(choice==-1){
                break;
            }
            switch(choice) {
                case 1:
                    myLibrary.addBooks();
                    break;
                case 2:
                    System.out.println("enter a book to remove:");
                    String removebook = obj.next();
                    myLibrary.removeBooks(removebook);
                    break;
                case 3:
                    myLibrary.displayBooks();
                    break;
                case 4:
                    System.out.println("Enter the title of the book to search:");
                    String searchTitle = obj.next();
                    myLibrary.searchBooks(searchTitle);
                    break;
                case 5:
                    System.out.println("Enter member name:");
                    String memberName = obj.next();
                    System.out.println("Enter book title:");
                    String bookTitle = obj.next();
                    myLibrary.lendBooks(memberName,bookTitle);
                    break;
                case 6:
                    myLibrary.registerMembers();
                    break;
                case -1:
                    System.out.println("exiting....");
                    break;
                case 7:
                    myLibrary.returnBooks();
                    break;
                case 8:
                    myLibrary.viewOverDueBooks();
                    break;
                case 9:
                    myLibrary.viewLendingInfo();
                    break;
                case 10:
                    myLibrary.viewOverDueBooks();
                    break;
                case 11:
                    myLibrary.calculateFine();
                    break;
                case 12:
                    System.out.println("enter a member name to remove:");
                    String removeMemberName = obj.next();
                    myLibrary.removeMembers(removeMemberName);
                    break;
                case 13:
                    myLibrary.displayMembers();
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }


        }

    }
}
