class Item:
    def __init__(self, weight, price) -> None:
        """ Constructor to set the weight and the price of an item."""
        self._weight = weight
        self._price = price

class Backpack:
    def __init__(self, capacity) -> None:
        """ Constructor to set the capacity of the backpack."""
        self._capacity = capacity

    def fillBackpack(self, items):
        """ Method which calls the recursive method backtracking with an array of items."""
        print("Backtracking: " , self.backtracking(items, 0, self._capacity))

    def backtracking(self, items, index, restCapacity) -> int:
        """ Method to find with backtracking the perfect solution for the backpack problem."""
        if(index == len(items)-1):
            if items[index]._weight > restCapacity:
                return 0
            else: 
                return items[index]._price
        else:
            if items[index]._weight > restCapacity:
                return self.backtracking(items, index+1, restCapacity)
            else:
                pathWithoutItemIndex = self.backtracking(items, index+1, restCapacity)
                pathWithItemIndex = self.backtracking(items, index+1, restCapacity-items[index]._weight)+items[index]._price
                return max(pathWithoutItemIndex, pathWithItemIndex)
            
if __name__ == "__main__":
    items = []
    items.append(Item(2,6))
    items.append(Item(2,3))
    items.append(Item(6,5))
    items.append(Item(5,4))
    items.append(Item(4,6))

    backpack = Backpack(6)
    backpack.fillBackpack(items)