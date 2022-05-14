class Solution {
    private int[] diff;
    
    //new function that returns an array of difference values
    //for all neighbors in arr.
    public int[] diffArr(int[] arr){
        diff = new int[arr.length];
        for(int i = 0; i < arr.length - 1; i++){
            diff[i + 1] = arr[i+1] - arr[i]; //the ith element of diff array stores the difference between the ith and the i-1th element of arr.
        }
        
        return diff;
    }
    
    //new function that presets the difference values of elements in the 
    //specified range in diff array based on the increment value from the ith update array.
    public int[] update(int leftEnd, int rightEnd, int increment){
    //To apply the increment starting at index leftEnd, we apply the increment to the element of diff array at index leftEnd.
        diff[leftEnd] += increment;
        //if the rightEnd is the end of the array, then all numbers after leftEnd are affected. No need to change the difference back after rightEnd.
        //If rightEnd is not the end of the array, then resotre the difference value in diff array after rightEnd;
        if(rightEnd + 1 < diff.length){
            diff[rightEnd + 1] -= increment;
        }
        
        return diff;
    }
    
    //new function that applies the new difference values to the original arr array to obtain the new array with updated elements in the specified range.
    public int[] updatedArr(int[] diff, int[] arr){
        //Populate the arr array
        arr[0] = diff[0];
        
        for(int i = 0; i < arr.length - 1; i++){
            arr[i+1] = arr[i] + diff[i+1];
        }
        
        return arr;
    }
    
    public int[] getModifiedArray(int length, int[][] updates) {
        //Create a new array with int length
        int[] arr = new int[length];
        diff = diffArr(arr);
        diff[0] = arr[0];
        
        int[] newDiff = new int[length];
        
        int i = 0, leftEnd, rightEnd, increment;
        
        while(i < updates.length){
            leftEnd = updates[i][0];
            rightEnd = updates[i][1];
            increment = updates[i][2];
            
            newDiff = update(leftEnd, rightEnd, increment); //apply updates to the diff array
            i++;
        }
        arr = updatedArr(newDiff, arr);//construct the new array based on the updated difference values;
            
        return arr; 
    }
}