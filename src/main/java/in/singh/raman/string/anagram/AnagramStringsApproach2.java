package in.singh.raman.string.anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * Here we will traverse first string, and put the count of each character in a HashMap
 *
 * Then we will traverse second string, and decrement the counter of character from the HashMap
 * If any character of 2nd string is not present in the HashMap or count is zero, then strings are not palindrome/anagram
 *
 * TC - O(n)
 * SC - O(n)
 */
public class AnagramStringsApproach2 {
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

        // prepare hash map with character count
        var charCount = new HashMap<Character, Integer>();
        for (char character : charArray1) {
            if (charCount.containsKey(character)) {
                var count = charCount.get(character);
                charCount.put(character, count+1);
            } else {
                charCount.put(character, 1);
            }
        }

        for (char character : charArray2) {
            if (!charCount.containsKey(character))
                return false;

            var count = charCount.get(character);
            if (count == 0)
                return false;

            charCount.put(character, count - 1);
        }

        return true;
    }
}
