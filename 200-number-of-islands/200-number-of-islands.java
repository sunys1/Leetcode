class Solution {
    //For each cell in the 2-D array, use DFS to traverse its surrounding cells if the cell is '1' land cell. Return if the visited cell is '0' water cell, otherwise set the current cell to water and continue traversing.
    int m, n, res;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    traverse(grid, i, j);
                }
            }
        }
        
        return res;
    }
    
    public void traverse(char[][] grid, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        if(grid[i][j] == '0') return;
        
        //set the current cell to water such that all adjacent land cells 
        //will not be revisited as we return at a water cell.
        grid[i][j] = '0';
        
        traverse(grid, i-1, j); //up
        traverse(grid, i+1, j); //down
        traverse(grid, i, j-1); //left
        traverse(grid, i, j+1); //right
    }
}