package spaceinvaders;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Invaders with Images");
        ImageSelection imageSelection = new ImageSelection();
        
        // Initialize Menu and pass the JFrame to it
        Menu menu = new Menu(imageSelection, frame);
        frame.setJMenuBar(menu.createMenuBar());
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
