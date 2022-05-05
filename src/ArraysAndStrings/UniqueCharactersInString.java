package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?
public class UniqueCharactersInString {
    public static void main(String[] args) {
        String s = "abcdea";
        System.out.println("Has Unique Chars in "+ s+": " + hasUniqueChars(s));
        s = "";
        System.out.println("Has Unique Chars in "+ s+": " + hasUniqueChars(s));
        s = "abcdefghijklmnopqrtsuvwxyz";
        System.out.println("Has Unique Chars in "+ s+": " + hasUniqueChars(s));
        s = "abcdefghijklmnopqrtsuvwxyzABC";
        System.out.println("Has Unique Chars in "+ s+": " + hasUniqueChars(s));
    }
    //BRUTE FORCE - using an additional data structure Set<Character>
    //Time Complexity = O(n)
    //Space Complexity = O(n)
    private static boolean hasUniqueChars1(String str) {
        Set<Character> charSet = new HashSet();
        for(Character ch: str.toCharArray()){
            if(charSet.contains(ch)) {
                return true;
            } else {
                charSet.add(ch);
            }
        }
        return false;
    }

    //Alternative BRUTE FORCE Approach - without using any additional data structure
    //Sort the input string, compare current char with previous
    //Time Complexity = O(nlogn)
    //Space Complexity = O(n)
    private static boolean hasUniqueChars2(String str) {
        if(str.length() <= 1) return false;

        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        char previousChar = charArr[0];
        for(int index = 1; index < charArr.length; index++){
            if(previousChar == charArr[index]) {
                return true;
            } else {
                previousChar = charArr[index];
            }
        }
        return false;
    }

    //Optimal Approach without using additional data structure
    //Maintain a boolean array of occurrence of any character similar to a Set
    //Time Complexity = O(n)
    //Space Complexity = O(1) as we have a constant size of 256 of char array
    private static boolean hasUniqueChars(String str) {
        if(str.length() > 256) return false;
        boolean[] charArr = new boolean[265];
        for(char ch: str.toCharArray()) {
            if(charArr[ch]) {
                return true;
            }
            charArr[ch] = true;
        }
        return false;
    }
}
