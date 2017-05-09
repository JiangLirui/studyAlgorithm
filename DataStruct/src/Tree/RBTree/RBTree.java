package Tree.RBTree;

public class RBTree {
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
		while(x.parent.RED){
			if(x.parent.parent.left==x.parent){
				if(x.parent.parent.right!=null && x.parent.parent.right.RED){
					x.parent.RED=false;
					x.parent.parent.RED=true;
					x.parent.parent.right.RED=false;
					x=x.parent.parent;
					if(x.parent==null){
						break;
					}
				}else{
					if(x.parent.right==x){
						x=x.parent;
						leftRotate(x);
					}
					x.parent.RED=false;
					x.parent.parent.RED=true;
					rightRotate(x.parent.parent);
					break;
				}
			}else{
				if(x.parent.parent.left!=null && x.parent.parent.left.RED){
					x.parent.RED=false;
					x.parent.parent.RED=true;
					x.parent.parent.left.RED=false;
					x=x.parent.parent;
					if(x.parent==null){
						break;
					}
				}else{
					if(x.parent.left==x){
						x=x.parent;
						rightRotate(x);
					}
					x.parent.RED=false;
					x.parent.parent.RED=true;
					leftRotate(x.parent.parent);
					break;
				}
			}
		}
		root.RED=false;
	}
	public void insert(int t){
		if(root==null){
			root=new Node<Integer>(t);
			root.RED=false;
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
	
	private void adjustForDelete(Node<Integer> x){
		while(x!=root && !x.RED){
			if(x.parent.left==x){
				Node<Integer> w=x.parent.right;
				if(w==null) {
					x=x.parent;
				}else{
					if(w.RED){
						x.parent.RED=true;
						w.RED=false;
						leftRotate(x.parent);
					}else{
						if(w.left==null){
							if(w.right==null){
								w.RED=true;
								x=x.parent;
							}else{
								if(w.right.RED){
									w.right.RED=false;
									w.RED=x.parent.RED;
									x.parent.RED=false;
									leftRotate(x.parent);
									break;
								}else{
									w.RED=true;
									x=x.parent;
								}
							}
						}else{
							if(w.right==null){
								if(w.left.RED){
									w.left.RED=false;
									w.RED=true;
									rightRotate(w);
								}else{
									w.RED=true;
									x=x.parent;
								}
							}else{
								if(w.right.RED){
									w.right.RED=false;
									w.RED=x.parent.RED;
									x.parent.RED=false;
									leftRotate(x.parent);
									break;
								}else{
									if(w.left.RED){
										w.left.RED=false;
										w.RED=true;
										rightRotate(w);
									}else{
										w.RED=true;
										x=x.parent;
									}
								}
							}
						}
					}
				}
			}else{
				Node<Integer> w=x.parent.left;
				if(w==null) {
					x=x.parent;
				}else{
					if(w.RED){
						x.parent.RED=true;
						w.RED=false;
						rightRotate(x.parent);
					}else{
						if(w.left==null){
							if(w.right==null){
								w.RED=true;
								x=x.parent;
							}else{
								if(w.right.RED){
									w.RED=true;
									w.right.RED=false;
									leftRotate(w);
								}else{
									w.RED=true;
									x=x.parent;
								}
							}
						}else{
							if(w.left.RED){
								w.left.RED=false;
								w.RED=w.parent.RED;
								w.parent.RED=false;
								rightRotate(w.parent);
								break;
							}else{
								if(w.right.RED){
									w.right.RED=false;
									w.RED=true;
									leftRotate(w);
								}else{
									w.RED=true;
									x=x.parent;
								}
							}
						}
					}
				}
			}
		}
		
		root.RED=false;
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
					}else{
						x.parent.right=null;
					}
					x.parent=null;
				}
			}else{
				System.out.println("case2:");
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
				
				if(!x.RED){
					if(x.right.RED){
						x.right.RED=false;
					}else{
						adjustForDelete(x.right);
					}
				}
				
				x.right=null;
			}
		}else if(x.right==null){
			System.out.println("case3:");
			x.left.parent=x.parent;
			if(x.parent==null){
				root=x.left;
			}else{
				if(x.parent.left==x){
					x.parent.left=x.left;
				}else{
					x.parent.right=x.left;
					
				}
				x.parent=null;
			}
			
			if(!x.RED){
				if(x.left.RED){
					x.left.RED=false;
				}else{
					adjustForDelete(x.left);
				}
			}

			x.left=null;
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
				
				if(y.RED){
					y.RED=false;
				}else{
					y.RED=x.RED;
					if(y.right!=null){
						if(y.right.RED){
							y.right.RED=false;
						}else{
							adjustForDelete(y.right);
						}
					}
				}
				
				x.right=null;
			}else{
				System.out.println("case5:");
				Node<Integer> z=y.right;
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
				
				if(!y.RED){
					y.RED=x.RED;
					if(z!=null){
						if(z.RED){
							z.RED=false;
						}else{
							adjustForDelete(z);
						}
					}
				}else{
					y.RED=x.RED;
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
				System.out.print(" "+x.key+"|"+x.RED);
				x=successor(x);
			}
			System.out.println();
			
			System.out.println("root:"+root.key);
			System.out.println("-------------------------------------------");
		}
	}
	
	public static void main(String[] args){
		RBTree tree=new RBTree();
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
		
		
	}
	
}
