public class Students {

    //  Class Attributes
    private String ID;
    private String name;
    private int PFMarks;
    private int DBMSMarks;
    private int total;


    //  Constractors
    Students(){
        ID = null;
        name = null;
        PFMarks = 0;
        DBMSMarks = 0;
        total =  PFMarks + DBMSMarks;
    }
    Students(String ID, String name, int PFMarks, int DBMSMarks){
        this.ID = ID;
        this.name = name;
        this.PFMarks = PFMarks;
        this.DBMSMarks = DBMSMarks;
        total = this.PFMarks + this.DBMSMarks;
    }


    //  Set Methods
    public void setMarks(int PFMarks, int DBMSMarks){
        this.PFMarks = PFMarks;
        this.DBMSMarks = DBMSMarks;
        total = PFMarks + DBMSMarks;
    }
    public void setName(String name){
        this.name = name;
    }


    //  Get Methods
    public String getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public int getTotal(){
        return total;
    }
    public int getPFMarks(){
        return PFMarks;
    }
    public int getDBMSMarks(){
        return DBMSMarks;
    }


    //  Other Methods
    public boolean checkID(String ID){
        boolean output = false;
        if(ID.toUpperCase().equals(this.ID)){
            output = true;
        }
        return output;
    }
    public void printStudentName(){
        System.out.println(name+"\n");
    }
    public void value(){
        System.out.println(ID+"\t"+name+"\t"+PFMarks+"\t"+DBMSMarks+"\t"+total);
    }
}
