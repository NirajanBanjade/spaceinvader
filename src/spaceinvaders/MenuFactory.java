// File: MenuFactory.java
package spaceinvaders;
import java.awt.Color;

import javax.swing.*;

import java.util.List;

public class MenuFactory {
    private final ImageLoader imageLoader;
    private final GameStarter gameStarter;
    private final Music music;
    

    public MenuFactory(JFrame frame, ImageLoader imageLoader, GameStarter gameStarter) {
        this.imageLoader = imageLoader;
        this.gameStarter = gameStarter;
        this.music = new Music(frame);  // Initialize Music with JFrame
    }

    public JMenuBar createMenuBar(List<ImageType> imageTypes) {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);

        for (ImageType type : imageTypes) {
            menuBar.add(imageLoader.createImageMenu(type));
        }
        
        JMenu musicMenu = music.createMusicMenu();  // Use createMusicMenu() from Music instance
        menuBar.add(musicMenu);

        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> gameStarter.startGame());
        menuBar.add(startGameButton);
        


        return menuBar;
    }
}
