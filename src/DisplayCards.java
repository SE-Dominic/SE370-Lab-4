package src;

import javax.swing.*;
import java.awt.*;

public class DisplayCards extends JPanel {
    final int row = 4;
    final int col = 13;
    final String[][] cardMatrix = new String[row][col];

    public DisplayCards() {
        setBackground(new Color(14, 115, 37));
        ImageIcon icon = new ImageIcon("src/CardImages/2_of_clubs.png");
        JLabel label = new JLabel(icon);
        this.add(label);
    }

    public void reshuffle() {
        System.out.println("Shuffling Cards");

        fill_array(cardMatrix);
        printArray(cardMatrix);
    }

    public void fill_array(String[][] cardMatrix) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cardMatrix[i][j] = " x ";
            }
        }
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
}

