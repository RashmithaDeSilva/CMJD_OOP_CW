import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudentDetails extends OptionControler{
    private String menuOptionName = "Update Student Details";
    private int menuOptionNumber = 4;

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

    UpdateStudentDetails(){
        setSize(450,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Update Student Details");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel1 =new JPanel(new FlowLayout());
        JPanel panel2 =new JPanel(new FlowLayout());
        JPanel panel3 =new JPanel(new FlowLayout());

        // Add options
        JLabel sLabel = new JLabel("");
        sLabel.setFont(new Font("",1,15));

        JLabel oldLabel = new JLabel("");
        oldLabel.setFont(new Font("",1,15));

        // Add name
        JLabel label = new JLabel(" Update Student Details");
        label.setFont(new Font("",1,25));
        panel1.add(label);
        add("North",panel1);

        // For ID
        JLabel IDLabel = new JLabel(" Enter Student ID ");
        IDLabel.setFont(new Font("",1,15));
        JTextField IDText = new JTextField(6);
        IDText.setFont(new Font("",1,15));

        // For Name
        JLabel nameLabel = new JLabel("          Enter Student New Name ");
        nameLabel.setFont(new Font("",1,15));
        JTextField nameText = new JTextField(10);
        nameText.setFont(new Font("",1,15));

        JButton btn2 = new JButton("Submit");
        btn2.setFont(new Font("",1,15));

        JButton btn = new JButton("Submit");
        btn.setFont(new Font("",1,15));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = IDText.getText().toUpperCase();
                if(IDchek(ID)){
                    int position = chekIDPositon(ID);
                    oldLabel.setText("           Student Name is :- "+getName(position)+"          ");
                    panel2.remove(btn);
                    panel2.add(oldLabel);
                    panel2.add(nameLabel);
                    panel2.add(nameText);
                    panel2.add(btn2);
                    btn2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (nameText.getText().equals("")){
                                new Warning("Invalide Name");

                            }else {
                                setName(nameText.getText(),position);
                                panel2.remove(btn2);
                                panel2.remove(nameText);
                                panel2.remove(nameLabel);
                                panel2.remove(oldLabel);
                                IDText.setText("");
                                nameText.setText("");
                                panel2.add(btn);
                                sLabel.setText("Successfully Change Name");
                            }
                        }
                    });

                }else {
                    new Warning("This ID Is Invalid");
                }
            }
        });

        panel2.add(IDLabel);
        panel2.add(IDText);
        panel2.add(btn);
        panel3.add(sLabel);
        add("Center",panel2);
        add("South",panel3);

    }
}
