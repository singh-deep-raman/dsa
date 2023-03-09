package in.singh.raman.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if string has unique characters
 *
 * TC - O(n)
 * SC - O(1)
 */
public class StringUniqueCharsApproach3 {

    public static void main(String[] args) {
        String str = "abcdxyzljsf";
        boolean hasUniqueChars = hasUniqueChars(str);
        System.out.println(hasUniqueChars);
    }

    private static boolean hasUniqueChars(String str) {
        boolean char_count[] = new boolean[256]; // utf8 max chars
        char[] chars = str.toCharArray();
        for (char character : chars) {
            if (char_count[character])
                return false;
            char_count[character] = true;
        }
        return true;
    }
}
