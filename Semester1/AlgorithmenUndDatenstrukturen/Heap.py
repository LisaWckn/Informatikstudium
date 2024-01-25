class Heap:
    def __init__(self, arr):
        self.heapify(arr)

    def heapify(self, arr):
        """This method considered the first n/2 elements backwards and seeped it in to create the heap property."""
        self.heap = arr
        lastInternIndex = int(len(self.heap)/2)
        for i in range(lastInternIndex,-1,-1):
            self.seepIn(i, len(self.heap))

    def sort(self):
        tmp = self.heap.copy()
        le = len(self.heap)-1
        while le > -1:
            self.swap(0,le)
            self.seepIn(0, le)
            le = le-1
        self.printHeapArray()
        self.heap = tmp
    
    def printHeapArray(self):
        print(self.heap)

    def seepIn(self, index, last):
        """This method seeps the element with the index from the heap in. """
        if index<last:
            current = self.heap[index]
            if 2*index+1 <last:
                leftChild = self.heap[2*index+1]
            else:
                leftChild = None
            if 2*index+2 < last:
                rightChild = self.heap[2*index+2]
            else:
                rightChild = None
            if not leftChild == None  and not rightChild == None:
                if current >= leftChild or current >= rightChild:
                    if leftChild < rightChild:
                        self.swap(index, 2*index+1)
                        self.seepIn(2*index+1, last)
                    else:
                        self.swap(index, 2*index+2)
                        self.seepIn(2*index+2, last)
            elif leftChild:
                if current >= leftChild:
                    self.swap(index, 2*index+1)
                    self.seepIn(2*index+1, last)
            elif rightChild:
                if current >= rightChild:
                    self.swap(index, 2*index+2)
                    self.seepIn(2*index+2, last)

    def swap(self, i, j):
        """This method swaps to elements from the heap."""
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def printPreOrder(self):
        """This method calls the recursive method preOrder with the first element to print the whole heap in pre order."""
        self.preOrder(0)

    def preOrder(self, i):
        """ This method prints an element of the heap and it's childs. 
            After that the preOrder method is called for the left and the right child."""
        if i<len(self.heap):
            if 2*i+1 < len(self.heap):
                leftChild = self.heap[2*i+1]
            else:
                leftChild = None
            if 2*i+2 < len(self.heap):
                rightChild = self.heap[2*i+2]
            else:
                rightChild = None
            print("(", self.heap[i], ",", leftChild,",",rightChild,")", end="  ")
            self.preOrder(2*i+1)
            self.preOrder(2*i+2)
            
if __name__ == "__main__":
    arr = [10,9,7,6,0,20,15,5]
    heap = Heap(arr) 
    heap.printPreOrder()
    print("\n")
    heap.sort()