package Main;

import java.util.ArrayList;

public class mergeSort {
	public static void runRecursion(ArrayList<Integer> data,int start,int end) {
		int len=end-start;
		if(len>1){
			if(len==2){
				if(data.get(start)>data.get(start+1)){
					int temp=data.get(start);
					data.set(start, data.get(start+1));
					data.set(start+1, temp);
				}
			}else{
				int mid=start+(len+1)/2;
				runRecursion(data,start,mid);
				runRecursion(data,mid,end);
				
				int[] left=new int[mid-start+1];
				int[] right=new int[end-mid+1];
				for(int i=0;i!=mid-start;++i){
					left[i]=data.get(start+i);
				}
				left[mid-start]=Integer.MAX_VALUE;
				for(int i=0;i!=end-mid;++i){
					right[i]=data.get(mid+i);
				}
				right[end-mid]=Integer.MAX_VALUE;
				
				for(int i=0,j=0,k=start;k!=end;++k){
					if(left[i]<=right[j]){
						data.set(k, left[i]);
						++i;
					}else{
						data.set(k, right[j]);
						++j;
					}
				}
				
			}
		}
	}
	
	public static void runIterator(ArrayList<Integer> data){
		if(data.size()>1){
			for(int step=1;step<data.size();step*=2){
				for(int start=0;start+step<data.size();start+=2*step){
					int mid = start + step;
					int end = start + 2*step;
					if (end > data.size()) {
						end = data.size();
					}

					int[] left = new int[mid - start + 1];
					int[] right = new int[end - mid + 1];
					for (int i = 0; i != mid - start; ++i) {
						left[i] = data.get(start + i);
					}
					left[mid - start] = Integer.MAX_VALUE;
					for (int j = 0; j != end - mid; ++j) {
						right[j] = data.get(mid + j);
					}
					right[end - mid] = Integer.MAX_VALUE;

					for (int i = 0, j = 0, k = start; k != end; ++k) {
						if (left[i] <= right[j]) {
							data.set(k, left[i]);
							++i;
						} else {
							data.set(k, right[j]);
							++j;
						}
					}
				}
			}
		}
	}
}
