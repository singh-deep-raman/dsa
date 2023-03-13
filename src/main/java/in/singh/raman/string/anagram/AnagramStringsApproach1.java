package in.singh.raman.string.anagram;

import java.util.Arrays;

/**
 * Check if two strings are anagram/permutation of each other
 *
 * Approach:
 *
 * We will sort both the character arrays, and then compare both sorted arrays if they are equal or not
 *
 * TC - O(2nlogn)
 * SC - O(1)
 *
 * Assumption: 2 blank spaces are counted as 2 characters
 */
public class AnagramStringsApproach1 {
    public static void main(String[] args) {
        var str1 = "desserts";
        var str2 = "stressed";

        var isAnagram = isAnagram(str1, str2);
        System.out.println(isAnagram);
    }

    private static boolean isAnagram(String str1, String str2) {

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        if (charArray1.length != charArray2.length)
            return false;

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] != charArray2[i])
                return false;
        }

        return true;
    }
}
