package in.singh.raman.string;

/**
 * URLify - Replace all the spaces in the input string with %20.
 *
 * Assumption - String has enough space to hold additional characters and your are given "true" length of the string
 *              True length always end at a character, not space.
 *
 * Approach:
 *  We use the true length as indication of last character of the string.
 *  We initialize a temp variable pointing to tail of the array.
 *  We traverse the string from back (using true length variable) and check if it is a space or character.
 *      If it is a character, we simply copy that character in the end using the temp variable and decrement both counters.
 *      If it is a space, we add '%20' characters in the end and decrement the temp variable by 3 and length counter by 1.
 *
 *  TC - O(n)
 *  SC - O(1)
 */
public class URLify {
    public static void main(String[] args) {
        var str = "Mr John Smith       ";
        var urlified = urlify(str, 14);
        System.out.println(urlified);
    }

    private static String urlify(String str, int length) {
        int tailPtr = str.length() - 1;
        char[] characters = str.toCharArray();
        length = length - 1;
        while (length >= 0) {
            if (characters[length] == ' ') {
                characters[tailPtr] = '0';
                characters[tailPtr-1] = '2';
                characters[tailPtr-2] = '%';
                tailPtr -= 3;
            } else {
                characters[tailPtr] = characters[length];
                tailPtr--;
            }
            length--;
        }

        return new String(characters);
    }
}
