RBTreeSetChild(parent, whichChild, child) {
   if (whichChild != "left" && whichChild != "right")
      return false

   if (whichChild == "left")
      parent->left = child
   else
      parent->right = child
   if (child != null)
      child->parent = parent
   return true
}

RBTreeReplaceChild(parent, currentChild, newChild) {
   if (parent->left == currentChild)
      return RBTreeSetChild(parent, "left", newChild)
   else if (parent->right == currentChild)
      return RBTreeSetChild(parent, "right", newChild)
   return false
}

RBTreeRotateLeft(tree, node) {
   rightLeftChild = node->right->left
   if (node->parent != null)
      RBTreeReplaceChild(node->parent, node, node->right)
   else { // node is root
      tree->root = node->right
      tree->root->parent = null
   }
   RBTreeSetChild(node->right, "left", node)
   RBTreeSetChild(node, "right", rightLeftChild)
}

RBTreeRotateRight(tree, node) {
   leftRightChild = node->left->right
   if (node->parent != null)
      RBTreeReplaceChild(node->parent, node, node->left)
   else { // node is root
      tree->root = node->left
      tree->root->parent = null
   }
   RBTreeSetChild(node->left, "right", node)
   RBTreeSetChild(node, "left", leftRightChild)
}

RBTreeInsert(tree, node) {
   BSTInsert(tree, node)
   node->color = red
   RBTreeBalance(tree, node)
}

RBTreeBalance(tree, node) {
  if (node->parent == null) {
     node->color = black
     return
  }
  if (node->parent->color == black)
     return
  parent = node->parent
  grandparent = RBTreeGetGrandparent(node)
  uncle = RBTreeGetUncle(node)
  if (uncle != null && uncle->color == red) {
     parent->color = uncle->color = black
     grandparent->color = red
     RBTreeBalance(tree, grandparent)
     return
  }
  if (node == parent->right &&
      parent == grandparent->left) {
     RBTreeRotateLeft(tree, parent)
     node = parent
     parent = node->parent
  }
  else if (node == parent->left &&
           parent == grandparent->right) {
     RBTreeRotateRight(tree, parent)
     node = parent
     parent = node->parent
  }
  parent->color = black
  grandparent->color = red
  if (node == parent->left)
     RBTreeRotateRight(tree, grandparent)
  else
     RBTreeRotateLeft(tree, grandparent)
}

RBTreeRemoveNode(tree, node) {
   if (node->left != null && node->right != null) {
      predecessorNode = RBTreeGetPredecessor(node)        
      predecessorKey = predecessorNode->key
      RBTreeRemoveNode(tree, predecessorNode)
      node->key = predecessorKey
      return
   }

   if (node->color == black)
      RBTreePrepareForRemoval(node)
   BSTRemove(tree, node->key)
}

RBTreeGetPredecessor(node) {
   node = node->left
   while (node->right != null) {
      node = node->right
   }
   return node
}

RBTreeGetSibling(node) {
   if (node->parent != null) {
      if (node == node->parent->left)
         return node->parent->right
      return node->parent->left
   }
   return null
}