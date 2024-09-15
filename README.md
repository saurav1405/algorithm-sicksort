# algorithm-sicksort
This algorithm sort integers by taking advantage of the binary representation of integers.
Lets suppose we have an array of n integers with each integer represented as 32 bit number.
We are sorting teh array in descending order.
From the most significant bit to the least significant bit we sort the array for every bit position.
We sort those elements that belong in one window only. We store teh window indexes in a list.
let bitIndex be current bit position for which we are sorting the array.
bitIndex -> 32 to 1
  when bitIndex is 32
  for all numbers in the array calculate the bit value at position 32. It can be either 0 or 1. Sort the array from indexes 0 to n -1
  according to this bit value which is equivalent to sorting a array with only 0s and 1s. It will take O(n) time.
  Record the index of the first element that has 0 at 32 position. Add that index to the window list. This way we have 2 windows 0 to k, k to n - 1.
  elements from index 0 to k has 1s at 32 bit position and elements from index k to n - 1 has 0s.
  Now when we sort for position 32 - 1 -> we will sort separately for window 0 to k and k to n-1. so that the sort order from previous bit position is maintained.

  
  
  
