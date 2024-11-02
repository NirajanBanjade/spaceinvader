// File: ShooterImage.java
package spaceinvaders;

public class ShooterImage implements ImageType {
    @Override
    public String getDisplayName() {
        return "Shooter";
    }

    @Override
    public String[] getImageNames() {
        return new String[]{"fire1.png", "fire2.png", "fire3.png"};
    }
}

