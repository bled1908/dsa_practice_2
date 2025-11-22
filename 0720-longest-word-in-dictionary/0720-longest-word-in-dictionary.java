class Solution {

    class Node{   // Trie - Prefix Tree
        Node[] children = new Node[26];
        boolean eow = false;
        Node(){
            for(int i =0; i< 26;i++){
                children[i]=null;
            }
        }
    }

    Node root = new Node();

    public void insert(String word){
        Node curr=root;
        for(int i = 0; i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    String ans="";
    public void solve(Node root, String temp){  // we will find the str for longest consecutive childs have its eow = true.  => so we will get the longest word in dictionary
        if(ans.length()<temp.length()){   //  to get the longest 
            ans=temp;
        }

        for(int i = 0; i<26;i++){
            if(root.children[i]!=null && root.children[i].eow){
                temp += (char)(i+'a');
                solve(root.children[i], temp);
                temp=temp.substring(0, temp.length()-1);  // backtrack step (remove the last character from temp)
            }
        }
    }

    public String longestWord(String[] words) {
        for(String word : words){
            insert(word);
        }
        solve(root, "");  // build final ans
        return ans;
    }
}