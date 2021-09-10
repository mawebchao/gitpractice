package cn.tedu.collection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;


public class MyUtils {
	/**
	 * 将源文件的内容通过IO流传送给目标文件
	 *
	 * @param from 源文件
	 * @param to 目标文件
	 */
	public static void copy(File from, File to) {
		InputStream in = null;// 定义在整个方法中都生效的字节输入流对象,注意是局部变量,需要初始化,对象的默认值是null
		OutputStream out = null;// 定义在整个方法中都生效的字节输出流对象,注意是局部变量,需要初始化,对象的默认值是null
		try {
			// 1.读取from文件--操作文件的是字节输入流
			in = new BufferedInputStream(new FileInputStream(from));
			// 2.写出到to文件--操作文件的是字节输出流
			out = new BufferedOutputStream(new FileOutputStream(to));

			// 3.边读边写
			int b = 0;// 定义变量b,记录读取到的数据
			/** 需求:想要实现批量读取,使用的是read(byte[] b)重载的形式,可以按照数组的方式来读 */
			/** 可以自定义数组,长度建议与源码保持一致,8*1024 = 8192 */
			byte[] bs = new byte[8 * 1024];
			while ((b = in.read(bs)) != -1) {// 只有没有数据时,才返回-1,跳出循环,读写结束
				out.write(bs);// 将读到的数据写出到文件
			}
			System.out.println("恭喜您!文件复制成功!");
		} catch (IOException e) {
			System.out.println("很抱歉!文件复制失败!");
			e.printStackTrace();// 打印错误信息
		} finally {
			// 释放资源
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 随机产生一个长度自定义，最大值可自定义的int数组
	 *
	 * @param min_Arr 数组长度最小值（包含）
	 * @param offset_Arr 数组长度最大偏移量
	 * @param max_IntValue 数组int元素最大值（不包含）
	 * @return
	 */
	public static int[] RandomIntArr(int min_Arr, int offset_Arr, int max_IntValue) {
		// 随机产生5+ [0,6)范围整数n
		int n = min_Arr + new Random().nextInt(offset_Arr);
		// 新建int[]数组，长度n
		// 再存到变量a
		int[] a = new int[n];
		// 遍历数组，填入100内随机整数
		for (int i = 0; i < a.length; i++) {
			a[i] = new Random().nextInt(max_IntValue);
		}
		// 返回数组a
		return a;
	}
	/**
	 * 冒泡排序sort
	 */
	public static int[] bubbleSort(int[] original) {
		for(int i=1;i<=original.length-1;i++) {
			for(int j=0;j<original.length-i;j++) {
				if(original[j]>original[j+1]) {
					int t;
					t=original[j];
					original[j]=original[j+1];
					original[j+1]=t;
				}
			}
		}
		return original;
	}
}
