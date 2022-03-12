class NumArray {

    private int[] presum; //use new array presum to store the sum
                          //of the first i elements at ith index
    
    public NumArray(int[] nums) {
        
        presum = new int[nums.length];
        for(int i = 0; i < presum.length; i++){
            if(i == 0){
                //starting point of the sum
                presum[i] = presum[i] + nums[i];
            }else{
                //sum the previous sum and the current number
                presum[i] = presum[i-1] + nums[i];
            }
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0){
            //If the left end is 0 and known that right > left. 
            //The sum = the stored value at presum[right]
            return presum[right];    
        }else{
            //Calculate the difference between the first "right" elements sum
            //and the first "left" elements sum inclusively
            return (presum[right] - presum[left - 1]);    
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */