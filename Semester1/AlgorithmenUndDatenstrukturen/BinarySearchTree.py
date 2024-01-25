class TreeNode:
    """This is a class for a tree node which must contains a value as key and may contains a reference his kids."""
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

    def __del__(self):
        del(self)

class BinarySearchTree:
    """ This class is for the binary search tree. The nodes are in a seperate class.
        The key of a tree are only necessary for the test method."""
    def __init__(self, node = None, key = None):
        self.root = node
        self.key = key

    def insertNode(self, node):
        """This method insert a node. 
            Case 1: Search for a node with a value higher than the insert node value and no left child.
            Case 2: Search for a node with a value lower than the insert node value and no right child.
            Insert the new node as child of the founded node."""
        if(self.root == None):
            self.root = node
        else:
            current = self.root
            while current:
                if(node.value < current.value):
                    if current.left:
                        current = current.left
                    else:
                        current.left = node
                        current = None
                else:
                    if current.right:
                        current = current.right
                    else:
                        current.right = node
                        current = None
            current = node

    def deleteNode(self, node):
        """ This method deletes a node.
            Case 1: The node is a leaf, then we set the reference to it None.
            Case 2: The node has only one child. This child gets pulled up to the position of the node.
            Case 3: The node has two childs, but one is a leaf. The leaf gets pulled up to the position of the node.
            Case 4: The node has two childs and neither of them are leafs. Then we search for the node furthest left in the right subtree.
                    This node will be swapped with the node to delete. After that the node furthest left will be deleted."""
        parent = self.findParent(node)
        if self.nodeIsLeaf(node):
            self.setParentKids(parent,node,None)
        elif node.left and node.right:
            rightNode = node.right
            leftNode = node.left
            if self.nodeIsLeaf(rightNode):
                rightNode.left = node.left
                self.setParentKids(parent, node, rightNode)
            elif self.nodeIsLeaf(leftNode):
                leftNode.right = node.right
                self.setParentKids(parent, node, leftNode)
            else:
                rightTree = BinarySearchTree(rightNode)
                nodeFurthestLeft = rightTree.findNodeFurthestLeft()
                tmp = nodeFurthestLeft
                self.deleteNode(nodeFurthestLeft)
                tmp.left = node.left
                tmp.right = node.right
                self.setParentKids(parent, node, tmp)
        else:
            if node.left:
                self.setParentKids(parent, node, node.left)
            else:
                self.setParentKids(parent, node, node.right)

    def findNodeFurthestLeft(self) -> TreeNode:
        """This method starts at the root of the tree and jumps to the left child, if the child exists."""
        node = self.root
        while node.left:
            node = node.left
        return node

    def nodeIsLeaf(self, node) -> bool:
        """This method checks if a node has no children and is therefore a leaf."""
        if not node.left and not node.right:
            return True
        else: return False

    def setParentKids(self, parent, oldCild, newChild):
        """ This method changes the reference from an old child to a new child. 
            If the parent is None, the old child was the root, so the new child have to become the root."""
        if parent:
            if parent.left == oldCild:
                parent.left = newChild
            else:
                parent.right = newChild
        else:
            self.root = newChild
    
    def findParent(self, node) -> TreeNode:
        """This method finds the parent of a node."""
        root = self.root
        if root == node:
            return None
        else:
            parent = root
            while not parent.left == node and not parent.right == node:
                if node.value < parent.value:
                    parent = parent.left
                else:
                    parent = parent.right
            return parent
        
    def findNodeByKey(self, key) -> TreeNode:
        """This method checks by the key if a node exists in the tree. If it does, the method returns the node."""
        root = self.root
        if not root:
            return None
        elif root.value == key:
            return root
        elif key < root.value:
            leftTree = BinarySearchTree(root.left)
            return leftTree.findNodeByKey(key)
        else:
            rightTree = BinarySearchTree(root.right)
            return rightTree.findNodeByKey(key)

    def printTreePreOrder(self):
        """This method calls the recursive method preOrder with the root to print the whole tree in pre order."""
        rootNode = self.root
        self.preOrder(rootNode)

    def preOrder(self, node):
        """This method prints the tree in pre order from the given node. After every node the associated balance of the subtree is printed."""
        if not node:
            return
        leftNode = node.left
        rightNode = node.right
        currentTree = BinarySearchTree(node)
        balance = currentTree.treeBalance()
        if not leftNode == None and not rightNode == None:
            print("(", node.value, ",", leftNode.value,",",rightNode.value,")-Balance:", balance, end="  ")
        elif leftNode:
            print("(", node.value, ",", leftNode.value,", None )-Balance:", balance, end="  ")
        elif rightNode:
            print("(", node.value, ", None ,",rightNode.value,")-Balance:", balance, end="  ")
        else:
            print("(", node.value, ", None , None )-Balance:", balance, end="  ")
        self.preOrder(leftNode)
        self.preOrder(rightNode)

    def treeBalance(self) -> int:
        """ This method calculates the balance of a tree."""
        current = self.root
        leftTree = BinarySearchTree(current.left)
        rightTree = BinarySearchTree(current.right)
        balance = leftTree.treeHeight() - rightTree.treeHeight()
        return balance

    def treeHeight(self) -> int:
        """ This method determines the height of a tree."""
        current = self.root
        if not current:
            return 0
        else:
            leftTree = BinarySearchTree(current.left)
            rightTree = BinarySearchTree(current.right)
            leftTreeHeight = leftTree.treeHeight()
            rightTreeHeight = rightTree.treeHeight()
            if leftTreeHeight >= rightTreeHeight:
                return leftTreeHeight +1
            else:
                return rightTreeHeight +1

