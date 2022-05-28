package exam2;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Fenetre1 extends JFrame{

    // methode main non demandé dans l exam - seulement pour test
    public static void main(String args[]) {

        Fenetre1 FF = new Fenetre1();
    }

    //Instanciation d'un objet JPanel
    private JPanel pan = new JPanel();
    private JTable jTable1 = new JTable();

    private JButton bouton = new JButton("recuperer ligne selectionnee");


    public Fenetre1(){

        this.setTitle("Ma première fenêtre");
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // definir la couleur de fond de la panel
        pan.setBackground(Color.ORANGE);


        //creer une jtable
        //-------------------------------------------



        //1- les titres de la tables (colonnes de la table)
        String[] titres = new String[3];
        titres[0] = "col1";   titres[1]="col2"; titres[2]="col3";


        //2- le tableau du contenu (les lignes de la table)
        String[][] table = {{"D_00","D_01","D_02"},{"D_10","D_11","D_12"},{"D_20","D_21","D_22"}};
        Object[][] datas = new Object[table.length][3];


        for(int i=0; i<table.length;i++){
            datas[i][0] = table[i][0];
            datas[i][1] = table[i][1];
            datas[i][2] = table[i][2];
        }

        //3- creation du TableModel
        DefaultTableModel aModel = new DefaultTableModel(datas,titres) ;



        //4- charger la tableModel dans jTable
        jTable1.setModel(aModel);


        // attacher la jTable a la panel
        pan.add(jTable1);

        // attacher le bouton a la panel


        pan.add(bouton);



        // attacher la panel a notre fenetre
        this.setContentPane(pan);
        this.setVisible(true);



        // definir l action du button
        bouton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int ligneSelectionne = jTable1.getSelectedRow();

                String col1 = ""+jTable1.getValueAt(ligneSelectionne, 0);
                String col2 = ""+jTable1.getValueAt(ligneSelectionne, 1);
                String col3 = ""+jTable1.getValueAt(ligneSelectionne, 2);


                Fenetre2 FF = new Fenetre2(col1,col2,col3);



            }
        });


    }





}