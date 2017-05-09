package Tree.AVLTree;

public class AVLTree {
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

	public void rightRotate(Node<Integer> y){
		if(y.left!=null){
			Node<Integer> x=y.left;
			x.parent=y.parent;
			if(y.parent==null){
				root=x;
			}else{
				if(y.parent.left==y){
					y.parent.left=x;
				}else{
					y.parent.right=x;
				}
			}
			y.left=x.right;
			if(x.right!=null){
				x.right.parent=y;
			}
			x.right=y;
			y.parent=x;
		}
	}
	public void leftRotate(Node<Integer> x){
		if(x.right!=null){
			Node<Integer> y=x.right;
			y.parent=x.parent;
			if(x.parent==null){
				root=y;
			}else{
				if(x.parent.left==x){
					x.parent.left=y;
				}else{
					x.parent.right=y;
				}
			}
			x.right=y.left;
			if(y.left!=null){
				y.left.parent=x;
			}
			y.left=x;
			x.parent=y;
		}
	}
	public void leftRightRotate(Node<Integer> z){
		if(z!=null){
			leftRotate(z.parent);
			rightRotate(z.parent);
		}
	}
	public void rightLeftRotate(Node<Integer> z){
		if(z!=null){
			rightRotate(z.parent);
			leftRotate(z.parent);
		}
	}
	
	private void adjustForInsert(Node<Integer> x){
		while(x.parent!=null){
			if(x.parent.left==x){
				x.parent.bf++;
				if(x.parent.bf==0){
					break;
				}else if(x.parent.bf==1){
					x=x.parent;
				}else if(x.parent.bf==2){
					if(x.bf==1){
						x.bf=0;
						x.parent.bf=0;
						rightRotate(x.parent);
					}else if(x.bf==-1){
						if(x.right.bf==1){
							x.bf=0;
							x.parent.bf=-1;
						}else if(x.right.bf==1){
							x.bf=1;
							x.parent.bf=0;
						}else if(x.right.bf==0){
							x.bf=0;
							x.parent.bf=0;
						}else{
							System.out.println("Error x.right.bf!=[-1,0,1] in LR");
						}
						x.right.bf=0;
						leftRightRotate(x.right);
					}else{
						System.out.println("Error x.bf==0 in L");
					}
					
					break;
				}else{
					System.out.println("Error x.parent.bf!=[0,1,2] in L");
					break;
				}
			}else{
				x.parent.bf--;
				if(x.parent.bf==0){
					break;
				}else if(x.parent.bf==-1){
					x=x.parent;
				}else if(x.parent.bf==-2){
					if(x.bf==-1){
						x.bf=0;
						x.parent.bf=0;
						leftRotate(x.parent);
					}else if(x.bf==1){
						if(x.left.bf==1){
							x.bf=-1;
							x.parent.bf=0;
						}else if(x.left.bf==-1){
							x.bf=0;
							x.parent.bf=1;
						}else if(x.left.bf==0){
							x.bf=0;
							x.parent.bf=0;
						}else{
							System.out.println("Error x.left.bf!=[-1,0,1] in RL");
						}
						x.left.bf=0;
						rightLeftRotate(x.left);
					}else{
						System.out.println("Error x.bf==0 in R");
					}
					
					break;
				}else{
					System.out.println("Error x.parent.bf!=[-2,-1,0] in R");
					break;
				}
			}
		}
	}
	public void insert(int t){
		if(root==null){
			root=new Node<Integer>(t);
			return;
		}
		Node<Integer> x=root;
		while(true){
			if(t<x.key){
				if(x.left==null){
					x.left=new Node<Integer>(t);
					x.left.parent=x;
					
					adjustForInsert(x.left);
					
					break;
				}else{
					x=x.left;
				}
			}else{
				if(x.right==null){
					x.right=new Node<Integer>(t);
					x.right.parent=x;
					
					adjustForInsert(x.right);
					
					break;
				}else{
					x=x.right;
				}
			}
		}
	}
	
