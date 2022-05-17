class Solution {
    public int search(int[] nums, int target) {
        //declare 3 pointers - left, right, mid
        int left = 0, right = nums.length-1, mid;
        
        while(left <= right){
            mid = left + (right-left)/2;
            
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }
        }
        
        //Target not found
        return -1;
        
    }
}