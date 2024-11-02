// File: ImageLoader.java
package spaceinvaders;

import javax.swing.*;
import java.awt.*;

public class ImageLoader {
    private final JFrame frame;
    private final ImageSelection imageSelection;

    public ImageLoader(JFrame frame, ImageSelection imageSelection) {
        this.frame = frame;
        this.imageSelection = imageSelection;
    }

    public JMenu createImageMenu(ImageType imageType) {
        JMenu menu = new JMenu(imageType.getDisplayName());
        menu.setForeground(Color.BLUE);

        for (String imageName : imageType.getImageNames()) {
            JMenuItem menuItem = new JMenuItem(imageName);
            menuItem.addActionListener(e -> setDefaultImage(imageType, "/spaceinvaders/icons/" + imageName));
            menu.add(menuItem);
        }

        JMenuItem customUrlItem = new JMenuItem("Custom URL");
        customUrlItem.addActionListener(e -> promptForCustomUrl(imageType));
        menu.add(customUrlItem);

        return menu;
    }

    private void setDefaultImage(ImageType imageType, String resourcePath) {
        switch (imageType.getDisplayName()) {
            case "Shooter" -> imageSelection.setShooterImage(resourcePath);
            case "Invader" -> imageSelection.setInvaderImage(resourcePath);
            case "Bullet" -> imageSelection.setBulletImage(resourcePath);
        }
        JOptionPane.showMessageDialog(frame, imageType.getDisplayName() + " image set to: " + resourcePath, "Image Updated", JOptionPane.INFORMATION_MESSAGE);
    }

    private void promptForCustomUrl(ImageType imageType) {
        String customUrl = JOptionPane.showInputDialog(frame, "Enter a custom URL for " + imageType.getDisplayName() + " image:", "Custom URL", JOptionPane.PLAIN_MESSAGE);
        if (customUrl != null && !customUrl.trim().isEmpty()) {
            setDefaultImage(imageType, customUrl);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid URL entered.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

