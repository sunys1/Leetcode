class NumArray {

    private int[] presum; //use new array presum to store the sum
                          //of the first i elements at ith index
    
    public NumArray(int[] nums) {
        presum = new int[nums.length + 1];
        presum[0] = 0; //To ease storing first i elements sum at each index
        //System.out.println(presum[0]);
        for(int i = 1; i < presum.length; i++){
            presum[i] = presum[i-1] + nums[i-1];
            System.out.println(presum[i]);
        }
    }
    
    public int sumRange(int left, int right) {
        //Calculate the difference between the first "right" elements sum
        //and the first "left" elements sum inclusively
        return (presum[right + 1] - presum[left]);   
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */