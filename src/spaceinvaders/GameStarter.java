// GameStarter.java
package spaceinvaders;

import javax.swing.JFrame;

public class GameStarter {
    private final JFrame frame;
    private final ImageSelection imageSelection;

    public GameStarter(JFrame frame, ImageSelection imageSelection) {
        this.frame = frame;
        this.imageSelection = imageSelection;
    }

    public void startGame() {
        frame.setJMenuBar(null);
        SpaceInvadersUI game = new SpaceInvadersUI(imageSelection); // Pass the existing instance
        frame.getContentPane().removeAll();
        frame.add(game);
        frame.revalidate();
        frame.repaint();
        System.out.println("Start Game button clicked, initializing game...");
    }
}
