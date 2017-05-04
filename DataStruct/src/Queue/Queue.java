package Queue;

public class Queue {
	public static void main(String[] args) {
		myQueue q=new myQueue(10);
		q.print();
		
		for(int i=0;i!=10;++i){
			q.push(i);
		}
		q.print();
		
		for(int i=0;i!=5;++i){
			q.pop();
		}
		q.print();
		
		for(int i=0;i!=3;++i){
			q.push(i);
		}
		q.print();
		
		while(!q.empty()){
			q.pop();
		}
		q.print();
	}
}
