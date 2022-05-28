package personal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
    }

    JPanel panel = new JPanel();
    JButton but1 = new JButton("Valider");
    JButton clear = new JButton("Clear");
    JTextField note = new JTextField("note");

    public MainWindow(){

        this.setTitle("Welcome");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(panel);
        panel.setBackground(Color.red);
        this.setVisible(true);
        panel.add(note);
        panel.add(but1);
        panel.add(clear);

        but1.addActionListener(new java.awt.event.ActionListener(){

            public void actionPerformed(ActionEvent e){

                SecondaryWindow win2 = new SecondaryWindow();
                win2.setVisible(true);
                setVisible(false);
                win2.note2.setText(note.getText());
            }
        });

        clear.addActionListener(new java.awt.event.ActionListener(){

            public void actionPerformed(ActionEvent e){
                note.setText("");
            }
        });
    }
}
