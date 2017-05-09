package Tree.RBTree;

public class Node<T> {
	public T key;
	public Node<T> parent=null;
	public Node<T> left=null;
	public Node<T> right=null;
	public boolean RED=true;
	
	public Node(){}
	public Node(T key){
		this.key=key;
	}
}
