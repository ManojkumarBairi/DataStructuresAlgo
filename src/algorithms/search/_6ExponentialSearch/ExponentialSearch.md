/**
 * ExponentialSearch is an algorithm that efficiently finds the position of a target
 * value within a sorted array. It works by expanding the range to find the bounds
 * where the target might exist and then using binary search within that range.
 *
 * <p>
 * Worst-case time complexity: O(log n)
 * Best-case time complexity: O(1) when the element is found at the first position.
 * Average time complexity: O(log n)
 * Worst-case space complexity: O(1)
 * </p>
 *
 * <p>
 * Note: This algorithm requires that the input array be sorted.
 * </p>
 */