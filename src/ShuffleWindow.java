package src;

import java.awt.*;
import javax.swing.*;

class ShuffleWindow extends JFrame {

    //JPanel that displays deck of cards
    private final DisplayCards displayCards;

    //JFrame constructor
    public ShuffleWindow() {
        //window handling
        setTitle("Card Shuffler");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        //JPanel that displays shuffled cards
        displayCards = new DisplayCards();
        add(displayCards, BorderLayout.CENTER);

        //JButton for reshuffling
        JButton reshuffleButton = getJButton();

        //add button to bottom of window
        add(reshuffleButton, BorderLayout.SOUTH);
    }

    private JButton getJButton() {
        JButton reshuffleButton = new JButton("Shuffle");

        //basically change the size of the button by adding buffers around the button text
        int buttonHeight = reshuffleButton.getPreferredSize().height;
        reshuffleButton.setBorder(BorderFactory.createEmptyBorder(buttonHeight/2, 0, buttonHeight/2, 0));
        reshuffleButton.setFocusPainted(false); //remove black line around text

        //button action -> call reshuffle() to shuffle and display cards
        reshuffleButton.addActionListener(e -> displayCards.reshuffle());
        return reshuffleButton;
    }

    public static void main(String[] args) {
        //thread safety
        SwingUtilities.invokeLater(() -> {
            new ShuffleWindow().setVisible(true); //initialize window
        });
    }
}
