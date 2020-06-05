class Node:
    def __init__(self, val=None):
        self.val = val
        self.next = None
    
class LinkedList:
    def __init__(self, head=None):
        self.head = Node(head)

    def atEnd(self, val):
        newNode = Node(val)
        if(self.head):
            last = self.head
            while(last.next):
                last = last.next
            last.next = newNode
        else:
            self.head = newNode

    def getMiddle(self):
        slowPt = self.head
        fastPt = self.head

        while(fastPt):
            slowPt = slowPt.next
            fastPt = fastPt.next.next
        
        return slowPt.val

    def printList(self):
        temp = self.head
        while(temp):
            print(temp.val)
            temp = temp.next


ll = LinkedList(5)
ll.atEnd(2)
ll.atEnd(3)
ll.atEnd(9)
ll.atEnd(55)
ll.atEnd(8)
ll.atEnd(7)
ll.atEnd(6)
ll.printList()
print(ll.getMiddle())
