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