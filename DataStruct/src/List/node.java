package List;

public class node<T>{
	public T key;
	public node<T> next=null;
	public node<T> prev=null;
	
	public node(){}
	public node(T key){
		this.key=key;
	}
}
