import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudent extends OptionControler{
    private String menuOptionName = "Delete Student";
    private int menuOptionNumber = 6;

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

    DeleteStudent(){
        setSize(450,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Delete Student");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel1 =new JPanel(new FlowLayout());
        JPanel panel2 =new JPanel(new FlowLayout());

        // Add name
        JLabel label = new JLabel("Delete Student");
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
                    setVisible("false");
                    new DeleteStudent(chekIDPositon(ID),ID).setVisible("true");
                }else{
                    IDText.setText("");
                    new Warning("Incorrect ID");
                }
            }
        });

        panel2.add(IDLabel);
        panel2.add(IDText);
        panel2.add(subBtn);
        add(panel2);
    }

    DeleteStudent(int position, String ID){
        setSize(450,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Delete Student");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel1 =new JPanel(new FlowLayout());
        JPanel panel2 =new JPanel(new FlowLayout());

        // Add name
        JLabel label = new JLabel("Delete Student");
        label.setFont(new Font("",1,25));
        panel1.add(label);
        add("North",panel1);

        // For ID
        JLabel IDLabel = new JLabel(" Enter Student ID ");
        IDLabel.setFont(new Font("",1,15));
        JTextField IDText = new JTextField(ID,6);
        IDText.setEnabled(false);
        IDText.setFont(new Font("",1,15));

        // For Old Name
        JLabel nameLabel = new JLabel("Student Name :- "+getName(position));
        nameLabel.setFont(new Font("",1,15));

        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("",1,15));
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible("false");
                new UpdateMarks().setVisible("true");
            }
        });

        JButton btn = new JButton("Submit");
        btn.setFont(new Font("",1,15));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent(position);
                setVisible("false");
                new UpdateMarks().setVisible("true");
            }
        });

        panel2.add(IDLabel);
        panel2.add(IDText);
        panel2.add(nameLabel);
        panel2.add(btn);
        add(panel2);
    }
}
