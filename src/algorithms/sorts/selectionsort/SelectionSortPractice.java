package algorithms.sorts.selectionsort;

public class SelectionSortPractice {

	public static void main(String[] args) {
		int[] arr = { 12, 16, 17, 11, 18, 20, 15, 14, 13, 19 };
		System.out.print("Input array is : ");
		printArray(arr);
		
		selectionSort(arr);
		
		System.out.print("Output array is : ");
		printArray(arr);
		
	}

	public static void selectionSort(int arr[]) {
		
		for(int i =0; i<arr.length; i++) {
			
			int minIndex = i ;
			for(int j = i+1; j <arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
			
			
		}
		
		
		
	}
	
	public static void printArray(int arr[]) {
		for(int i =0 ; i <arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
	}
}
