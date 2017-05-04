package Queue;

public class myQueue {
	private int[] data;
	private int capacity=1000;
	private int back=0;
	private int front=0;
	private boolean isEmpty=true;
	private boolean isFill=false;
	
	public myQueue(){
		data=new int[1000];
	}
	public myQueue(int capacity){
		this.capacity=capacity;
		data=new int[this.capacity];
	}
	
	public void push(int element){
		if(isFill){
			System.out.println("The queue is fill.");
			System.exit(0);
		}else{
			data[back]=element;
			if(back==capacity-1){
				back=0;
			}else{
				back++;
			}
			if(back==front){
				isFill=true;
			}
			if(isEmpty){
				isEmpty=false;
			}
		}
	}
	public void pop(){
		if(isEmpty){
			System.out.println("The queue is empty.");
			System.exit(0);
		}else{
			if(front==capacity-1){
				front=0;
			}else{
				front++;
			}
			if(front==back){
				isEmpty=true;
			}
			if(isFill){
				isFill=false;
			}
		}
	}
	
	public int get_front(){
		if(isEmpty) System.exit(0);
		return data[front];
	}
	public int get_back(){
		if(isEmpty) System.exit(0);
		return data[back-1];
	}
	
	public int size(){
		if(isEmpty) return 0;
		if(isFill) return capacity;
		
		if(back>front) return back-front;
		else return capacity+back-front;
	}
	
	public boolean empty(){
		return isEmpty;
	}
	public boolean fill(){
		return isFill;
	}
	
	public void print(){
		if(isEmpty){
			System.out.println("The queue is empty.");
		}else{
			if(back>front){
				for(int i=front;i!=back;++i){
					System.out.print(" "+data[i]);
				}
				System.out.println();
			}else{
				for(int i=front;i!=capacity;++i){
					System.out.print(" "+data[i]);
				}
				for(int i=0;i!=back;++i){
					System.out.print(" "+data[i]);
				}
				System.out.println();
			}
		}
	}
}
