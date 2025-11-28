class StockSpanner {
    List<Integer> list;
    public StockSpanner() {
        this.list=new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int ans=0;
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i)>price)break;
            ans++;
        }
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */