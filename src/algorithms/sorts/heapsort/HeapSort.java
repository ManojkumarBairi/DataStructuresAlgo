package algorithms.sorts.heapsort;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = { 12,11,13,5,6,7};
		int N = arr.length;
		
		System.out.print("Input array is ");
		printArray(arr);
		
		//function call
		HeapSort ob = new HeapSort();
		ob.sort(arr);
		
		
		System.out.println("Sorted array is ");
		printArray(arr);
	}

	public void sort(int arr[]) {
		int N = arr.length;
		
		// Build Heap ( rearrange array)
		for(int i = N/2 - 1; i >=0; i--) {
	      heapify(arr, N , i);	
	      System.out.print("Build Heap array for i="+i+": ");
		  printArray(arr);
		}
		
		for(int i = N -1; i>= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
		    System.out.print("Before MAX Heapify for i="+i+": ");
			printArray(arr);
			  
			//call max heapify on reduced heap
			heapify(arr, i , 0);
			
			System.out.print("After MAX Heapify for i="+i+": ");
			printArray(arr);
		}
	}
	
	void heapify(int arr[], int N , int i) {
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if (l < N &&  arr[l] > arr[largest])
			largest = l;
		if (r < N && arr[r] > arr[largest])
			largest = r;
		
		// if largest is not root
		if(largest != i) {
			System.out.print("largest:"+largest+" is not root for i="+i+": ");
			int temp = arr[i];  //swap
			arr[i] = arr[largest];
			arr[largest] = temp;
			System.out.print("before heapifing effecthed sub tree ");
			 printArray(arr);
			heapify(arr, N , largest);
			System.out.print("after heapifing effecthed sub tree ");
			 printArray(arr);
		}
		
	}
	
	static void printArray(int arr[]) {
		int N = arr.length;
		for(int i =0 ; i< N ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
