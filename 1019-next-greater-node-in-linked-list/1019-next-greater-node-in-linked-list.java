class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> a = new ArrayList<>();
        while(head!=null){
            a.add(head.val);
            head=head.next;
        }
        int[] arr = new int[a.size()];
        arr[a.size()-1]=0;
        for(int i=0;i<a.size();i++){
            int max = 0;
            for(int j=i+1;j<a.size();j++){
               if (a.get(j)>a.get(i)){
               max=a.get(j);
               break;
               }
        }
            arr[i]=max;
        }
        return arr;
    }
}