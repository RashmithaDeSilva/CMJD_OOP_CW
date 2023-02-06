import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestInProgrammingFundamentals extends OptionControler {
    private String menuOptionName = "Best In Programming Fundamentals";
    private int menuOptionNumber = 9;

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

    BestInProgrammingFundamentals(){
        setSize(600,550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Best In Programming Fundamentals");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        String[][] data = allData();
        String[] coluamNames = {"ID","Name","PF Marks","DBMS Marks"};
        JTable table = new JTable(data,coluamNames);
        table.setFont(new Font("",1,14));

        JPanel panel = new JPanel(new FlowLayout());
        JButton btn  = new JButton("Refresh");
        btn.setFont(new Font("",1,15));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible("false");
                new BestInProgrammingFundamentals().setVisible("true");
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
        for (int i=0;i<PF.length;i++){
            if(PF[i] == (-1)){
                count++;
            }
        }

        // Create new arrays
        String[] newID = new String[PF.length-count];
        String[] newName = new String[PF.length-count];
        int[] newPF = new int[PF.length-count];
        int[] newDBMS = new int[PF.length-count];
        count = 0;

        // Add all values in to new array without -2 values
        for (int i=0;i<PF.length;i++){
            if (PF[i] != -1){
                newPF[count] = PF[i];
                newName[count] = name[i];
                newID[count] = ID[i];
                newDBMS[count] = DBMS[i];
                count++;
            }
        }

        // Sort all values
        for (int j=0;j<newPF.length;j++){
            for (int i=0;i<(newPF.length-1);i++){
                if (newPF[i] < newPF[i+1]){

                    int temp = newPF[i+1];
                    newPF[i+1] = newPF[i];
                    newPF[i] = temp;

                    String temp2 = newName[i+1];
                    newName[i+1] = newName[i];
                    newName[i] = temp2;

                    String temp3 = newID[i+1];
                    newID[i+1] = newID[i];
                    newID[i] = temp3;

                    int temp4 = newDBMS[i+1];
                    newDBMS[i+1] = newDBMS[i];
                    newDBMS[i] = temp4;
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
                    data[i][j] = Integer.toString(newPF[i]);
                } else {
                    data[i][j] = Integer.toString(newDBMS[i]);
                }
            }
        }

        // Return 2D array refaranse
        return data;
    }
}
