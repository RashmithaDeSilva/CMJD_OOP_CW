import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintStudentDetails extends OptionControler{
    private String menuOptionName = "Print Student Details";
    private int menuOptionNumber = 7;

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

    PrintStudentDetails(){
        setSize(450,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Print Student Details");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel1 =new JPanel(new FlowLayout());
        JPanel panel2 =new JPanel(new FlowLayout());

        // Add name
        JLabel label = new JLabel("Print Student Details");
        label.setFont(new Font("",1,25));
        panel1.add(label);
        add("North",panel1);

        // For ID
        JLabel IDLabel = new JLabel(" Enter Student ID ");
        IDLabel.setFont(new Font("",1,15));
        JTextField IDText = new JTextField(6);
        IDText.setFont(new Font("",1,15));

        JButton subBtn = new JButton("Submit");
        subBtn.setFont(new Font("",1,15));
        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = IDText.getText().toUpperCase();
                if(IDchek(ID)){
                    if(chekTotal(chekIDPositon(ID)) != (-2)){
                        IDText.setText("");
                        setVisible("false");
                        new PrintStudentDetails(chekIDPositon(ID),ID).setVisible("true");

                    }else {
                        IDText.setText("");
                        new Warning("Marks Not added");
                    }
                }else{
                    IDText.setText("");
                    new Warning("Incorrect ID");
                }
            }
        });

        panel2.add(IDLabel);
        panel2.add(IDText);
        panel2.add(subBtn);
        add("Center",panel2);
    }

    PrintStudentDetails(int position, String ID){
        setSize(450,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Print Student Details");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel1 =new JPanel(new FlowLayout());
        JPanel panel2 =new JPanel(new FlowLayout());

        // Add name
        JLabel label = new JLabel(" Update Marks");
        label.setFont(new Font("",1,25));
        panel1.add(label);
        add("North",panel1);

        // For ID
        JLabel IDLabel = new JLabel(" Enter Student ID ");
        IDLabel.setFont(new Font("",1,15));
        JTextField IDText = new JTextField(ID,6);
        IDText.setEnabled(false);
        IDText.setFont(new Font("",1,15));

        // For Old Name, Pro, DBMS, total and avg
        JLabel nameLabel = new JLabel("Student Name :- "+getName(position));
        nameLabel.setFont(new Font("",1,15));

        JLabel proLabel = new JLabel("Programming Fundementals Marks :- "+getProMarks(position));
        proLabel.setFont(new Font("",1,15));

        JLabel DBMSLabel = new JLabel("Databese Management System Marks :- "+getDBMSMarks(position));
        DBMSLabel.setFont(new Font("",1,15));

        JLabel totalLabel = new JLabel("              Total Marks :- "+getTotalMarks(position));
        totalLabel.setFont(new Font("",1,15));

        JLabel avgLabel = new JLabel("               Avg. Marks :- "+(getTotalMarks(position)/2.0));
        avgLabel.setFont(new Font("",1,15));

        JLabel rankLabel = new JLabel("Student Rank :- "+getRank(getTotalMarks(position)));
        rankLabel.setFont(new Font("",1,15));
        if(getRank(getTotalMarks(position)) == 1){
            rankLabel.setText("Student Rank :- First Plase");
        }else if(getRank(getTotalMarks(position)) == 2){
            rankLabel.setText("Student Rank :- Second Plase");
        }else if(getRank(getTotalMarks(position)) == 3){
            rankLabel.setText("Student Rank :- Third Plase");
        }

        JButton btn = new JButton("OK");
        btn.setFont(new Font("",1,15));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrintStudentDetails().setVisible("true");
                setVisible("false");
            }
        });

        panel2.add(IDLabel);
        panel2.add(IDText);
        panel2.add(nameLabel);
        panel2.add(proLabel);
        panel2.add(DBMSLabel);
        panel2.add(totalLabel);
        panel2.add(avgLabel);
        panel2.add(rankLabel);
        panel2.add(btn);
        add(panel2);
    }
}