	private void adjustForDelete(Node<Integer> x,boolean left){
		while(x!=null){
			if(left){
				x.bf--;
				if(x.bf==0){
					if(x.parent!=null){
						if(x.parent.left==x){
							left=true;
						}else{
							left=false;
						}
					}
					x=x.parent;
				}else if(x.bf==-1){
					break;
				}else if(x.bf==-2){
					if(x.right.bf==-1){
						x.bf=0;
						x.right.bf=0;
						if(x.parent!=null){
							if(x.parent.left==x){
								left=true;
							}else{
								left=false;
							}
						}
						leftRotate(x);

						x=x.parent.parent;
					}else if(x.right.bf==0){
						x.bf=-1;
						x.right.bf=1;
						leftRotate(x);
						
						break;
					}else if(x.right.bf==1){
						if(x.right.left.bf==-1){
							x.bf=1;
							x.right.bf=0;
						}else if(x.right.left.bf==0){
							x.bf=0;
							x.right.bf=0;
						}else if(x.right.left.bf==1){
							x.bf=0;
							x.right.bf=-1;
						}
						x.right.left.bf=0;
						
						if(x.parent!=null){
							if(x.parent.left==x){
								left=true;
							}else{
								left=false;
							}
						}
						rightLeftRotate(x.right.left);
						
						x=x.parent.parent;
					}
				}
			}else{
				x.bf++;
				if(x.bf==0){
					if(x.parent!=null){
						if(x.parent.left==x){
							left=true;
						}else{
							left=false;
						}
					}
					x=x.parent;
				}else if(x.bf==1){
					break;
				}else if(x.bf==2){
					if(x.left.bf==1){
						x.bf=0;
						x.left.bf=0;
						
						if(x.parent!=null){
							if(x.parent.left==x){
								left=true;
							}else{
								left=false;
							}
						}
						rightRotate(x);
						
						x=x.parent.parent;
						
					}else if(x.left.bf==0){
						x.bf=1;
						x.left.bf=-1;
						rightRotate(x);
						
						break;
					}else if(x.left.bf==-1){
						if(x.left.right.bf==1){
							x.bf=-1;
							x.left.bf=0;
						}else if(x.left.right.bf==0){
							x.bf=0;
							x.left.bf=0;
						}else if(x.left.right.bf==-1){
							x.bf=0;
							x.left.bf=1;
						}
						x.left.right.bf=0;
						
						if(x.parent!=null){
							if(x.parent.left==x){
								left=true;
							}else{
								left=false;
							}
						}
						rightLeftRotate(x.left.right);
						
						x=x.parent.parent;
						
					}
				}
			}
		}
	}
	public void delete(Node<Integer> x){
		if(x.left==null){
			if(x.right==null){
				System.out.println("case1:");
				if(x.parent==null){
					root=null;
				}else{
					if(x.parent.left==x){
						x.parent.left=null;
						
						adjustForDelete(x.parent,true);
					}else{
						x.parent.right=null;
						
						adjustForDelete(x.parent,false);
					}
					x.parent=null;
				}
			}else{
				System.out.println("case2:");
				x.right.parent=x.parent;
				if(x.parent==null){
					root=x.right;
					x.right=null;
				}else{
					if(x.parent.left==x){
						x.parent.left=x.right;
						x.right=null;
						
						adjustForDelete(x.parent,true);
					}else{
						x.parent.right=x.right;
						x.right=null;
						
						adjustForDelete(x.parent,false);
					}
					x.parent=null;
				}
			}
		}else if(x.right==null){
			System.out.println("case3:");
			x.left.parent=x.parent;
			if(x.parent==null){
				root=x.left;
				x.left=null;
			}else{
				if(x.parent.left==x){
					x.parent.left=x.left;
					x.left=null;
					
					adjustForDelete(x.parent,true);
				}else{
					x.parent.right=x.left;
					x.left=null;
					
					adjustForDelete(x.parent,false);
				}
				x.parent=null;
			}
		}else{
			Node<Integer> y=minNode(x.right);
			if(y.parent==x){
				System.out.println("case4:");
				x.left.parent=x.right;
				x.right.left=x.left;
				x.left=null;
				x.right.parent=x.parent;
				if(x.parent==null){
					root=x.right;
				}else{
					if(x.parent.left==x){
						x.parent.left=x.right;
					}else{
						x.parent.right=x.right;
					}
					x.parent=null;
				}
				
				x.right.bf=x.bf;
				adjustForDelete(x.right,false);
				
				x.right=null;
			}else{
				System.out.println("case5:");
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
				
				y.bf=x.bf;
				Node<Integer> p=y.parent;
				
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
				
				adjustForDelete(p,true);
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
//				System.out.print(" "+x.key);
				System.out.print(" "+x.key+"|"+x.bf);
				if(Math.abs(x.bf)>1){
					System.out.print("hello");
				}
				x=successor(x);
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args){
		AVLTree tree=new AVLTree();
		tree.insert(20);
		tree.print();
		tree.insert(10);
		tree.print();
		tree.insert(5);
		tree.print();
		tree.insert(30);
		tree.print();
		tree.insert(40);
		tree.print();
		tree.insert(15);
		tree.print();
		tree.insert(25);
		tree.print();
		tree.insert(23);	
		tree.print();
		tree.insert(50);	
		tree.print();
		tree.insert(1);
		tree.print();
		tree.insert(3);
		tree.print();
		
		tree.delete(tree.search(15));
		tree.print();
		tree.delete(tree.search(25));
		tree.print();
		tree.delete(tree.search(40));
		tree.print();
		tree.delete(tree.search(3));
		tree.print();
		tree.delete(tree.search(20));
		tree.print();
		
//		tree.delete(tree.search(15));
//		tree.print();
//		tree.delete(tree.search(23));
//		tree.print();
//		tree.delete(tree.search(25));
//		tree.print();
//		tree.delete(tree.search(1));
//		tree.print();
//		tree.delete(tree.search(30));
//		tree.print();
//		tree.delete(tree.search(50));
//		tree.print();
//		tree.delete(tree.search(40));
//		tree.print();
//		tree.delete(tree.search(3));
//		tree.print();
		
	}
	
}
