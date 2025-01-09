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