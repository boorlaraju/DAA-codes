import java.util.*;
class point 
{
    int x,y;
    point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
class convexhull
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter no of points");
        int n=sc.nextInt();
        point p[]=new point[n];
        point convex[]=new point[n];
        int m=0;
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=-1;
        }
        for(int i=0;i<n;i++)
        {
            int x,y;
           x= sc.nextInt();
           y=sc.nextInt();
           p[i]=new point(x,y);

        }
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int a=p[j].getY()-p[i].getY();
                int b=p[i].getX()-p[j].getX();
                int c=p[i].getX()*p[j].getY() - p[i].getY()*p[j].getX();
                int nn=0,np=0;
                for(int k=0;k<n;k++)
                {
                    if(k!=i &&k!=j)
                    {

                        int val=a*p[k].getX()+b*p[k].getY()-c;
                        if(val>0)
                        {
                            np++;
                        }
                        else if(val<0)
                        {
                            nn++;
                        }
                    }

                }
                if(nn==0 ||np==0)
                {
                    // System.out.println(p[i].getX()+" "+p[i].getY());
                    // System.out.println(p[j].getX()+" "+p[j].getY());
                    if(arr[i]==-1)
                    {
                        convex[m]=new point(p[i].getX(),p[i].getY());
                        m++;
                        arr[i]=1;
                    }
                    if(arr[j]==-1)
                    {
                        convex[m]=new point(p[j].getX(),p[j].getY());
                        m++;

                        arr[j]=1;
                    }
                }
            }
        }

        sc.close();
        System.out.println("convex points");    
        for(int i=0;i<m;i++)
        {
            System.out.println(convex[i].getX()+" "+convex[i].getY());
        }
    }
}