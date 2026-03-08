class Solution {
    public int longestValidParentheses(String s) {
        Stack<String> st = new Stack<>();
        int max = 0;
        for(String t : s.split("")){
            if(t.equals("(")){
                st.push("(");
            }
            else{
                if(!st.isEmpty()){
                    int sum = 0;
                    boolean flag = true;
                    while(!st.isEmpty()){
                        String top = st.pop();
                        if(top.equals("(")){
                            sum+=2;
                            flag = false;
                            break;
                        }
                        else{
                            sum+=Integer.parseInt(top);
                        }
                    }
                    max = Math.max(max,sum);
                    if(flag) sum = 0;
                    st.push(sum+"");
                }
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            String top = st.pop();
            if(top.equals("(")) sum = 0;
            else sum+=Integer.parseInt(top);
            max = Math.max(max,sum);
        }
        return max;
    }
}