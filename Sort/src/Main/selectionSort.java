package Main;

import java.util.ArrayList;

public class selectionSort {
	public static void run(ArrayList<Integer> data) {
		if(data.size()>1){
			for(int i=0;i!=data.size()-1;++i){
				int minLoc=i;
				for(int j=i+1;j!=data.size();++j){
					if(data.get(j)<data.get(minLoc)){
						minLoc=j;
					}
				}
				if(minLoc!=i){
					int temp=data.get(i);
					data.set(i, data.get(minLoc));
					data.set(minLoc, temp);
				}
			}
			
			
//			for(int i=0,j=data.size()-1;i<j;++i,--j){
//				int minLoc=i;
//				int maxLoc=j;
//				for(int k=i;k<=j;++k){
//					if(data.get(k)<data.get(minLoc)){
//						minLoc=k;
//					}
//					if(data.get(k)>data.get(maxLoc)){
//						maxLoc=k;
//					}
//				}
//				int temp=data.get(i);
//				data.set(i, data.get(minLoc));
//				data.set(minLoc, temp);
//				temp=data.get(j);
//				data.set(j, data.get(maxLoc));
//				data.set(maxLoc, temp);
//			}
			
		}
	}

}
