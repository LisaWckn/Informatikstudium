class PartialSum:
    def __init__(self, sequence):
        self._sequence = sequence

    def dynamicMaximalPartialSum(self):
        n = len(self._sequence)
        subtotals = [[ 0 for y in range( n ) ] for x in range( n )]
        maxsum = self._sequence[0]
        start = end = 0

        for j in range(0,n):
            subtotals[0][j] = self._sequence[j]
            if(subtotals[0][j] > maxsum):
                maxsum = subtotals[0][j]
                start = j
                end = j

        for i in range(1,n):
            for j in range(0,n-i):
                subtotals[i][j] = subtotals[i-1][j] + subtotals[0][j+i]
                if(subtotals[i][j] > maxsum):
                    maxsum = subtotals[i][j]
                    start = j
                    end = j+i

        print("Max. partial sum:", maxsum,"\nFirst index:", start,"\nLast index:", end)
        print("Complexity class of the algorithm is O(n^2) so it is better than the algorithm from the lecture.")


if __name__ == "__main__":
    sequence = [4,-2,-2,-3,1,5,-2,0,1]
    partialSum = PartialSum(sequence)
    partialSum.dynamicMaximalPartialSum()
