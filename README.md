# algorithm-sicksort
This algorithm sort integers by taking advantage of the binary representation of integers.
Lets suppose we have an array of n integers with each integer represented as 32 bit number.
From the most significant bit to the least significant bit we sort the array for every bit position.
We sort those elements that belong in one window only. We store the window indexes in a list.
Let bitIndex be current bit position for which we are sorting the array.
bitIndex -> 32 to 1
  when bitIndex is 32
  for all numbers in the array calculate the bit value at position 32. It can be either 0 or 1. Sort the array from indexes 0 to n -1
  according to this bit value which is equivalent to sorting a array with only 0s and 1s. It will take O(n) time.
  Record the index of the first element that has 1 at 32th bit position. Add that index to the window list. This way we have 2 windows 0 to k, k to n - 1.
  elements from index 0 to k has 0s at 32 bit position and elements from index k to n - 1 has 1s.
  Now when we sort for position 32 - 1 -> we will sort separately for window 0 to k and k to n-1. so that the sort order from previous bit position is maintained.

  pseudo code ->
Let arr be the array of n 32 bit unisgned positive integers with starting index as 0 (integer are represented as 32 bit unsigned - the first bit doesnt represent the sign of the number
Let list be a linked list with initial elements 0,n 
For k = 32 to 1 {
  ListNode start = list.first()
  ListNode end  = start.next()
  While ( end != null)
  {
     int p = Sort(arr, start.val, end.val - 1, k) // sort element of arr from index start to end using bit values at bit position k
     // Sort will return a number p such that all elements from start to p - 1 have 0 as kth bit and all elements from p to end have 1 at kth bit position.
    if(p >= start && p <= end) {
         start.insertafter(p); // Insert number p in list after node start
    }
     start = end.next();
     end = start == null ? null : start.next();
} 

// Sort method will sort the numbers between index start and end on the basis of values at kth bit position
int Sort(arr, start, end, k) {
  int p = start - 1;
  for i = start to end {
    int bitVal = getBitValue(arr[i], k);
    if(bitVal == 0) {
      p = p + 1;
      swap(arr[i], arr[p]);
    }
   }
    return p;
}
int getBitValue(int number, int bitPosition) - will give the bit value of a integer at particular position in O(1) time

class ListNode {
int val;
ListNode next;
insertAfter(int val) // create aa ListNode with value val and insert it after the ListNode object on whcih it is called
  
  
