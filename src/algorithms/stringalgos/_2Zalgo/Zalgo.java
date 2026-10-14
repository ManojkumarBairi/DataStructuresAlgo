package algorithms.stringalgos._2Zalgo;

import java.util.Objects;

public class Zalgo {

    public static void main(String[] args) {
        String text = "xxabaxxaba";
        String pattern = "aba";

        int index = search(text, pattern);
        System.out.println("Pattern found at index: " + index);
    }

    /**
     * Finds the first occurrence of {@code pattern} in {@code text} using the Z algorithm.
     *
     * @return the zero-based index of the first match, or -1 if no match exists
     */
    public static int search(String text, String pattern) {
        Objects.requireNonNull(text, "text must not be null");
        Objects.requireNonNull(pattern, "pattern must not be null");

        if (pattern.isEmpty()) {
            return 0;
        }

        int[] combined = new int[pattern.length() + 1 + text.length()];
        for (int i = 0; i < pattern.length(); i++) {
            combined[i] = pattern.charAt(i);
        }
        combined[pattern.length()] = -1;
        for (int i = 0; i < text.length(); i++) {
            combined[pattern.length() + 1 + i] = text.charAt(i);
        }

        int[] z = calculateZ(combined);
        int textOffset = pattern.length() + 1;
        for (int i = textOffset; i < combined.length; i++) {
            if (z[i] >= pattern.length()) {
                return i - textOffset;
            }
        }

        return -1;
    }

    /**
     * Returns the Z array, where each position stores the matching prefix length
     * starting at that position. By convention, z[0] is 0.
     */
    public static int[] zFunction(String input) {
        Objects.requireNonNull(input, "input must not be null");

        int[] values = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            values[i] = input.charAt(i);
        }
        return calculateZ(values);
    }

    private static int[] calculateZ(int[] values) {
        int[] z = new int[values.length];
        int left = 0;
        int right = 0;

        for (int i = 1; i < values.length; i++) {
            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            while (i + z[i] < values.length && values[z[i]] == values[i + z[i]]) {
                z[i]++;
            }

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }

        return z;
    }
}
