class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        //check by making every new string by inserting first char to the remaining string
        for(int i=0;i<s.length();i++){
            if(s.equals(goal))
              return true;
            s=s.substring(1)+s.charAt(0);
        }
        return false;
    }
}