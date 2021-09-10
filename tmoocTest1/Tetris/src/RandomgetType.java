import java.util.HashMap;

public class RandomgetType {
    public static HashMap<String,int[]> rand_dic=new HashMap<String,int[]>();
    private static int[] arr1=new int[]{1,1,1,0,0,1,0,0};//T型
    private static int[] arr2=new int[]{1,1,0,0,1,1,0,0};//正方形
    private static int[] arr3=new int[]{1,1,1,0,1,0,0,0};//L型
    private static int[] arr4=new int[]{1,1,1,1,0,0,0,0};//I型
    private static int[] arr5=new int[]{1,1,0,0,0,1,1,0};//Z型
    private static int[] arr6=new int[]{0,1,1,0,1,1,0,0};//S型
    private static int[] arr7=new int[]{1,1,1,0,0,0,1,0};//J型
    static{

        rand_dic.put("T",arr1);
        rand_dic.put("O",arr2);
        rand_dic.put("L",arr3);
        rand_dic.put("I",arr4);
        rand_dic.put("Z",arr5);
        rand_dic.put("S",arr6);
        rand_dic.put("J",arr7);
    }
}
