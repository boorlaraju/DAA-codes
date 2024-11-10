

public class minDifferenceSubset {



    public static int min_differnce(int arr[],int n,int Tsum,int calSum)
    {
        if(n==0)
        {
            return Math.abs((Tsum-calSum)-calSum);
        }
        if(calSum<=Tsum)
            return Math.min(min_differnce(arr, n-1,Tsum,calSum+arr[n-1]),min_differnce(arr, n-1, Tsum, calSum));
    
    return -1;
    }

    public static void main(String args[])
    {
        int arr[]={1,5 ,6,4};
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        System.out.println(min_differnce(arr, arr.length, sum, 0));
    }
    
}
