package Tree;

import java.util.Random;

public class BinarySearchTree {
	public Node<Integer> root=null;
	
	public Node<Integer> search(int t){
		if(root==null) return root;
		
		Node<Integer> x=root;
		while(!x.key.equals(t)){
			if(t<x.key){
				x=x.left;
			}else{
				x=x.right;
			}
			
			if(x==null) break;
		}
		return x;
	}
	
	public Node<Integer> minNode(Node<Integer> x){
		if(x!=null){
			while(x.left!=null){
				x=x.left;
			}
		}
		return x;
	}
	public Node<Integer> maxNode(Node<Integer> x){
		if(x!=null){
			while(x.right!=null){
				x=x.right;
			}
		}
		return x;
	}
	
	public Node<Integer> successor(Node<Integer> x){
		if(x.right!=null){
			return minNode(x.right);
		}
		while(x.parent!=null && x.parent.right==x){
			x=x.parent;
		}
		return x.parent;
	}
	public Node<Integer> preSuccessor(Node<Integer> x){
		if(x.left!=null){
			return maxNode(x.left);
		}
		while(x.parent!=null && x.parent.left==x){
			x=x.parent;
		}
		return x.parent;
	}
	
	public void insert(Node<Integer> element){
		if(root==null){
			root=element;
			root.parent=null;
			root.left=null;
			root.right=null;
		}
		Node<Integer> x=root;
		while(x!=root){
			if(element.key<x.key){
				if(x.left==null){
					x.left=element;
					element.parent=x;
					element.left=null;
					element.right=null;
				}else{
					x=x.left;
				}
			}else{
				if(x.right==null){
					x.right=element;
					element.parent=x;
					element.left=null;
					element.right=null;
				}else{
					x=x.right;
				}
			}
		}
	}
	public void insert(int t){
		if(root==null){
			root=new Node<Integer>(t);
		}
		Node<Integer> x=root;
		while(true){
			if(t<x.key){
				if(x.left==null){
					x.left=new Node<Integer>(t);
					x.left.parent=x;
					break;
				}else{
					x=x.left;
				}
			}else{
				if(x.right==null){
					x.right=new Node<Integer>(t);
					x.right.parent=x;
					break;
				}else{
					x=x.right;
				}
			}
		}
	}
	
	public void delete(Node<Integer> x){
		if(x.left==null){
			if(x.right==null){
				if(x.parent==null){
					root=null;
				}else{
					if(x.parent.left==x){
						x.parent.left=null;
					}else{
						x.parent.right=null;
					}
					x.parent=null;
				}
			}else{
				x.right.parent=x.parent;
				if(x.parent==null){
					root=x.right;
					x.right=null;
				}else{
					if(x.parent.left==x){
						x.parent.left=x.right;
					}else{
						x.parent.right=x.right;
					}
					x.parent=null;
					x.right=null;
				}
			}
		}else if(x.right==null){
			x.left.parent=x.parent;
			if(x.parent==null){
				root=x.left;
				x.left=null;
			}else{
				if(x.parent.left==x){
					x.parent.left=x.left;
				}else{
					x.parent.right=x.left;
				}
				x.parent=null;
				x.left=null;
			}
		}else{
			if(x.right.left==null){
				x.left.parent=x.right;
				x.right.left=x.left;
				x.left=null;
				x.right.parent=x.parent;
				if(x.parent==null){
					root=x.right;
					x.right=null;
				}else{
					if(x.parent.left==x){
						x.parent.left=x.right;
					}else{
						x.parent.right=x.right;
					}
					x.parent=null;
					x.right=null;
				}
			}else{
				Node<Integer> y=minNode(x.right);
				y.parent.left=y.right;
				if(y.right!=null){
					y.right.parent=y.parent;
				}
				
				y.left=x.left;
				x.left.parent=y;
				x.left=null;
				y.right=x.right;
				x.right.parent=y;
				x.right=null;
				
				y.parent=x.parent;
				if(x.parent==null){
					root=y;
				}else{
					if(x.parent.left==x){
						x.parent.left=y;
					}else{
						x.parent.right=y;
					}
					x.parent=null;
				}
			}
		}
	}
	
	//效率较快
	public void print(Node<Integer> x){
		if(x!=null){
			print(x.left);
			System.out.print(" "+x.key);
			print(x.right);
		}
	}
	//效率较慢
	public void print(){
		if(root==null){
			System.out.println("The BinarySearchTree is empty.");
		}else{
			Node<Integer> x=minNode(root);
			while(x!=null){
				System.out.print(" "+x.key);
				x=successor(x);
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args){
		BinarySearchTree tree=new BinarySearchTree();
		Random rand=new Random();
//		long start=System.currentTimeMillis();
		for(int i=0;i!=50;++i){
			tree.insert(rand.nextInt(10));
		}
//		long end=System.currentTimeMillis();
//		System.out.println("used time:"+(end-start)+"ms");
		
		tree.print(tree.root);
		System.out.println();
		
		tree.insert(5);
		tree.print(tree.root);
		System.out.println();
		
		System.out.println(tree.search(5).key);
		
		System.out.println("min:"+tree.minNode(tree.root).key);
		System.out.println("max:"+tree.maxNode(tree.root).key);
		
		Node<Integer> x=null;
		while((x=tree.search(5))!=null){
			tree.delete(x);
			tree.print(tree.root);
			System.out.println();
		}
		
		System.out.println(tree.search(5));
		
		while((x=tree.minNode(tree.root))!=null){
			tree.delete(x);
			tree.print();
		}
		
		
	}
	
}
