package Main;

import java.util.ArrayList;

public class quickSort {
	public static void run(ArrayList<Integer> data, int start,int end) {
		if(end-start>1){
			int mid=(start+end)/2;
			int i=start,j=end-1;
			while(i<j){
				while(i<mid){
					if(data.get(i)>data.get(mid)){
						break;
					}
					++i;
				}
				while(j>mid){
					if(data.get(j)<data.get(mid)){
						break;
					}
					--j;
				}
				
				if(i<j){
					int temp=data.get(i);
					data.set(i, data.get(j));
					data.set(j, temp);
					
					if(i==mid) mid=j;
					else if(j==mid) mid=i;
				}
			}
			
			run(data,start,mid);
			run(data,mid+1,end);
		}
	}

}
