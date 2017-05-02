package Main;

import java.util.ArrayList;

public class shellSort {
	public static void run(ArrayList<Integer> data) {
		if(data.size()>1){
			for(int step=data.size()/3+1;step>=1;step=step/3+1){
				for(int i=0;i<step;++i){
					for(int j=i+step;j<data.size();j+=step){
						int key=data.get(j);
						int k=j-step;
						while(k>=i && data.get(k)>key){
							data.set(k+step, data.get(k));
							k=k-step;
						}
						data.set(k+step,key);
					}
				}
				if(step==1){
					break;
				}
			}
		}
	}
}
