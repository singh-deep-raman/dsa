package in.singh.raman.arrays;

import java.util.Arrays;

public class StringUniqueCharsApproach4 {

    public static void main(String[] args) {
        String str = "abcdxyzljsf";
        boolean hasUniqueChars = hasUniqueChars(str);
        System.out.println(hasUniqueChars);
    }

    private static boolean hasUniqueChars(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        int i=0;
        while(i++ < chars.length - 2) {
            if (chars[i] == chars[i+1])
                return false;
        }
        return true;
    }
}
