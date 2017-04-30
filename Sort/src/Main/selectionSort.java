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
		}
	}

}
