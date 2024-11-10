import java.util.Scanner;

public class insertion_sort {

    public static void insertionsort(int arr[])
    {
        int n=arr.length;
        int key;
        int i,j;
        for( i=1;i<n;i++)
        {
            key=arr[i];
            j=i-1;
            while(j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;

        }
    }

    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        insertionsort(arr);
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i]);
        }

        sc.close();
    }
    
}
