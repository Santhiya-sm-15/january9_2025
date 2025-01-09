class Solution {
    public int maxVowels(String s, int k) {
        int cnt=0,max=0,i;
        for(i=0;i<k;i++)
        {
            if(isVowel(s.charAt(i)))
                cnt++;
        }
        max=cnt;
        for(i=k;i<s.length();i++)
        {
            if(isVowel(s.charAt(i)))
                cnt++;
            if(isVowel(s.charAt(i-k)))
                cnt--;
            max=Math.max(max,cnt);
        }
        return max;
    }
    public boolean isVowel(char c)
    {
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}