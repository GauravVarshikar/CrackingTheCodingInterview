package ArraysAndStrings;

//Assume you  have a method isSubstring which checks if one word is a substring of another.
//Given two strings s1 and s2, write code to check if s1 is a rotation of s2 using only one call to isSubstring
//e.g. "waterbottle" is a rotation of "erbottlewat"
public class StringRotationCheck {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "rbottlewate";
        System.out.println(s1 + " is rotation of " + s2 + " : " +isRotation(s1, s2));

        //Actual Solution in the book -- which makes us look dumb!
        System.out.println((s1+s1).contains(s2));

        s1 = "eeeeea";
        s2 = "aeeeee";
        System.out.println(s1 + " is rotation of " + s2 + " : " +isRotation(s1, s2));
    }

    private static int isSubstring(String s1, String s2) {
        return s1.contains(s2) ? s1.indexOf(s2) : -1;
    }

    //Find the index of the first character of s2 in s1
    //If found, iterate over each character in s2 and check if they exist in the same order in s1.
    //if the pointer in s1 reaches end, then reset it to 0
    //Time Complexity = O(n)
    //Space Complexity = O(1)
    private static boolean isRotation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int pointer = isSubstring(s1, s2.substring(0,1));
        System.out.println("Found " + s2.charAt(0) + " in string: " + s1 + " at index: "+ pointer);
        if(pointer == -1) return false;

        for(char ch: s2.toCharArray()) {
            if(ch != s1.charAt(pointer)) {
                return false;
            }
            pointer++;

            //if pointer has reached the end of string then reset it to 0
            if(pointer == s1.length()){
                pointer = 0;
            }
        }
        return true;
    }
}