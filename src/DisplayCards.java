package src;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;

public class DisplayCards extends JPanel {
    final int ROW = 4;
    final int COL = 13;
    final int CARD_WIDTH = 70;
    final int CARD_HEIGHT = 100;
    final ArrayList<Image> cardImageList = new ArrayList<>();   //contains all images of cards
    final Path cardImageDirectoryPath = Paths.get("CardImages/");   //Path to CardImages folder/directory

    //JPanel constructor
    public DisplayCards() {
        setBackground(new Color(14, 115, 37));
        setLayout(new GridLayout(ROW, COL));
        readDirectory();
        printCards();
    }

    //reshuffle the card order of cardImageList
    public void reshuffle() {
        System.out.println("Shuffling Cards");
        Collections.shuffle(cardImageList);
        printCards(); //already handles removing all cards from JPanel
    }

    //reads all files in the card image directory/folder
    private void readDirectory() {
        try {
            //check if directory exists/is valid
            if (Files.exists(cardImageDirectoryPath) && Files.isDirectory(cardImageDirectoryPath)) {
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(cardImageDirectoryPath)) {
                    //iterate through all files in directory
                    for (Path file : stream) {
                        ImageIcon cardIcon = new ImageIcon(file.toString()); //convert Path -> String, then String -> ImageIcon
                        Image scaledCardIcon = cardIcon.getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH); //ImageIcon -> Image for scaling
                        cardImageList.add(scaledCardIcon); //add Image to cardImageList ArrayList
                    }
                }
            } else {
                System.out.println("Invalid directory path.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //converts the ArrayList of ImageIcons to JLabels and adds them to main panel
    private void printCards() {
        //clear everything in green window
        removeAll();

        for (Image icon : cardImageList) {
            ImageIcon cardIcon = new ImageIcon(icon); //Image -> ImageIcon
            JLabel label = new JLabel(cardIcon); //ImageIcon -> JLabel

            label.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
            label.setHorizontalAlignment(SwingConstants.CENTER);

            this.add(label);
        }

        //update window just in case
        revalidate();
        repaint();
    }
}
