package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

// Write an algorithm such that if an element in an M*N matrix is 0,
// its entire row and column are set to 0.
public class SetZerosInMatrix {
    public static void main(String[] args) {
        int[][] inputMatrix = {{1,2,3}, {4,5,0}, {7,8,9}};
        System.out.println("Input: ");
        print2DMatrix(inputMatrix);
        System.out.println("Set rows and columns to 0s");
        print2DMatrix(setZerosInMatrix(inputMatrix));
    }

    private static void print2DMatrix(int[][] input) {
        int len = input.length;
        for (int[] ints : input) {
            for (int j = 0; j < len; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }

    //Iterate the input matrix and populate separate sets for rows and columns having 0.
    // Iterate the matrix again and for whichever rows and columns are present in the above sets, update the cell value to 0.
    // Time Complexity = O(M*N)
    // Space Complexity = O(M + N)
    private static int[][] setZerosInMatrix(int[][] matrix){
        if(matrix.length == 0) return matrix;
        int N = matrix.length;
        int M = matrix[0].length;
        Set<Integer> rowsHavingZeros = new HashSet<>();
        Set<Integer> colsHavingZeros = new HashSet<>();

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(matrix[r][c] == 0){
                    rowsHavingZeros.add(r);
                    colsHavingZeros.add(c);
                }
            }
        }
        for(int r = 0; r < N; r++){
            for(int c = 0; c< M; c++){
                if(rowsHavingZeros.contains(r) || colsHavingZeros.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
        return matrix;
    }
}
