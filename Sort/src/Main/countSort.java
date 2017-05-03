package Main;

import java.util.ArrayList;

public class countSort {
	public static void run(ArrayList<Integer> data) {
		if(data.size()>1){
			int min=data.get(0);
			int max=min;
			for(int i=0;i!=data.size();++i){
				if(data.get(i)<min){
					min=data.get(i);
				}
				if(data.get(i)>max){
					max=data.get(i);
				}
			}
			
			int[] C=new int[max+1];
			for(int i=0;i<=max;++i){
				C[i]=0;
			}
			
			for(int i=0;i!=data.size();++i){
				C[data.get(i)]++;
			}
			
			for(int i=1;i<=max;++i){
				C[i]+=C[i-1];
			}
			
			int[] B=new int[data.size()];
			for(int i=data.size()-1;i>=0;--i){
				B[C[data.get(i)]-1]=data.get(i);
				C[data.get(i)]--;
			}
			
			for(int i=0;i!=data.size();++i){
				data.set(i, B[i]);
			}
			
		}
		
	}

}
