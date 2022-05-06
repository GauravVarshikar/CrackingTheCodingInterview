package ArraysAndStrings;

//Implement a function which reverses a string
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
    private static String reverseString(String str) {
        StringBuilder result = new StringBuilder();
        for(int index = str.length()-1 ; index>=0; index--) {
            result.append(str.charAt(index));
        }
        return result.toString();
    }
}
