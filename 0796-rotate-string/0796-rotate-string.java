class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(n!=goal.length()) return false;
        String current=s;
        for(int i=0;i<n;i++){
           current=current.substring(1)+current.charAt(0);
           if(current.equals(goal)) return true;
        }
      return false;
    }
}