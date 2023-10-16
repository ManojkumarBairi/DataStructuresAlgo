package algorithms.problems;

public class lengthOfLastWord {

	public static void main(String[] args) {
		String s = "luffy is still joyboy ";
		
		String sa[] = s.split(" "); 
        System.out.println(sa[sa.length -1].length());
	}

}
