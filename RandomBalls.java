import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class RandomBalls extends JFrame {

    ArrayList<Ball> balls;
    final String TITLE_OF_PROGRAM = "Random balls";
    final int WINDOW_WIDTH = 650;
    final int WINDOW_HEIGHT = 650;
    final Color[] COLORS = {Color.red, Color.green, Color.blue};
    final int COUNT_BALLS = 50;

    public static void main(String[] args){
        new RandomBalls();
    }
    Random random;

    public RandomBalls(){                //конструктор
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        random = new Random();
        balls = new ArrayList<>();

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.setPreferredSize(
                new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                canvas.repaint();
            }
        });

        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    class Ball{
        int x, y, d;
        Color color;

        Ball(int x, int y, int d, Color color){
            this.x = x;
            this.y = y;
            this.d = d;
            this.color = color;
            for (int i = 0; i < COUNT_BALLS; i++) {
                addBall();
            }
        }

        void paint(Graphics g){
            g.setColor(color);
            g.fillOval(x, y, d, d);
            g.setColor(Color.black);
            g.drawOval(x, y, d, d);
        }

        void addBall(){
            int d = random.nextInt(20) + 60;
            int x = random.nextInt(WINDOW_WIDTH - d);
            int y = random.nextInt(WINDOW_HEIGHT - d);
            Color color = COLORS[random.nextInt(COLORS.length)];
            balls.add(new Ball(x, y, d, color));
        }
    }

    class Canvas extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            for (int i = 0; i < 100; i++) {
                int d = random.nextInt(20) + 60;
                int x = random.nextInt(WINDOW_WIDTH - d);
                int y = random.nextInt(WINDOW_HEIGHT - d);
                Color color = COLORS[random.nextInt(COLORS.length)];
                g.setColor(color);
                g.fillOval(x, y, d, d);
                g.setColor(Color.black);
                g.drawOval(x, y, d, d);

            }
        }
    }
}
