package in.singh.raman.string.palindromepermutation;

/**
 * Approach - We will count the occurrence of each character, except spaces
 *            For a palindrome to exist, there should be a pair of characters, so we will check if all the elements are in pairs or not.
 *            One element without pair can exist only, so we need to take care of this also
 *
 *            We are counting occurrence of each character in the array.
 *            After that, we traverse the array to check if pair is there or not.
 *            If pair is not there, we check if we have already found the single element, if yes it can't be palindrome permutation
 *            Otherwise, we check the next pair.
 *
 *  Time Complexity - O(n)
 *  Space Complexity - O(1) 256 ascii chars * 4 bytes of integer = 1024 bytes
 */
public class PalindromePermutationApproach1 {
    public static void main(String[] args) {
        var str = "Tact Coa";
        var isPalindromePermutation = isPalindromePermutation(str.toLowerCase());
        System.out.println(isPalindromePermutation);
    }

    private static boolean isPalindromePermutation(String str) {
        char[] characters = str.toCharArray();
        int charCount[] = new int[256];
        for (char character : characters) {
            if (character == ' ')
                continue;

            charCount[character]++;
        }

        // check if we have pairs or not, result can only have one single element, others need to be in pairs only
        boolean singleElementFound = false;
        for (int count : charCount) {
            if (count % 2 == 0)
                continue;

            if (singleElementFound)
                return false;

            singleElementFound = true;
        }

        return true;
    }
}
