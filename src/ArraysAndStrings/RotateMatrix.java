package ArraysAndStrings;

//Given an image represented by an N*N matrix, where each pixel in the image is 4b, write a method to rotate
//the image by 90 degrees. Can you do this in place?
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] inputMatrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println("Input: ");
        print2DMatrix(inputMatrix);
        System.out.println("Rotated 90 degrees clockwise:");
        print2DMatrix(rotateClockwise(inputMatrix));
        System.out.println("Rotated 90 degrees anti-clockwise:");
        print2DMatrix(rotateAntiClockwise(inputMatrix));
        inputMatrix = new int[][]{{1, 2}, {4, 5}};
        System.out.println("Input: ");
        print2DMatrix(inputMatrix);
        System.out.println("Rotated 90 degrees clockwise:");
        print2DMatrix(rotateClockwise(inputMatrix));
    }
    private static void print2DMatrix(int[][] input) {
        int len = input.length;
        for(int i=0; i < len; i++) {
            for(int j=0; j< len; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }

    //Simply rotate the array 90 degrees clockwise. So the [0][0] element of input will now become [0][N-1] of result
    //[0][1] will become [1][N-1].... till the first row is completed
    //when row changes result array's row counter will be back to 0 and column counter will be decremented.
    //Time Complexity = O(n^2)
    //Space Complexity = O(n^2)
    private static int[][] rotateClockwise(int[][] input){
        int len = input.length;
        if (len == 1) return input;
        int row = 0; int column = len-1;
        int[][] result = new int[len][len];

        for(int r = 0; r < len; r++) {
            for(int c = 0; c < len; c++) {
                result[row++][column] = input[r][c];
            }
            row = 0;
            column--;
        }
        return result;
    }

    //Simply rotate the array 90 degrees anti-clockwise. So the [0][0] element of input will now become [N-1][0] of result
    //[0][1] will become [N-2][0].... till the first row is completed
    //when row changes result array's row counter will be back to N-1 and column counter will be incremented.
    //Time Complexity = O(n^2)
    //Space Complexity = O(n^2)
    private static int[][] rotateAntiClockwise(int[][] input){
        int len = input.length;
        if (len == 1) return input;
        int row = len-1; int column = 0;
        int[][] result = new int[len][len];

        for(int r = 0; r < len; r++) {
            for(int c = 0; c < len; c++) {
                result[row--][column] = input[r][c];
            }
            row = len-1;
            column++;
        }
        return result;
    }
}
