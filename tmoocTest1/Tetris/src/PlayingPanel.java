import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class PlayingPanel extends JPanel {

    private static final int HEIGHT = 32;
    private static final int WIDTH = 10;
    public static final int BLOCKSIZE = 20;
    private static final int PANELWIDTH = (WIDTH + 1) * BLOCKSIZE;
    private static final int PANELHEIGHT = HEIGHT * BLOCKSIZE;
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;
    public static final int PLAYING = 4;
    private static int state = RUNNING;
    private static HashMap<String, int[]> rand_dic;
    private static Integer[] ceasingBlocksMaxY =

            {
                    32, 32, 32, 32, 32, 32, 32, 32, 32, 32
            };
    private GamingObject[] cellSets = {};
    private Cell[] staticCells = {};

    {
        rand_dic = RandomgetType.rand_dic;
    }

    int Index = 1;

    public void nextOne() {
        GamingObject[] new_cellSets = new CellSet[1];
        Cell[] new_cells = new Cell[4];
        int index = 0;
        int ran_block_index = (int) (Math.random() * (10 - 4));
        char[] charArr = new char[]{'T', 'O', 'L', 'S', 'Z', 'I', 'J'};
        int ran_index = (int) (Math.random() * (charArr.length) - 1);
//        int ran_index = 5;
        int[] cell_pos_arr = rand_dic.get(charArr[ran_index] + "");
        for (int i = 0; i < cell_pos_arr.length; i++) {
            if (cell_pos_arr[i] == 1) {
                if (i >= 4) {
                    new_cells[index++] = new Cell(ran_block_index + i % 4 + 1, 1);
//                    new_cells[index++] = new Cell(ran_block_index + i % 4 + 1, 5);
                } else {
//                    new_cells[index++] = new Cell(ran_block_index + i % 4 + 1, 4);
                    new_cells[index++] = new Cell(ran_block_index + i % 4 + 1, 0);
                }
            }
        }
//        new_cellSets[0] = new CellSet(ran_block_index + 1, 4, new_cells, charArr[ran_index] + "");
        new_cellSets[0] = new CellSet(ran_block_index + 1, 0, new_cells, charArr[ran_index] + "");
        cellSets = Arrays.copyOf(cellSets, cellSets.length + new_cellSets.length);
        System.arraycopy(new_cellSets, 0, cellSets, cellSets.length - new_cellSets.length, new_cellSets.length);
//        System.out.println("添加后cellset的长度为：" + cellSets.length);
    }


    public void enterAction() {
        if (state == RUNNING) {
            nextOne();
            state = PLAYING;
        }

    }

    private void addStaticCells(CellSet cellSet) {
        Cell[] new_cells = cellSet.getCells();
        this.staticCells = Arrays.copyOf(this.staticCells, staticCells.length + new_cells.length);
        System.arraycopy(new_cells, 0, this.staticCells, staticCells.length - new_cells.length, new_cells.length);
    }

    //更新当前的处于ACTIVE状态的小块（去除处于DISAPPERED状态的小块）
    //更新当前的处于ACTIVE状态的小块（去除处于DISAPPEARING状态的小块）
    //ACTIVE代表已经不能动的小块
    public void updateCeasingMaxYAction() {
        Integer[] newArr = new Integer[]{0,0,0,0,0,0,0,0,0,0};
        Integer[] hhh=newArr;
        for (Cell c : staticCells) {
            if (c.getState() == Cell.ACTIVE) {
                if (newArr[c.x] == 0 || c.y < ceasingBlocksMaxY[c.x])
                    ceasingBlocksMaxY[c.x] = c.y;
            }
        }
        if (!Arrays.toString(ceasingBlocksMaxY).equals(Arrays.toString(newArr))&&!Arrays.toString(hhh).equals(Arrays.toString(newArr)))
            ceasingBlocksMaxY = newArr;
        System.out.println("更新后的静态标记数组：" + Arrays.toString(ceasingBlocksMaxY));
    }

    //打上DISAPPEARING的标记，等待闪烁后消失
    public void disappearTagAction() {
        int[] dis_Y = {};
        boolean allTheSame = true;
        for (int i = (int) Collections.min(Arrays.asList(ceasingBlocksMaxY)); i < HEIGHT; i++) {
            int count = 0;
            for (Cell c :
                    staticCells) {
                if (c.y == i)
                    count++;
            }
            if (count > 0 && Index % 100 == 0)
                System.out.println("第" + i + "行有" + count + "个小块");
            if (count == WIDTH) {
                dis_Y = Arrays.copyOf(dis_Y, dis_Y.length + 1);
                dis_Y[dis_Y.length - 1] = i;
            }
        }
        if (dis_Y.length <= 0)
            allTheSame = false;
        else {
            Cell[] new_cells = new Cell[staticCells.length - dis_Y.length * WIDTH];
            for (int x :
                    dis_Y) {
                //将即将消失小块打上标记，在paint的时候，筛选掉这些小块
                for (Cell c : this.staticCells) {
                    if (c.y == x) {
                        c.setState(Cell.DISAPPEARING);
                    }
                }
                //将y坐标小于dis_Y的小块，向下移动一格（调用movedown函数）

                int index = 0;
                for (Cell c : this.staticCells) {
                    if (c.getState() == Cell.ACTIVE) {
                        //更新静态小块（调用updateStaticCells函数）
                        new_cells[index++] = c;
                        if (c.y < x)
                            c.stepDown();

                    }
                }
            }
            //更新静止的小块数组（删去消失的小块）
            this.staticCells = new_cells;
            System.out.println("删除消失的小块后，小块的总数为：" + this.staticCells.length);
        }
    }

    public void stepAction() {
        if (Index % 40 == 0) {
            CellSet now_cell_set = ((CellSet) cellSets[cellSets.length - 1]);
            if (now_cell_set.getStatus() == CellSet.MOVING) {
                //&&!now_cell_set.isArriveBottom(this.ceasingBlocksMaxY)
//                    System.out.println("当前中心点X坐标："+now_cell_set.getCenterX()+",Y坐标为："+now_cell_set.getCenterY());
//                    System.out.println("当前bottmY:"+now_cell_set.getBottomY());
                if (now_cell_set.getBottomY() <= (HEIGHT - 3) && !now_cell_set.isArriveBottom(this.ceasingBlocksMaxY)) {
                    now_cell_set.step();
                } else {
                    now_cell_set.setState(CellSet.STATIC);
                    //更新activeCells数组
                    //添加静止的小块
                    this.addStaticCells(now_cell_set);
                    //更新Panel对象的maxY数组
                    Cell[] nowCells = now_cell_set.getCells();
                    for (int j = 0; j < nowCells.length; j++) {
                        int now_x = nowCells[j].x;
                        if (nowCells[j].y < ceasingBlocksMaxY[now_x])
                            ceasingBlocksMaxY[now_x] = nowCells[j].y;
                    }
                    System.out.println("添加了新的cellSet");
                    System.out.println("更新后的静态标记数组：" + Arrays.toString(ceasingBlocksMaxY));
                    state = RUNNING;
                }
            }


        }
        Index++;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < cellSets.length; i++) {
            cellSets[i].paint(g);
        }
    }

    public void action() {
        KeyAdapter k = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                CellSet playing_cellset = ((CellSet) cellSets[cellSets.length - 1]);
                if ("a".equals(e.getKeyChar() + "")) {
                    //Cellset中处于Moving状态的方块向左移动一格
                    if (playing_cellset.getLeftX() > 0) {
                        playing_cellset.moveLeft();
//                        System.out.println("方块被左移动后："+playing_cellset.toString());
//                        System.out.println("左移动后centerX坐标:"+playing_cellset.getCenterX()+",centerY坐标为："+playing_cellset.getCenterY());
                    }
                }
                if ("s".equals(e.getKeyChar() + "")) {
                    //Cellset中处于Moving状态的方块向左移动一格
                    if (playing_cellset.getBottomY() <= (HEIGHT - 3)) {
                        playing_cellset.moveDown();
                    }
                }
                if ("d".equals(e.getKeyChar() + "")) {
                    //Cellset中处于Moving状态的方块向左移动一格
                    if (playing_cellset.getRightX() < WIDTH) {
                        playing_cellset.moveRight();
                    }
                }
                if (e.getKeyCode() == 10) {
                    //Cellset中处于Moving状态的方块顺时针旋转90度
                    //注意如果方块的类型是O型，不需要旋转
                    playing_cellset.addTheta(90);
                    playing_cellset.rotate();
                }
            }

        };
        this.requestFocus();
        this.addKeyListener(k);
        Timer timer = new Timer();
        int intervel = 6;
        timer.schedule(new TimerTask() {
            public void run() {
                if (state == RUNNING || state == PLAYING) {
//                if (state == RUNNING ) {
                    enterAction();
                    stepAction();
                    disappearTagAction();
                    updateCeasingMaxYAction();
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
        frame.setSize(PANELWIDTH, PANELHEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.action();
    }
}
