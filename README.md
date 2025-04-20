# MSB-Based Bitwise Radix Sort (with Windowing)
This sorting algorithm leverages the binary representation of 32-bit unsigned integers to sort an array in linear time complexity per bit. The core idea is to sort the array bit by bit, starting from the most significant bit (MSB) to the least significant bit (LSB), i.e., from bit position 32 down to 1.

At each bit position k, the array is partitioned into windows—subarrays—based on previous bit-level divisions. Initially, the entire array is considered a single window. For each window, the elements are stably sorted based on the k-th bit (1-indexed from the MSB). This step effectively performs a stable binary radix sort over the bits.

For every sorting operation at a bit position k, the partition index (where elements with bit 0 end and bit 1 begin) is recorded. These indices define new sub-windows for the next iteration (bit k-1), ensuring previous sort orders are preserved.

A window is a contiguous subarray (range of consecutive indices) within the array. At every bit position k, the array is partitioned into one or more non-overlapping windows. The array maintains sorted order by higher (more significant) bits.
We sort only within each window, so that previously sorted bits are preserved and stability is maintained.
 Why Can We Sort Only Within Windows?
When sorting at a given bit position k, the sort must preserve the ordering established by previous (more significant) bits.

Since elements in different windows already differ in more significant bits, their relative positions should not be changed.

Therefore, we only sort within each window — the boundaries between windows are determined by earlier bit partitions.

Each sort step for a window uses a binary partitioning logic:
Traverse the window.
Move all elements with 0 in the k-th bit to the front.
Return the index p, which is the first index where a 1 appears at bit position k.



High-Level Steps:
Initialize a linked list of window boundaries with [0, n].

For each bit index from 32 down to 1:

For every window defined by consecutive nodes in the list:

Partition elements in that window based on the current bit.

Record the partition index if both 0 and 1 values are present.

Update the window list with this new boundary.

The array becomes fully sorted after processing all 32 bits.



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
  
  
