#w = node , k = key , v - root 

class Node:
    
    def __init__(self, value):
        self.value = value
        self.leftChild = None
        self.rightChild = None


class binarySearchTree:
    def __init__(self):
        self.root = None

    def insertNode(self, value):
        if self.root == None:
            self.root = Node(value)
        else:
            self._insert(value,self.root)

    def _insert(self, value, curNode):
        if value < curNode.value:
            if curNode.leftChild == None:
                curNode.leftChild = Node(value)
            else:
                self._insert(value, curNode.leftChild)
        elif value > curNode.value:
            if curNode.rightChild == None:
                curNode.rightChild = Node(value)
            else:
                self._insert(value, curNode.rightChild)

    def inOrder(self, curNode):
        res = []
        if curNode:
            self.inOrder(curNode.leftChild)
            res.append(curNode.value)
            self.inOrder(curNode.rightChild)
        return res

    def printTree(self):
        if self.root != None:
            self._printTree(self.root)
            

    def _printTree(self, curNode):
        if curNode != None:
            self._printTree(curNode.leftChild)
            print(curNode.value)
            self._printTree(curNode.rightChild)

    def search(self, value):
        if self.root != None:
            return self._search(value, self.root)
        else:
            return False

    def _search(self, value, curNode):
        if value == curNode.value:
            return True
        elif value < curNode.value and curNode.leftChild != None:
            return self._search(value, curNode.leftChild)
        elif value > curNode.value and curNode.rightChild != None:
            return self._search(value, curNode.rightChild)
        return False
    


tree = binarySearchTree()
tree.insertNode(25)
tree.insertNode(35)
tree.insertNode(45)
tree.insertNode(20)
tree.insertNode(30)
tree.insertNode(5)
tree.insertNode(55)
tree.insertNode(43)
tree.insertNode(22)
tree.insertNode(6)
tree.insertNode(8)
tree.insertNode(40)

tree.printTree()

print(tree.search(55))

print(tree.inOrder(tree))


'''
    def 
def inOrder(


def search(k, v):
    if v == w:
        return v
    if k = w:
        return v
    else
        if k < key: 
            return search(k, w.leftChild)
        else:
            return seach(k, w.rightChild)



root = Node(25)
root.insertNode(35)
root.insertNode(45)
root.insertNode(20)
root.insertNode(30)
root.insertNode(5)
root.insertNode(55)
root.insertNode(43)
root.insertNode(22)
root.insertNode(6)
root.insertNode(8)
root.insertNode(40)
'''

