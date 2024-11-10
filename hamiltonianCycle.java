import java.util.Scanner;

public class hamiltonianCycle {
     
        int v;
        int[] path;
        hamiltonianCycle(int v)
        {
            this.v=v;
            path= new int[v];
            for(int i=0;i<v;i++)
            {
                path[i]=-1;
            }
        }

        void hamilCycle(int pos,int v,int[][] adj)
        {
            if(pos==v)
            {
                if(adj[path[pos-1]][path[0]]==1)
                {
                    for(int i=0;i<v;i++)
                    {
                        System.out.println(path[i]+" ");
                    }
                    System.out.println(path[0]+" ");
                }
                return;
            }

            for(int i=1;i<v;i++)
            {
                if(isSafe(pos,i,adj))
                {
                    path[pos]=i;
                    hamilCycle(pos+1, v, adj);
                    path[pos]=-1;
                }
            }
        }

        boolean isSafe(int pos,int i,int[][] adj)
        {
            if(adj[path[pos-1]][i]==0)
            {
                return false;
            }
            for(int j=0;j<pos;j++)
            {
                if(path[j]==i)
                {
                    return false;   
                }
            }
            return true;
        }

    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter no vertices");
        int V=sc.nextInt();
        System.out.println("enter no edges");
        int n=sc.nextInt();
        hamiltonianCycle ham = new hamiltonianCycle(V);
        int[][] adj = new int[V+1][V+1];
        for(int i=0;i<n;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj[u][v]=1;
            adj[v][u]=1; 
        }
        for(int i=0;i<=V;i++)
        {
            for(int j=0;j<=V;j++)
            {
                System.out.print(adj[i][j]+" ");
            }
            System.out.println("");
        }
        ham.path[0]=1;
        ham.hamilCycle(1, V, adj);
        sc.close();

    }
    
}
