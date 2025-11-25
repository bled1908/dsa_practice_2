class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        int j = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(i=0; i<indices.length; i++){
            if(map.containsKey(indices[i])){
                if(indices[i]+sources[i].length()>s.length()) continue;
                String sub = s.substring(indices[i], indices[i]+sources[i].length());
                if(sub.equals(sources[i])) map.put(indices[i],i);
            }
            else map.put(indices[i],i);
        }
        i=0;
        while(i<s.length()){
            if(!map.containsKey(i)){
                str.append(s.charAt(i));
                i++;
                continue;
            }
            // if(i<indices[j]) i++;
            j = map.get(i);
            int len = sources[j].length();
            if(i+len>s.length()){
                str.append(s.charAt(i));
                i++;
            }else{
                String sub = s.substring(i,i+len);
                if(sub.equals(sources[j])){
                    str.append(targets[j]);
                    i = i+len;
                }else{
                    str.append(s.charAt(i));
                    i++;
                }
            }
        }
        return str.toString();
    }
}