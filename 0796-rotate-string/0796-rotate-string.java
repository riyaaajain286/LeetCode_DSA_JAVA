class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        //check by making every new string by combining s+s as it contains all new strings
        String combined=s+s;
        if(combined.contains(goal))
           return true;
        return false;
    }
}