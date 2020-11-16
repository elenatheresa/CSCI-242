AVLTreeUpdateHeight(node) {
   leftHeight = -1
   if (node->left != null)
      leftHeight = node->left->height
   rightHeight = -1
   if (node->right != null)
      rightHeight = node->right->height
   node->height = max(leftHeight, rightHeight) + 1
}


AVLTreeSetChild(parent, whichChild, child) {
   if (whichChild != "left" && whichChild != "right")
      return false

   if (whichChild == "left")
      parent->left = child
   else
      parent->right = child
   if (child != null)
      child->parent = parent

   AVLTreeUpdateHeight(parent)
   return true
}

AVLTreeReplaceChild(parent, currentChild, newChild) {
   if (parent->left == currentChild)
      return AVLTreeSetChild(parent, "left", newChild)
   else if (parent->right == currentChild)
      return AVLTreeSetChild(parent, "right", newChild)
   return false
}

AVLTreeGetBalance(node) {
   leftHeight = -1
   if (node->left != null)
      leftHeight = node->left->height
   rightHeight = -1
   if (node->right != null)
      rightHeight = node->right->height
   return leftHeight - rightHeight
}

AVLTreeRotateRight(tree, node) {
   leftRightChild = node->left->right
   if (node->parent != null)
      AVLTreeReplaceChild(node->parent, node, node->left)
   else { // node is root
      tree->root = node->left
      tree->root->parent = null
   }
   AVLTreeSetChild(node->left, "right", node)
   AVLTreeSetChild(node, "left", leftRightChild)
}

AVLTreeRebalance(tree, node) {
   AVLTreeUpdateHeight(node)        
   if (AVLTreeGetBalance(node) == -2) {
      if (AVLTreeGetBalance(node->right) == 1) {
         // Double rotation case.
         AVLTreeRotateRight(tree, node->right)
      }
      return AVLTreeRotateLeft(tree, node)
   }
   else if (AVLTreeGetBalance(node) == 2) {
      if (AVLTreeGetBalance(node->left) == -1) {
         // Double rotation case.
         AVLTreeRotateLeft(tree, node->left)
      }
      return AVLTreeRotateRight(tree, node)
   }        
   return node
}

AVLTreeInsert(tree, node) {
   if (tree->root == null) {
      tree->root = node
      node->parent = null
      return
   }

   cur = tree->root
   while (cur != null) {
      if (node->key < cur->key) {
         if (cur->left == null) {
            cur->left = node
            node->parent = cur
            cur = null
         }
         else {
            cur = cur->left
         }
      }
      else {
         if (cur->right == null) {
            cur->right = node
            node->parent = cur
            cur = null
         }
         else
            cur = cur->right
      }
   }

   node = node->parent
   while (node != null) {
      AVLTreeRebalance(tree, node)
      node = node->parent
   }
}


AVLTreeRemoveNode(tree, node) {
   if (node == null)
      return false
   .
   .
   .
   node = parent
   while (node != null) {
      AVLTreeRebalance(tree, node)            
      node = node->parent
   }
   return true
}

AVLTreeRebalance(tree, node) {
   AVLTreeUpdateHeight(node)        
   if (AVLTreeGetBalance(node) == -2) {
      if (AVLTreeGetBalance(node->right) == 1) {
         // Double rotation case.
         AVLTreeRotateRight(tree, node->right)
      }
      return AVLTreeRotateLeft(tree, node)
   }
   else if (AVLTreeGetBalance(node) == 2) {
      if (AVLTreeGetBalance(node->left) == -1) {
         // Double rotation case.
         AVLTreeRotateLeft(tree, node->left)
      }
      return AVLTreeRotateRight(tree, node)
   }        
   return node
}

AVLTreeRemoveNode(tree, node) {
   if (node == null)
      return false
        
   // Parent needed for rebalancing
   parent = node->parent
        
   // Case 1: Internal node with 2 children
   if (node->left != null && node->right != null) {
      // Find successor
      succNode = node->right
      while (succNode->left != null)
         succNode = succNode->left
            
      // Copy the value from the node
      node = Copy succNode
            
      // Recursively remove successor
      AVLTreeRemoveNode(tree, succNode)
            
      // Nothing left to do since the recursive call will have rebalanced
      return true
   }

   // Case 2: Root node (with 1 or 0 children)
   else if (node == tree->root) {
      if (node->left != null)
         tree->root = node->left
      else
         tree->root = node->right

      if (tree->root)
         tree->root->parent = null

      return true
   }

   // Case 3: Internal with left child only
   else if (node->left != null)
      AVLTreeReplaceChild(parent, node, node->left)
        
   // Case 4: Internal with right child only OR leaf
   else
      AVLTreeReplaceChild(parent, node, node->right)
        
   // node is gone. Anything that was below node that has persisted is already correctly
   // balanced, but ancestors of node may need rebalancing.
   node = parent
   while (node != null) {
      AVLTreeRebalance(tree, node)            
      node = node->parent
   }
   return true
}