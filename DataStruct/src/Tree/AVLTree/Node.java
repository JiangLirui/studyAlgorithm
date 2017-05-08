package Tree.AVLTree;

public class Node<T> {
	public T key;
	public Node<T> parent=null;
	public Node<T> left=null;
	public Node<T> right=null;
	public int bf=0;
	
	public Node(){}
	public Node(T key){
		this.key=key;
	}
}
