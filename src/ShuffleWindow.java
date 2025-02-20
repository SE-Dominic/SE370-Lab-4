package src;

import java.awt.*;
import javax.swing.*;


class ShuffleWindow extends JFrame {
    final int row = 4;
    final int col = 13;
    final String[][] cardMatrix = new String[row][col];
    private DisplayCards displayCards;

    public ShuffleWindow() {
        //window handling
        setTitle("Card Shuffler");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //JPanel that displays shuffled cards
        displayCards = new DisplayCards();
        add(displayCards, BorderLayout.CENTER);

        //the button for reshuffling
        JButton reshuffleButton = new JButton("Shuffle");

        //basically change the size of the button by adding buffers around the button text
        int buttonHeight = reshuffleButton.getPreferredSize().height;
        reshuffleButton.setBorder(BorderFactory.createEmptyBorder(buttonHeight/2, 0, buttonHeight/2, 0));
        reshuffleButton.setFocusPainted(false); //remove black line around text

        //add button to bottom of window
        add(reshuffleButton, BorderLayout.SOUTH);

        //button action -> call reshuffle() to shuffle and display cards
        reshuffleButton.addActionListener(e -> displayCards.reshuffle());

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


    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new ShuffleWindow().setVisible(true); //initialize window
        });;
    }
}
