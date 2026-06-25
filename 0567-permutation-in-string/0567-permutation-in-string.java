class Solution {
    public boolean checkInclusion(String s1, String s2) {
        

        if (s1.length() > s2.length())
            return false;

        int[] freq = new int[26];

        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        int l = 0, r = 0;
        int c = s1.length();   

        while (r < s2.length()) {

            if (freq[s2.charAt(r) - 'a'] > 0)
                c--;

            freq[s2.charAt(r) - 'a']--;
            r++;

            if (c == 0)
                return true;

            if (r - l == s1.length()) {
                if (freq[s2.charAt(l) - 'a'] >= 0)
                    c++;

                freq[s2.charAt(l) - 'a']++;
                l++;
            }
        }

        return false;
    
    }
}