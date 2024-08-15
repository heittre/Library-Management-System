package library;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
public class borrowedBooks{

    private String borrowedBy;
    private String title;
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private LocalDate currentDate;
    String dueDateStr;


    public borrowedBooks(String borrowedBy, String title){
                    //constructor
                    //DueDate =
            currentDate = LocalDate.now();
            borrowedDate = LocalDate.now();
//            dueDate = currentDate.plusWeeks(1);
            dueDateStr = "2023-09-05"; // The date string in "yyyy-MM-dd" format
            dueDate = LocalDate.parse(dueDateStr);
            this.borrowedBy = borrowedBy;
            this.title =title;

    }

    //getters and setters
    public LocalDate getCurrentDate(){
        return currentDate;
    }
    public void setCurrentDate(LocalDate currentDate){
        this.currentDate = currentDate;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

//    public void setBorrowedDate(LocalDate borrowedDate) {
//        this.borrowedDate = borrowedDate;
//    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    //methods
    public boolean isOverDue(){

        if(currentDate.isAfter(dueDate)){
            return true;
        }
        else{
            return false;
        }
    }


}