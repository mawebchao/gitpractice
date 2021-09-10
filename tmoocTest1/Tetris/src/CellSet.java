import Utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashMap;

public class CellSet extends GamingObject {
    public static final int MOVING = 0;
    public static final int STATIC = 1;

    public int getLeftX() {
        return leftX;
    }

    public void setLeftX(int leftX) {
        this.leftX = leftX;
    }

    public int getRightX() {
        return rightX;
    }

    public void setRightX(int rightX) {
        this.rightX = rightX;
    }

    private int leftX;
    private int rightX;

    public int getStatus() {
        return this.status;
    }

    public boolean isArriveBottom(Integer[] ceasingBlocksMaxY) {
        boolean return_bool = false;
        Cell[] nowCells = this.cells;
        for (int j = 0; j < nowCells.length; j++) {
            if ((nowCells[j].y + 1) == ceasingBlocksMaxY[nowCells[j].x]) {
                return_bool = true;
                break;
            }
        }
        return return_bool;
    }

    public void setState(int newState) {
        this.status = newState;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    private String type;

    public int getBottomY() {
        return bottomY;
    }

    private int bottomY;

    public Cell[] getCells() {
        return cells;
    }

    private Cell[] cells = new Cell[4];


    public void addTheta(int theta) {
        this.theta += theta;
        System.out.println("当前转角位：" + this.theta);
    }

    private int status;
    private int theta;

    public CellSet(int x, int y, Cell[] myCells, String type) {
        this.x = x;
        this.y = y;
        this.cells = myCells;
        this.centerX = this.x + 2;
        this.centerY = this.y + 1;
        this.theta = 0;
        this.status = MOVING;
        this.type = type;
        this.bottomY = (type.equals("I") ? ((int) centerY) : ((int) centerY + 1));
        this.leftX = x;
        switch (type) {
            case "T":
            case "L":
            case "S":
            case "Z":
            case "J":
                rightX = (int) centerX + 1;
                break;
            case "I":
                rightX = (int) centerX + 2;
                break;
        }
        System.out.println("类型为：" + type + ",方块被创建，当前leftX：" + leftX + ",rightX为：" + rightX);
        System.out.println(this.toString());
    }

    public void updateLeftRightX() {
        switch (type) {
            case "T":
            case "L":
            case "S":
            case "Z":
            case "J":
                if (theta % 180 == 90) {
                    leftX = (int) centerX - 1;
                    rightX = (int) centerX + 1;
                } else if (theta % 360 == 0) {
                    leftX = (int) centerX - 2;
                    rightX = (int) centerX + 1;
                } else if (theta % 360 == 180) {
                    leftX = (int) centerX - 1;
                    rightX = (int) centerX + 2;
                }
                break;
            case "I":
                if (theta % 360 == 90) {
                    leftX = (int) centerX;
                    rightX = (int) centerX + 1;
                } else if (theta % 360 == 270) {
                    leftX = (int) centerX - 1;
                    rightX = (int) centerX;
                } else if (theta % 180 == 0) {
                    leftX = (int) centerX - 2;
                    rightX = (int) centerX + 2;
                }
                break;
        }

    }

    @Override
    public String toString() {
        return "当前CellSet的cells数组坐标为：{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }

    private HashMap<String, Double> getRotatedXY(Double x, Double y) {
        HashMap<String, Double> new_xys = new HashMap<String, Double>();
        HashMap<String, Double> map = new HashMap<String, Double>() {
            {
                put("X", 0.0);
                put("Y", 0.0);
            }
        };
        map.put("X", x);
        map.put("Y", y);
        HashMap<String, Double> xy1 = Utils.getRotatedXY(Math.toRadians(90), this.centerX, this.centerY, map);
        new_xys.put("X", xy1.get("X"));
        new_xys.put("Y", xy1.get("Y"));
        return new_xys;
    }

    @Override
    public void rotate() {
        System.out.println("当前方块被旋转");

        //重新计算底部bottomY
        switch (type) {
            case "T":
            case "L":
            case "S":
            case "Z":
            case "J":
                if (theta % 270 == 0)
                    bottomY = (int) this.centerY + 2;
                else
                    bottomY = (int) this.centerY + 1;
                break;
            case "I":
                if (theta % 90 == 0 && theta % 180 != 0)
                    bottomY = (int) this.centerY + 2;
                else
                    bottomY = (int) this.centerY + 1;
                break;
        }
        updateLeftRightX();
        for (int i = 0; i < this.cells.length; i++) {
            Cell nowCell = cells[i];
            double now_centerX = nowCell.getCenterX();
            double now_centerY = nowCell.getCenterY();
//            System.out.println("当前小块中心X坐标："+now_centerX+",Y坐标："+now_centerY);
            HashMap<String, Double> rotatedXY = this.getRotatedXY(now_centerX, now_centerY);
            nowCell.x = rotatedXY.get("X").intValue();
            nowCell.y = rotatedXY.get("Y").intValue();
            nowCell.centerX = rotatedXY.get("X");
            nowCell.centerY = rotatedXY.get("Y");
//            System.out.println("当前小块中心X坐标："+nowCell.centerX +",Y坐标："+nowCell.centerY);
        }
        System.out.println("当前中心点X坐标：" + getCenterX() + ",Y坐标为：" + getCenterY());

    }

    @Override
    public void stepDown() {
//        System.out.println("方块被操控向下移动一格");
//        System.out.println("移动前bottomY："+bottomY);
        super.stepDown();
        this.centerY += 1;
        this.bottomY += 1;
//        System.out.println("移动后bottomY："+bottomY);
    }

    @Override
    public void stepLeft() {
        super.stepLeft();
        this.centerX -= 1;
    }

    @Override
    public void stepRight() {
        super.stepRight();
        this.centerX += 1;
    }

    public void moveLeft() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].stepLeft();
        }
        this.stepLeft();
        updateLeftRightX();
    }

    public void moveRight() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].stepRight();
        }
        this.stepRight();
        updateLeftRightX();
    }

    public void moveDown() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].stepDown();
        }
        this.stepDown();
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }

    @Override
    public void step() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].step();
        }
        this.centerY += step;
        this.bottomY += step;

    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].getState() == Cell.ACTIVE)
                cells[i].paint(g);
        }
    }

}
