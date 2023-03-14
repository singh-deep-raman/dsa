package in.singh.raman.string.palindromepermutation;

import java.util.BitSet;

/**
 * Approach - Use BitSet as Bit Vector
 *
 * The approach is same as Bit Vector, only difference is we use Java BitSet API which is more clean and not limited to lowercase characters
 *
 */
public class PalindromePermutationApproach3 {
    public static void main(String[] args) {
        var str = "Tact Coa";
        var isPalindromePermutation = isPalindromePermutation(str.toLowerCase());
        System.out.println(isPalindromePermutation);
    }

    private static boolean isPalindromePermutation(String str) {
        BitSet bitSet = new BitSet(256);
        char[] characters = str.toCharArray();
        for (char character : characters) {
            if (character == ' ')
                continue;

            if (bitSet.get(character))
                bitSet.clear(character);
            else
                bitSet.set(character);
        }

        // check if all the bits are zero except one
        return bitSet.cardinality() <= 1;
    }
}
