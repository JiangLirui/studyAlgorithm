package List;

public class List {
	public static void main(String[] args) {
//		myList<Integer> list=new myList<Integer>();
		myListHead<Integer> list=new myListHead<Integer>();
		for(int i=0;i!=10;++i){
			list.insert(i);
		}
		System.out.println("size="+list.getSize());
		list.print();
		
		System.out.println(list.searchFirst(3).key);
		
		for(int i=0;i!=10;++i){
			list.insert(9-i);
		}
		System.out.println("size="+list.getSize());
		list.print();
		
		list.deleteFirst(3);
		System.out.println("size="+list.getSize());
		list.print();
		
		list.deleteAll(5);
		System.out.println("size="+list.getSize());
		list.print();
	}

}
