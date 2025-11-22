class Solution {
    Deque<Poly> stack = new ArrayDeque<>();
    Deque<String> op = new ArrayDeque<>();
    int[] order = new int[128];
    String ALL = ".";
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        order['*'] = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++){
            map.put(evalvars[i], evalints[i]);
        }
        String[] A = expression.replaceAll("\\(", "( ").replaceAll("\\)", " )").split(" "); // separate ( and ) with variables and numbers
        for (int i = 0; i < A.length; i++) if (map.containsKey(A[i])){
            A[i] = ""+map.get(A[i]); // replace known variables
        }
        return solve(A).build();
    }

    private Poly solve(String[] A){ // shunting yard algo
        for (String s : A){
            switch(s){
                case "(" -> op.push(s);
                case ")" -> {go(ALL); op.pop();}
                case "+", "-", "*" -> {go(s); op.push(s);}
                default -> stack.push(new Poly(s));
            };
        }
        go(ALL);
        return stack.pop();
    }

    private void go(String s){ // shunting yard algo helper function
        int ch = s.charAt(0);
        while(!op.isEmpty() && order[op.peek().charAt(0)] >= order[ch] && !op.peek().equals("(")){
            Poly r = stack.pop(), l = stack.pop();
            switch(op.pop()){
                case "+" -> stack.push(l.add(r));
                case "-" -> stack.push(l.minus(r));
                default  -> stack.push(l.multiply(r));
            };
        }
    }

    private class Poly {
        List<Term> all = new ArrayList<>();

        Poly(List<Term> terms){
            all=terms;
        }

        Poly(String s){
            if (s.charAt(0) == '-' || s.chars().allMatch(Character::isDigit)){
                all.add(new Term(Integer.parseInt(s))); // digit 
            }else{
                all.add(new Term(s)); // variable
            }
        }

        Poly multiply(Poly other){
            Map<Term, Integer> map = new HashMap<>();
            for (Term a : all){
                for (Term b : other.all){
                    Term cur = new Term();
                    cur.rank = a.rank + b.rank; // add the rank
                    cur.constant = a.constant * b.constant; // multiply the constant
                    cur.variables.addAll(a.variables); // all variables
                    cur.variables.addAll(b.variables); // from both
                    map.merge(cur, cur.constant, Integer::sum); // then put it into map
                }
            }
            return make(map); // make it 
        }

        Poly minus(Poly other){
            for (Term t : other.all){ // invert all constant
                t.constant *= -1;
            }
            return add(other); // then call addition
        }

        Poly add(Poly other){
            List<Term> cur = new ArrayList<>();
            Map<Term, Integer> map = new HashMap<>();
            for (Term t : all){ // merge all terms
                map.merge(t, t.constant, Integer::sum);
            }
            for (Term t : other.all){ // all terms
                map.merge(t, t.constant, Integer::sum);
            }
            return make(map); // then make it
        }

        Poly make(Map<Term, Integer> map){
            List<Term> ans = new ArrayList<>();
            for (Term t : map.keySet()){
                if (map.get(t) != 0){ // if it is has something (constant = 0 means it got cancelled out)
                    t.constant = map.get(t); // update the constant
                    ans.add(t); // then add it.
                }
            }
            return new Poly(ans); // return a new Poly
        }

        List<String> build(){ // build the final answer
            List<String> ans = new ArrayList<>();
            var cmp = Comparator.<Term>comparingInt(o -> -o.rank).thenComparing(o -> o.all());
            all.sort(cmp);
            for (Term t : all){
                String got = t.serialize();
                if (!got.equals("0")){ // got a WA for this, "0" shouldn't be included.
                    ans.add(got);
                }
            }
            return ans;
        }
    }

    private class Term {
        int rank = 0;
        int constant = 1;
        List<String> variables = new ArrayList<>();

        Term(){}

        Term(int num){
            constant = num;
        }

        Term(String v){ // variable, set rank to 1.
            variables.add(v);
            rank = 1;
        }

        String all(){ // for easy comparison.
            Collections.sort(variables);
            StringBuilder sb = new StringBuilder();
            for (String s : variables){
                sb.append('*');
                sb.append(s);
            }
            return sb.toString();
        }

        String serialize(){ // serialize the current term, for build() function in Poly.
            return constant + all();
        }

        @Override
        public boolean equals(Object o){ // for the hashmap to work, I had to override this method
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Term other = (Term) o;
            return other.rank == rank &&
                   other.all().equals(all());
        }

        @Override
        public int hashCode(){ // and this method.
            return Objects.hash(all(), rank);
        }
    }
}