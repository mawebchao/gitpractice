import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


public class PlayingPanel extends JPanel {
    private static int LEFTPRESSED = 0;
    public static final int WIDTH = 658;
    public static final int HEIGHT = 400;
    public static final int TOP = 0;
    public static final int BOTTOM = 1;
    private Bird myBird = new Bird();
    private GameObject[] columns = {};
    private static GameObject background;
    private static BufferedImage start;
    private static BufferedImage pause;
    private static BufferedImage gameover;
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;
    private static int state = START;

    static {
        background = new Background();
        start = Images.start;
        pause = Images.pause;
        gameover = Images.game_over;
    }

    int Index = 1;

    public void enterAction() {
        if (Index % 100 == 0) {
            GameObject[] new_column_pair = new Column[2];
            int minYCut = (int) (Math.random() * (PlayingPanel.HEIGHT - 300) + 60);
            new_column_pair[0] = new Column(PlayingPanel.TOP, minYCut);
            new_column_pair[1] = new Column(PlayingPanel.BOTTOM, minYCut);
            columns = Arrays.copyOf(columns, columns.length + 2);
            System.arraycopy(new_column_pair, 0, columns, columns.length - new_column_pair.length, new_column_pair.length);
        }
        Index++;
    }

    public void paint(Graphics g) {
        super.paint(g);
        background.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < columns.length; i++) {
            columns[i].paint(g);
        }
        double alpha = myBird.getAlpha() * Math.PI;
        System.out.println("旋转角：" + alpha / Math.PI);
        g2.rotate(alpha, myBird.x + myBird.width / 2, myBird.y + myBird.height / 2);
        myBird.paint(g);

        switch (state) {
            case START:
//                g.drawImage(start,0,0,null);
                break;
            case GAMEOVER:
                g.drawImage(gameover, 150, -80, null);
                break;
        }
    }

    public void hitAction() {
        for (int i = 0; i < columns.length; i++) {
            if(Index>=209){
                if (columns[i].hit(myBird)) {
                    state = GAMEOVER;
                }
            }

        }
    }

    public void stepAction() {
        background.step();
        myBird.step(0);
        for (int i = 0; i < columns.length; i++) {
            columns[i].step();
        }
    }

    public void action() {
        MouseAdapter l = new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                switch (state) {
                    case START:
                        state = RUNNING;
                        break;
                    case GAMEOVER:
                        state = START;
                        break;
                    case RUNNING:
                        myBird.setVelocity(-5);
                        myBird.setAlpha(-0.2);
                        break;
                }
            }


            public void mouseExited(MouseEvent e) {
                if (state == RUNNING) {
                    state = PAUSE;
                }
            }

            public void mouseEntered(MouseEvent e) {
                if (state == PAUSE) {
                    state = RUNNING;
                }
            }
        };
        this.addMouseListener(l);
        this.addMouseMotionListener(l);
        Timer timer = new Timer();
        int intervel = 6;
        timer.schedule(new TimerTask() {
            public void run() {
                if (state == RUNNING) {
                    enterAction();
                    stepAction();
                    hitAction();
                }
                repaint();
            }
        }, intervel, intervel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PlayingPanel panel = new PlayingPanel();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.action();
    }
}
