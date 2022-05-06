package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given two strings, write a method to decide if one is a permutation of the other.
public class StringPermutation {
    public static void main(String[] args) {
        String s = "fruit";
        String p = "tuifr";
        System.out.println("Permutation "+ s+": " + isPermutation(s, p));
        s = "";
        p=" ";
        System.out.println("Permutation "+ s+": " + isPermutation(s, p));
        s = "abcdefghijklmnopqrtsuvwxyz";
        p = "abcdefghijklmnopqrtsuvwxya";
        System.out.println("Permutation "+ s+": " + isPermutation(s, p));
        s = "abcdefghijklmnopqrt123suvwxyzAVA";
        p = "abcdefg1AhijklmnoVpqr2tsuvw3Axyz";
        System.out.println("Permutation "+ s+": " + isPermutation(s, p));
    }
    //Sort both the strings and then compare with each other.
    //Time Complexity = O(nlogn)
    private static boolean isPermutation1(String str, String perm) {
        if(str.length() != perm.length()) return false;
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        char[] permArr = perm.toCharArray();
        Arrays.sort(permArr);
        return Arrays.equals(strArr, permArr);
    }

    //Create individual arrays for both string which contain the count of each character. Compare both arrays to get result
    //This is applicable if we know the input string contains only lowercase characters
    //Time Complexity = O(n)
    private static boolean isPermutation2(String str, String perm) {
        if(str.length() != perm.length()) return false;

        int[] strArr = new int[26];
        int[] permArr = new int[26];

        for(char ch: str.toCharArray()){
            strArr[ch-'a']++;
        }
        for(char ch: perm.toCharArray()){
            permArr[ch-'a']++;
        }
        return Arrays.equals(strArr, permArr);
    }

    //In case the string can contain upper case or lower case or numbers
    //Create a Map for each string having the character as a key and its count as value
    //Iterate over the string checking if the count value is same in both maps for each key
    //Time Complexity = O(n)
    //Space Complexity = O(2n) ~~ O(n)
    private static boolean isPermutation(String str, String perm) {
        if(str.length() != perm.length()) return false;

        Map<Character, Integer> strCountMap = new HashMap<>();
        Map<Character, Integer> permCountMap = new HashMap<>();

        for(char ch: str.toCharArray()) {
            strCountMap.put(ch, strCountMap.getOrDefault(ch, 0) + 1);
        }
        for(char ch: perm.toCharArray()) {
            permCountMap.put(ch, permCountMap.getOrDefault(ch, 0) + 1);
        }
        for(char ch: str.toCharArray()){
            if(strCountMap.get(ch) != permCountMap.get(ch)){
                return false;
            }
        }
        return true;
    }
}
