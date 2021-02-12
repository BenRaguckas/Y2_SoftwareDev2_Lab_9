import java.awt.*;

public class ColorShape{
    public double x, y;
    private Color color;
    private Shape shape;

    public ColorShape() {}

    public ColorShape(Color color, Shape shape) {
        this.color = color;
        this.shape = shape;
    }

    public ColorShape(Color color, Shape shape, double x, double y) {
        this.color = color;
        this.shape = shape;
        this.x = x;
        this.y = y;
    }

    public ColorShape setPos(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    //  Automatic getters and setters

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}