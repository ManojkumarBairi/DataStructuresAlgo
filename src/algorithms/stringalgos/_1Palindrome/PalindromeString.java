package algorithms.stringalgos._1Palindrome;

public class PalindromeString {
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println("iS palindrome: " + checkPalindrome(s));

        System.out.println("iS palindrome recursion: " + checkPalindromeRecursion(s));

         System.out.println("iS palindrome two pointer: " + checkPalindromeTwoPointer(s));
    }

    /* 1 Using StringBuilder */
    public static boolean checkPalindrome(String s) {

        if((s == null || s.length() <=1) || s.equals(new StringBuilder(s).reverse().toString())){
            return true;
        }
        return false;
    }

    // Using recursion
    public static boolean checkPalindromeRecursion(String s) {
        if(s == null || s.length() <= 1){
            return true;
        }
        if(s.charAt(0) != s.charAt(s.length() -1)){
            return false;
        }
        return checkPalindromeRecursion(s.substring(1, s.length() -1));
    }

    // Using two Poiner technqiue
    public static boolean checkPalindromeTwoPointer(String s){
        if(s == null || s.length() <= 1){
            return true;
        }

        for(int i=0,j=s.length()-1;i <j ;++i,--j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;

    }
}
