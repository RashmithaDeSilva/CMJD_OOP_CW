import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HomePage extends JFrame {
    private JLabel[] lb;
    private JButton[] btn;

    HomePage(SystemManager SM){
        setSize(900,350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("GDSE Marks Management System");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        //  Add to name
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("WELCOME  TO  GDSE  MARKS  MANAGEMENT  SYSTEM");
        label.setFont(new Font("",1,25));
        panel.add(label);
        add("North",panel);

        //  Add options
        //  Count options create layout
        int count = (SM.getOCLength()  / 2) + (SM.getOCLength() % 2);
        JPanel panel2 = new JPanel(new GridLayout(count,2));

        //  Create btn and labels
        lb = new JLabel[SM.getOCLength()];
        btn = new JButton[SM.getOCLength()];

        for(int i=0;i<SM.getOCLength();i++){
            JPanel temp = new JPanel(new FlowLayout());
            lb[i] = new JLabel("   ["+Integer.toString(SM.getNumber(i))+"]");
            lb[i].setFont(new Font("",1,15));
            btn[i] = new JButton(SM.getName(i));
            btn[i].setFont(new Font("",1,15));
            temp.add(lb[i]);
            temp.add(btn[i]);
            panel2.add(temp);
        }

        //  Set actions
        btn[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(0);
            }
        });
        btn[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(1);
            }
        });
        btn[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(2);
            }
        });
        btn[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(3);
            }
        });
        btn[4].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(4);
            }
        });
        btn[5].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(5);
            }
        });
        btn[6].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(6);
            }
        });
        btn[7].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(7);
            }
        });
        btn[8].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(8);
            }
        });
        btn[9].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SM.setVisible(9);
            }
        });



        add("Center",panel2);
    }
}
