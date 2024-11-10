import java.util.*;
public class climbing_starirs 
{
    public static int climbstairs(int index)
    {
        // if(index==0)
        // {
        //     return 1; 
        // }
        // if(index==1)
        // {
        //     return 1;
        // }
        if(index<=1)
        {
            return index;
        }
        return climbstairs(index-1)+climbstairs(index-2);
        
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of steps");
        int n=sc.nextInt();
        int p=climbstairs(n+1);
        System.out.println(p);
        sc.close();

    }
    
}
