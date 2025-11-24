class Solution {
    public List<String> ambiguousCoordinates(String s) {
        // split string to pair combinations (1d list) - O(s length -1)
        // further break down each pair to varition combinations (2d list) - O((left len
        // -1)*(right len) -1)
        // ~ O(m^3) m is the length of s
        List<String[]> pairs = new LinkedList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            String s1 = s.substring(1, i);
            String s2 = s.substring(i, s.length() - 1);
            if (s1.length() > 1 && Integer.valueOf(s1) == 0 || s2.length() > 1 && Integer.valueOf(s2) == 0)
                continue;
            pairs.add(new String[] { s1, s2 });
        }
        //pairs.forEach(x -> System.out.println(Arrays.toString(x)));
        List<String> res = new LinkedList<>();
        for (String[] pair : pairs) {
            List<String> left = mutate(pair[0]);
            List<String> right = mutate(pair[1]);
            for (String sLeft : left)
                for (String sRight : right)
                    res.add("(" + sLeft + ", " + sRight + ")");
        }
        return res;
    }

    List<String> mutate(String s) {
        List<String> list = new LinkedList<>();
        if (s.length() == 1 || s.charAt(0) != '0')
            list.add(s);
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i), s2 = s.substring(i, s.length());
            //System.out.println(s1 + "|" + s2);
            if (s1.length() > 1 && s1.charAt(0) == '0' || s2.charAt(s2.length() - 1) == '0')
                continue;
            list.add(s1 + "." + s2);
        }
        return list;
    }

}