class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //1. for each i in nums1, locate j in nums2: nums[i] == nums[j]
        //2. find the next element greater than nums[j] in nums2
        
        int[] ans = new int[nums1.length];
        int j;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //mapping key->val: nums2[i] -> next greater element for nums2[i] in nums2
        int[] greater = nextGreaterElement(nums2);
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], greater[i]);
        }
        
        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        
        return ans;
    }
    
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Stack<Integer> s = new Stack<>(); 
        //push the elements into the stack in reverse order
        //such that peek/pop will be in forward order
        for (int i = n - 1; i >= 0; i--) {
            //the elements pushed in reversed order are considered the potential next greater
            //element in forward order
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                //remove the smaller values because they can never be the next greater element
                s.pop();
            }
            //the stack is empty if no greater next element. Otherwise the element left is the next greater element
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}