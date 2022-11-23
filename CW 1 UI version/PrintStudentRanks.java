import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintStudentRanks extends OptionControler {
    private String menuOptionName = "Print Students Ranks";
    private int menuOptionNumber = 8;

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

    PrintStudentRanks(){
        setSize(600,550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Print Students Ranks");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        String[][] data = allData();
        String[] coluamNames = {"Rank","ID","Name","Total","Avg Marks"};
        JTable table = new JTable(data,coluamNames);
        table.setFont(new Font("",1,14));

        JPanel panel = new JPanel(new FlowLayout());
        JButton btn  = new JButton("Refresh");
        btn.setFont(new Font("",1,15));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible("false");
                new PrintStudentRanks().setVisible("true");
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
        int[] total = new int[0];

        // Add all student ditels
        for (int j=0;j<1;j++){
            String[] tempID = new String[getAllStudentTotal()];
            String[] tempName = new String[getAllStudentTotal()];
            int[] tempTotal = new int[getAllStudentTotal()];

            for (int i=0;i<getAllStudentTotal();i++){
                tempID[i] = getID(i);
                tempName[i] = getName(i);
                tempTotal[i] = getTotalMarks(i);
            }

            ID = tempID;
            name = tempName;
            total = tempTotal;
        }

        // Count all -2 values
        int count = 0;
        for (int i=0;i<total.length;i++){
            if(total[i] == (-2)){
                count++;
            }
        }

        // Create new arrays
        String[] newID = new String[total.length-count];
        String[] newName = new String[total.length-count];
        int[] newTotal = new int[total.length-count];
        count = 0;

        // Add all values in to new array without -2 values
        for (int i=0;i<total.length;i++){
            if (total[i] != -2){
                newTotal[count] = total[i];
                newName[count] = name[i];
                newID[count] = ID[i];
                count++;
            }
        }

        // Sort all values
        for (int j=0;j<newTotal.length;j++){
            for (int i=0;i<(newTotal.length-1);i++){
                if (newTotal[i] < newTotal[i+1]){

                    int temp = newTotal[i+1];
                    newTotal[i+1] = newTotal[i];
                    newTotal[i] = temp;

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
        count = 1;
        String[][] data = new String[newID.length][5];
        for (int i=0;i < newID.length;i++){
            for (int j=0;j < 5;j++){
                if (j == 0){
                    data[i][j] = Integer.toString(count);
                } else if (j == 1) {
                    data[i][j] = newID[i];
                } else if (j == 2) {
                    data[i][j] = newName[i];
                } else if (j == 3) {
                    data[i][j] = Integer.toString(newTotal[i]);
                }else {
                    data[i][j] = Double.toString(newTotal[i] / 2.0);
                }
            }
            count++;
        }

        // Return 2D array refaranse
        return data;
    }
}
