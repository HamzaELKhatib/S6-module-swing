package add_row_with_data_to_specific_line;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Test1 extends JFrame {

    public static void main(String[] args) {
        revision.Test1 test1 = new revision.Test1();
    }

    JPanel panel = new JPanel();
    JTable myTable = new JTable();

    JLabel labelColonne1 = new JLabel("Colonne 1");
    JTextField textColonne1 = new JTextField();

    JLabel labelColonne2 = new JLabel("Colonne 2");
    JTextField textColonne2 = new JTextField();



    JButton buttonModifier = new JButton("Modifier");

    public Test1() {
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
        panel.add(labelColonne1);
        panel.add(textColonne1);
        panel.add(labelColonne2);
        panel.add(textColonne2);
        panel.add(buttonModifier);
        panel.setBackground(Color.BLUE);

        this.setContentPane(panel);
        this.setVisible(true);

        buttonModifier.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                int ligne = myTable.getSelectedRow();

                int colonne1 = Integer.parseInt(textColonne1.getText());
                int colonne2 = Integer.parseInt(textColonne2.getText());


                //modelTable.insertRow(0, new Object[] {colonne1, colonne2});
                //modelTable.insertRow(5, new Object[] {colonne1, colonne2});
                modelTable.insertRow(modelTable.getRowCount(), new Object[] {colonne1, colonne2});
            }
        });
    }
}