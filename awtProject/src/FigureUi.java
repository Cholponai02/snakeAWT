import java.awt.*;
public class FigureUi extends Frame
{
    public FigureUi()  // конструктор
    {
        setSize(800,400);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.RED);
        g.drawLine(200,100,300,200);
        g.setColor(Color.BLUE);
        g.drawLine(300,200,200,300);
        g.setColor(Color.GREEN);
        g.drawLine(200,300,100,200);
        g.setColor(Color.BLACK);
        g.drawLine(100,200,200,100);

        g.setColor(Color.ORANGE);
        g.drawRect(100,200,200,100);
        g.setColor(Color.ORANGE);
        g.fillRect(100,0,200,100);

        g.setColor(Color.GRAY);
        g.drawOval(300,200,200,100);
        g.setColor(Color.ORANGE);
        g.fillOval(300,0,200,100);
    }
}
