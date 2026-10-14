 # Jump Search
 * Jump Search is an algorithm for searching sorted arrays. It works by dividing the array
 * into blocks of a fixed size (the block size is typically the square root of the array length)
 * and jumping ahead by this block size to find a range where the target element may be located.
 * Once the range is found, a linear search is performed within that block.

  <b>How it works:</b>
 * <ol>
 *   <li>Calculate the optimal block size as √n (square root of array length)</li>
 *   <li>Jump ahead by the block size until the current element is greater than the target</li>
 *   <li>Perform a linear search backwards within the identified block</li>
 * </ol>
 *
 * <p>
 * <b>Example:</b><br>
 * Array: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19], Target: 9<br>
 * Step 1: Jump from index 0 → 3 → 6 (9 < 13, so we found the block)<br>
 * Step 2: Linear search from index 3 to 6: found 9 at index 4<br>
 * Result: Index = 4
 *
 * <p>
 * <b>Time Complexity:</b><br>
 * - Best-case: O(1) - element found at first position<br>
 * - Average: O(√n) - optimal block size reduces jumps<br>
 * - Worst-case: O(√n) - element at end of array or not present<br>
 *
 * <p>
 * <b>Space Complexity:</b> O(1) - only uses a constant amount of extra space
 *
 * <p>
 * <b>Edge Cases:</b>
 * <ul>
 *   <li>Empty array → returns -1</li>
 *   <li>Element not present → returns -1</li>
 *   <li>Single element array</li>
 * </ul>
 * <p>
 * <b>Note:</b> Jump Search requires a sorted array. For unsorted arrays, use Linear Search.
 * Compared to Linear Search (O(n)), Jump Search is faster for large arrays.
 * Compared to Binary Search (O(log n)), Jump Search is less efficient but may be
 * preferable when jumping through a linked list or when backward scanning is costly.