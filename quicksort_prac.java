import java.util.Scanner;

public class quicksort_prac {

   public static void quicksort(int arr[],int low ,int high)
   {
        int mid;
        if(low<high)
        {
            mid=partision(arr,low,high);
            quicksort(arr,low,mid-1);
            quicksort(arr,mid+1,high);
        }
   }

   public static int partision(int arr[],int low,int high)
   {
        int i,j;
        i=low;
        j=high;
        int pivot=low;
        while(i<j)
        {
            while(arr[i]<=arr[pivot]  && i<high)
            {
                i++;
            }
            while(arr[j]>arr[pivot] && j>low)
            {
                j--;
            }
            if(i<j)
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
                int temp=arr[low];
                arr[low]=arr[j];
                arr[j]=temp;


                return j;
   }


    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("enter the elements of array");

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        quicksort(arr, 0, n-1);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
    
}
