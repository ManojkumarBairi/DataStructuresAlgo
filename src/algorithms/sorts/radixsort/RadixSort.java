package algorithms.sorts.radixsort;

public class RadixSort {

	public static void countingSort(int arr[], int n, int exp ) {
		
		//output array
		int output[] = new int[n];
		
		//count array to store count of numbers
		int count[] = new int[11];
		for(int i =0 ; i < 11; i++) {
			count[i] = 0;
		}
		
		//store count of each number
		for(int i = 0 ; i < n; i++) {
			count[(arr[i] / exp ) % 10] = count[(arr[i] / exp ) % 10] + 1;
		}
		System.out.print("Count Array : ");
		printArray(count);
		
		// Change count[] so that count[] now
		// contains actual position of number in output array
		for(int i=1; i <= 10; i++) {
			count[i]= count[i] + count[i - 1];
		}
		System.out.print("Count Array with actual position : ");
		printArray(count);
		
		// Build the output array 
		// To make it stable we operate in reverse order
		for(int i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp ) % 10] - 1] = arr[i];
			--count[(arr[i] / exp ) % 10];
		}
		//System.out.print("Output Array : ");
		// printArray(output);
		
	     // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
	}
	
	
	public static void radixSort(int[] arr) {
		int n = arr.length;
		
		// Find the maximum number to know number of digits
		int maxNum = getMax(arr, n);
		
		//Do counting sort for every digit.
		// Note that instead of passing digit number, exp is passed
		// exp is 10^i where i is the current number
		for(int exp = 1; maxNum /exp > 0; exp *= 10) {
			countingSort(arr, n , exp);
		}
		
	}
	
	// A utility function to get maximum value in arr[]
	static int getMax(int arr[], int n)  {
		int max = arr[0];
		for(int i=1; i < n ; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// int arr[] = {3, 6, 8, 7, 9, 0, 3, 2, 10, 1};
		
		int arr[] = {387, 654, 821, 776, 954, 988, 932, 211, 102, 134};
		System.out.print("Input Array : ");
		printArray(arr);
		
		radixSort(arr);
		
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
