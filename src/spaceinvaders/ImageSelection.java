package spaceinvaders;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSelection {
    private Image shooterImage;
    private Image invaderImage;
    private Image bulletImage;

    public ImageSelection() {
        setGameImages();  // Set defaults when ImageSelection is created
    }


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
        shooterImage = loadImage("Shooter", "./icons/fire1.png");
        invaderImage = loadImage("Invader", "./icons/invader1.jpeg");
        bulletImage = loadImage("Bullet", "./icons/bullet1.png");
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

   private static Image loadImage(String imageType, String resourcePath) {
        try {
            File file = new File(resourcePath);
            if (file.exists()) {
                System.out.println("Loading image from file: " + resourcePath);
                return ImageIO.read(file);
            } else {
                // Try loading as a resource from the classpath for default images
                System.out.println("Loading image from classpath: " + resourcePath);
                return ImageIO.read(ImageSelection.class.getResource(resourcePath));
            }
        } catch (IOException e) {
            GameExceptions.showErrorDialog("Failed to load " + imageType + " image: " + e.getMessage());
        }
        return null;
    }
}
