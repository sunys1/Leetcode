class Solution {
    public void rotate(int[][] matrix) {
        //the given array is n x n
        int arrLength = matrix.length;
        
        int temp;
        //1.Make a matrix tranpose
        for(int i=0; i < arrLength; i++){
            for(int j = i; j < arrLength; j++){
                if(i != j){
                    temp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }
        
        int temp2;
        //2.Reverse rows
        for(int i=0; i < arrLength; i++){
            for(int j = 0; j < arrLength / 2; j++){
                temp2 = matrix[i][arrLength - 1 - j];
                matrix[i][arrLength - 1 - j] = matrix[i][j];
                matrix[i][j] = temp2;
            }
        }
    }
}