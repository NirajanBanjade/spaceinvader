package spaceinvaders;

import java.awt.*;

public class PaintingActions {

    public PaintingActions() {
   
    }

    public void drawShooter(Graphics g, SpaceInvadersUI game) {
        Image shooter_image = game.imageSelection.getShooterImage();
        int shooter_height = game.getShooterHeight();
        int shooter_width = game.getShooterWidth();
        int shooter_X_Coordinate = game.getShooter_X_Coordinate();
        int shooter_Y_Coordinate = game.getHeight() - shooter_height;

        g.drawImage(shooter_image, shooter_X_Coordinate, shooter_Y_Coordinate, shooter_width, shooter_height, game);

    }

    public void drawInvaders(Graphics g, java.util.List<SpaceInvadersUI.InvaderBox> invaderboxes, Image invaderboxImage,
            SpaceInvadersUI game) {
        for (SpaceInvadersUI.InvaderBox invaderbox : invaderboxes) {
            g.drawImage(invaderboxImage, invaderbox.x, invaderbox.y, invaderbox.size, invaderbox.size, game);
        }
    }

    public void drawBullets(Graphics g, java.util.List<SpaceInvadersUI.Bullet> bullets, Image bulletImage) {
        for (SpaceInvadersUI.Bullet bullet : bullets) {
            g.drawImage(bulletImage, bullet.x - 5, bullet.y, 10, 10, null); 
        }
        // it will provide default as bullet1.png or we can set it to custom.
    }
}
