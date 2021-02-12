import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContextMenu extends PopupMenu implements ActionListener {
    private MenuItem item1, item2, item3, item4, item5, item6, item7;
    private int x, y;
    ShapeGame game;
    public ContextMenu(ShapeGame game, int x, int y, int type) {
        //  Add position
        this.x = x;
        this.y = y;
        //  Populate the menu
        switch (type) {
            default -> CreateMenu();
            case 1 -> InteractMenu();
        }
        //  Add game reference and this to game
        this.game = game;
        game.add(this);
        //  Show at position
        show(game, x , y);
    }

    public void CreateMenu() {
        //  Initialize menu items
        item1 = new MenuItem("Rectangle");
        item2 = new MenuItem("Arc");
        item3 = new MenuItem("Ellipse");
        item4 = new MenuItem("Quad Curve");
        item5 = new MenuItem("Random");
        //  Add menu items to the object
        add(item1);
        add(item2);
        add(item3);
        add(item4);
        add(item5);
        //  Add action listeners
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);
    }

    public void InteractMenu() {
        //  Initialize menu items
        item6 = new MenuItem("Delete");
        item7 = new MenuItem("Randomize");
        //  Add menu items to the object
        add(item6);
        add(item7);
        //  Add action listeners
        item6.addActionListener(this);
        item7.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1) {
            System.out.println("New Rectangle");
            game.handler.add(SC.Rectangle().setPos(x, y));
            game.frameUpdate();
        }
        else if (e.getSource() == item2) {
            System.out.println("New Arc");
            game.handler.add(SC.Arc().setPos(x, y));
            game.frameUpdate();
        }
        else if (e.getSource() == item3) {
            System.out.println("New Ellipse");
            game.handler.add(SC.Ellipse().setPos(x, y));
            game.frameUpdate();
        }
        else if (e.getSource() == item4) {
            System.out.println("New Quad Curve");
            game.handler.add(SC.QuadCurve().setPos(x, y));
            game.frameUpdate();
        }
        else if (e.getSource() == item5) {
            System.out.println("New Random");
            game.handler.add(SC.Random().setPos(x, y));
            game.frameUpdate();
        }
        else if (e.getSource() == item6) {
            System.out.println("Removing");
            game.handler.remove(game.getSelection());
            game.frameUpdate();
        }
        else if (e.getSource() == item7) {
            System.out.println("New Shape");
            game.randomize();
            game.frameUpdate();
        }
    }
}
