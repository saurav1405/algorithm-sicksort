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



Pseudocode
<pre lang="plaintext"><code>Function RecursiveMSBRadixSort(arr: array of unsigned 32-bit integers): MSBRadixSort(arr, 0, length(arr) - 1, 32) Function MSBRadixSort(arr: array, start: int, end: int, bitIndex: int): If start >= end or bitIndex < 1: return mid = PartitionByBit(arr, start, end, bitIndex) // Recursively sort the 0-bit group and 1-bit group MSBRadixSort(arr, start, mid - 1, bitIndex - 1) MSBRadixSort(arr, mid, end, bitIndex - 1) Function PartitionByBit(arr: array, start: int, end: int, bitIndex: int) -> int: p = start - 1 For i from start to end: bitVal = GetBit(arr[i], bitIndex) If bitVal == 0: p = p + 1 Swap arr[i], arr[p] Return p + 1 Function GetBit(number: int, bitIndex: int) -> int: // BitIndex is 1-based from MSB (bit 32) to LSB (bit 1) Return (number >> (32 - bitIndex)) & 1 </code></pre>
  
  
