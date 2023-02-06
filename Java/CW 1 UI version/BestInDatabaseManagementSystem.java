import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestInDatabaseManagementSystem extends OptionControler{
    private String menuOptionName = "Best In Database Management System";
    private int menuOptionNumber = 10;

    public String getName(){
        return menuOptionName;
    }
    public int getNumber(){
        return menuOptionNumber;
    }
    public void setVisible(String b){
        if(b.equals("true")){
            setVisible(true);
        }else if(b.equals("false")){
            setVisible(false);
        }
    }

    BestInDatabaseManagementSystem(){
        setSize(600,550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Best In Database Management System");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        String[][] data = allData();
        String[] coluamNames = {"ID","Name","DBMS Marks","PF Marks"};
        JTable table = new JTable(data,coluamNames);
        table.setFont(new Font("",1,14));

        JPanel panel = new JPanel(new FlowLayout());
        JButton btn  = new JButton("Refresh");
        btn.setFont(new Font("",1,15));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible("false");
                new BestInDatabaseManagementSystem().setVisible("true");
            }
        });

        panel.add(btn);
        add("South", panel);
        add("Center",new JScrollPane(table));
    }

    public String[][] allData(){

        // Create arrays
        String[] ID = new String[0];
        String[] name = new String[0];
        int[] PF = new int[0];
        int[] DBMS = new int[0];

        // Add all student ditels
        for (int j=0;j<1;j++){
            String[] tempID = new String[getAllStudentTotal()];
            String[] tempName = new String[getAllStudentTotal()];
            int[] tempPF = new int[getAllStudentTotal()];
            int[] tempDBMS = new int[getAllStudentTotal()];

            for (int i=0;i<getAllStudentTotal();i++){
                tempID[i] = getID(i);
                tempName[i] = getName(i);
                tempPF[i] = getProMarks(i);
                tempDBMS[i] = getDBMSMarks(i);
            }

            ID = tempID;
            name = tempName;
            PF = tempPF;
            DBMS = tempDBMS;
        }

        // Count all -2 values
        int count = 0;
        for (int i=0;i<DBMS.length;i++){
            if(DBMS[i] == (-1)){
                count++;
            }
        }

        // Create new arrays
        String[] newID = new String[DBMS.length-count];
        String[] newName = new String[DBMS.length-count];
        int[] newPF = new int[DBMS.length-count];
        int[] newDBMS = new int[DBMS.length-count];
        count = 0;

        // Add all values in to new array without -2 values
        for (int i=0;i<DBMS.length;i++){
            if (DBMS[i] != -1){
                newPF[count] = PF[i];
                newName[count] = name[i];
                newID[count] = ID[i];
                newDBMS[count] = DBMS[i];
                count++;
            }
        }

        // Sort all values
        for (int j=0;j<newDBMS.length;j++){
            for (int i=0;i<(newDBMS.length-1);i++){
                if (newDBMS[i] < newDBMS[i+1]){

                    int temp4 = newDBMS[i+1];
                    newDBMS[i+1] = newDBMS[i];
                    newDBMS[i] = temp4;

                    int temp = newPF[i+1];
                    newPF[i+1] = newPF[i];
                    newPF[i] = temp;

                    String temp2 = newName[i+1];
                    newName[i+1] = newName[i];
                    newName[i] = temp2;

                    String temp3 = newID[i+1];
                    newID[i+1] = newID[i];
                    newID[i] = temp3;
                }
            }
        }

        // Create 2D array
        String[][] data = new String[newID.length][4];
        for (int i=0;i < newID.length;i++){
            for (int j=0;j < 4;j++){
                if (j == 0){
                    data[i][j] = newID[i];
                } else if (j == 1) {
                    data[i][j] = newName[i];
                } else if (j == 2) {
                    data[i][j] = Integer.toString(newDBMS[i]);
                } else {
                    data[i][j] = Integer.toString(newPF[i]);
                }
            }
        }

        // Return 2D array refaranse
        return data;
    }
}
