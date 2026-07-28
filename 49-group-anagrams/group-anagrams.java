class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> res = new ArrayList<>();
       if(strs == null || strs.length ==0){
        return res;
       }
       int n = strs.length;
       boolean[] visited = new boolean[n];
       for(int i=0; i<n; i++){
        if(visited[i]){
            continue;
        }
        List<String> currGroup = new ArrayList<>();
        currGroup.add(strs[i]);
        visited[i] =true;

        for(int j=i+1; j<n; j++){
            if(!visited[j] &&isAnagram(strs[i],strs[j])){
                currGroup.add(strs[j]);
                visited[j]= true;
            }
        }
        res.add(currGroup);
       }
       return res;
    }

    // Helper method to check if two strings are anagrams
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s11 = s1.toCharArray();
        char[] s22 = s2.toCharArray();
        Arrays.sort(s11);
        Arrays.sort(s22);

        return Arrays.equals(s11,s22);
    }
}