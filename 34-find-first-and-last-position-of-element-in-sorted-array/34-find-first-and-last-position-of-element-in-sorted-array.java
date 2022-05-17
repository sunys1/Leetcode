class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        
        int start = searchStartPos(nums, target);
        int end = searchEndPos(nums, target);
        
        return new int[]{start,end}; 
    }
    
    //find the starting position
    public int searchStartPos(int[] nums, int target){
        int left = 0, right = nums.length, mid;
        //left pinter max value = nums.length
        while(left < right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                //continue searching for the starting point of the target
                right = mid; //the range is an open interval [left, right)    
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        
        //check for indexOutOfBound
        if(left == nums.length || nums[left] != target){
            return -1;
        }
        
        return left;
    }
    
    //find the ending position
    public int searchEndPos(int[] nums, int target){
        int left = 0, right = nums.length, mid;
        //left pinter max value = nums.length
        while(left < right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                //continue searching for the ending point of the target
                left = mid + 1; //the range is an open interval [left, right)    
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        
        //check for indexOutOfBound
        if(right == 0 || nums[right-1] != target){
        //or if(left == 0 || nums[left-1] != target){
        //both are ok because eventually left == right when the loop terminates
        //It's left/right - 1 because after the last iteration, left = mid + 1 and nums[left] !=         target, but nums[left-1] could be ending position of the target value.
            return -1;
        }
        
        return right-1;
    }
}