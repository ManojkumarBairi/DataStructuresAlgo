package algorithms.stringalgos._1KMP;

import java.util.Arrays;
import java.util.Objects;

public class KMPStringSearch {

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int index = search(text, pattern);
        System.out.println("Pattern found at index: " + index);
    }

    /**
     * Finds the first occurrence of {@code pattern} in {@code text}.
     *
     * @return the zero-based index of the first match, or -1 if no match exists
     */
    public static int search(String text, String pattern) {
        Objects.requireNonNull(text, "text must not be null");
        Objects.requireNonNull(pattern, "pattern must not be null");

        if (pattern.isEmpty()) {
            return 0;
        }

        int[] lps = buildLps(pattern);

        System.out.println(Arrays.toString(lps));
        int textIndex = 0;
        int patternIndex = 0;

        while (textIndex < text.length()) {
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;

                if (patternIndex == pattern.length()) {
                    return textIndex - patternIndex;
                }
            } else if (patternIndex > 0) {
                patternIndex = lps[patternIndex - 1];
            } else {
                textIndex++;
            }
        }

        return -1;
    }

    private static int[] buildLps(String pattern) {
        int[] lps = new int[pattern.length()];
        int prefixLength = 0;
        int index = 1;

        while (index < pattern.length()) {
            if (pattern.charAt(index) == pattern.charAt(prefixLength)) {
                lps[index] = ++prefixLength;
                index++;
            } else if (prefixLength > 0) {
                prefixLength = lps[prefixLength - 1];
            } else {
                lps[index] = 0;
                index++;
            }
        }

        return lps;
    }
}
