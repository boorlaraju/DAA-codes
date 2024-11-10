

public class subset_sum {


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


    public static boolean subsetsum_memorisation(int n,int s,int val[],boolean a[][])
    {
        if(a[n][s]!=false)
        {
            return a[n][s];
        }
        if(s==0)
        {
            return a[n][s]=true;
        }
        if(n==0)
        {
            return a[n][s]=false;
        }
        if(val[n-1]<=s)
        {
            return a[n][s]=subsetsum_memorisation(n-1, s-val[n-1], val,a) || subsetsum_memorisation(n-1, s, val,a);
        }
        else
        {
            return a[n][s]=subsetsum_memorisation(n-1, s, val,a);
        }
    }

    public static boolean subsetsum_tab(int n,int s,int val[],boolean a[][])
    {
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<s+1;j++)
            {
                if( i==0)
                {
                    a[i][j]=false;
                }
                if(j==0)
                {
                    a[i][j]=true;
                }
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<s+1;j++)
            {
                if(val[i-1]<=j)
                {
                    a[i][j]= a[i-1][j-val[i-1]] || a[i-1][j];
                }
                else
                {
                    a[i][j]=a[i-1][j];
                }
            }
        }
        return a[n][s];
    }

    public static void main(String[] args)
    {
        int val[]={5,3,2,1,4};
        int s=23;
        boolean[][]a=new boolean [val.length+1][s+1];
        
        System.out.println(subsetsum_tab(val.length, 23, val,a));

    }
    
}
