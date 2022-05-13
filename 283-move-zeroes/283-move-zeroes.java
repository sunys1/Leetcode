class Solution {
    public void moveZeroes(int[] nums) {
        //define 2 pointers i,j
        int i = 0, j = 0;
        
        while(j < nums.length){
            //if nums[i] == 0 and nums[j] != 0, swap the elements at i, j
            if(nums[i] == 0){
                if(nums[j] != 0){
                    swap(nums, i++,j++);
                }else{
                    j++;
                }
            }else{
                i++;
                j++;
            }
            
            
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}