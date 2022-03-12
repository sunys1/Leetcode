class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        //Create a new array with int length
        int [] arr = new int[length];
        int[] diff = new int[length];
        int[] update = new int[length];
        
        int i = 0;
        
        while(i < updates.length){
            diff = diffArr(arr); //construct the difference array
            update = update(diff, updates[i]); //apply updates to diff first
            arr = updatedArr(update); //construct the new array based on the updated difference values
            
            i++;
        }
        
        return arr;
    }
    
    //new function that returns an array of difference values
    //for all neighbors in arr.
    public int[] diffArr(int[] arr){
        int[] diff = new int[arr.length];
        diff[0] = arr[0]; //The 1st element has no left neighbor for           comparison
        for(int i = 0; i < arr.length - 1; i++){
            diff[i + 1] = arr[i+1] - arr[i]; //the ith element of diff array stores the difference between the ith and the i-1th element of arr.
        }
        
        return diff;
    }
    
    //new function that presets the difference values of elements in the 
    //specified range in diff array based on the increment value from the ith update array.
    public int[] update(int[]diff, int[]updateI){
        //By definition, the 1st element in ith update array is the left             boundary;
        //the 2nd element is the right boundary;the 3rd is the increment(+           or -)
        int leftEnd = updateI[0];
        int rightEnd = updateI[1];
        int increment = updateI[2];
        
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
    public int[] updatedArr(int[] diff){
        int[] newArr = new int[diff.length];
        newArr[0] = diff[0]; //The 1st element in the result array and the difference array is always equal;
        
        //Populate the newArr array
        for(int i = 0; i < newArr.length - 1; i++){
            newArr[i+1] = newArr[i] + diff[i+1];
        }
        
        return newArr;
    }
}