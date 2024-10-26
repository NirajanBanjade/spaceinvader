package spaceinvaders;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Invaders with Images");
        SpaceInvadersUI game = new SpaceInvadersUI();
        ImageSelection imageSelection = new ImageSelection();
        
        // Initialize Menu and set it to the frame
        Menu menu = new Menu(imageSelection);
        frame.setJMenuBar(menu.createMenuBar());
        frame.add(game);
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
