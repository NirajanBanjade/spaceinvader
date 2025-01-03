package spaceinvaders;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SpaceInvadersUI extends JPanel implements ActionListener, KeyListener {

    private final Timer timer;
    public ArrayList<InvaderBox> invaderboxes;
    public ArrayList<Bullet> bullets;
    public Random random;
    public boolean moveLeft, moveRight;
    private final ListenerActions listenerActions;
    public final ImageSelection imageSelection;
    private final PaintingActions paintingActions;
    private int shooter_width = 50;
    private int shooter_height = 60;
    private int shooter_X_Coordinate = 200;

    // Constructor
    public SpaceInvadersUI(ImageSelection imageSelection) {
        this.imageSelection = imageSelection;
        timer = new Timer(20, this);
        invaderboxes = new ArrayList<>();
        bullets = new ArrayList<>();
        random = new Random();
        moveLeft = false;
        moveRight = false;
        listenerActions = new ListenerActions(this);  // passing the instance of listenerActions.
        paintingActions = new PaintingActions();
    
        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        listenerActions.updatePositions(this);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        listenerActions.keyPressed(e, this);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        listenerActions.keyReleased(e, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used. Not providing an implementation Violates Integration Segregation
        // Principle
        // Could be used for character keys.
    }

    @Override
    // Let's move these methods into a separate PaintUI class
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        // Draw shooter (rectangle)
        paintingActions.drawShooter(g, this);

        // Draw falling invaderboxes (as images)
        paintingActions.drawInvaders(g, invaderboxes, imageSelection.getInvaderImage(), this);

        // Draw bullets (bullets)
        paintingActions.drawBullets(g, bullets, imageSelection.getBulletImage());

    }

    public int getShooterWidth() {
        return (shooter_width);
    }

    public int getShooterHeight() {
        return (shooter_height);
    }

    public int getShooter_X_Coordinate() {
        return (shooter_X_Coordinate);
    }

    public void setShooter_X_Coordinate(int shooter_X) {
        shooter_X_Coordinate = shooter_X;
    }

    // These are the characters or objects used in the game. Create a shooter class
    // thing.

    // Inner class representing falling invaderboxes

    

    public class InvaderBox {
        int x, y, size;

        public InvaderBox(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    // Inner class representing bullets (bullets)
    // Look for Java bullet class
    public class Bullet {
        int x, y;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
