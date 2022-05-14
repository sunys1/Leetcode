class Solution {
    private int[] diff;
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //Initialize the answer array with the number of flights
        int[] answer = new int[n];
        //by default all flights have 0 booking
        diff = new int[n];    
        
        int i = 0, first, last, seats;
        
        while(i < bookings.length){
            first = bookings[i][0];
            last = bookings[i][1];
            seats = bookings[i][2];
            
            diff = updateDiff(first, last, seats);
            i++;
        }
        
        answer = updatedArr(diff, answer);
        
        return answer;
        
    }
    
    //Update the diff elements by the seat bookings for all flights
    public int[] updateDiff(int first, int last, int seats){
        diff[first - 1] += seats;
        
        if((last) < diff.length){
            diff[last] -= seats;
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
}