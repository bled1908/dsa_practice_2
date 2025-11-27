class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] result=new int[A.length];
      
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<B.length;i++){
            int val=B[i];
            Pair np=new Pair(val,i);
            pq.add(np);
        }
        
        Arrays.sort(A);
        
        int end=A.length-1;
        int start=0;
        while(start<=end){
           Pair top=pq.remove();
            
           int idx=top.idx;
           int val=top.val;
            
           int max=A[end];
           int min=A[start];
            
           if(max>val){
               result[idx]=max;
               end--;
           }else{
               result[idx]=min;
               start++;
           }
        }
        return result;
    }
    
    public class Pair implements Comparable<Pair>{
        int idx;
        int val;
        
        Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        
        @Override
        public int compareTo(Pair other){
            return other.val-this.val;
        }
    }
}