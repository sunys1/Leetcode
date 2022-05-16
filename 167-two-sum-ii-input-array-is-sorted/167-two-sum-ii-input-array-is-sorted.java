class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //Declare a left pointer and a right pointer
        int left = 0, right = numbers.length - 1;
        
        while(numbers[left] + numbers[right] != target){
            if(numbers[left] + numbers[right] < target){
                left++;
            }else{
                right--;   
            }
        }
        
        return new int[]{left+1, right+1};
    }
}