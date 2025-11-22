class Solution {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int total=0;
        for (String op : operations)
        {
            switch(op){
                case "C":
                    st.pop();
                    break;
                case "D":
                    st.push(st.peek()*2);
                    break;
                case "+":
                    int last_element = st.pop();
                    int sum = last_element + st.peek();
                    st.push(last_element);
                    st.push(sum);
                    break;
                default :
                    st.push(Integer.parseInt(op));
                    break;
            }
        }
        for(int sc : st)
        {
            total = total+sc;
        }
        return total;
    }
}