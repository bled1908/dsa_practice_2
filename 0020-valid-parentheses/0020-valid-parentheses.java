class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        matchingBrackets.put(']', '[');

        for(char c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) return false;

                char requiredOpener = matchingBrackets.get(c);
                char actualOpener = stack.pop();

                if(actualOpener != requiredOpener) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}