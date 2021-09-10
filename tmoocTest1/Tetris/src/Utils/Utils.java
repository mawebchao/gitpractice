package Utils;

import java.util.HashMap;

public class Utils {
    public static boolean isInside(double x1, double x4, double y1, double y4, double x, double y)
    {
        if(x <= x1) return false;
        if(x >= x4) return false;
        if(y <= y1) return false;
        if(y >= y4) return false;
        return true;
    }

    public static boolean isInside(HashMap<String, Double> xys, double x, double y)
    {
        double x1=xys.get("X1");
        double y1=xys.get("Y1");
        double x2=xys.get("X2");
        double y2=xys.get("Y2");
        double x3=xys.get("X3");
        double y3=xys.get("Y3");
        double x4=xys.get("X4");
        double y4=xys.get("Y4");
        if(x1 == x3) return isInside(x1, x4, y1, y4, x, y);
        double l = y4 - y3;
        double k = x4 - x3;
        double s = Math.sqrt(k * k + l * l);
        double sin = -l / s;
        double cos = k / s;
        double x1r = cos * x1 + sin * y1;
        double y1r = -x1 * sin + y1 * cos;
        double x4r = cos * x4 + sin * y4;
        double y4r = -x4 * sin + y4 * cos;
        double xr = cos * x + sin * y;
        double yr = -x * sin + y * cos;
        return isInside(x1r, x4r, y1r, y4r, xr, yr);
    }
    public static HashMap<String, Double> getRotatedXY(double alpha,double centerX,double centerY,HashMap<String, Double> old_XY){
        HashMap<String,Double> return_map=new HashMap<String,Double>();
        double oldX=old_XY.get("X");
        double oldY=old_XY.get("Y");
        return_map.put("X",(oldX-centerX)*Math.cos(alpha)-(oldY-centerY)*Math.sin(alpha)+centerX);
        return_map.put("Y",(oldX-centerX)*Math.sin(alpha)+(oldY-centerY)*Math.cos(alpha)+centerY);
        return return_map;
    }
}
