import java.awt.*;
public class DrawUi extends Frame
{
    public DrawUi()
    {
        setSize(400,600);
        setVisible(true);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.drawLine(100,100,150,150);
        g.drawRect(50,50,100,200);
        g.fillRect(200,50,50,50);
        g.drawOval(50,200,100,50);
        g.fillOval(50,100,100,50);


    }
}
