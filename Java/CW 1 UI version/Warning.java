import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warning extends JFrame {
    Warning(String wMg){
        setSize(400,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Warning");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout());

        JLabel label = new JLabel(wMg);
        label.setFont(new Font("",1,25));

        JButton btn = new JButton("Exit");
        btn.setFont(new Font("",1,15));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        panel.add(label);
        panel.add(btn);
        add("Center",panel);
        setVisible(true);
    }
}
