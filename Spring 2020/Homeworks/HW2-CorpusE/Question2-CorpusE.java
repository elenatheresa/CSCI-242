public class BST1 {
	class Node{
		Node left, right, currentent;
		
		int key;

		public Node parent = null;
		
		public Node (int n) {
			left = right = null;
			key = n;
		}
	}
	static Node root = null;
	
	Node insert(int key) {
		Node current = root;
		
		if(root == null) {
			root = new Node(key);
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
		}
		return current;
	}
		
		void inOrder(Node current) {
			if (current != null) {
				inOrder(current.left);
				System.out.print(current.key + " ");
				inOrder(current.right);
			}
		}
		
		Node root(Node root) {
			return root;
		}
		Node search(int key) {
			Node current = root;
			while (current != null) {
				if (key>current.key) 
					current = current.right;
				else if (key<current.key) {
					current = current.left;
				} else if (key == current.key) {
					return current;
				}
			}
			return current;
		}
		
		Node successor(int key) {
			Node current = search(key);
			boolean found = false;
			
			if (current.right != null) {
				current = current.right;
			while(!found) {
				if(current.left == null) {
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
			return current;
		}
		
		Node predecessor(int key) {
			Node current = search(key);
			boolean found = false;
			
			if (current.left != null) {
				current = current.left;
			while(!found) {
				if(current.right == null) {
					found = true;
				} else {
					current = current.right;
				}
			}
			}else if (current.left== null) {
			while (!found) {
				if(current.parent.right == null) {
					if(current.parent.left.key == current.key) {
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
			System.out.print("The predecessor for " + key + " is "+ current.key);
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
		
		void postOrder(Node current) { 
	        //if (root == null) 
	            //return; 
	        if(current.left != null) {
	        postOrder(current.left); 
	        } else if (current.right != null) {
	        	postOrder(current.right); 
	        }
	        System.out.print(current.key + " "); 
	    } 
		
		void rangeQuery(Node v, int k1, int k2) { 
	        Node current = v;
			// Base Case 
	        if(current == null) 
	            return; 
	  
	        if(current.key > k1) 
	        	rangeQuery(current.left, k1,k2);
	        
	        if (k1 <= current.key &&  k2 >= current.key) 
	        	System.out.print(current.key + " ");
	        
	        if (current.key < k2) 
	        	rangeQuery(current.right, k1, k2);
	        
	    }
		
		void isExternal(Node current){
			if (current.left == null && current.right == null)
				System.out.println(current.key + " is External");
			else
				System.out.println(current.key + " is not External");
		}
		
		void isRoot(int key) {
			if (key == root.key) 
				System.out.print(key + " is the root");
			else
				System.out.print(key + " is not the root");
		}
		
		Node LCA(Node root, Node v, Node w) {
			Node current = root;
			while (current != null) {
			if (current == v || current == w) {
				System.out.println(current.key);
				return current;}
			else {
			current.left =	LCA(current.left, v, w);
			current.right =LCA(current.right, v, w);
			if (current.left != null && current.right != null)
				return current;
			if (current.left == null)
				return current.right;
			else 
				return current.left;
						
			}
			
			}return current;
		}
		void select(Node root){
		
			while (root != null && root.right != null) { 
			root = root.right; 
			}
			System.out.print("The largest value is: "+ root.key);
			} 
	BST1(int[] array) {
		root = new Node(array[0]);
		for(int i = 1; i < array.length; i++) {
			insert(array[i]);
		}
	}	
	 public static void main(String[] args) {
		 int[] binaryArray = {25,35,45,20,30,5,55,43,22,6,8,40};
		 BST1 tree = new BST1 (binaryArray);
		 System.out.println("");
		 tree.inOrder(root);
		 System.out.println("\n");

		 tree.root(root);
		 System.out.println("The root is " + tree.root(root).key);
		 System.out.println("\n");
		 tree.search(45);
		 System.out.println("Match found for key " + tree.search(45).key + " at location " + tree.search(45));
		 System.out.println("\n");

		 tree.successor(8);
		 tree.successor(35);
		 
		System.out.println("\n");
		 tree.predecessor(20);
		 System.out.println("");
		 tree.predecessor(40);
		 
		 System.out.println("\n");
		 tree.remove(35);
		 tree.postOrder(root);
		 
		 System.out.println("\n");
		 tree.remove(8);
		 tree.postOrder(root);
		 
		System.out.println("\n");
		 tree.rangeQuery(root, 25, 45);
		 
		 System.out.println("\n");
		 tree.isExternal(tree.search(40));
		 
		 System.out.println("\n");
		 tree.isRoot(25);
		 
		 System.out.println("\n");
		 tree.select(root);
		 
		 Node v = tree.search(35);
		 Node w = tree.search(45);
		 System.out.println("\n");
		 System.out.println("The LCA of 35 and 45 is: ");
		 tree.LCA(root,v,w);
		 System.out.println("\n");

		 System.out.println("\n");
		 tree.rangeQuery(root, 25, 45);

	 }
}
