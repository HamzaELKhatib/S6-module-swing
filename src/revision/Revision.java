package revision;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Revision extends JFrame{

    public static void main(String[] args) {
        Revision revision = new Revision();
    }
    private JPanel panel = new JPanel();
    private Button bouton = new Button("My button");

    public Revision(){

        this.setVisible(true);
        this.setTitle("My first window");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(bouton);
        this.setContentPane(panel);

        bouton.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                Test2 test2 = new Test2();
                test2.setVisible(true);
                setVisible(false);
            }
        });
    }
}
