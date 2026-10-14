package algorithms.search._5InterpolationSearch;

public class InterpolationSearch {
    public static void main(String args[]) {
        int[] array = { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47 };

        int target = 18;

        System.out.println("Iterative - element found at index: " + interpolationSearchIterative(array, target));
        System.out.println("Recursive - element found at index: " + interpolationSearchRecursive(array, target));
        System.out.println("Not present: " + interpolationSearchIterative(array, 99));
    }

    // Iterative approach: O(log log n) for uniformly distributed data, O(n) worst case, O(1) space
    public static int interpolationSearchIterative(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && target >= array[low] && target <= array[high]) {
            // all remaining elements are equal; avoid division by zero
            if (array[low] == array[high]) {
                return array[low] == target ? low : -1;
            }

            int pos = probe(array, low, high, target);

            if (array[pos] == target) {
                return pos;
            }
            if (array[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1;
    }

    // Recursive approach: same probe, but O(log log n) / O(n) call stack in worst case
    public static int interpolationSearchRecursive(int[] array, int target) {
        return interpolationSearchRecursive(array, target, 0, array.length - 1);
    }

    private static int interpolationSearchRecursive(int[] array, int target, int low, int high) {
        if (low > high || target < array[low] || target > array[high]) {
            return -1;
        }
        if (array[low] == array[high]) {
            return array[low] == target ? low : -1;
        }

        int pos = probe(array, low, high, target);

        if (array[pos] == target) {
            return pos;
        }
        if (array[pos] < target) {
            return interpolationSearchRecursive(array, target, pos + 1, high);
        }
        return interpolationSearchRecursive(array, target, low, pos - 1);
    }

    // pos = low + (target - array[low]) * (high - low) / (array[high] - array[low])
    // long arithmetic prevents int overflow in the multiplication
    private static int probe(int[] array, int low, int high, int target) {
        return low + (int) (((long) (target - array[low]) * (high - low)) / ((long) array[high] - array[low]));
    }
}
