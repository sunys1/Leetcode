class Solution {
    int validNums;
    HashMap<Integer, Integer>map = new HashMap<>();
    Random rand = new Random();
    public Solution(int n, int[] blacklist) {
        validNums = n - blacklist.length;
        //put all blacklist numbers into the HashMap
        for(int num : blacklist){
            map.put(num, 100); //100 is a random number just for adding the blacklist numbers
        }
        
        //consider the int n as an array [0,n)
        //now we map the blacklist numbers to the valid numbers/indexes
        //starting with index n - 1;
        int last = n - 1;
        
        //if index "last" is in the blacklist, jump to the next index
        for(int num : blacklist){
            //if the num is already in the range of indexes used for mapping
            //the blacklist numbers, do nothing
            if (num >= validNums) continue;
            
            while(map.containsKey(last)){
                last--;
            }
            map.put(num, last);
            last--;
        }
    }
    
    public int pick() {
        int num = rand.nextInt(validNums);
        //if num is in blacklist, return the valid index that it maps to
        if(map.containsKey(num)){
            return map.get(num);
        }
        //return the valid num
        return num;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */