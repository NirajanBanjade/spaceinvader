// File: InvaderImage.java
package spaceinvaders;

public class InvaderImage implements ImageType {
    @Override
    public String getDisplayName() {
        return "Invader";
    }

    @Override
    public String[] getImageNames() {
        return new String[]{"invader1.jpeg", "invader2.jpeg", "invader3.jpeg"};
    }
}

