package algorithms.problems;

public class PalindromeNumber {

	public static void main(String[] args) {
		int x = 121;
		boolean pal = checkpalindrome(x);
		System.out.println("Is palidnrome:  " + pal);
	}

	public static boolean checkpalindrome(int num) {
	 int originalNumber = num;
	 int reverseNumber = 0;
	 while(num > 0) {
	//	 System.out.println("before calculation");
		 int remainder =  num%10;
//		 System.out.println("remainder:: " +remainder );
//		 System.out.println("reverseNumber:: " + reverseNumber);
//		 System.out.println("num:: "+num);
		 reverseNumber = reverseNumber * 10 + remainder;
		 num = num /10;
//		 System.out.println("After calculation");
//		 System.out.println("remainder:: " +remainder );
//		 System.out.println("reverseNumber:: " + reverseNumber);
//		 System.out.println("num:: "+num);
	 }
//	 System.out.println("originalNumber :" + originalNumber);
//	 System.out.println("reverseNumber :" + reverseNumber);
	 return originalNumber == reverseNumber;
	}
}
