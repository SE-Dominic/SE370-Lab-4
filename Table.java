import javax.swing.*;
import java.io.*;
import java.awt.*;

class Table {
    final int row = 5;
    final int col = 13;
    final String[][] cardMatrix = new string[row][col];

    public void fill_array(String[][] cardMatrix);

    public Table() {
        JFrame window = new JFrame();
        window.setLocation(300, 500);
        window.setBounds(600, 600);
        window.setSize(600, 500);
        window.setVisible(true);
        Table table = new Table();
        window.add(table);
    }

    public void fill_array(String[][] cardMatrix) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cardMatrix[i][j] = " x ";
            }
            System.out.println("\n");
        }
    }
}

