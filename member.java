package library;

public class member{
    private String name;
    private int membID;



    public member(String name, int membID){  //constructor
        this.name = name;
        this.membID = membID;
    }


    //getters and setters


    public String getName() {
        return name;
    }
    public int getMembID(){
        return membID;
    }


    public void setName(String name){
        this.name = name;
    }
    public void setMembID(int membID){
        this.membID=membID;}



}
