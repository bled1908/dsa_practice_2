class ExamRoom {
    TreeSet<int[]> intervals;
    TreeSet<Integer> pos;
    int n;
    public ExamRoom(int n) {
        intervals = new TreeSet<int[]>((a,b)->compare(a,b));
        pos = new TreeSet<>();
        pos.add(Integer.MIN_VALUE);
        pos.add(Integer.MAX_VALUE);
        intervals.add(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE});
        this.n = n;
    }
    int[] getInterval(int[]a){
        int low = Math.max(a[0],0);
        int high = Math.min(a[1],n-1);
        if(a[0]==Integer.MIN_VALUE || a[1]==Integer.MAX_VALUE){
            return new int[]{(high-low),low};
        }
        return new int[]{(high-low)/2,low};
    }
    int compare(int[]a, int b[]){
        int [] r1 = getInterval(a);
        int [] r2 = getInterval(b);
        if(r1[0]!=r2[0]){
            return r2[0] - r1[0];
        }
        return r1[1] - r2[1];
    }
    public int seat() {
        int [] interval = intervals.first();
        int seat = seatPos(interval);
        intervals.remove(interval);
        pos.add(seat);
        intervals.add(new int[]{interval[0],seat});
        intervals.add(new int[]{seat,interval[1]});
        return seat;
    }
    public void leave(int p) {
        int lower = pos.lower(p);
        int upper = pos.higher(p);
        pos.remove(p);
        intervals.remove(new int[]{lower,p});
        intervals.remove(new int[]{p,upper});
        intervals.add(new int[]{lower,upper});
    }
    int seatPos(int[]a){
        if(a[0]==Integer.MIN_VALUE){
            return 0;
        }
        if(a[1]==Integer.MAX_VALUE){
            return n-1;
        }
        return (a[0]+a[1])/2;
    }
}