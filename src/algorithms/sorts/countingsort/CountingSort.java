package algorithms.sorts.countingsort;

public class CountingSort {

	public static void countingSort(int arr[]) {
		int n = arr.length;
		
		//output array
		int output[] = new int[n];
		
		//count array to store count of numbers
		int count[] = new int[11];
		for(int i =0 ; i < 11; i++) {
			count[i] = 0;
		}
		
		//store count of each number
		for(int i = 0 ; i < n; i++) {
			count[arr[i]] = count[arr[i]] + 1;
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
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}
		//System.out.print("Output Array : ");
		// printArray(output);
		
	     // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
	}
	
	
	
	public static void main(String[] args) {
		// int arr[] = {3, 6, 8, 7, 9, 0, 3, 2, 10, 1};
		
		int arr[] = {3, 6, 8, 7, 9, 9, 9, 2, 10, 1};
		System.out.print("Input Array : ");
		printArray(arr);
		
		countingSort(arr);
		
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
