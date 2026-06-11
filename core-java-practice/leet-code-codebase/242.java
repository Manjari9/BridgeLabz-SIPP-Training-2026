class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int freq1[]=new int [26];
        for(int j=0;j<t.length();j++){
            freq1[t.charAt(j)-'a']++;
        }
        if(Arrays.equals(freq,freq1)){
           return true;
        }
        return false;
    }
}
    

