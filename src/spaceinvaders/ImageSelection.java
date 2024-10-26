package spaceinvaders;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSelection {
    private Image shooterImage;
    private Image invaderImage;
    private Image bulletImage;


    public Image getShooterImage() {
        return shooterImage;
    }


    public Image getInvaderImage() {
        return invaderImage;
    }
 

    public Image getBulletImage() {
        return bulletImage;
    }

    public void setGameImages() {   // links need to be changed
        shooterImage = loadImage("invader", "./resources/ShooterImage.png");
        invaderImage = loadImage("shooter", "./resources/InvaderImage.png");
        bulletImage = loadImage("bullet", "./resources/InvaderImage.png");
    }
    // set images is different for each as we have option to set each image differently


    public void setShooterImage(String path) {
        this.shooterImage = loadImage("Shooter", path);
    }

    public void setInvaderImage(String path) {
        this.invaderImage = loadImage("Invader", path);
    }

    public void setBulletImage(String path) {
        this.bulletImage = loadImage("Bullet", path);
    }

    private static Image loadImage(String imageType, String resourcePath) {  // no need of a dialogbar will set the menubar separately.
        try {
            return ImageIO.read(ImageSelection.class.getResource(resourcePath));
        } catch (IOException e) {
            GameExceptions.showErrorDialog("Failed to load default " + imageType + " image: " + e.getMessage());
        }
        return null;
    }
}
