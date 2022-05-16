class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // the longest palindrome centered at s[i]
            String s1 = palindrome(s, i, i);
            // the longest palindrome centered at s[i] and s[i+1]
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
    
    // search for the longest palindrome centered at s[l] and s[r] in s
    public String palindrome(String s, int l, int r) {
        //Prevent indexOutOfBound
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            //expand the window between the l and r pointer
            l--; r++;
        }
        //l+1 is inclusive and r is exclusive
        return s.substring(l + 1, r);
    }
}