package Stack;

public class myStack {
	private int[] data;
	private int capacity=1000;
	private int top=0;
	
	public myStack(){
		data=new int[capacity];
	}
	public myStack(int capacity){
		this.capacity=capacity;
		data=new int[this.capacity];
	}
	
	public void push(int element){
		if(top==capacity){
			System.out.println("The stack is fill.");
			System.exit(0);
		}else{
			data[top]=element;
			top++;
		}
	}
	public void pop(){
		if(top==0){
			System.out.println("The stack is empty.");
			System.exit(0);
		}else{
			top--;
		}
	}
	
	public boolean empty(){
		return top==0;
	}
	public boolean fill(){
		return top==capacity;
	}
	
	public int size(){
		return top;
	}
	
	public void print(){
		if(top==0){
			System.out.println("The queue is empty.");
		}else{
			for(int i=top-1;i>=0;--i){
				System.out.print(" "+data[i]);
			}
			System.out.println();
		}
	}

}
