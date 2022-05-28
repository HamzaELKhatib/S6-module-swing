package show_selected_row_in_other_window;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class test1 extends JFrame {

    public static void main(String[] args) {
        test1 test = new test1();
    }

    JPanel panel = new JPanel();
    JTable table = new JTable();

    JButton select = new JButton("Select");

    public test1() {
        this.setTitle("window");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.red);
        String[] columnTitles = {"column1", "column2", "column3"};
        String[][] data = {
                {"Cell[0][0]", "Cell[0][1]", "Cell[0][2]"},
                {"Cell[1][0]", "Cell[1][1]", "Cell[1][2]"},
                {"Cell[2][0]", "Cell[2][1]", "Cell[2][2]"}
        };
        Object[][] tableData = new Object[data.length][3];
        for (int i = 0; i < data.length; i++) {
            tableData[i][0] = data[i][0];
            tableData[i][1] = data[i][1];
            tableData[i][2] = data[i][2];
        }
        DefaultTableModel tableModel = new DefaultTableModel(tableData, columnTitles);
        table.setModel(tableModel);
        panel.add(table);
        panel.add(select);
        this.setContentPane(panel);
        this.setVisible(true);
        select.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int ligne = table.getSelectedRow();
                String colonne1 = (String) table.getValueAt(ligne, 0);
                String colonne2 = (String) table.getValueAt(ligne, 1);
                String colonne3 = (String) table.getValueAt(ligne, 2);

                test2 test2 = new test2(colonne1, colonne2, colonne3);
                test2.setVisible(true);
                setVisible(false);
            }
        });
    }
}
