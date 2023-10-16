package algorithms.sorts.bucketsort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
	
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j > -1 && temp < array[j]) {
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }
	
	public static void bucketSort(int[] arr) {
		int n = arr.length;

		List<Integer>[] buckets = new List[n];
		
		for(int i =0; i <n ; i++) {
			buckets[i] = new LinkedList<Integer>();
		}

		// Put array elements in different buckets
		for(int i=0; i < n ; i++ ) {
			int x = arr[i] / n; // hash code concept
			buckets[x].add(arr[i]);
		}
		
		// sort individual buckets
		for(int i =0; i < n; i++) {
			Collections.sort(buckets[i]);
		}
		
		//Concatenate all buckets into an array[]
		int index=0;
		for(int i=0; i < n; i++) {
			for(int j =0; j<buckets[i].size(); j++) {
				arr[index++]=buckets[i].get(j);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {3, 6, 8, 7, 9, 0, 3, 2, 10, 1};
		
		//not working for 3 digits input
		// int arr[] = {387, 654, 821, 776, 954, 988, 932, 211, 102, 134};
		System.out.print("Input Array : ");
		printArray(arr);
		
		bucketSort(arr);
		
		System.out.print("Output Array : ");
		printArray(arr);

	}

	static void printArray(int arr[]) {
		int N = arr.length;
		for(int i =0 ; i< N ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
