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