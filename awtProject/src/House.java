import java.awt.*;
public class House extends Frame
{
    public House()
    {
        setSize(800,500);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.ORANGE);
        g.fillRect(100,150,200,150);

        g.setColor(Color.RED);
        int[] xPoints = {100,200,300};
        int[] yPoints = {150,50,150};
        g.fillPolygon(xPoints,yPoints,3);

        g.setColor(Color.YELLOW);
        g.fillArc(150,100,100,70,0,180);
    }
}
