class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> path=new ArrayList<>();
         backtrack(s,0,result,path);
         return result;
    }
    public void backtrack(String s,int start,List<List<String>> result,List<String> path){
        //base case=reached end of string
        if(start==s.length()){
           result.add(new ArrayList<>(path));
           return;
        }
         for(int end=start;end<s.length();end++){
           if(isPalindrome(s,start,end)){
            path.add(s.substring(start,end+1));//choose
            backtrack(s,end+1,result,path);//explore new
            path.remove(path.size()-1);//unchoose means remmove last char from path
        }
         }
    }
    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}