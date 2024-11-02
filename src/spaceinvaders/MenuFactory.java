// File: MenuFactory.java
package spaceinvaders;
import java.awt.Color;

import javax.swing.*;
import java.util.List;

public class MenuFactory {
    private final ImageLoader imageLoader;
    private final GameStarter gameStarter;

    public MenuFactory(ImageLoader imageLoader, GameStarter gameStarter) {
        this.imageLoader = imageLoader;
        this.gameStarter = gameStarter;
    }

    public JMenuBar createMenuBar(List<ImageType> imageTypes) {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);

        for (ImageType type : imageTypes) {
            menuBar.add(imageLoader.createImageMenu(type));
        }

        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> gameStarter.startGame());
        menuBar.add(startGameButton);

        return menuBar;
    }
}
