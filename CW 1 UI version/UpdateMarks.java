import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMarks extends OptionControler{
    private String menuOptionName = "Update Marks";
    private int menuOptionNumber = 5;

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

    // Add options
    JLabel sLabel = new JLabel("");

    UpdateMarks(){
        setSize(450,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Update Marks");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel1 =new JPanel(new FlowLayout());
        JPanel panel2 =new JPanel(new FlowLayout());
        JPanel panel3 =new JPanel(new FlowLayout());

        // Add name
        JLabel label = new JLabel("Update Marks");
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
                        new UpdateMarks(chekIDPositon(ID),ID);
                        setVisible("false");

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
        panel3.add(sLabel);
        add("Center",panel2);
        add("South",panel3);

    }

    UpdateMarks(int position,String ID){
        setSize(450,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Update Marks");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        setVisible(true);

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

        // For Old Name, Pro ane DBMS
        JLabel nameLabel = new JLabel("Student Name :- "+getName(position));
        nameLabel.setFont(new Font("",1,15));

        JLabel oldProLabel = new JLabel("Programming Fundementals Marks :- "+getProMarks(position));
        oldProLabel.setFont(new Font("",1,15));

        JLabel oldDBMSLabel = new JLabel("Databese Management System Marks :- "+getDBMSMarks(position));
        oldDBMSLabel.setFont(new Font("",1,15));

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
                    setMarks(pro,DBMS,position);
                    proText.setText("");
                    DBMSText.setText("");
                    setVisible("false");
                    sLabel.setText("Successfully Added..!");
                    sLabel.setFont(new Font("",1,15));
                    new UpdateMarks().setVisible("true");

                }else{
                    new Warning("Invalid Marks");
                }
            }
        });

        panel2.add(IDLabel);
        panel2.add(IDText);
        panel2.add(nameLabel);
        panel2.add(oldProLabel);
        panel2.add(oldDBMSLabel);
        panel2.add(proLabel);
        panel2.add(proText);
        panel2.add(DBMSLabel);
        panel2.add(DBMSText);
        panel2.add(btn);
        add(panel2);
    }
}
