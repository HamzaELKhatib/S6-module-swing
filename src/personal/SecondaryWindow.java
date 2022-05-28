package personal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SecondaryWindow extends JFrame {

    JPanel panel2 = new JPanel();
    JTextField note2 = new JTextField();
    JButton clear = new JButton("Clear");
    JButton back = new JButton("Return");

    public SecondaryWindow() {

        this.setSize(600, 600);
        this.setTitle("Your notes");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(panel2);
        panel2.setBackground(Color.blue);
        panel2.add(note2);
        panel2.add(clear);
        panel2.add(back);

        clear.addActionListener(new java.awt.event.ActionListener(){

            public void actionPerformed(ActionEvent e){
                note2.setText("");
            }
        });

        back.addActionListener(new java.awt.event.ActionListener(){

           public void actionPerformed(ActionEvent e){
               MainWindow mainWindow = new MainWindow();
               setVisible(false);
               mainWindow.setVisible(true);
           }
        });
    }
}
