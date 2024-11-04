package spaceinvaders;

import javax.swing.JFrame;

public class GameStarter {
    private final JFrame frame;
    private final ImageSelection imageSelection;
    private final Music music;
    private boolean gameStarted = false;  // Flag to check if the game has started

    public GameStarter(JFrame frame, ImageSelection imageSelection, Music music) {
        this.frame = frame;
        this.imageSelection = imageSelection;
        this.music = music;
    }

    public void startGame() {
        frame.setJMenuBar(null);
        SpaceInvadersUI game = new SpaceInvadersUI(imageSelection);
        frame.getContentPane().removeAll();
        frame.add(game);
        frame.revalidate();
        frame.repaint();
        game.requestFocusInWindow();// requesting focus immediately after the start.
        
        System.out.println("Start Game button clicked, initializing game...");
        gameStarted = true;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }
}
