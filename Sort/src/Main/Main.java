package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static ArrayList<Integer> data=new ArrayList<Integer>();
	public static String path = new String("E:/eclipse/JavaCode/Sort/");
	
	public static void output(String filename){
		File file=new File(path+filename);
		OutputStreamWriter out;
		try {
			out=new FileWriter(file);
			for(int i=0;i!=data.size();++i){
				out.write(data.get(i)+"\n");
			}
			out.close();
			System.out.println(filename+" Save location: "+path+filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int len=10000;
		Random rand = new Random();
		for (int i = 0; i != len; ++i) {
			data.add(rand.nextInt(10000));
		}
		
		output("before_sort.txt");
		
		long startTime=System.currentTimeMillis();
//		insertionSort.run(data);
		selectionSort.run(data);
//		bubbleSort.run(data);
		long endTime=System.currentTimeMillis();
		System.out.println("use time: "+ (endTime-startTime)+"ms");
		
		output("after_sort.txt");
	}

}
