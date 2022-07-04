package src.corejava.java8;

interface Drawable {
    void draw();
}

class DrawableImpl implements Drawable{
    @Override
    public void draw() {
        System.out.println("drawing..........");
    }
}

public class LambdaExample1 {

    public static void main(String[] args) {
        Drawable drawable = new DrawableImpl();
        drawable.draw();
    }
}
