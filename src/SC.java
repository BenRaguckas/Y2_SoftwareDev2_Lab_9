import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

//  ShapeCreator
public class SC {
    public static Color RandomColor() {
        return new Color( (int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255) );
    }
    //  Rectangle creation
    public static ColorShape Rectangle() {
        return Rectangle(Math.random() * 128 + 32, Math.random() * 128 + 32);
    }
    public static ColorShape Rectangle(double w, double h) {
        return new ColorShape(RandomColor(),new Rectangle2D.Double(0, 0, w, h));
    }
    //  Arc creation
    public static ColorShape Arc() {
        return Arc(Math.random() * 128 + 32, Math.random() * 128 + 32, Math.random() * 360, Math.random() * 360);
    }
    public static ColorShape Arc(double w, double h, double s, double e) {
        return new ColorShape(RandomColor(), new Arc2D.Double(0, 0, w, h, s, e, (int) (Math.random() * 3)));
    }
    //  Ellipse creation
    public static ColorShape Ellipse() {
        return Ellipse(Math.random() * 128 + 32, Math.random() * 128 + 32);
    }
    public static ColorShape Ellipse(double w, double h) {
        return new ColorShape(RandomColor(), new Ellipse2D.Double(0, 0, w, h));
    }
    //  Quad Curve
    public static ColorShape QuadCurve() {
        return QuadCurve(Math.random() * 128 + 32, Math.random() * 128 + 32);
    }
    public static ColorShape QuadCurve(double w, double h) {
        return new ColorShape(RandomColor(), new QuadCurve2D.Double(0, Math.random() * w, Math.random() * h, 0, w, h) );
    }
    //  Random
    public static ColorShape Random() {
        switch ((int)( Math.random() * 4 )) {
            default -> {    return Rectangle(); }
            case 1 -> { return Arc(); }
            case 2 -> { return Ellipse(); }
            case 3 -> { return QuadCurve(); }
        }
    }
}
