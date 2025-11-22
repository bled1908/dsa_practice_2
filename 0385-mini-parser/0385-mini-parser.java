/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        //basic case 1
        if (s.equals("[]")) {
            return new NestedInteger();
        }
        //basic case 2
        if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-') {
            int value = Integer.valueOf(s);
            return new NestedInteger(value);
        }
        //it is a nest list, we try to split it with ','
        s = s.substring(1, s.length() - 1);
        NestedInteger ans = new NestedInteger();
        int l = 0;
        int count = 0;
        //we only care about the first level
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                count++;
            } else if (ch == ']') {
                count--;
            } else if (ch == ',' && count == 0) {
                System.out.println("*");
                NestedInteger nest = deserialize(s.substring(l, r));
                ans.add(nest);
                l = r + 1;
            }
        }
        //add the last part
        NestedInteger nest = deserialize(s.substring(l, s.length()));
        ans.add(nest);
        return ans;
    }
}