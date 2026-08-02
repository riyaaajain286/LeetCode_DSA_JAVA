class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        for(char ch:expression.toCharArray()){
            // Ignore comma and opening bracket
            if(ch=='(' || ch==',')
              continue;
            // Push operands/operators
             if(ch!=')'){
                st.push(ch);
            }
            else{
                int t=0,f=0;
                // Pop operands
                while(st.peek()=='t' || st.peek()=='f'){
                    char value=st.pop();
                    if(value=='t')
                        t++;
                    else
                        f++;
                }  
                // Pop operator
                      char op=st.pop();
                        if(op=='&' ){
                            st.push(f>0?'f':'t');
                        }
                        else if(op=='|'){
                            st.push(t>0?'t':'f');
                        }
                        else{//for !
                          st.push(t==1?'f':'t');
                        }
                    }
               }
           return st.peek()=='t'; 
    }
}