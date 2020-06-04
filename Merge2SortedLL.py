from LinkedList import SLinkedList

class ListNode:
    def __init__(self, data=0, next=None):
        self.data = data
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dum = ListNode(0)
        res = dum
        while l1 and l2:
            if(l1.data <= l2.data):
                res.next = l1
                l1 = l1.next
            else:
                res.next = l2
                l2 = l2.next
            res = res.next
            
        if l1 is None:
            res.next = l2
            
        if l2 is None:
            res.next = l1
        
        return dum.next

    def listprint(self, head):
        printval = head
        while printval is not None:
            print (printval.data)
            printval = printval.next

if __name__ == "__main__":
    ll = SLinkedList()
    ll.AtBeg(1)
    ll.AtEnd(3)
    ll.AtEnd(4)
    ll.AtEnd(7)

    ll2 = SLinkedList()
    ll2.AtBeg(2)
    ll2.AtEnd(3)
    ll2.AtEnd(5)
    ll2.AtEnd(10)

    res = Solution()

    result = res.mergeTwoLists(ll.headval, ll2.headval)

    res.listprint(result.next)


    
    