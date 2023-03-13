package in.singh.raman.string.anagram;

import java.util.HashMap;

/**
 * Here we will traverse first string, and put the count of each character in an integer array of fixed size of ASCII char set
 *
 * Then we will traverse second string, and decrement the counter of character in the array
 * If any character of 2nd string is not present in the array or count is zero, then strings are not palindrome/anagram
 *
 * TC - O(n)
 * SC - O(1) (always 256)
 */
public class AnagramStringsApproach3 {
    public static void main(String[] args) {
        var str1 = "desserts";
        var str2 = "stressed";

        var isAnagram = isAnagram(str1, str2);
        System.out.println(isAnagram);
    }

    private static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // prepare array with character count
        int asciiSet[] = new int[256];
        for (char character : charArray1) {
            asciiSet[character]++;
        }

        for (char character : charArray2) {
            if (asciiSet[character] == 0)
                return false;

            asciiSet[character]--;
        }

        return true;
    }
}
