class NumMatrix {
    //Declare a prefix sum array
    private int[][] presum;
    
    public NumMatrix(int[][] matrix) {
        //Get the dimension of the 2D array matrix
        int l = matrix.length, w = matrix[0].length;
        //Check the dimension
        if(l == 0 || w == 0) return;
        //let presum[0][0] = 0;
        presum = new int[l+1][w+1]; 
        //Construct the prefix sum array
        for(int i = 1; i <= l; i++){
            for(int j = 1; j <= w; j++){
                //Calculate the sum of elements from matrix[0][0] to matrix[i-1][j-1]
                presum[i][j] = presum[i-1][j] + presum[i][j-1] + matrix[i-1][j-1] - presum[i-1][j-1];            
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //use presum array to calculate the sum of the target rectangle
        return presum[row2+1][col2+1] - presum[row1][col2+1] - presum[row2+1][col1] + presum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */