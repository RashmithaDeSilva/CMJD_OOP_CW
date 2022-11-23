import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddNewStudent extends OptionControler{
    private String menuOptionName = "Add New Student";
    private int menuOptionNumber = 1;

    AddNewStudent(){
        setSize(600,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Add New Student");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new GridLayout(2,1));
        JPanel panel5 = new JPanel(new FlowLayout());

        // Add name
        JLabel label = new JLabel(" Add New Student ");
        label.setFont(new Font("",1,25));
        panel.add(label);
        add("North",panel);

        // Add options
        JLabel IDLabel = new JLabel(" Enter Student ID ");
        IDLabel.setFont(new Font("",1,15));
        JTextField IDText = new JTextField(6);
        IDText.setFont(new Font("",1,15));

        JLabel nameLabel = new JLabel(" Enter Student Name ");
        nameLabel.setFont(new Font("",1,15));
        JTextField nameText = new JTextField(12);
        nameText.setFont(new Font("",1,15));

        JLabel sLabel = new JLabel("");
        sLabel.setFont(new Font("",1,15));

        JButton btn = new JButton("Submit");
        btn.setFont(new Font("",1,15));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = IDText.getText().toUpperCase();
                if(IDchek(ID)){
                    new Warning("This Student ID Already Exists");
                }else {
                    if(nameText.getText().equals("") || IDText.getText().equals("")){
                        new Warning("Enter Student Details Correctly");
                    }else {
                        addNewStudent(ID,nameText.getText(),-1,-1);
                        sLabel.setText("Successfully Added..!");
                        IDText.setText("");
                        nameText.setText("");
                    }
                }
            }
        });

        panel2.add(IDLabel);
        panel2.add(IDText);
        panel3.add(nameLabel);
        panel3.add(nameText);
        panel3.add(btn);
        panel4.add(panel2);
        panel4.add(panel3);
        panel5.add(sLabel);
        add("Center",panel4);
        add("South",panel5);

    }

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
}
