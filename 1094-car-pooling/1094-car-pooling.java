class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengers = new int[1001];
        for (int[] trip : trips) {
            passengers[trip[1]] += trip[0];
            passengers[trip[2]] -= trip[0];
        }
        
        int currCapacity = 0;
        for (int i = 0; i < passengers.length; i++) {
            currCapacity += passengers[i];
            if (currCapacity > capacity) {
                return false;
            }
        }
        
        return true;
    }
}