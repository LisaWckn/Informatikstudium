"""Class and tests for task 2 - Linked List"""

class LinkedList:
    """The class variable head with the value None. None is the equal to null in java for creating an empty variable."""
    head = None

    def __init__(self, value, next = None):
        """Constructor which only sets head, if the constructor get first time called."""
        if(LinkedList.head == None):
            LinkedList.head = self
        
        self.value = value
        self.next = next
    
    def print(self):
        """Function to print the part off the list after the current element."""
        current = self
        while current:
            print(current.value, end=" -> ")
            current=current.next
        print("None")
    
    def printList(self):
        """Function to print the complete list."""
        current = LinkedList.head
        while current:
            print(current.value, end=" -> ")
            current=current.next
        print("None")
    
    def setNextElem(self, node):
        """ Function sets the next element of self. If self is current the last element of the list, set the new node on next. 
            Else the current next need to be stored and set as next of the new node."""
        if(self.next == None):
            self.next = node
        else:
            currentNext = self.next
            self.next = node
            node.next = currentNext
    
    def setPrevElem(self, node):
        """ Function to set the previous element of self. 
            Case 1: Self is current the head, then will the new node be the head.
            Case 2: Self is not the head, so we iterate through the list and store the current previous element. 
                    After that we set the new node as the next of the current previous element."""
        if(self == LinkedList.head):
            LinkedList.head = node
            node.next = self
        else:
            elemPrevNode = LinkedList.head
            while(not elemPrevNode.next == self):
                elemPrevNode = elemPrevNode.next
            elemPrevNode.next = node
            node.next = self
    
    def removePrevElem(self):
        """ Function to remove the previous element of self.
            Case 1: Self is the head and there is no previous element, so we don't need to do anything.
            Case 2: Self is the second element of the list, so it becomes the head.
            Case 3: Self is in the middle of the list, so we store the tow element bevore self and skip with next the previous element."""
        firstElem = LinkedList.head
        secondElem = firstElem.next
        if(secondElem==self):
            LinkedList.head = self
        else:
            while( not secondElem == self):
                zerothElem = firstElem
                firstElem = secondElem
                secondElem = firstElem.next
        zerothElem.next = secondElem

    def setFirstElem(self, node):
        """ Function to set a new first element."""
        if(LinkedList.head == None):
            LinkedList.head = node
        else:
            oldFirstElem = LinkedList.head
            LinkedList.head = node
            node.next = oldFirstElem
    
    def removeFirstElem(self):
        """ Function to remove the first element of the List. The second element becomes the head."""
        if(not LinkedList.head == None):
            firstElem = LinkedList.head
            secondElem = firstElem.next
            LinkedList.head = secondElem

    def deleteList(self):
        LinkedList.head = None

#Test for the constructor
llist = LinkedList(4)
print("Constructor test:\n","head: ", LinkedList.head.value, " value:", llist.value, " next:", llist.next)

#Test for setNextElem
print("Current List:")
llist.printList()
llist.setNextElem(LinkedList(7))
llist1 = LinkedList(3)
llist.setNextElem(llist1)
llist1.setNextElem(LinkedList(9))
print("List after adding three elements:")
llist.printList()
llist1.print()

#Test for setPrevElement
llist2 = LinkedList(0)
llist1.setPrevElem(llist2)
print("List after set an element before the 3:")
llist1.printList()

#Test for removePrevElement
llist3 = LinkedList(2)
llist1.setNextElem(llist3)
print("List after adding an element after 3:")
llist1.printList()
llist3.removePrevElem()
print("List after remove the element before the new element(removed the 3):")
llist.printList()

#Test for removeFirstElement
llist.removeFirstElem()
print("List after removing the first element:")
llist.printList()