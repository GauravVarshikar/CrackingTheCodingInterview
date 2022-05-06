package ArraysAndStrings;

public class ReverseString {
    public static void main(String[] args) {
        String s = "abcdea";
        System.out.println("Reversed "+ s+": " + reverseString(s));
        s = "";
        System.out.println("Reversed "+ s+": " + reverseString(s));
        s = "abcdefghijklmnopqrtsuvwxyz";
        System.out.println("Reversed "+ s+": " + reverseString(s));
        s = "abcdefghijklmnopqrtsuvwxyzABC";
        System.out.println("Reversed "+ s+": " + reverseString(s));
    }

    //BRUTE FORCE - start from last index, move towards the first index, put each character in a new string
    //Time Complexity = O(n)
    //Space Complexity = O(n)
    private static String reverseString1(String str) {
        StringBuilder result = new StringBuilder();
        for(int index = str.length()-1 ; index>=0; index--) {
            result.append(str.charAt(index));
        }
        return result.toString();
    }
    //2-pointer approach - left and right pointer, swap characters between right and left
    //Time Complexity = O(n/2) ~~ O(n) -- slightly faster than the above method
    private static String reverseString(String str) {
        int left = 0;
        int right = str.length()-1;
        char[] strCharArr = str.toCharArray();
        while(left < right) {
            char temp = strCharArr[right];
            strCharArr[right] = strCharArr[left];
            strCharArr[left] = temp;
            left++;
            right--;
        }
        return String.valueOf(strCharArr);
    }
}
