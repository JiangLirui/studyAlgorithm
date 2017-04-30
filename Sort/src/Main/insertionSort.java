package Main;

import java.util.ArrayList;

public class insertionSort {
	public static void run(ArrayList<Integer> data){
		if(data.size()>1){
			for(int i=1;i!=data.size();++i){
				int key=data.get(i);
				int j=i-1;
				while(j>=0 && data.get(j)>key){
					data.set(j+1, data.get(j));
					--j;
				}
				data.set(j+1,key);
			}
		}
	}
}
