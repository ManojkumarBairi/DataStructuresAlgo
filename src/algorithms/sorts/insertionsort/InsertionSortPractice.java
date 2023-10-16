package algorithms.sorts.insertionsort;

public class InsertionSortPractice {

	public static void main(String[] args) {
		int arr[] = { 5,2,4,6,1,3 };
		insertionSort(arr);
		for(int i =0; i<arr.length; i++) {
		System.out.print(arr[i] + " ");
		}

	}
public static void insertionSort(int array[]) {
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
}
