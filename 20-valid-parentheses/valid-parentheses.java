class Solution {
    public boolean isValid(String s) {
        
        char[] stack = new char[s.length()];
        int top = -1;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch; 
            } else {
                if (top == -1) {
                    return false; 
                }
                char last = stack[top--]; 
                if ((ch == ')' && last != '(') || 
                    (ch == '}' && last != '{') || 
                    (ch == ']' && last != '[')) {
                    return false;
                }
            }
        }
        
        return top == -1; 
    }
}