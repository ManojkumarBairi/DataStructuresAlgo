package datastructures.array;

class LowArray {
  private long[] a;   //reference to array a
  
  public LowArray(int size) {  //constructor
	  a = new long[size];      // create array
  }
  
  public void setElem(int index, long value) { //set Value
	  a[index] = value;
  }

  public long getElem(int index) {   //get Value
	  return a[index];
  }

}

 public class LowArrayApp {
	public static void main(String args[]) {
		LowArray arr;
		arr = new LowArray(100);
		int nElems = 0;
		int j;
		
		arr.setElem(0, 77);
		arr.setElem(1, 99);
		arr.setElem(2, 44);
		arr.setElem(3, 55);
		arr.setElem(4, 22);
		arr.setElem(5, 88);
		arr.setElem(6, 11);
		arr.setElem(7, 00);
		arr.setElem(8, 66);
		arr.setElem(9, 33);
		
		nElems =10;
		
		//display items
		for(j= 0;j<nElems; j++) {
			System.out.print(arr.getElem(j) + " ");
		}
		System.out.println(" ");
		
		//search for data item
		int searchKey = 26;
		for(j=0; j < nElems; j++) {
			if(arr.getElem(j) == searchKey) {
				break;
			}
		}
		
		if(j == nElems) {
			System.out.println(" Can't find " + searchKey);
		} else {
			System.out.println(" Found " + searchKey);
		}
		
		// delete value 55
		for(j =0 ;j <nElems ; j++) {
			if(arr.getElem(j) == 55) {
				break;
			}	
		}
		System.out.println("j : " + j);
		for(int k =j ; k < nElems ; k++) {
			arr.setElem(k, arr.getElem(k+1));
		}
		nElems--;
		
		//display items
		for(j= 0;j<nElems; j++) {
			System.out.print(arr.getElem(j) + " ");
		}
		System.out.println(" ");
	}
}