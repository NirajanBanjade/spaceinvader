// File: GameStarter.java
package spaceinvaders;

import javax.swing.*;

public class GameStarter {
    private final JFrame frame;

    public GameStarter(JFrame frame) {
        this.frame = frame;
    }

    public void startGame() {
        frame.setJMenuBar(null);
        SpaceInvadersUI game = new SpaceInvadersUI();
        frame.getContentPane().removeAll();
        frame.add(game);
        frame.revalidate();
        frame.repaint();
        System.out.println("Start Game button clicked, initializing game...");
    }
}
