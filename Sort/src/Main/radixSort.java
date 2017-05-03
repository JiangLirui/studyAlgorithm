package Main;

import java.util.ArrayList;

public class radixSort {
	public static void run(ArrayList<Integer> data) {
		if(data.size()>1){
			int max=data.get(0);
			for(int i=0;i!=data.size();++i){
				if(data.get(i)>max){
					max=data.get(i);
				}
			}
			
			int d=1;
			while((max/=10)!=0){
				d++;
			}
			
			
			
			
		}
	}

}
