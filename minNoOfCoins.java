public class minNoOfCoins 
{
    public static int min_Coins(int n,int s,int coin[])  
    {
        if(s==0)
        {
            return 0;
        }
        if(n==0)
        {
            return Integer.MAX_VALUE-1;
        }
        if(coin[n-1]<=s)
        {
            return Math.min( 1+min_Coins(n, s-coin[n-1], coin),min_Coins(n-1, s, coin)  );
        }
        return min_Coins(n-1, s, coin);
    }  

    public static int minCoinsMem(int n,int s,int coin[],int dp[][])
    {
        if(dp[n][s]!=-1)
        {
            return dp[n][s];
        }
        if(s==0)
        {
            return dp[n][s]=0;
        }
        if(n==0)
        {
            return dp[n][s]=Integer.MAX_VALUE-1;
        }
        if(coin[n-1]<=s)
        {
            return dp[n][s]=Math.min( 1+minCoinsMem(n, s-coin[n-1], coin,dp),minCoinsMem(n-1, s, coin,dp)  );
        }
        return dp[n][s]=minCoinsMem(n-1, s, coin,dp);
    }


    public static int MinCoinsTab(int n,int s,int coin[],int dp[][])
    {
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=s;j++)
            {
               if(n==0)
               {
                dp[i][j]=Integer.MAX_VALUE-1;
               }
               if(s==0)
               {
                    dp[i][j]=0;
               }
            }
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=s;j++)
            {
               if(coin[i-1]<=j)
               {
                dp[i][j]=Math.min(  1+  dp[i][j-coin[i-1]],  dp[i-1][j] );
               }
               else
               {
                    dp[i][j]=dp[i-1][j];
               }
            }
        }
        return dp[n][s];
    }

    public static void main(String[] args)
    {
        
        int coin[]={5,3,2,1,4};
        int n=coin.length;
        int s=8;
        int[][] dp=new int[n+1][s+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=s;j++)
            {
               dp[i][j]=-1;
            }
        }
        System.out.println(minCoinsMem(n, s, coin,dp));
        System.out.println(MinCoinsTab(n, s, coin, dp));
    }
}
