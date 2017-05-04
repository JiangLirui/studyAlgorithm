package List;

public class myListHead<T> {
	private node<T> list;
	private int size=0;
	
	public myListHead(){
		list=new node<T>();
		list.prev=list;
		list.next=list;
	}
	
	public void insert(T t){
		node<T> element=new node<T>(t);
		element.next=list.next;
		list.next.prev=element;
		element.prev=list;
		list.next=element;
		size++;
	}
	
	public node<T> searchFirst(T t){
		for(node<T> element=list.next;!element.equals(list);element=element.next){
			if(element.key.equals(t)){
				return element;
			}
		}
		return null;
	}
	
	public void delete(node<T> element){
		if(element==null) return;
		element.prev.next=element.next;
		element.next.prev=element.prev;
		size--;
	}
	
	public void deleteFirst(T t){
		delete(searchFirst(t));
	}
	
	public void deleteAll(T t){
		for(node<T> element=list.next;!element.equals(list);element=element.next){
			if(element.key.equals(t)){
				delete(element);
			}
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public void print(){
		for(node<T> element=list.next;!element.equals(list);element=element.next){
			System.out.print(" "+element.key);
		}
		System.out.println();
	}

}
