class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

class SLinkedList:
    def __init__(self):
        self.headval = None

    def listprint(self):
        printval = self.headval
        while printval is not None:
            print (printval.data)
            printval = printval.next

    def AtBeg(self,newdata):
        NewNode = Node(newdata)

        NewNode.next = self.headval
        self.headval = NewNode

    def AtEnd(self, newdata):
        NewNode = Node(newdata)
        if self.headval is None:
            self.headval = NewNode
            return
        laste = self.headval
        while(laste.next):
            laste = laste.next
        laste.next=NewNode

    def Inbetween(self,middle_node,newdata):
        if middle_node is None:
            print("The mentioned node is absent")
            return

        NewNode = Node(newdata)
        NewNode.next = middle_node.next
        middle_node.next = NewNode

    def RemoveNode(self, Removekey):

        HeadVal = self.headval

        if (HeadVal is not None):
            if (HeadVal.data == Removekey):
                self.headval = HeadVal.next
                HeadVal = None
                return

        while (HeadVal is not None):
            if HeadVal.data == Removekey:
                break
            prev = HeadVal
            HeadVal = HeadVal.next

        if (HeadVal == None):
            return

        prev.next = HeadVal.next

        HeadVal = None

llist = SLinkedList()
llist.AtBeg("Mon")
llist.AtBeg("Tue")
llist.AtBeg("Wed")
llist.AtBeg("Thu")
llist.AtEnd("Sat")
llist.RemoveNode("Tue")
llist.listprint()