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

root = Node(5)
root.insert(10)
root.insert(4)
root.insert(7)
root.insert(7)
root.printTree()

#https://www.bigocheatsheet.com/
