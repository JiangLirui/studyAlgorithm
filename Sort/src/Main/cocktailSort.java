package Main;

import java.util.ArrayList;

public class cocktailSort {
	public static void run(ArrayList<Integer> data) {
		if(data.size()>1){
			boolean flag=true;
			for(int i=0,j=data.size()-1;i<j;++i,--j){
				
				int k=i;
				for(;k!=j;++k){
					if(data.get(k)>data.get(k+1)){
						int temp=data.get(k);
						data.set(k, data.get(k+1));
						data.set(k+1, temp);
						flag=false;
					}
				}
				
				if(flag) break;
				else flag=true;
				
				for(;k!=i;--k){
					if(data.get(k)<data.get(k-1)){
						int temp=data.get(k);
						data.set(k, data.get(k-1));
						data.set(k-1, temp);
						flag=false;
					}
				}
				
				if(flag) break;
				else flag=true;
			}
		}

	}

}
