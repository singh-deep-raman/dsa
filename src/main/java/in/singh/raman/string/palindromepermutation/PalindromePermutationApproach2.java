package in.singh.raman.string.palindromepermutation;

import java.util.BitSet;

/**
 * Approach - Use bit vector (bit manipulation)
 *
 * This approach assumes that there are only lowercase characters in the string
 * We traverse over each character in the string and check if that character is set or not set in the bit 'checker' (using AND operation)
 * If it is already set, we unset it (using XOR operation)
 * If it is not set, we set it (using OR operation)
 *
 * After the traversal, we need to check if number of 1s in the 'checker' is either zero or one, if yes it is palindrome permutation
 * If multiple bits are set in the 'checker' which means incomplete pairs are there, so it is not palindrome permutation
 *
 * TC - O(n)
 * SC - O(1) 4 bytes of integer 'checker'
 */
public class PalindromePermutationApproach2 {
    public static void main(String[] args) {
        var str = "Tact Coa";
        var isPalindromePermutation = isPalindromePermutation(str.toLowerCase());
        System.out.println(isPalindromePermutation);
    }

    private static boolean isPalindromePermutation(String str) {
        char[] characters = str.toCharArray();
        int checker = 0;
        for (char character : characters) {
            if (character == ' ')
                continue;

            int current = character - 'a'; // to get value in between 1-26
            int current_char_in_bit = 1 << current;
            // unset the bit, if already set
            if ((checker & current_char_in_bit) > 0 ) {
                checker = checker ^ current_char_in_bit;
            } else {
                // set the bit
                checker = checker | current_char_in_bit;
            }
        }
        // 0 means, all pairs, 1 means one single element
        return Integer.bitCount(checker) <= 1;
    }
}
