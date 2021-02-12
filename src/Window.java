import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(int width, int height, String title, ShapeGame game) {
        setTitle(title);
        //  jFrame sizes
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));

        //  Closing, resizing, location
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        add(game);

        setVisible(true);
    }
}
