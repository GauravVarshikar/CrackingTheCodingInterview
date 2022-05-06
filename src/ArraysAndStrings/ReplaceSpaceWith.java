package ArraysAndStrings;

//Write a method to replace all spaces in a string with '%20'.
//You may assume that the string has sufficient space at the end of the string to hold the additional characters
//and that you are given the 'true' length of the string
public class ReplaceSpaceWith {
    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        System.out.println("Replaced " + s + " with : " + replaceSpaceWith(s));
        s = "Mr Gaurav this works.      ";
        System.out.println("Replaced " + s + " with : " + replaceSpaceWith(s));
    }

    //Start backward till the first non-space character is found.
    //Maintain a separate "end" pointer. Put the non-space characters from backward into a char array
    //decrement "end" pointer
    //when internal space encountered, replace the result with '0', '2', '%' backwards.
    private static String replaceSpaceWith(String str) {
        char[] strArr = str.toCharArray();
        int end = str.length() - 1;
        boolean trailingWhiteSpaceOver = false;

        for(int index = str.length()-1; index>=0; index--){
            if(str.charAt(index) != ' '){
                strArr[end--] = str.charAt(index);
                trailingWhiteSpaceOver = true;
            }
            if(trailingWhiteSpaceOver && str.charAt(index) == ' ') {
                strArr[end--] = '0';
                strArr[end--] = '2';
                strArr[end--] = '%';
            }
        }
        return String.valueOf(strArr);
    }
}
