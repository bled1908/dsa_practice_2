import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        
        for (char c:s.toCharArray()){
            stack.push(c);
            if(stack.size()>=3) {
                char c3=stack.pop();
                char c2=stack.pop();
                char c1=stack.pop();  
                if(c1=='a'&&c2=='b'&&c3=='c'){
                    continue;
                }
                else{
                    stack.push(c1);
                    stack.push(c2);
                    stack.push(c3);
                }
            }
        }
        
        return stack.isEmpty();
    }
}