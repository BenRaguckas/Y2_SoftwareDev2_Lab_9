import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
    //  Variables for mouse control Previous x/y, drag x/y, margin for click
    private int px, py, dx, dy, margin = 2;
    //  Time tracker
    private long lastTime;
    //  Has object been clicked
    private boolean object = false;

    private boolean drag = false;
    private ShapeGame game;

    public MouseInput(ShapeGame game) {
        this.game = game;
        lastTime = System.currentTimeMillis();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            game.LMB(e);
        else if (e.getButton() == MouseEvent.BUTTON3)
            game.RMB(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //  Bind mouse interaction to button 1 - 3
        if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
            px = e.getX();
            py = e.getY();
        }
        if (game.getAt(px, py)) {
            object = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //  Make sure mouse has moved and within the margin
        if (!drag && ( Math.abs( px - e.getX() ) > margin || Math.abs( py - e.getY() ) > margin ) && ( e.getX() != px || e.getY() != py )) {
            if (e.getButton() == MouseEvent.BUTTON1)
                game.LMB(e);
            else if (e.getButton() == MouseEvent.BUTTON3)
                game.RMB(e);
        }
        //  Stop dragging if MBL or MBR is released
        if (drag && ( e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3 )) {
            drag = false;
            object = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //  If mouse leaves margin box
        if (!drag && ( Math.abs( px-e.getX() ) > margin || Math.abs( py-e.getY() ) > margin )) {
            drag = true;
            dx = e.getX();
            dy = e.getY();
        }
        //  If mouse is dragged send drag update and limit updates
        if (drag && object && System.currentTimeMillis() - lastTime > 17) {
            //  Update timer
            lastTime = System.currentTimeMillis();
            game.MDrag(e.getX() - dx, e.getY() - dy);
            //  Update after sending update
            dx = e.getX();
            dy = e.getY();
        }
    }

    //  UNUSED
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}
