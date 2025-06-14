import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JFrame {
    public SnakeGame(){ // конструктор
        setTitle("Змейка");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); //запрещаем изменения размера окна
        setLocationRelativeTo(null);

        setVisible(true);
    }

}
class GamePanel extends JPanel implements ActionListener
{
    private final int SIZE = 600;//Размер комнаты
    private final int DOT_SIZE = 20; //один сегмент змейки
    private final int ALL_DOTS = 900; //макс длина змейки

    private int[] x = new int[ALL_DOTS]; // массив для хранения координат змейки
    private int[] y = new int[ALL_DOTS]; // массив для хранения координат змейки
    private int dots = 3; // начальная длина змейки

    private int appleX, appleY; // координаты ЕДЫ
    private  Timer timer;
    private Random random = new Random();
    private boolean left = false, right = true, up = false, down = false;
    private boolean inGame = true;

    public GamePanel(){
        setBackground(Color.GREEN);
        setFocusable(true); // фокус для обработкинажатия
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_LEFT && !right){
                    left = true;
                    up = down = false;
                }
                else if(key == KeyEvent.VK_RIGHT && !left){
                    right = true;
                    up = down = false;
                }
                else if(key == KeyEvent.VK_UP && !down){
                    up = true;
                    left = right = false;
                }
                else if(key == KeyEvent.VK_DOWN && !up){
                    down = true;
                    left = right = false;
                }
            }
        });
    }

    private void gameOver(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD,30));
        g.drawString("Игра окончена",300,300);
    }

    private void startGame(){
        // начальное положение змейки
        for(int i = 0; i < dots; i++){
            x[i] = - i * DOT_SIZE;
            y[i] = 100;
        }
        //Размещение первого яблока
        timer = new Timer(150,this);
        timer.start();
    }

    private void spawnApple(){
        appleX = random.nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
        appleY = random.nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
    }

    private void checkApple(){
        if(x[0] == appleX && y[0] == appleY){
            dots++;            /* увелич.длину змейки*/
            spawnApple();
        }
    }

    private void checkCollision(){
        // столкновение с границами
        if(x[0] < 0 || x[0] >= SIZE || y[0] < 0 || y[0] >= SIZE)
        {
            inGame = false;
            timer.stop();
        }
        //столкновение с телом
        for(int i = 1; i < dots; i++) // обращие к каждое точке змейки
        {
            if(x[0] == x[i] || y[0] == y[i])
            {
                inGame = false;
                timer.stop();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    protected void move(){
        dom();
    }

    private void dom(){
        move();
    }


}