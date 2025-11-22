class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length;
        int len2 = list2.length;
        if(len1 > len2) return findRestaurant(list2,list1);

        int idx = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String val : list2) map.put(val,idx++);

        int min = Integer.MAX_VALUE;
        ArrayList<String> result = new ArrayList<>();

        for(int i =0;i<len1;i++){
            if(map.containsKey(list1[i])){
                int ans = i + map.get(list1[i]);
                if(ans > min) continue;
                else if(ans < min) result = new ArrayList<>();
                result.add(list1[i]);
                min = ans;
            }
        }
        System.out.println(min);
        return result.toArray(new String[0]);
    }
}