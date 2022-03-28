class Solution {
    public int removeDuplicates(int[] nums) {
        //define 2 indexes i,j:
        //i increments slower than j
        int i = 0, j = 0;
        
        for(j = 0; j < nums.length; j++){
            //Let index j increment first and check if the indexed element is different than the element at index i
            //if a different element is found at j, increment i and update it to the new value to form a non-repetitive array
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        
        //The first k element = nums[0...i]
        return i+1;
    }
}