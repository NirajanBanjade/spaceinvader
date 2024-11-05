package spaceinvaders;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.Iterator;

public class ListenerActions {
    private boolean isShooting = false; // Indicates if the shooter is currently shooting
    private final Timer shootingTimer;  // Timer for continuous shooting

    public ListenerActions(SpaceInvadersUI game) {
        // Timer for shooting bullets continuously while space is pressed
        shootingTimer = new Timer(200, e -> {
            if (isShooting) {
                shootBullet(game);
            }
        });
        shootingTimer.start(); // Start the shooting timer
    }

    // Update positions of all game elements
    public void updatePositions(SpaceInvadersUI game) {
        int shooter_X_Coordinate = game.getShooter_X_Coordinate();
        int shooter_Width = game.getShooterWidth();

        // Move shooter left or right
        if (game.moveLeft && shooter_X_Coordinate > 0) {
            game.setShooter_X_Coordinate(shooter_X_Coordinate - 5);
        }
        if (game.moveRight && shooter_X_Coordinate < game.getWidth() - shooter_Width) {
            game.setShooter_X_Coordinate(shooter_X_Coordinate + 5);
        }

        // Add new falling invader boxes randomly
        if (game.random.nextInt(100) < 2) {
            int x = game.random.nextInt(game.getWidth());
            game.invaderboxes.add(game.new InvaderBox(x, 0, 40)); // Example size 40
        }

        // Move invader boxes down
        Iterator<SpaceInvadersUI.InvaderBox> invaderboxIterator = game.invaderboxes.iterator();
        while (invaderboxIterator.hasNext()) {
            SpaceInvadersUI.InvaderBox invaderbox = invaderboxIterator.next();
            invaderbox.y += 2;
            if (invaderbox.y > game.getHeight()) {
                invaderboxIterator.remove(); // Remove invader boxes that go off the screen
            }
        }

        // Move bullets up
        Iterator<SpaceInvadersUI.Bullet> bulletIterator = game.bullets.iterator();
        while (bulletIterator.hasNext()) {
            SpaceInvadersUI.Bullet bullet = bulletIterator.next();
            bullet.y -= 5;
            if (bullet.y < 0) {
                bulletIterator.remove(); // Remove bullets that go off the screen
            }
        }

        // Check for bullet-invader box collisions
        bulletIterator = game.bullets.iterator();
        while (bulletIterator.hasNext()) {
            SpaceInvadersUI.Bullet bullet = bulletIterator.next();
            invaderboxIterator = game.invaderboxes.iterator();
            while (invaderboxIterator.hasNext()) {
                SpaceInvadersUI.InvaderBox invaderbox = invaderboxIterator.next();
                if (new Rectangle(bullet.x - 5, bullet.y, 10, 10).intersects(
                        new Rectangle(invaderbox.x, invaderbox.y, invaderbox.size, invaderbox.size))) {
                    bulletIterator.remove();
                    invaderboxIterator.remove();
                    break;
                }
            }
        }
    }

    public void keyPressed(KeyEvent e, SpaceInvadersUI game) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            game.moveLeft = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            game.moveRight = true;
        }
        if (key == KeyEvent.VK_SPACE) {
            isShooting = true; // Set shooting flag to true when space is pressed
            shootBullet(game); // Shoot bullet immediately when the space bar is pressed
        }
    }

    public void keyReleased(KeyEvent e, SpaceInvadersUI game) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            game.moveLeft = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            game.moveRight = false;
        }
        if (key == KeyEvent.VK_SPACE) {
            isShooting = false; // Stop shooting when the space bar is released
        }
    }

    // Method to shoot a bullet
    private void shootBullet(SpaceInvadersUI game) {
        int shooter_X_Coordinate = game.getShooter_X_Coordinate();
        int shooter_width = game.getShooterWidth();
        int shooter_height = game.getShooterHeight();
        game.bullets.add(game.new Bullet(shooter_X_Coordinate + shooter_width / 2, game.getHeight() - shooter_height));
    }
}
