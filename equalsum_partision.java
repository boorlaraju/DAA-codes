public class equalsum_partision {


    public static boolean subsetsum(int n,int s,int val[])
    {
        if(s==0)
        {
            return true;
        }
        if(n==0)
        {
            return false;
        }
        if(val[n-1]<=s)
        {
            return subsetsum(n-1, s-val[n-1], val) || subsetsum(n-1, s, val);
        }
        else
        {
            return subsetsum(n-1, s, val);
        }
    }

    public static boolean equalsumPartision(int val[])
    {
        int n=val.length;
        int sum=0;
        for(int i=0;i<val.length;i++)
        {
            sum+=val[i];
        }
        if(sum%2!=0)
        {
            return false;

        }
        if(sum%2==0)
        {
            return subsetsum(n,sum/2,val);
        }
        return false;
        
        

    }
    public static void main(String args[])
    {
        int val[]={1,3,6};
        boolean x =equalsumPartision(val);
        System.out.println(x);
    }
}
