class Solution {
    private int[]diff;
    
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        diff = new int[arr.length];
        int i = 0, numPassenger, start, end;
        
        while(i < trips.length){
            numPassenger = trips[i][0];
            start = trips[i][1];
            end = trips[i][2];
            
            diff = updateDiff(numPassenger, start, end);
            i++;
        }
        
        return updateArr(diff, arr, capacity);
    }
    
    //Update the diff elements by the starting and ending bus stop of a trip
    public int[] updateDiff(int numPassenger, int start, int end){
        diff[start] += numPassenger;
        
        if((end) < diff.length){
            diff[end] -= numPassenger;
        }
        
        return diff;
    }
    
    //new function that applies the new difference values to the original arr array to obtain the new array with updated elements in the specified range.
    public boolean updateArr(int[] diff, int[] arr, int capacity){
        //Populate the arr array
        arr[0] = diff[0];
        
        for(int i = 0; i < arr.length - 1; i++){
            arr[i+1] = arr[i] + diff[i+1];
            if(arr[i] > capacity){
                return false;
            }
        }
        
        return true;
    }
}