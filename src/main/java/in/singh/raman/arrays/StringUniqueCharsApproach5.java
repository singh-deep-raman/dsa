package in.singh.raman.arrays;

/**
 * Earlier we used a boolean array of size 256 to check if an element already exists or not.
 *
 * Instead of boolean array, we can use bits to check for absence / presence of a character.
 *
 * Since, int has size 4 byte, means 32 bits, we can only check presence / absence of 32 characters only.
 *
 * So assumption is, our input string will only have lowercase letters
 *
 * Algo:
 *
 *  We check the first character, subtract ASCII value of 'a', so that it will come in the range of 1-26.
 *  Now we need to set the corresponding bit of this character into our int variable called 'checker'
 *  Before setting, we need to check if the corresponding bit is already set, that you can check by creating a temp variable with current character bit sit and do AND operation,
 *      if both bits are set, then AND operation will give value > 0
 *
 * Note:
 *  1 << 0 means, 1 is set to 1st position, then shift 0 times, so it will become 00000001 in bit, and 1 in decimal
 *  1 << 1 means, 1 is set to 1st position, then shifted 1 times, so it will become 00000010 in bit, and 2 in decimal
 *  1 << 2 means, 1 is set to 1st position, then shifted 1 times, so it will become 00000100 in bit, and 4 in decimal
 *
 */
public class StringUniqueCharsApproach5 {

    public static void main(String[] args) {
        String str = "abcdxyzljsf";
        boolean hasUniqueChars = hasUniqueChars(str);
        System.out.println(hasUniqueChars);
    }

    private static boolean hasUniqueChars(String str) {
        int checker = 0;
        char[] chars = str.toCharArray();
        for (char character : chars) {
            int val = character - 'a';
            // create temporary variable to set bit for current character
            int current_bit = 1 << val;
            // check if that bit is already set, if yes return false
            if ((checker & current_bit) > 0)
                return false;

            // if current bit was not set, we need to set it into the checker
            checker = checker | current_bit;
        }
        return true;
    }
}
