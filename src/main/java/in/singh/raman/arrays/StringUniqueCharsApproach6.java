package in.singh.raman.arrays;

import java.util.BitSet;

/**
 *  Bit manipulation approach we saw earlier only works for lowercase/uppercase letters.
 *  Good news is Java has given us an API BitSet where we can create BitSet of our required size, so we can create with size of 256
 */
public class StringUniqueCharsApproach6 {

    public static void main(String[] args) {
        String str = "abcdxyzljsf";
        boolean hasUniqueChars = hasUniqueChars(str);
        System.out.println(hasUniqueChars);
    }

    private static boolean hasUniqueChars(String str) {
        BitSet bitSet = new BitSet(256);
        char[] chars = str.toCharArray();
        for (char character : chars) {
            if (bitSet.get(character))
                return false;
            bitSet.set(character);
        }
        return true;
    }
}
