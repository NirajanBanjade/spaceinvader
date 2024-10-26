
package spaceinvaders;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.net.URL;

public class Menu {
    private final ImageSelection imageSelection;

    public Menu(ImageSelection imageSelection) {
        this.imageSelection = imageSelection;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Shooter Image Menu
        JMenu shooterMenu = new JMenu("Shooter Image");
        addImageMenuItems(shooterMenu, "Shooter");
        menuBar.add(shooterMenu);

        // Invader Image Menu
        JMenu invaderMenu = new JMenu("Invader Image");
        addImageMenuItems(invaderMenu, "Invader");
        menuBar.add(invaderMenu);

        // Bullet Type Menu
        JMenu bulletMenu = new JMenu("Bullet Type");
        addImageMenuItems(bulletMenu, "Bullet");
        menuBar.add(bulletMenu);

        return menuBar;
    }

    private void addImageMenuItems(JMenu menu, String type) {
        JMenuItem defaultItem1 = new JMenuItem("Default " + type + " 1");
        defaultItem1.addActionListener(e -> setDefaultImage(type, "/resources/" + type + "Image1.png"));
        menu.add(defaultItem1);

        JMenuItem defaultItem2 = new JMenuItem("Default " + type + " 2");
        defaultItem2.addActionListener(e -> setDefaultImage(type, "/resources/" + type + "Image2.png"));
        menu.add(defaultItem2);
       

        JMenuItem defaultItem3 = new JMenuItem("Default " + type + " 3");
        defaultItem2.addActionListener(e -> setDefaultImage(type, "/resources/" + type + "Image3.png"));
        menu.add(defaultItem3);
       

    }

    private void playMusic(String musicUrl) {  
        try {
            // Create a URL object for the music file
            URL url = new URL(musicUrl);
    
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
    
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Unsupported audio format: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading audio file: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Audio line unavailable: " + e.getMessage());
        }
    }

    private void setDefaultImage(String type, String resourcePath) {
        switch (type) {
            case "Shooter" -> imageSelection.setShooterImage(resourcePath);
            case "Invader" -> imageSelection.setInvaderImage(resourcePath);
            case "Bullet" -> imageSelection.setBulletImage(resourcePath);
        }
    }

    
}




