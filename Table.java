import javax.swing.*;
import java.io.*;
import java.awt.*;

class Table extends JFrame {
    final int row = 4;
    final int col = 13;
    final String[][] cardMatrix = new String[row][col];

    public Table() {
        JFrame window = new JFrame();
        window.setLocation(300, 500);
        window.setBounds(600, 600, 0, 0);
        window.setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        fill_array(cardMatrix);
        JTextArea text = new JTextArea();
        text.setFont(new Font("Monospaced", Font.PLAIN, 12));
        text.setEditable(false);

        //we need to convert array to a strong to set it in the JText
        String arrStr = arrayToString(cardMatrix);
        text.setText(arrStr);
    }

    public void fill_array(String[][] cardMatrix) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cardMatrix[i][j] = " x ";
            }
        }
    }

    public String arrayToString(String[][] cardMatrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(cardMatrix[i][j]);
            }
            sb.append("\n"); // Add a newline after each row
        }
        return sb.toString();
    }

    public void printArray(String[][] cardMatrix)
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(cardMatrix[i][j]);
            }

            System.out.println("\n");
        }
    }


    public static void main(String args[]) {
        Table main = new Table();

    }
}

