package algorithms.search._6ExponentialSearch;

import java.util.Arrays;

public class ExponentialSearch {
    public static void main(String args[]) {
        int[] array = { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47 };

        int target = 18;

        System.out.println("element found at index: " + exponentialSearch(array, target));
        System.out.println("Not present: " + exponentialSearch(array, 99));
    }

    public static int exponentialSearch(int[] array, int target) {
        if(array.length == 0){
            return -1;
        }

        if(array[0] == target){ 
            return 0;
        }
        
        int range = 1;
        while(range < array.length && array[range] < target){
            range = range *2;
        }

        // The candidate block is the inclusive index range [range / 2, range], so the
        // exclusive upper bound handed to binarySearch has to be range + 1.
        int index = Arrays.binarySearch(array, range/2, Math.min(range + 1, array.length), target);
        return index >= 0 ? index: -1;

    }
}