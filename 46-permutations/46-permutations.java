class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtrack(nums, visited);
        
        return result;
    }
    
    public void backtrack(int[] nums, boolean[] visited){
        //base case: finish the backtrack when all numbers are included in the current path
        if(path.size() == nums.length){
            result.add(new LinkedList(path));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            //check if the int i is already in the path
            if(visited[i]) continue;
            
            visited[i] = true;
            path.add(nums[i]);
            backtrack(nums, visited);
            //now remove the last visited node to clear the current path
            path.removeLast();
            visited[i] = false;
        }
    }
}