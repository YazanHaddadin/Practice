import unittest
from ValidBST import ValidBST

class Node:

    def __init__(self, value):
        self.left = None
        self.right = None
        self.value = value

    def insert(self, value):
        if(self.value):
            if(value < self.value):
                if(self.left == None):
                    self.left = Node(value)
                else:
                    self.left.insert(value)
            elif(value > self.value):
                if(self.right == None):
                    self.right = Node(value)
                else:
                    self.right.insert(value)
            else:
                print(f"{value} already exists")
        else:
            self.value = value
    
    def printTree(self):
        if(self.left):
            self.left.printTree()
        print(self.value)
        if(self.right):
            self.right.printTree()

class TestTree(unittest.TestCase):
    testT = Node(5)
    testT.insert(3)
    testT.insert(6)
    testT.insert(10)
    testT.insert(-1)

    def test_insert(self):
        self.assertTrue(ValidBST(self.testT), "NO")


if __name__ == "__main__":
    unittest.main()


