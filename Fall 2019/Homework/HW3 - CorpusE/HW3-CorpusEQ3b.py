class TreeNode(object): 
    def __init__(self, val): 
        self.val = val 
        self.left = None
        self.right = None
        self.height = 1
  
# Insert operation 
class AVL_Tree(object): 
  
    # new root of subtree. 
    def insert(self, root, key): 
      
        if not root: 
            return TreeNode(key) 
        elif key < root.val: 
            root.left = self.insert(root.left, key) 
        else: 
            root.right = self.insert(root.right, key) 
  
        root.height = 1 + max(self.getHeight(root.left), 
                           self.getHeight(root.right)) 
  
        balance = self.getBalance(root) 
  
        if balance > 1 and key < root.left.val: 
            return self.rightRotate(root) 
  
        if balance < -1 and key > root.right.val: 
            return self.leftRotate(root) 
  
        if balance > 1 and key > root.left.val: 
            root.left = self.leftRotate(root.left) 
            return self.rightRotate(root) 
  
        if balance < -1 and key < root.right.val: 
            root.right = self.rightRotate(root.right) 
            return self.leftRotate(root) 
  
        return root 
  
    def leftRotate(self, z): 
  
        y = z.right 
        T2 = y.left 
  
        y.left = z 
        z.right = T2 
  
        z.height = 1 + max(self.getHeight(z.left), 
                         self.getHeight(z.right)) 
        y.height = 1 + max(self.getHeight(y.left), 
                         self.getHeight(y.right)) 
  
        return y 
  
    def rightRotate(self, z): 
  
        y = z.left 
        T3 = y.right 
  
        y.right = z 
        z.left = T3 
  
        z.height = 1 + max(self.getHeight(z.left), 
                        self.getHeight(z.right)) 
        y.height = 1 + max(self.getHeight(y.left), 
                        self.getHeight(y.right)) 
  
        return y 
  
    def getHeight(self, root): 
        if not root: 
            return 0
  
        return root.height 
  
    def getBalance(self, root): 
        if not root: 
            return 0
  
        return self.getHeight(root.left) - self.getHeight(root.right) 
  
    def preOrder(self, root): 
  
        if not root: 
            return
  
        print("{0} ".format(root.val), end="") 
        self.preOrder(root.left) 
        self.preOrder(root.right) 
 
    def delete(self, root, key): 
  
        if not root: 
            return root 
  
        elif key < root.val: 
            root.left = self.delete(root.left, key) 
  
        elif key > root.val: 
            root.right = self.delete(root.right, key) 
  
        else: 
            if root.left is None: 
                temp = root.right 
                root = None
                return temp 
  
            elif root.right is None: 
                temp = root.left 
                root = None
                return temp 
  
            temp = self.getMinValueNode(root.right) 
            root.val = temp.val 
            root.right = self.delete(root.right, 
                                      temp.val) 
  
        if root is None: 
            return root 
 
        root.height = 1 + max(self.getHeight(root.left), 
                            self.getHeight(root.right)) 
  
        balance = self.getBalance(root) 
  
        if balance > 1 and self.getBalance(root.left) >= 0: 
            return self.rightRotate(root) 
  
        if balance < -1 and self.getBalance(root.right) <= 0: 
            return self.leftRotate(root) 
  
        if balance > 1 and self.getBalance(root.left) < 0: 
            root.left = self.leftRotate(root.left) 
            return self.rightRotate(root) 
  
        if balance < -1 and self.getBalance(root.right) > 0: 
            root.right = self.rightRotate(root.right) 
            return self.leftRotate(root) 
  
        return root 


#(a key of node: a depth of node, a key of parent, a key of left-child, a key of right-child) 
    #def printOrder(self, root, key):

  

  
myTree = AVL_Tree() 
root = None
  
root = myTree.insert(root, 20) 
root = myTree.insert(root, 40) 
root = myTree.insert(root, 50) 
root = myTree.insert(root, 78) 
root = myTree.insert(root, 88) 
root = myTree.insert(root, 62) 
root = myTree.insert(root, 70)
root = myTree.insert(root, 55)  
 
myTree.preOrder(root) 
print()

# Delete 
key = 40
root = myTree.delete(root, key) 
myTree.preOrder(root) 
print()

print("50: 0, null, 40, 78")