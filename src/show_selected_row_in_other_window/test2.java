package show_selected_row_in_other_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class test2 extends JFrame{

    JPanel panel2 = new JPanel();

    JLabel labelColumn1 = new JLabel("Colonne 1 : ");
    JTextField textColumn1 = new JTextField();

    JLabel labelColumn2 = new JLabel("Colonne 2 : ");
    JTextField textColumn2 = new JTextField();

    JLabel labelColumn3 = new JLabel("Colonne 3 : ");
    JTextField textColumn3 = new JTextField();

    JButton bReturn = new JButton("Return");

    public test2(String colonne1, String colonne2, String colonne3){
        this.setTitle("window2");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel2.setBackground(Color.blue);

        textColumn1.setText(colonne1);
        textColumn2.setText(colonne2);
        textColumn3.setText(colonne3);

        panel2.add(labelColumn1);
        panel2.add(textColumn1);
        panel2.add(labelColumn2);
        panel2.add(textColumn2);
        panel2.add(labelColumn3);
        panel2.add(textColumn3);
        panel2.add(bReturn);
        this.setContentPane(panel2);
        this.setVisible(false);
        bReturn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(ActionEvent e){
                test1 test1 = new test1();
                setVisible(false);
                test1.setVisible(true);
            }
        });
    }
}
