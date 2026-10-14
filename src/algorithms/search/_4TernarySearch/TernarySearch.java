package algorithms.search._4TernarySearch;

public class TernarySearch {
    public static void main(String args[]) {
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
                97 };

        int target = 67;
        int index = ternarySearch(primes, target);

        System.out.println("Element found at index: " + index);
    }

    public static int ternarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (array[mid1] == target) {
                return mid1;
            }
            if (array[mid2] == target) {
                return mid2;
            }

            if (target < array[mid1]) {
                right = mid1 - 1;
            } else if (target > array[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        return -1;
    }
}
