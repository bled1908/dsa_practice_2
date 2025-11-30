class Solution {
    public int[] beautifulArray(int n) {
            ArrayList<Integer> beautifulArrayList = new ArrayList<>();
        beautifulArrayList.add(1);

        // 2 se n tak isliye gaya kyuki abhi beatifulArrayList mai 1 stored hai toh uska
        // size 1 hai already isliye size 2 se start karne ke liye i ko 2 se initialize
        // kiya aur size n tak pochne ke liye n tak gaye

            while(beautifulArrayList.size() <n){
            ArrayList<Integer> temp = new ArrayList<>();

            for (Integer num : beautifulArrayList) {
                // adding even numbers
                if (2 * (num) <= n) {
                    temp.add(2 * num);
                }
            }

            for (Integer num : beautifulArrayList) {
                // adding odd numbers
                if (2 * (num) - 1 <= n) {
                    temp.add(2 * (num) - 1);
                }

            }
            beautifulArrayList = temp;

        }

int [] arr = new int[n];
for(int i = 0 ; i <beautifulArrayList.size() ; i++)
{
    arr[i] = beautifulArrayList.get(i);
}    

return arr;
    }
}