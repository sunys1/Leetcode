class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    
    public void backtrack(int[] nums, int root){
        //every node is a subset
        res.add(new LinkedList(path));
        
        for(int i = root; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i+1);
            path.removeLast();
        }
    }
}