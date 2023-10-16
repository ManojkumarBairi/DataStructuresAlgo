package datastructures.stack.reversestring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {

	public static void main(String[] args) throws IOException {
		String input, output;
		while(true) {
			System.out.println("Enter a string: ");
			System.out.flush();
			input = getString();
			if (input.equals(""))
				break;
			System.out.println(input);
			Reverser theReverser = new Reverser(input);
			output = theReverser.doRev();
			System.out.println("Reversed:  " + output);
		} //end while

	} //end main

	public static String getString() throws IOException {
		InputStreamReader isr= new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s =br.readLine();
		return s;
	}
}
