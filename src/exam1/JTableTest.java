package exam1;

import revision.Test1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableTest extends JFrame {

    public static void main(String[] args) {
        JTableTest test1 = new JTableTest();
    }

    JPanel panel = new JPanel();
    JTable myTable = new JTable();

    JLabel labelLigne = new JLabel("Ligne");
    JTextField textLigne = new JTextField();

    JLabel labelColonne = new JLabel("Colonne");
    JTextField textColonne = new JTextField();

    JLabel labelValeur = new JLabel("Valeur");
    JTextField textValeur = new JTextField();

    JButton buttonModifier = new JButton("Modifier");

    public JTableTest() {
        this.setTitle("First window");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        String[] nomsColonnes = {"Colonne 1", "Colonne 2"};

        String[][] cellules = {
                {"Cell[0][0]", "Cell[0][1]"},
                {"Cell[1][0]", "Cell[1][1]"},
                {"Cell[2][0]", "Cell[2][1]"}
        };

        Object[][] tableData = new Object[cellules.length][2];

        for(int i = 0; i<cellules.length ; i++){
            tableData[i][0] = cellules[i][0];
            tableData[i][1] = cellules[i][1];
        }

        DefaultTableModel modelTable = new DefaultTableModel(tableData, nomsColonnes);
        myTable.setModel(modelTable);
        panel.add(myTable);
        panel.add(labelLigne);
        panel.add(textLigne);
        panel.add(labelColonne);
        panel.add(textColonne);
        panel.add(labelValeur);
        panel.add(textValeur);
        panel.add(buttonModifier);
        panel.setBackground(Color.BLUE);

        this.setContentPane(panel);
        this.setVisible(true);

        buttonModifier.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int ligne = Integer.parseInt(textLigne.getText());
                int colonne = Integer.parseInt(textColonne.getText());
                int valeur = Integer.parseInt(textValeur.getText());

                modelTable.setValueAt(valeur, ligne, colonne);
            }
        });
    }
}

