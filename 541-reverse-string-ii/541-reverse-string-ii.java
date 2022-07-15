class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        if(arr.length <= k){
            reverseAll(arr, 0, arr.length-1);
        }else{
            int a = 0, b = a+k-1;
            while(a < arr.length && b < arr.length){
                reverseAll(arr, a, b);
                a+= 2*k;
                b+= 2*k;
                if(b >= arr.length){
                    b = arr.length-1;
                }
            }
        }
        
        return String.valueOf(arr);
    }
    
    public void reverseAll(char[] arr, int start, int end){
        for(int i = start; i < start+(end-start+1)/2; i++){
            char temp = arr[i];
            arr[i] = arr[end-i+start];
            arr[end-i+start] = temp;
        }
    }
}