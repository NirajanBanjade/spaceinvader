package spaceinvaders;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.*;
import javax.swing.*;
import java.net.URL;

public class Menu {
    private final ImageSelection imageSelection;
    private final JFrame frame;

    public Menu(ImageSelection imageSelection, JFrame frame) {
        this.imageSelection = imageSelection;
        this.frame = frame;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY); // Set menu bar background color

        // Create and add Shooter Image Menu
        JMenu shooterMenu = createImageMenu("Shooter");
        menuBar.add(shooterMenu);

        // Create and add Invader Image Menu
        JMenu invaderMenu = createImageMenu("Invader");
        menuBar.add(invaderMenu);

        // Create and add Bullet Type Menu
        JMenu bulletMenu = createImageMenu("Bullet");
        menuBar.add(bulletMenu);

        // Create and add Music Menu


        // Create and add Start Game button
        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> startGame());
        menuBar.add(startGameButton);

        return menuBar;
    }

    private JMenu createImageMenu(String type) {
        JMenu menu = new JMenu(type);
        menu.setForeground(Color.BLUE); // Set menu text color

        // Add predefined image items
        String[] imageNames = getImageNames(type);
        for (String imageName : imageNames) {
            JMenuItem menuItem = new JMenuItem(imageName);
            menuItem.addActionListener(e -> setDefaultImage(type, "/spaceinvaders/icons/"  + imageName));
            menu.add(menuItem);
        }

        // Add a custom URL option
        JMenuItem customUrlItem = new JMenuItem("Custom URL");
        customUrlItem.addActionListener(e -> promptForCustomUrl(type));
        menu.add(customUrlItem);

        return menu;
    }

    private String[] getImageNames(String type) {
        return switch (type) {
            case "Shooter" -> new String[]{"fire1.png", "fire2.png", "fire3.png"};
            case "Invader" -> new String[]{"invader1.jpeg", "invader2.jpeg", "invader3.jpeg"};
            case "Bullet" -> new String[]{"bullet1.png", "bullet2.png", "bullet3.png"};
            default -> new String[]{};
        };
    }



    private void promptForCustomUrl(String type) {
        String customUrl = JOptionPane.showInputDialog(frame, "Enter a custom URL for " + type + " image:", "Custom URL", JOptionPane.PLAIN_MESSAGE);
        if (customUrl != null && !customUrl.trim().isEmpty()) {
            setDefaultImage(type, customUrl);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid URL entered.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    

    private void setDefaultImage(String type, String resourcePath) {
        switch (type) {
            case "Shooter" -> imageSelection.setShooterImage(resourcePath);
            case "Invader" -> imageSelection.setInvaderImage(resourcePath);
            case "Bullet" -> imageSelection.setBulletImage(resourcePath);
        }
        // Optionally add feedback to user
        JOptionPane.showMessageDialog(frame, type + " image set to: " + resourcePath, "Image Updated", JOptionPane.INFORMATION_MESSAGE);
    }

    public void startGame() {
        // Hide the menu bar
        frame.setJMenuBar(null);

        // Initialize and add the game UI
        SpaceInvadersUI game = new SpaceInvadersUI();
        frame.getContentPane().removeAll(); // Clear any existing components
        frame.add(game); // Add the game UI
        frame.revalidate(); // Refresh the frame to display the game
        frame.repaint();
        System.out.println("Start Game button clicked, initializing game...");
    }
}
