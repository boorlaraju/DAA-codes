import java.util.Scanner;

public class knapsack {
    int n,w;
    static int[] val;
    static int[] wt;
    knapsack(int n,int w)
    {
        this.n=n;
        this.w=w;
        val=new int[n];
         wt=new int[n];
    }
    void read()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the weights :");
        for(int i=0;i<n;i++)
        {
            wt[i]=sc.nextInt();
        }
        System.out.println("Enter the values :");
        for(int i=0;i<n;i++)
        {
            val[i]=sc.nextInt();
        }
        sc.close();
    }
    int ks(int n,int w)
    {
        if(n==0 || w==0)
        {
            return 0;
        }
        if(wt[n-1]<=w)
        {
            return Math.max( val[n-1] + ks(n-1,w-wt[n-1]), ks(n-1,w) );
        }
        else
        {
            return ks(n-1,w);
        }
    }
    int knapsack_dp(int n,int w,int[][] dp)
    {
        if(dp[n][w]!=-1)
        {
            return dp[n][w];
        }
        if(n==0 || w==0)
        {
            return dp[n][w]=0;
        }
        if(wt[n-1]<=w)
        {
            return dp[n][w]=Math.max(val[n-1]+knapsack_dp(n-1, w-wt[n-1], dp), knapsack_dp(n-1, w, dp));
        }
        else
        {
            return dp[n][w]=knapsack_dp(n-1,w,dp);
        }
    }

    public static int knapsack_tab(int n,int s,int dp[][])
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<s;j++)
            {
                if(i==1 || j==0)
                {
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=s;j++)
            {
                if(wt[i-1]<=j)
                {
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][s];
    }

    public static void main(String args[])
    {
        int n,w;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number weights and weight of bag");
        n=sc.nextInt();
        w=sc.nextInt();
        knapsack k=new knapsack(n, w);
        k.read();
        int[][] dp= new int[n+1][w+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<w+1;j++)
            {
                dp[i][j]=-1;
            }
        }
        int val=knapsack.knapsack_tab(n,w,dp);
        System.out.println("value = "+val);
        sc.close();
    }
}
