package src;

import java.awt.*;
import javax.swing.*;


class ShuffleWindow extends JFrame {

    private final DisplayCards displayCards;

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

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShuffleWindow().setVisible(true); //initialize window
        });
    }
}
