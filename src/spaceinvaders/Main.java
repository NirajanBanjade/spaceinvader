// File: Main.java
package spaceinvaders;

import javax.swing.JFrame;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Invaders with Images");
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageSelection imageSelection = new ImageSelection();
        ImageLoader imageLoader = new ImageLoader(frame, imageSelection);
        GameStarter gameStarter = new GameStarter(frame);
        MenuFactory menuFactory = new MenuFactory(imageLoader, gameStarter);

        // Create Menu and set up the menu bar with the available image types
        Menu menu = new Menu(menuFactory);
        frame.setJMenuBar(menu.createMenuBar());
        
        frame.setVisible(true);
    }
}


