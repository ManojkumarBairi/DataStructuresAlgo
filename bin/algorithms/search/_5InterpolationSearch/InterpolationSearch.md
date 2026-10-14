Interpolation search is an improved variant of binary search for **sorted, uniformly distributed** arrays. Instead of always probing the middle, it estimates where the target is likely to be, the way you open a phone book near the end when looking for "Z".

Probe position formula:

pos = low + ((target - array[low]) * (high - low)) / (array[high] - array[low])

How it works
1. Start with low = 0 and high = n - 1.
2. While target lies within [array[low], array[high]], compute pos with the formula above.
3. If array[pos] == target, return pos.
4. If array[pos] < target, search the right part (low = pos + 1); otherwise search the left part (high = pos - 1).
5. If the range is exhausted or the target is outside it, return -1.

Edge case: if array[low] == array[high] the formula divides by zero, so compare directly.

Approaches
- Iterative: a while loop that shrinks low/high. O(1) extra space. Preferred.
- Recursive: the same probe, calling itself on the narrowed range. Uses call-stack space (O(n) in the worst case).

Complexity
- Best case: O(1)
- Average case (uniform data): O(log log n)
- Worst case (skewed data, e.g. exponentially growing values): O(n)
- Space: O(1) iterative, O(n) worst-case recursive

When to use Interpolation Search
- The array is sorted and values are roughly evenly distributed.
- The array is large and comparisons/accesses are expensive (e.g. disk lookups).

When not to use
- Data is unsorted or heavily skewed; prefer binary search, which guarantees O(log n).

Implementation: see InterpolationSearch.java (interpolationSearchIterative and interpolationSearchRecursive).
