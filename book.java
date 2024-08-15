package library;

public class book {
    private String title;
    private int ID;
    private String author;



    public book(String title, int ID, String author){  //constructor
        this.title = title;
        this.ID = ID;
        this.author = author;

    }
    //getters and setters

    public String getTitle() {
        return title;
    }
    public int getID(){
        return ID;
    }

    public String getAuthor(){
        return author;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    public void setAuthor(String author){
        this.author = author;
    }
}
