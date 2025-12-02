import java.math.BigDecimal;

class Solution {
    public boolean isRationalEqual(String s, String t) {
        s = expand(s);
        t = expand(t);

        BigDecimal ds = new BigDecimal(s);
        BigDecimal dt = new BigDecimal(t);

        BigDecimal re = new BigDecimal("1E-10");
        BigDecimal rr = ds.compareTo(dt) == 1 ? ds.subtract(dt) : dt.subtract(ds);

        if (ds.compareTo(dt) == 0 || rr.equals(re)) {
            return true;
        }
        return false;
    }

    private String expand(String s) {
        int p = s.indexOf("(");
        if (p > -1) {
            String left = s.substring(0, p);
            String right = s.substring(p + 1, s.length() - 1);
            while (right.length() < 11) {
                right += right;
            }
            s = left + right;
            String[] parts = s.split("\\.");
            parts[1] = parts[1].substring(0, 10);
            s = parts[0] + "." + parts[1];
        }
        return s;
    }
}