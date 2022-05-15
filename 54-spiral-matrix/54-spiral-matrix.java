class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //Get the dimension of the matrix
        int l = matrix.length, w = matrix[0].length;
        int leftBound = 0, upperBound = 0, rightBound = w-1, lowerBound = l-1;
        //Initialize the result list with the matrix dimension
        List<Integer> result = new LinkedList<>();
        
        while(result.size() < l*w){
            //read from left to right
            if(upperBound <= lowerBound){
                for(int i = leftBound; i <= rightBound; i++){
                    result.add(matrix[upperBound][i]);
                }
                upperBound++;
            }
            
            //read from top to bottom
            if(rightBound >= leftBound){
                for(int j = upperBound; j <= lowerBound; j++){
                    result.add(matrix[j][rightBound]);
                }
                rightBound--;
            }
            
            //read from right to left
            if(lowerBound >= upperBound){
                for(int k = rightBound; k >= leftBound; k--){
                    result.add(matrix[lowerBound][k]);
                }
                lowerBound--;
            }
            
            
            //read from bottom to top
            if(leftBound <= rightBound){
                for(int z = lowerBound; z >= upperBound; z--){
                    result.add(matrix[z][leftBound]);
                }
                leftBound++;
            }
        }
        
        return result;
    }
}