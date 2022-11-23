import javax.swing.*;
import java.awt.*;


public class OptionControler extends JFrame {

    private MainProgram mainProgram = new MainProgram();

    public String getName(){
        return null;
        //  null
    }
    public int getNumber(){
        return 0;
        // null
    }
    public void setVisible(String b){
        // null
    }

    // ID check
    public boolean IDchek(String ID){
        boolean output = mainProgram.checkID(ID);
        return output;
    }

    //  Checking Total----------------------------------------------------------------------
    public int chekTotal(int position){
        return mainProgram.checkTotal(position);
    }

    //  Check ID Position-------------------------------------------------------------------
    public int chekIDPositon(String ID){
        return mainProgram.checkIDPositon(ID);
    }

    //  Set Marks---------------------------------------------------------------------------
    public void setMarks(int pro,int DBMS,int IDPosition){
        mainProgram.setMarks(pro, DBMS, IDPosition);
    }
    public void setName(String name,int position){
        mainProgram.setName(name,position);
    }

    // Get Methods-------------------------------------------------------------------------
    public String getID(int position){
        return mainProgram.getID(position);
    }

    public String getName(int position){
        return mainProgram.getName(position);
    }
    public int getProMarks(int position){
        return mainProgram.getProMarks(position);
    }
    public int getDBMSMarks(int position){
        return mainProgram.getDBMSMarks(position);
    }
    public int getTotalMarks(int position){
        return mainProgram.getTotalMarks(position);
    }

    // Set Student---------------------------------------------------------------------------
    public void addNewStudent(String ID, String name, int pro, int DBMS){
        mainProgram.addNewStudent(ID,name,pro,DBMS);
    }

    public void deleteStudent(int position){
        mainProgram.deleteStudent(position);
    }
    public int getRank(int total){
        return mainProgram.getRank(total);
    }
    public void value(){
        mainProgram.value();
    }
    public int getAllStudentTotal(){
        return mainProgram.getAllStudentTotal();
    }
}
