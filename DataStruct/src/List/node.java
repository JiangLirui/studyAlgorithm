package List;

public class node<T>{
	public T key;
	public node next=null;
	public node prev=null;
	
	public node(){}
	public node(T key){
		this.key=key;
	}
}
