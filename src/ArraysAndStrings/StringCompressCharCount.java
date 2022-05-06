package ArraysAndStrings;

//Implement a method to perform basic string compression using the counts of repeated characters.
//For example, the string aabcccccaaa would become a2b1c5a3.
//If the "compressed" string would not become smaller than the original string, your method should return the original string.
public class StringCompressCharCount {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println("Compressed "+ s+": " + compressString(s));
        s = "";
        System.out.println("Compressed "+ s+": " + compressString(s));
        s = "aabbbbbcccccdddeeeefffffggggh";
        System.out.println("Compressed "+ s+": " + compressString(s));
        s = "abcdefghijklmnopqrtsuvwxyzABC";
        System.out.println("Compressed "+ s+": " + compressString(s));
    }

    //Iterate through the input string, compare current char with previous char and increment count
    //Maintain a new stringbuilder as result, append char and count whenever the character changes.
    //Time Complexity = O(n)
    //Space Complexity = O(n)
    private static String compressString(String str) {
        if(str == null || str.trim().length() == 0) return str;

        StringBuilder result = new StringBuilder();
        int count = 1;
        char prevChar = str.charAt(0);

        for(int index=1; index<str.length(); index++) {
            char currChar = str.charAt(index);
            if(prevChar == currChar){
                count++;
            }
            else {
                result.append(prevChar).append(count);
                prevChar = currChar;
                count = 1;
            }
        }
        result.append(prevChar).append(count);

        return result.length() < str.length() ? result.toString() : str;
    }
}
