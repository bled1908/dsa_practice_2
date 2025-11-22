import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    List<int[]> cal;
    List<int[]> intrscs;

    public MyCalendarTwo() {
        cal = new ArrayList<>();
        intrscs = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] x : intrscs) {
            if ((start < x[0] && end > x[0]) || (start >= x[0] && start < x[1])) {
                return false;
            }
        }
        for (int[] x : cal) {
            if ((start < x[0] && end > x[0]) || (start >= x[0] && start < x[1])) {
                int cs = Math.max(x[0], start);
                int ce = Math.min(x[1], end);
                intrscs.add(new int[]{cs, ce});
            }
        }
        cal.add(new int[]{start, end});
        return true;
    }
}