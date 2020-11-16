#Elena Corpus
#CSCI 242 - HW 2


class Node: 
  
    def __init__(self, key): 
        self.key = key  
        self.left = None
        self.right = None

def insert( node, key): 
  
    if node is None: 
        return Node(key) 
  
    if key < node.key: 
        node.left = insert(node.left, key) 
    else: 
        node.right = insert(node.right, key) 
  
    return node
  
def inorder(root): 
    if root is not None: 
        inorder(root.left) 
        print (root.key) 
        inorder(root.right) 

def root(self):
    return self.root
    

def search(root, key):
    if root == key:
        return True
    elif (root < key) and root.left != None:
        return seach(root, root.left)
    elif (root > key) and root.right != None:
        return search(root, root.right)
    return False   
  
 
def deleteNode(root, key): 
  
    if root is None: 
        return root  
  
    if key < root.key: 
        root.left = deleteNode(root.left, key) 
  
    elif(key > root.key): 
        root.right = deleteNode(root.right, key) 
  
    else: 
          
        if root.left is None : 
            temp = root.right  
            root = None 
            return temp  
              
        elif root.right is None : 
            temp = root.left  
            root = None
            return temp 
   
        temp = minValueNode(root.right) 
  
        root.key = temp.key 
  
        root.right = deleteNode(root.right , temp.key) 
  
    return root


def successor(value, root, vFound):
    if root is not None: 
        successor(value, root.left,vFound) 
        if root.key == value:
            print(root.key)
            vFound = True
        elif vFound: 
            print(root.key)
            vFound = False
        successor(value, root.right, vFound)
        


def predecessor(root):
    if root is not None: 
        predecessor(value, root.left, vFound)  
        if root.key == key:
            if root.right is not None: 
                tmp = root.right 
                while(temp.left): 
                    tmp = tmp.left  
                predecessor.suc = tmp  
  
            return
    
    if root.key > key : 
        predecessor.suc = root  
        predecessor(root.left, key) 
  
    else: 
        predecessor.pre = root 
        predecessor(root.right, key)

'''
def removeAboveExternal(node):
# remove an external node w and its parent node v, then reconnect v’s
# parent with w’s sibling. 


def remove(key):
# Remove a node of (a) the key 35, then that of (b) the key 5 
    if root is None or root.val == key:
        return root
  
    if root.val < key: 
        return search(root.right,key) 
    
    return search(root.left,key)



    
def postOrder(v):
#Then, (c) print the keys after each deletion in 7) by PostOrder traversal


def rangeQuery(k1, k2, v):
#find and print the keys in the range of [25, 45].





def isExternal(v):
#Test whether a node v with a key 40 is an external node.





def isRoot(v):
#Test whether a node v with a key 25 is the root of BST.



'''


key = 100
  
root = None
root = insert(root, 25) 
root = insert(root, 23) 
root = insert(root, 45) 
root = insert(root, 20) 
root = insert(root, 30) 
root = insert(root, 5) 
root = insert(root, 55)
root = insert(root, 43) 
root = insert(root, 22) 
root = insert(root, 6) 
root = insert(root, 8)
root = insert(root, 40)
  
print ("Inorder traversal of the given tree")
inorder(root) 
  
print ()
root = deleteNode(root, 35) 
print ("Inorder traversal of the modified tree")
inorder(root) 
  
print ()
root = deleteNode(root, 5) 
print ("Inorder traversal of the modified tree")
inorder(root)

#print(search(root, 45)) 

# Static variables of the function findPreSuc  
predecessor.pre = None
successor.suc = None
  
#findPreSuc(root, key) 
if predecessor.pre is not None: 
    print ("Predecessor is", findPreSuc.pre.key )
  
else: 
    print ("No Predecessor")

vFound = False
successor(8, root, vFound)

'''
if successor(8, root, vFound) is not None: 
    print ("Successor is",  )
else: 
    print ("No Successor")
'''
