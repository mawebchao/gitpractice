package AirWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.TimerTask;
import java.util.Timer;

public class World extends JPanel {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;
    private static final int START = 0;
    private static final int RUNNING = 1;
    private static final int PAUSE = 2;
    private static final int GAME_OVER = 3;
    private static int state = START;
    private static BufferedImage start;
    private static BufferedImage gameover;
    private static BufferedImage pause;
    private FlyingObject[] bullets = {};
    private FlyingObject[] enemies = {};
    private Hero hero = new Hero();

    static {
        start = Images.start;
        gameover = Images.gameover;
        pause = Images.pause;
    }

    public int score = 0;


    public FlyingObject nextOne(){
        FlyingObject return_obj=null;
        int type=(int)(Math.random()*3+1);
        switch (type){
            case 1:
                return_obj= new Airplane();
                break;
            case 2:
                return_obj=new BigAirplane();
                break;
            case 3:
                return_obj=new Bee();
                break;
        }
        return return_obj;
    }
    int enterIndex=1;
    public void enterAction(){
        if(enterIndex%30==0){
            FlyingObject new_enemy=nextOne();
            if(new_enemy!=null){
                enemies=Arrays.copyOf(enemies,enemies.length+1);
                enemies[enemies.length-1]=new_enemy;
            }

        }
        enterIndex++;
    }
    public void stepAction() {
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].step();
        }
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].step();
        }
    }
    int shootIndex=1;
    public void shootAction() {
        if(shootIndex%30==0){
            Bullet[] bs = hero.shoot();
            int original_length= bullets.length;
            bullets=Arrays.copyOf(bullets, bullets.length + bs.length);
            for (int i = 0; i < bs.length; i++) {
                bullets[original_length + i] = bs[i];
            }
        }
        shootIndex++;
    }
    public void bangAction(){
        for(int i=0;i<bullets.length;i++){
            FlyingObject now_bullet=bullets[i];
            if(now_bullet.isLife()){
                for(int j=0;j<enemies.length;j++){
                    FlyingObject now_enemy=enemies[j];
                    if(now_enemy.isLife()&&now_bullet.hit(now_enemy)){
                        now_enemy.goDead();
                        now_bullet.goDead();
                        if(now_enemy instanceof Enemy){
                            score+=((Enemy) now_enemy).getScore();
                        }else if(now_enemy instanceof Award){
                            switch (((Award) now_enemy).getType()){
                                case 0:
                                    hero.addDoubleFire();
                                    break;
                                case 1:
                                    hero.addlife();
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    public void crashAction(){
        for(int j=0;j<enemies.length;j++){
            FlyingObject now_enemy=enemies[j];
            if(now_enemy.isLife()&&hero.hit(now_enemy)){
                now_enemy.goDead();
                hero.subLife();
                hero.clearDoubleFire();
            }
        }
    }
    public void removeAction(){
        FlyingObject[] now_enemies=new FlyingObject[enemies.length];
        int index=0;
        for(int i=0;i< enemies.length;i++){
            if(!enemies[i].isRemove())
                now_enemies[index++]=enemies[i];
        }
        enemies=Arrays.copyOf(now_enemies,index);
        index=0;
        FlyingObject[] now_bullets=new FlyingObject[bullets.length];
        for(int i=0;i< bullets.length;i++){
            if(!bullets[i].isRemove())
                now_bullets[index++]=bullets[i];
        }
        bullets=Arrays.copyOf(now_bullets,index);
    }
    public void gameoverCheckAction(){
        if(hero.getLives()<=0){
            state=GAME_OVER;
        }
    }
    public void action() { //启动执行
        MouseAdapter l = new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                if (state == RUNNING) {
                    int x = e.getX();
                    int y = e.getY();
                    hero.moveTo(x, y);
                }
            }

            public void mouseClicked(MouseEvent e) {
                switch (state) {
                    case START:
                        state = RUNNING;
                        break;
                    case GAME_OVER:
                        score = 0;
                        hero = new Hero();
                        enemies = new FlyingObject[0];
                        state = START;
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
                    shootAction();
                    bangAction();
                    stepAction();
                    removeAction();
                    crashAction();
                    gameoverCheckAction();
                }
                repaint();
            }
        }, intervel, intervel);
    }

    public void paint(Graphics g) {
        super.paint(g);
        hero.paint(g);
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].paint(g);
        }
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].paint(g);
        }
        g.drawString("SCORE:"+score, 10, 25);
        g.drawString("life:"+ hero.getLives(), 10, 45);
        switch (state) {
            case START:
                g.drawImage(start, 0, 0, null);
                break;
            case GAME_OVER:
                g.drawImage(gameover, 0, 0, null);
                break;
            case PAUSE:
                g.drawImage(pause, 0, 0, null);
                break;
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        Airplane airplane = new Airplane();
        world.enemies = Arrays.copyOf(world.enemies, world.enemies.length + 1);
        world.enemies[world.enemies.length - 1] = airplane;
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        world.action();
    }
}
