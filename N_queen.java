

public class N_queen {
    static int[] a= new int[4];
    public static void nqueen(int k,int n)
    {
        if(k==n){
            for(int i=0;i<n;i++)

            {
                System.out.println("arr[i]=="+a[i]);
            }
            return;
            
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(k,i))
            {
                a[k]=i;
                nqueen(k+1, n);
            }
        }
    }
    public static boolean isSafe(int k,int i)
    {
        for(int j=0;j<k;j++)
        {
            if(a[j]==i)
            {
                return false;   
            }
            if(Math.abs(i-a[j])==Math.abs(k-j))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        nqueen(0,4);
    }
    
}
