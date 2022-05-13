class Solution {
    public int removeElement(int[] nums, int val) {
        //define a slow pointer and a fast pointer
        int slow = 0, fast = 0;
        
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++; 
            }
            fast++;
        }
        
        return slow;
    }
}