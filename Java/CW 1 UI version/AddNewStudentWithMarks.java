import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddNewStudentWithMarks extends OptionControler{
    private String menuOptionName = "Add New Student With Marks";
    private int menuOptionNumber = 2;

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

    AddNewStudentWithMarks(){
        setSize(600,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Add New Student With Marks");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel1 =new JPanel(new FlowLayout());
        JPanel panel2 =new JPanel(new FlowLayout());
        JPanel panel3 =new JPanel(new FlowLayout());

        // Add name
        JLabel label = new JLabel(" Add New Student With Marks");
        label.setFont(new Font("",1,25));
        panel1.add(label);

        // Add options
        JLabel sLabel = new JLabel("");
        sLabel.setFont(new Font("",1,15));

        // For ID
        JLabel IDLabel = new JLabel(" Enter Student ID ");
        IDLabel.setFont(new Font("",1,15));
        JTextField IDText = new JTextField(6);
        IDText.setFont(new Font("",1,15));

        // For name
        JLabel nameLabel = new JLabel(" Enter Student Name ");
        nameLabel.setFont(new Font("",1,15));
        JTextField nameText = new JTextField(12);
        nameText.setFont(new Font("",1,15));

        // For Pro
        JLabel proLabel = new JLabel(" Enter Programming Fundementals Marks ");
        proLabel.setFont(new Font("",1,15));
        JTextField proText = new JTextField(4);
        proText.setFont(new Font("",1,15));

        // For DBMS
        JLabel DBMSLabel = new JLabel(" Enter Databese Management System Marks ");
        DBMSLabel.setFont(new Font("",1,15));
        JTextField DBMSText = new JTextField(4);
        DBMSText.setFont(new Font("",1,15));

        JButton btn = new JButton("Submit");
        btn.setFont(new Font("",1,15));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = IDText.getText().toUpperCase();
                if(IDchek(ID)){
                    new Warning("This Student ID Already Exists");
                }else {
                    int pro = 0,DBMS = 0;
                    boolean ans = true;

                    try {
                        pro = Integer.parseInt(proText.getText());
                        if(pro >= 0 && pro <= 100){

                        }else {
                            ans = false;
                        }
                    }catch (Exception ex){
                        ans = false;
                    }

                    try {
                        DBMS = Integer.parseInt(DBMSText.getText());
                        if(DBMS >= 0 && DBMS <= 100){

                        }else {
                            ans = false;
                        }
                    }catch (Exception ex){
                        ans = false;
                    }

                    if(ans){
                        if(nameText.getText().equals("") || IDText.getText().equals("")){
                            new Warning("Enter Student Details Correctly");
                        }else {
                            addNewStudent(ID,nameText.getText(),pro,DBMS);
                            sLabel.setText("Successfully Added..!");
                            IDText.setText("");
                            nameText.setText("");
                            proText.setText("");
                            DBMSText.setText("");
                        }
                    }else{
                        new Warning("Invalid Marks");
                    }
                }
            }
        });


        panel2.add(IDLabel);
        panel2.add(IDText);
        panel2.add(nameLabel);
        panel2.add(nameText);
        panel2.add(proLabel);
        panel2.add(proText);
        panel2.add(DBMSLabel);
        panel2.add(DBMSText);
        panel2.add(btn);
        panel3.add(sLabel);

        add("North",panel1);
        add("Center",panel2);
        add("South",panel3);


    }
}
