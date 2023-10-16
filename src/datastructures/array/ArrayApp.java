package datastructures.array;

public class ArrayApp {
public static void main (String args[]) {
	long[] arr; // reference to array
	arr = new long[100]; //make array
	int nElems = 0;  // number of items
	int j; //loop counter;
	long searchkey;  //key of item to search for
	
	//insert 10 items
	arr[0] = 77;
	arr[1] = 99;
	arr[2] = 44;
	arr[3] = 55;
	arr[4] = 22;
	arr[5] = 88;
	arr[6] = 11;
	arr[7] = 00;
	arr[8] = 66;
	arr[9] = 33;
	nElems = 10;
	
	//display items
	for(int i =0; i < nElems; i++) {
		System.out.print(arr[i] + " ");
	}
	
	System.out.println("");
	
	
	//find item with key 66
//	searchkey = 33;
//	for(j=0; j <nElems ; j++) {
//		if(arr[j] == searchkey) {
//			break;
//		}
//	}
//	if ( j == nElems) {
//		System.out.println(j);
//		System.out.println("Cant find" + searchkey);   //yes
//	} else {
//		System.out.println(j);
//		System.out.println("found " + searchkey);  //no
//	}
	
	//delete item with key 55
	searchkey = 55;
	for(j=0; j <nElems; j++) {   //look for it
		if (arr[j] == searchkey) {
			break;
		}
	}
	
	for (int k=j; k <nElems -1; k++) {//move higher ones down
		arr[k] = arr[k+1];
	}
	nElems--;                      //decrement size
	
	//display items
	for(int i =0; i < nElems; i++) {
		System.out.print(arr[i] + " ");
	}
	
	System.out.println("");
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
