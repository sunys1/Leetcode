class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Create a HashMap that stores the value:Index pairs
        HashMap<Integer, Integer> val = new HashMap<>();
        int[] res = new int[2];
        
        for(int i = 0; i < numbers.length; i++){
            //check if the complement of numbers[i] for the target sum exists 
            //in the hashmap
            if(val.containsKey(target - numbers[i])){
                res[0] = val.get(target - numbers[i]);
                res[1] = i+1;
            }else{
                //assuming no duplicates
                val.put(numbers[i], i+1);
            }
        }
        
        return res;
    }
}