class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //eliminate some cases
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;

        boolean[] used = new boolean[nums.length];
        int target = sum / k;
        //start choosing integer with nums[0]
        return backtrack(k, 0, nums, 0, used, target);
    }
    
    public boolean backtrack(int k, int bucket, 
    int[] nums, int start, boolean[] used, int target) {
        // base case
        if (k == 0) {
            return true;
        }
        
        // turn the "used" array into a [true, false, ...] string
        // store it in memo for an easy lookup to check if the current combination has been           tested
        String state = Arrays.toString(used);

        if (bucket == target) {
            // current subset works; start choosing integers for next subset
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            // store the current combination into memo
            memo.put(state, res);
            return res;
        }

        if (memo.containsKey(state)) {
            // skip it if the current combination has been tested
            return memo.get(state);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                // nums[i] is taken
                continue;
            }
            if (nums[i] + bucket > target) {
                // nums[i] doesn't work
                continue;
            }
            // choose the current integer
            used[i] = true;
            bucket += nums[i];
            // choose next integers for the current subset recursively
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // undo this choice of integer
            used[i] = false;
            bucket -= nums[i];
        }
        // no solution after exhausive tests of all combinations
        return false;
    }
}