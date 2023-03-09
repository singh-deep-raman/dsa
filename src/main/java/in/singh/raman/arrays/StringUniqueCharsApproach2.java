package in.singh.raman.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if string has unique characters, without extra space
 * <p>
 * TC - O(n2)
 * SC - O(1)
 */
public class StringUniqueCharsApproach2 {

    public static void main(String[] args) {
        String str = "abcdxyzljsf";
        boolean hasUniqueChars = hasUniqueChars(str);
        System.out.println(hasUniqueChars);
    }

    private static boolean hasUniqueChars(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j])
                    return false;
            }
        }
        return true;
    }
}
