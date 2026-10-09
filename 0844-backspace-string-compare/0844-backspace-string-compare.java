class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1=new Stack<>();
        Stack<Character> st2=new Stack<>();
        for(char ch1:s.toCharArray()){
            if(ch1!='#'){
                st1.push(ch1);
            }
            else if(ch1=='#' && !st1.isEmpty()){
                st1.pop();
            }
        }
        for(char ch2:t.toCharArray()){
            if(ch2!='#'){
                st2.push(ch2);
            }
            else if(ch2=='#' && !st2.isEmpty()){
                st2.pop();
            }
        }
        String s1="";
        while(!st1.isEmpty()){
            s1+=st1.pop();
        }
        String s2="";
        while(!st2.isEmpty()){
            s2+=st2.pop();
        }
         if(s1.equals(s2))
           return true;
        return false;
    }
}