// File: BulletImage.java
package spaceinvaders.ImageLoadFile;

import spaceinvaders.ImageType;

public class BulletImage implements ImageType {
    @Override
    public String getDisplayName() {
        return "Bullet";
    }

    @Override
    public String[] getImageNames() {
        return new String[]{"bullet1.png", "bullet2.png", "bullet3.png"};
    }
}


