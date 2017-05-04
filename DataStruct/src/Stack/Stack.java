package Stack;

public class Stack {
	public static void main(String[] args) {
		myStack s=new myStack(100);
		s.print();
		System.out.println(s.empty());
		System.out.println(s.fill());
		for(int i=0;i!=10;++i){
			s.push(i);
		}
		s.print();
		System.out.println(s.empty());
		System.out.println(s.fill());
		for(int i=0;i!=3;++i){
			s.pop();
		}
		s.print();
		for(int i=0;i!=4;++i){
			s.push(i);
		}
		s.print();
		for(int i=0;i!=5;++i){
			s.pop();
		}
		s.print();
		

	}

}
