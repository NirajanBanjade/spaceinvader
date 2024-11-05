// File: Menu.java
package spaceinvaders;

import javax.swing.*;

import spaceinvaders.ImageLoadFile.BulletImage;
import spaceinvaders.ImageLoadFile.InvaderImage;
import spaceinvaders.ImageLoadFile.ShooterImage;

import java.util.Arrays;

public class Menu {
    private final MenuFactory menuFactory;

    public Menu(MenuFactory menuFactory) {
        this.menuFactory = menuFactory;
    }

    public JMenuBar createMenuBar() {
        return menuFactory.createMenuBar(Arrays.asList(
            new ShooterImage(),
            new InvaderImage(),
            new BulletImage()
        ));
    }
}
