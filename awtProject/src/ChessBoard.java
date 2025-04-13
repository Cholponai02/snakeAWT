import java.awt.*;
public class ChessBoard extends Canvas
{
    public void paint(Graphics g)
    {
        int tileSize = 50; // размер одной клетки
        int boardSize = 8; //8X8
        for(int row = 0; row < boardSize; row++){
            for(int col = 0; col < boardSize; col++){
                int x = col * tileSize;
                int y = row * tileSize;
                if((row+col) % 2 == 0){
                    g.setColor(Color.WHITE);
                }
                else{
                    g.setColor(Color.BLACK);
                }
                g.fillRect(x,y,tileSize,tileSize);
            }
        }
    }
    public static void main(String[] args)
    {
        Frame frame = new Frame();
        ChessBoard canvas = new ChessBoard();
        frame.add(canvas);
        frame.setSize(420,440);
        frame.setVisible(true);
    }
}


