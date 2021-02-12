import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class Handler {
    LinkedList<ColorShape> shapes = new LinkedList<>();
    public Handler() {

    }
    public void draw(Graphics2D g) {
        for (ColorShape cs : shapes) {
            //  Translate draw position
            g.translate(cs.x, cs.y);
            g.setColor(cs.getColor());
            g.draw(cs.getShape());
            g.fill(cs.getShape());
            //  Reset translation
            g.translate(-cs.x, -cs.y);
        }
    }

    public void add(ColorShape cs) {
        shapes.add(cs);
    }
    public void remove(ColorShape cs) {
        shapes.remove(cs);
    }
}
