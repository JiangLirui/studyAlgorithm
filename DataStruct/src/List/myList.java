package List;

public class myList<T> {
	
	private node<T> list=null;
	private int size=0;
	
	public void insert(T t){
		node<T> element=new node<T>(t);
		if(list==null){
			list=element;
		}else{
			element.next=list;
			list.prev=element;
			list=element;
		}
		size++;
	}
	
	public node<T> searchFirst(T t){
		for(node<T> element=list;element!=null;element=element.next){
			if(element.key.equals(t)){
				return element;
			}
		}
		return null;
	}
	
	public void delete(node<T> element){
		if(element==null) return;
		if(element.next==null){
			if(element.prev==null){
				list=null;
			}else{
				element.prev=null;
			}
		}else{
			if(element.prev==null){
				list=element.next;
				element.next.prev=null;
			}else{
				element.prev.next=element.next;
				element.next.prev=element.prev;
			}
		}
		size--;
	}
	public void deleteFirst(T t){
		delete(searchFirst(t));
	}
	public void deleteAll(T t){
		for(node<T> element=list;element!=null;element=element.next){
			if(element.key.equals(t)){
				delete(element);
			}
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public void print(){
		for(node<T> element=list;element!=null;element=element.next){
			System.out.print(" "+ element.key);
		}
		System.out.println();
	}

}
