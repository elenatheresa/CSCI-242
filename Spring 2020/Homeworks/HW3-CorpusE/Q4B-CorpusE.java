public class RBTree {
	
	class Node{
		Node left, right, current;
		int key, height;
		char color;
		public Node parent = null;
		
		public Node (int n) {
			left = right = null;
			key = n;
			height = 1;
			color = 'R';
		}
	}
	static Node root = null;
	
	Node insert(int key) {
		Node current = root;
		
		if(root == null) {
			root = new Node(key);
			setColor(root, 'B');
		} else {
			do {
				if(key < current.key && current.left == null) {
					current.left = new Node(key);
					current.left.parent = current;
					break;
				} else if (key > current.key && current.right == null) {
					current.right = new Node(key);
					current.right.parent = current;
					break;
				} else if(key < current.key && current.left != null) {
					current = current.left;
				} else if (key > current.key && current.right != null) {
					current = current.right;
				}
					
			} while (current != null);
			while (current != null) {
				treeBalance (root);
				current = current.parent;
			}
		}
		return current;
	}
	
	private void setColor(Node current, char color) {
		current.color = color;
	}
	
	Node treeBalance(Node node){
		//Node current = root;
		Node parent, grandparent,uncle;
		
		if (node.parent == null) {
			setColor(node,'B');
			return node;
		}
		if(node.parent.color == 'B')
			return node;
		parent = node.parent;
		grandparent = getGrandparent(node);
		uncle = getUncle(node);
		
		if (uncle != null && uncle.color == 'R') {
			setColor(parent,'B');
			setColor(uncle,'B');
			setColor(grandparent,'R');
			treeBalance(grandparent);
			return node;
		} 
		if (node == parent.right && parent == grandparent.left) {
			rotateLeft(parent);
			node = parent;
			parent = node.parent;
		}else if(node == parent.left && parent == grandparent.right) {
			rotateRight(parent);
			node = parent;
			parent = node.parent;
		}
		setColor(parent, 'B');
		setColor(grandparent, 'R');
		
		if (node == parent.left) 
			rotateRight(grandparent);
		else
			rotateLeft(grandparent);
		return null;
	}
	int height(Node node) {
		if (node == null) 
			return 0;
		else
			return node.height;
	}
	
	Node rotateLeft(Node x) {
		Node y = x.right; 
        Node temp = y.left; 
  
      
        y.left = x; 
        x.right = temp; 
        
        //x.height = Math.max(height(x.left), height(x.right)) + 1; 
        //y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y; 
		}
	
	Node rotateRight(Node y) {
		Node x = y.left;
		Node temp = x.right;
		
		x.right = y; 
        y.left = temp; 
  
        //y.height = Math.max(height(y.left), height(y.right)) + 1; 
        //x.height = Math.max(height(x.left), height(x.right)) + 1; 
  
        return x; 
	}
	
	Node getGrandparent(Node node) {
		if (node.parent == null) 
			return null;
		else 
			return node.parent.parent;
		
	}
	
	Node getUncle(Node node) {
		Node grandParent = null;
		if (node.parent != null) 
			grandParent = node.parent.parent;
		if(grandParent == null) 
			return null;
		if (grandParent.left == node.parent){
			return grandParent.right;
		}else {
			return grandParent.left;
		}
	}
	
	Node successor(int key) {
		Node current = search(key);
		//Node next = null;
		boolean found = false;
		
		if (current.right != null) {
			current = current.right;
		while(!found) {
			if(current.left == null) {
				//next = current;
				found = true;
			} else {
				current = current.left;
			}
		}
		}else if (current.right == null) {
		while (!found) {
			if(current.parent.left == null) {
				if(current.parent.right.key == current.key) {
					current = current.parent;
				} else {
					current = current.parent;
					found = true;
				}
			}else {
					current = current.parent;
					found = true;
				}
			}
		}
		System.out.println("The successor for " + key + " is "+ current.key);
		treeBalance(current);
		return current;
	}
	Node search(int key) {
		Node current = root;
		while (current != null) {
			if (key>current.key) 
				//System.out.println("no match for " + key);
				current = current.right;
			else if (key<current.key) {
				//System.out.println("no match for " + key);
				current = current.left;
			} else if (key == current.key) {
				//System.out.println(current.key + ":" + current.height + "," + current.parent + ", " + current.right.key + ", " + current.left.key);
				//return current;
				System.out.println("Match found for " + current.key);
				break;
			}
		}
		return current;
	}
	
	void remove(int key){
		Node current = search(key);
		if(current.parent.right != null && current.parent.right.key == current.key) {
			current.key = successor(current.key).key;
			Node temp = successor(current.key).parent;
			temp.left = null;
			
		} else {
			current.key = successor(current.key).key;
			Node temp = successor(current.key);
			temp.key = temp.right.key;
			temp.right = null;
		}
		System.out.println("Delete of "+ key+ " Successful");
	}
	
	void inOrder(Node current) {
		if (current != null) {
			inOrder(current.left);
			if(current.left == null && current.right == null) {
				System.out.println("key-"+ current.key+" Color-"+current.color+": Depth-"+current.height+", Parent-"+current.parent.key+",Left Child-null, Right Child-null");
			} else if (root.left == null) {
				System.out.println("Key-"+current.key+" Color-"+current.color+": Depth-"+current.height+", Parent-"+current.parent.key+",Left Child-null, Right Child-"+current.right.key);
			} else if (current.right == null) {
				System.out.println("Key-"+current.key+" Color-"+current.color+": Depth-"+current.height+", Parent-"+current.parent.key+", Left Child-"+current.left.key+",Right Child- null");
			}else if (current.parent == null) {
				System.out.println("Key-"+current.key+" Color-"+current.color+": Depth-"+current.height+",Paernt- null, Left Child-"+current.left.key+", Right Child-"+current.right.key);
			}else {
				System.out.println("Key-"+current.key+" Color-"+current.color+": Depth-"+current.height+", Parent-"+current.parent.key+", Left Child-"+current.left.key+", Right Child-"+current.right.key);
			}
			inOrder(current.right);
		}
	}
	RBTree(int[] array) {
		root = new Node(array[0]);
		for(int i = 1; i < array.length; i++) {
			insert(array[i]);
		}	
	}	
	
	public static void main(String[] args) { 
        //Node current;
		int[] rbtArray = {50,20,80,10,45,65,90,30,55,70};
		RBTree tree = new RBTree(rbtArray); 
		
		
		tree.inOrder(root);
		System.out.print("\n");
		tree.remove(10);
		tree.inOrder(root);
		
	}
}
