package Main;

import java.util.ArrayList;

public class bubbleSort {
	public static void run(ArrayList<Integer> data) {
		if(data.size()>1){
			for(int i=data.size()-1;i>=0;--i){
				boolean flag=true;
				for(int j=0;j<i;++j){
					if(data.get(j)>data.get(j+1)){
						int temp=data.get(j);
						data.set(j, data.get(j+1));
						data.set(j+1, temp);
						
						flag=false;
					}
				}
				
				//优化措施，最好可以达到O(n)
				if(flag){
					break;
				}
			}
			
		}
	}
}
