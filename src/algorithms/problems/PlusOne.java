package algorithms.problems;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// int[] digits = {4,3,2,1};
		int[] digits= {9};
		
		digits[digits.length - 1]++;
		
		System.out.println(Arrays.toString(digits) );

	}

}
