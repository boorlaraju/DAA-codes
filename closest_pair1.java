import java.util.*;
//import java.math.*;
class point{
    int x;
    int y;
    point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
   public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
    
}

public class closest_pair1 {
    public static void main(String args[])
    {
        double distance=0;
        int x1=0,x2=0,y1=0,y2=0;
        double min=Integer.MAX_VALUE;
        System.out.println("enter the no of points");
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        point p[]=new point[n];
        System.out.println("enter point co-ordinates");
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            p[i]=new point(x,y);
        }

        //brute force approch to find short distance
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                distance=Math.sqrt(((p[j].getx()-p[i].getx())*(p[j].getx()-p[i].getx()))+((p[j].gety()-p[i].gety())*(p[j].gety()-p[i].gety())));
                if(min>distance)
                {
                    min=distance;
                    x1=p[i].getx();
                    x2=p[j].getx();
                    y1=p[i].gety();
                    y2=p[j].gety();


                }
                
            }
        }
        System.out.println("x1="+x1+"y1="+y1);
        System.out.println("x2="+x2+"y2="+y2);
        System.out.println("mimimun distance ="+ min);

        sc.close();

    }

    


    
}
