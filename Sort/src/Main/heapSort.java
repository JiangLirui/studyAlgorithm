package Main;

import java.util.ArrayList;

public class heapSort {
	public static void maxHeapify(ArrayList<Integer> data,int loc,int len){
		for(int left=2*loc+1,right=left+1;left<len;left=2*loc+1,right=left+1){
			int largest=loc;
			if(data.get(left)>data.get(largest)){
				largest=left;
			}
			if(right<len && data.get(right)>data.get(largest)){
				largest=right;
			}
			if(largest!=loc){
				int temp=data.get(largest);
				data.set(largest, data.get(loc));
				data.set(loc, temp);
				loc=largest;
			}else{
				break;
			}
		}
	}
	public static void buildMaxHeap(ArrayList<Integer> data){
		for(int i=data.size()/2-1;i>=0;--i){
			maxHeapify(data,i,data.size());
		}
	}
	public static void run(ArrayList<Integer> data) {
		buildMaxHeap(data);
		for(int i=data.size()-1;i>0;--i){
			int temp=data.get(i);
			data.set(i, data.get(0));
			data.set(0, temp);
			maxHeapify(data,0,i);
		}
	}

}
