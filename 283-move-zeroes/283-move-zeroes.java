class Solution {
    public void moveZeroes(int[] nums) {
        // //remove all 0s
        // int pos = removeElement(nums, 0);
        // //update nums[pos..length-1] to 0
        // for (; pos < nums.length; pos++) {
        //     nums[pos] = 0;
        // }
        int p = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j] != 0){
                        int temp = nums[j];
                        nums[i] = temp;
                        nums[j] = 0;
                        System.out.println(nums[i]);
                        break;
                    }
                }
            }
        }
    }
    
//     public int removeElement(int[] nums, int val) {
//         //define a slow pointer and a fast pointer
//         int slow = 0, fast = 0;
        
//         while(fast < nums.length){
//             if(nums[fast] != val){
//                 nums[slow] = nums[fast];
//                 slow++; 
//             }
//             fast++;
//         }
        
//         return slow;
//     }
}