# january9_2025
The problem that i solved today in leetcode

1.You are given an array of strings words and a string pref. Return the number of strings in words that contain pref as a prefix. A prefix of a string s is any leading contiguous substring of s.

Code:
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

2.Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Code:
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m=new HashMap<>();
        for(String x:strs)
        {
            char[] c=x.toCharArray();
            Arrays.sort(c);
            String s=new String(c);
            if(!m.containsKey(s))
                m.put(s,new ArrayList<>());
            m.get(s).add(x);
        }
        return new ArrayList<>(m.values());
    }
}

3.Write an algorithm to determine if a number n is happy. A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits. Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy. Return true if n is a happy number, and false if not.

Code:
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s=new HashSet<>();
        int x=n;
        while(!s.contains(x))
        {
            s.add(x);
            if(x==1)
                return true;
            int sum=0;
            n=x;
            while(n>0){
                int a=n%10;
                sum+=a*a;
                n/=10;
            }
            x=sum;
        }
        return false;
    }
}

4.You are given an integer array nums consisting of n elements, and an integer k. Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Code:
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        int i;
        for(i=0;i<k;i++)
            sum+=nums[i];
        double max=sum/(double)k;
        for(i=k;i<nums.length;i++)
        {
            sum+=nums[i]-nums[i-k];
            max=Math.max(max,sum/(double)k);
        }
        return max;
    }
}

5.Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k. Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Code:
class Solution {
    public int maxVowels(String s, int k) {
        int cnt=0,max=0,i;
        for(i=0;i<k;i++)SS
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

6.Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Code:
class Solution {
    public int maximalSquare(char[][] matrix) {
        int i,j;
        int n=matrix.length,m=matrix[0].length,max=0;
        int[][] dp=new int[n][m];
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(i==0 || j==0)
                    dp[i][j]=matrix[i][j]-'0';
                else if(matrix[i][j]=='0')
                    dp[i][j]=0;
                else
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
