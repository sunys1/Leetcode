class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        
        //Push the nums element into the stack in reverse order
        for(int i = nums.length - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() <= nums[i]){
                s.pop();
            }
            
            int res = (s.isEmpty() ? -1 : s.peek());
            
            if(s.isEmpty()){
                for(int j = 0; j < i; j++){
                    if(nums[j] > nums[i]){
                        res = nums[j];
                        break;
                    }
                }
            }
            
            ans[i] = res;
            s.push(nums[i]);
        }
        
        return ans;
    }
}