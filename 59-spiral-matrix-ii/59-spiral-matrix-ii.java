class Solution {
    public int[][] generateMatrix(int n) {
        int leftBound = 0, upperBound = 0, lowerBound = n-1, rightBound = n-1;
        int[][] res = new int[n][n];
        int num = 1;
        
        while(num <= n*n){
            //read from left to right
            if(upperBound <= lowerBound){
                for(int i = leftBound; i <= rightBound; i++){
                    res[upperBound][i] = num;
                    num++;
                }
                upperBound++;
            }
            
            //read from top to bottom
            if(rightBound >= leftBound){
                for(int j = upperBound; j <= lowerBound; j++){
                    res[j][rightBound] = num;
                    num++;
                }
                rightBound--;
            }
            
            //read from right to left
            if(lowerBound >= upperBound){
                for(int k = rightBound; k >= leftBound; k--){
                    res[lowerBound][k] = num;
                    num++;
                }
                lowerBound--;
            }
            
            
            //read from bottom to top
            if(leftBound <= rightBound){
                for(int z = lowerBound; z >= upperBound; z--){
                    res[z][leftBound] = num;
                    num++;
                }
                leftBound++;
            }
        }
        
        return res;
    }
}