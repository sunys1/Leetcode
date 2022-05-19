class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        
        HashMap<Character, Integer>target = new HashMap<>();
        HashMap<Character, Integer>window = new HashMap<>();
        //Store the number of each character needed in String t
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(target.containsKey(c)){
                target.put(c, target.get(c) + 1);    
            }else{
                target.put(c, 1);
            }
        }
        
        //expand the window by incrementing right pointer until the target condition is met
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            
            //check if the character c is needed in t
            if(target.containsKey(c)){
                if(window.containsKey(c)){
                    window.put(c, window.get(c) + 1);    
                }else{
                    window.put(c, 1);
                }
                if(target.get(c).equals(window.get(c))){ //the substring has covered enough c for the target String t
                    valid++;
                }
            }
            
            //Shrink the window by incrementing the left pointer to optimize the substring
            while(valid == target.size()){
                
                if(right - left < len){ //optimize substring length
                    start = left;
                    len = right - left;
                }
                
                char d = s.charAt(left);
                left++;

                if(target.containsKey(d)){
                    if(window.get(d).equals(target.get(d))){ //the substring currently has exactly the number of character d needed for t
                        valid--; //shrinking the window at this point invalidates the substring because a character d is moved outside the window
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        } 
        
        if(len == Integer.MAX_VALUE) return "";
        
        //return the optimized substring
        return s.substring(start, start+len);
    }
}