class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def ValidBST(root, left=None, right=None):
    if(root is None):
        return True
    
    if(left != None and root.value <= left.value):
        return False
    
    if(right != None and root.value >= right.value):
        return False
    
    return ValidBST(root.left, left, root) and ValidBST(root.right, root, right)

def printTree(root):
    
    if(root.left is not None):
        printTree(root.left)
    print(root.value, end=' ')
    if(root.right is not None):
        printTree(root.right)

    

H = Node(5)
H.left = Node(2)
H.left.left = Node(1)
H.left.right = Node(3)
H.right = Node(7)
H.right.left = Node(6)
H.right.right = Node(8)

printTree(H)
print(ValidBST(H))
        

    