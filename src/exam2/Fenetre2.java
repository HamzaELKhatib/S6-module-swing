package exam2;

import java.awt.*;
import javax.swing.*;


public class Fenetre2 extends JFrame{



    //Instanciation d'un objet JPanel
    private JPanel pan = new JPanel();

    private JLabel jLabelT1 = new JLabel("Colonne 1 : ");
    private JLabel jLabelV1 = new JLabel();
    private JLabel jLabelT2 = new JLabel("Colonne 2 : ");
    private JLabel jLabelV2 = new JLabel();
    private JLabel jLabelT3 = new JLabel("Colonne 3 : ");
    private JLabel jLabelV3 = new JLabel();

    private JButton bouton = new JButton("modifier element table");


    public Fenetre2(String col1,String col2,String col3){

        this.setTitle("fenetre 2");
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // definir la couleur de fond de la panel
        pan.setBackground(Color.ORANGE);


        jLabelV1.setText(col1);
        jLabelV2.setText(col2);
        jLabelV3.setText(col3);


        pan.add(jLabelT1);
        pan.add(jLabelV1);

        pan.add(jLabelT2);
        pan.add(jLabelV2);

        pan.add(jLabelT3);
        pan.add(jLabelV3);

        // attacher la panel a notre fenetre
        this.setContentPane(pan);
        this.setVisible(true);





    }

}