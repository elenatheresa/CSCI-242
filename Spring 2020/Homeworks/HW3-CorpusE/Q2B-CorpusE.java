public class AVL {

	class Node{
		Node left, right, current;
		int key, height;
		public Node parent = null;
		
		public Node (int n) {
			left = right = null;
			key = n;
			height = 1;
		}
	}
	static Node root = null;
	
	Node insertAVL(int key) {
		Node current = root;
		
		if (root == null) {
			root = new Node (key);
			root.parent = null;
		} else {
			current = root;
			do {
				if (key < current.key && current.left == null) {
						current.left = new Node (key);
						current.left.parent = current;
						//current = null;
						break;
				} else if (key > current.key && current.right == null) {
					current.right = new Node(key);
					current.right.parent = current;
					break;
					//current = null;
				}else if (key < current.key && current.left != null){
						current = current.left;
				}else if (key > current.key && current.right != null){
						current = current.right;
				}
			
			}while (current != null);
		}
			//current = current.parent;
			while (current != null) {
				treeBalance (root, key);
				current = current.parent;
			}
			return current;
		}
		
	Node treeBalance(Node root, int key){
		Node current = root;
		current.height = 1 + Math.max(height(current.left), height(current.right));
		
		int balance = getBalance(current);
		if (balance > 1 && key < current.left.key) 
            return rightRotate(current); 
		
		if (balance < -1 && key > current.right.key) 
            return leftRotate(current); 
		
		if (balance > 1 && key > current.left.key) { 
            current.left = leftRotate(current.left); 
            return rightRotate(current);
		}
		if (balance < -1 && key < current.right.key) { 
            current.right = rightRotate(current.right); 
            return leftRotate(current); 
		}
		return current;
	}
	
	/*int max(int a, int b) { 
        return (a > b) ? a : b; 
    }*/
	
	
	int height(Node node) {
		if (node == null) 
			return 0;
		else
			return node.height;
	}
	
	Node leftRotate(Node x) { 
        Node y = x.right; 
        Node temp = y.left; 
  
      
        y.left = x; 
        x.right = temp; 
        
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y; 
    } 
	
	Node rightRotate(Node y) {
		Node x = y.left;
		Node temp = x.right;
		
		x.right = y; 
        y.left = temp; 
  
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
  
        return x; 
	}
	
	int getBalance(Node node) { 
        if (node == null) 
            return 0; 
  
        return height(node.left) - height(node.right); 
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
	
	void inOrder(Node current) {
		if (current != null) {
			inOrder(current.left);
			//System.out.print(current.key + " ");
			if(current.left == null && current.right == null) {
				System.out.println("key-"+current.key+": Depth-"+current.height+", Parent-"+current.parent.key+",Left Child-null, Right Child-null");
			} else if (root.left == null) {
				System.out.println("Key-"+current.key+": Depth-"+current.height+", Parent-"+current.parent.key+",Left Child-null, Right Child-"+current.right.key);
			} else if (current.right == null) {
				System.out.println("Key-"+current.key+": Depth-"+current.height+", Parent-"+current.parent.key+", Left Child-"+current.left.key+",Right Child- null");
			}else if (current.parent == null) {
				System.out.println("Key-"+current.key+": Depth-"+current.height+",Paernt- null, Left Child-"+current.left.key+", Right Child-"+current.right.key);
			}else {
				System.out.println("Key-"+current.key+": Depth-"+current.height+", Parent-"+current.parent.key+", Left Child-"+current.left.key+", Right Child-"+current.right.key);
			}
			inOrder(current.right);
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
		treeBalance(current, key);
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
	
	AVL(int[] array) {
		root = new Node(array[0]);
		for(int i = 1; i < array.length; i++) {
			insertAVL(array[i]);
		}
	}	
	public static void main(String[] args) { 
		int[] avlArray = {35,15,45,10,25,40,55};
		AVL tree = new AVL(avlArray); 
        
        tree.inOrder(root);
        System.out.print("\n");
        tree.remove(55);
        System.out.print("\n");
        tree.inOrder(root);
	}
}
