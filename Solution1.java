class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt=0;
        for(String x:words)
        {
            if(x.startsWith(pref))
                cnt++;
        }
        return cnt;
    }
}