if __name__ == "__main__":
    treeList = []

    def findTreeByKey(key) -> BinarySearchTree:
        """This method finds a tree from the treeList by a key."""
        tree = None
        for x in range(0, len(treeList)):
            currentTree = treeList[x]
            treeKey = currentTree.key
            if treeKey == key:                        
                tree = currentTree
        return tree

    def testMethod():
        finish = False
        print("Codes for testing:")
        print("n - create new tree")
        print("k - insert node")
        print("l - delete node")
        print("c - change the key of a node")
        print("b - balance of the tree")
        print("d - print tree")
        print("dA - print all treekeys")
        print("pC - print testing codes again")
        print("e - finish testing")
        while not finish:
            code = input("\nPlease insert your Code: ")
            if code == "n":
                key = input("Please insert the tree key: ")
                testTreeExists = findTreeByKey(key)
                if testTreeExists == None:
                    newTree = BinarySearchTree(key=key)
                    treeList.append(newTree)
                    print("Tree created!")
                else:
                    print("There is actually a tree with this key.")
            elif code == "k":
                key = input("Please insert the key of the tree: ")
                tree =  findTreeByKey(key)
                if tree:
                    nodeValue = input("Please insert your node value: ")
                    nodeValue = int(nodeValue)
                    node = TreeNode(nodeValue)
                    tree.insertNode(node)
                else:
                    print("Your tree key isn't valid.")
            elif code == "l":
                key = input("Please insert the key of the tree: ")
                tree =  findTreeByKey(key)
                if tree:
                    nodeValue = input("Please insert your node value to delete: ")
                    nodeValue = int(nodeValue)
                    node = tree.findNodeByKey(nodeValue)
                    if node:
                        tree.deleteNode(node)
                    else:
                        print("Your tree doesn't contains a node with this value.")
                else:
                    print("Your tree key isn't valid.")
            elif code == "c":
                print("If we want to change the key of a node, we can do this in four steps.\nStep 1: Save the node in a temporary var.\nStep 2: Delete the node.\nStep 3: Modify the key of the temporary var.\nStep 4: Insert the temporary var as new node.")
                print("Not implemented yet.")
            elif code == "b":
                key = input("Please insert the key of the tree: ")
                tree =  findTreeByKey(key)
                print("Balance:" , tree.treeBalance())
            elif code == "d":
                key = input("Please insert the key of the tree: ")
                tree =  findTreeByKey(key)
                if tree:
                    tree.printTreePreOrder()
                    print("")
                else:
                    print("There is no tree with this key.")
            elif code == "dA":
                if len(treeList) == 0:
                    print("Your tree list is empty.")
                else:
                    for x in range(0, len(treeList)):
                        currentTree = treeList[x]
                        root = currentTree.root
                        print("Tree", x+1, end=": ")
                        if root:                        
                            print("Key:", currentTree.key, "Rootvalue:", root.value)
                        else:
                            print("Key:", currentTree.key, "Rootvalue: None")
            elif code == "pC":
                print("Codes for testing:")
                print("n - create new tree")
                print("k - insert node")
                print("l - delete node")
                print("c - change the key of a node")
                print("d - print tree")
                print("dA - print all treekeys")
                print("pC - print testing codes again")
                print("e - finish testing")
            elif code == "e":
                finish = True
            else:
                print("This isn't a valid code.")

    """This tree is hardcoded for easier testing."""
    tree = BinarySearchTree(node=TreeNode(10), key="a")
    treeList.append(tree)
    tree.insertNode(TreeNode(5))
    tree.insertNode(TreeNode(12))
    tree.insertNode(TreeNode(2))
    tree.insertNode(TreeNode(7))
    tree.insertNode(TreeNode(11))
    tree.insertNode(TreeNode(14))
    tree.insertNode(TreeNode(17))
    tree.insertNode(TreeNode(25))

    tree.printTreePreOrder()

    print("\nBalance:" , tree.treeBalance())

    testMethod()