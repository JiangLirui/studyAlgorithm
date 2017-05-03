package Main;

import java.util.ArrayList;

public class bucketSort {
	public static void run(ArrayList<Integer> data) {
		if(data.size()>1){
			int max=data.get(0);
			for(int i=0;i!=data.size();++i){
				if(data.get(i)>max){
					max=data.get(i);
				}
			}
			
			int[] bucket=new int[max+1];
			for(int i=0;i<=max;++i){
				bucket[i]=0;
			}
			for(int i=0;i!=data.size();++i){
				bucket[data.get(i)]++;
			}
			
			for (int i = 0, k = 0; i <= max; ++i) {
				while (bucket[i] > 0) {
					data.set(k, i);
					++k;
					--bucket[i];
				}
			}
		}
	}

}
