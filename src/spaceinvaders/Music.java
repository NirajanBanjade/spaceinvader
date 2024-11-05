package spaceinvaders;

import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class Music {
    private final JFrame frame;
    private Clip clip;
    private boolean customMusicSelected = false; // Flag to track if custom music is selected

    public Music(JFrame frame) {
        this.frame = frame;
    }
    public boolean isCustomMusicSelected() { //getter for custom music . if it is not custom then default.
        return customMusicSelected;
    }
    private void playMusic(String musicPath) {
        stopMusic(); // Stop any currently playing music
        try {
            AudioInputStream audioStream;

            if (isURL(musicPath)) {
                URL url = new URL(musicPath);
                audioStream = AudioSystem.getAudioInputStream(url);
            } else {
                audioStream = AudioSystem.getAudioInputStream(getClass().getResource(musicPath));
            }

            clip = AudioSystem.getClip();
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

    // Method to play default music only if no custom music has been selected

    // Only play default if no custom music has been chosen
    public void playDefaultMusic() {
        
        if (!isCustomMusicSelected()) { 
            stopMusic();
            String defaultMusicPath = "icons/music1.wav";
            playMusic(defaultMusicPath);
        }

    }

    // Method to handle custom music selection, marking that custom music was chosen
    public void playCustomMusic(String customMusicPath) {
        stopMusic();   // stop any previous music and use custom.
        customMusicSelected = true; // Set custom music as selected
        playMusic(customMusicPath);    // Play the selected custom music
    }

    private void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    private boolean isURL(String path) {
        try {
            new URL(path);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public JMenu createMusicMenu() {
        JMenu musicMenu = new JMenu("Music");
        musicMenu.setForeground(Color.GREEN);

        String[] musicTracks = {"music1.wav", "music2.wav", "music3.wav"};
        for (String track : musicTracks) {
            JMenuItem trackItem = new JMenuItem(track);
            trackItem.addActionListener(e -> playCustomMusic("icons/" + track));
            musicMenu.add(trackItem);
        }

        JMenuItem customUrlItem = new JMenuItem("Custom Music URL");
        customUrlItem.addActionListener(e -> {
            String customUrl = JOptionPane.showInputDialog(frame, "Enter a custom music URL:", "Custom Music URL", JOptionPane.PLAIN_MESSAGE);
            if (customUrl != null && !customUrl.trim().isEmpty()) {
                playCustomMusic(customUrl);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid URL entered.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        musicMenu.add(customUrlItem);

        return musicMenu;
    }
}
