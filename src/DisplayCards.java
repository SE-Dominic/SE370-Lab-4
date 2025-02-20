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
    final ArrayList<Image> cardImageList = new ArrayList<>();
    final String cardImageDirectoryPath = "CardImages/";
    final int CARD_WIDTH = 70;
    final int CARD_HEIGHT = 100;

    public DisplayCards() {
        setBackground(new Color(14, 115, 37));
        setLayout(new GridLayout(ROW, COL));
        readDirectory();
        printCards();
    }

    public void reshuffle() {
        System.out.println("Shuffling Cards");
        Collections.shuffle(cardImageList);
        printCards();
    }

    //method to read all files in a directory/folder
    private void readDirectory() {
        try {
            //convert string to Path variable
            Path dirPath = Paths.get(cardImageDirectoryPath);

            //check if directory is valid
            if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath)) {
                    //iterate through all files in directory
                    for (Path file : stream) {
                        //create new ImageIcon with each file, and add to cardImageList
                        ImageIcon cardIcon = new ImageIcon(file.toString());
                        Image scaledCardIcon = cardIcon.getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH);
                        cardImageList.add(scaledCardIcon);
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
        removeAll();

        for (Image icon : cardImageList) {
            ImageIcon cardIcon = new ImageIcon(icon);
            JLabel label = new JLabel(cardIcon);
            label.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));  // Set preferred size
            label.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(label);
        }

        revalidate();
        repaint();
    }
}

