class Solution {
    public boolean backspaceCompare(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();

        StringBuilder result1 = new StringBuilder(""); 
        StringBuilder result2 = new StringBuilder(""); 

        for(int i =0;i<n1;i++){
            char ch = s.charAt(i);
            if(ch == '#' && result1.length() > 0) result1.deleteCharAt(result1.length()-1);
            else if(ch != '#') result1.append(String.valueOf(ch));
            System.out.println(result1);
        }

        for(int i =0;i<n2;i++){
            char ch = t.charAt(i);
            if(result2.length() > 0 && ch == '#') result2.deleteCharAt(result2.length()-1);
            else if(ch != '#') result2.append(String.valueOf(ch));
            System.out.println(result2);
        }

        return (result1.toString().equals(result2.toString()));
    }
}