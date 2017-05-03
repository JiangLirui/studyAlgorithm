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
			
			int[] B=new int[data.size()];
			
			int[] X=new int[data.size()];
			for(int i=0;i!=data.size();++i){
				X[i]=data.get(i);
				B[i]=data.get(i);
			}
			
			int[] B_X=new int[data.size()];
			int[] Y=new int[data.size()];
			for(int i=1;i<=d;++i){
				for(int j=0;j!=data.size();++j){
					Y[j]=X[j]%10;
					X[j]/=10;
				}
				
				int[] C=new int[10];
				for(int j=0;j!=10;++j){
					C[j]=0;
				}
				for(int j=0;j!=data.size();++j){
					C[Y[j]]++;
				}
				for(int j=1;j!=10;++j){
					C[j]=C[j]+C[j-1];
				}
				for(int j=data.size()-1;j>=0;--j){
					B[C[Y[j]]-1]=data.get(j);
					B_X[C[Y[j]]-1]=X[j];
					C[Y[j]]--;
				}
				
				for(int j=0;j!=data.size();++j){
					data.set(j, B[j]);
					X[j]=B_X[j];
				}
			}
		}
		
	}

}
