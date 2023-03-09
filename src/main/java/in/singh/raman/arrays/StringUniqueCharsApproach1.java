package in.singh.raman.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if string has unique characters
 *
 * TC - O(n)
 * SC - O(n)
 */
public class StringUniqueCharsApproach1 {

    public static void main(String[] args) {
        String str = "abcdxyzljsf";
        boolean hasUniqueChars = hasUniqueChars(str);
        System.out.println(hasUniqueChars);
    }

    private static boolean hasUniqueChars(String str) {
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char character : chars) {
            if (set.contains(character))
                return false;
            set.add(character);
        }
        return true;
    }
}
