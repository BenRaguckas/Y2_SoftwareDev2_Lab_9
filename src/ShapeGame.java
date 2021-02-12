import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

public class ShapeGame extends Canvas{
    //  Display handler
    public Handler handler;
    //  Mouse input object
    private MouseInput mouse;
    //  Selected shape
    private ColorShape selection = null;
    //  Start the game
    public static void main(String[] args) {
        ShapeGame sg = new ShapeGame();
    }
    //  Initialize new instance of the game
    public ShapeGame() {
        //  Create mouse and listeners
        mouse = new MouseInput(this);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        //  Create handler for rendering
        handler = new Handler();
        //  Create window
        Window win = new Window(640, 480, "ShapeGame", this);
        //  create initial BufferStrategy
        this.createBufferStrategy(3);
    }

    public boolean getAt(double x, double y) {
        //  Reverse loop through all the shapes
        for (int i = handler.shapes.size() - 1; i >= 0; i--) {
            ColorShape cs = handler.shapes.get(i);
            if (cs.getShape().contains(x - cs.x, y - cs.y)) {
                selection = cs;
                return true;
            }
        }
        selection = null;
        return false;

    }

    //  Left mouse Button click
    public void LMB(MouseEvent e) {
        if (getAt(e.getX(), e.getY())) {
            selection.setColor(SC.RandomColor());
            frameUpdate();
        }
    }
    //  mouse drag
    public void MDrag(double x, double y) {
        if (selection != null) {
            selection.x += x;
            selection.y += y;
            frameUpdate();
        }
    }
    //  Right Mouse Button Click
    public void RMB(MouseEvent e) {
        //  Check if an object was clicked
        if (getAt(e.getX(), e.getY())) {
            new ContextMenu(this, e.getX(), e.getY(), 1);
        }
        else    //  Create default menu
            new ContextMenu(this, e.getX(), e.getY(), 0);
    }

    public void randomize() {
        handler.shapes.set(handler.shapes.indexOf(selection), SC.Random().setPos(selection.x, selection.y));
    }


    public void frameUpdate() {
        //  Initialize / create new BufferStrategy
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        //  Cast to Graphics2D
        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        //  Add background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        handler.draw(g);

        g.dispose();
        bs.show();
    }

    //  Auto generated getters / setters
    public ColorShape getSelection() {
        return selection;
    }

    public void setSelection(ColorShape selection) {
        this.selection = selection;
    }
}