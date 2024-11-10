public class dijkshtra {

    boolean visisted[];
    int distances[];
    int n;
    int adjMatrix[][];

    public dijkshtra(int n)
    {
        this.n=n;
        visisted= new boolean[n];
        distances = new int[n];
        adjMatrix = new int[n][n];


    }


    public void Dijkstra(int src,int adjMatrix[][])
    {
        this.adjMatrix=adjMatrix;
        for(int i=0;i<distances.length;i++)
        {
            distances[i]=Integer.MAX_VALUE;
        }

        distances[src]=0;

        for(int i=0; i < n-1; i++)
        {
            int u=minDistance();
            visisted[u]=true;
            for(int v=0 ; v<n ; v++)
            {
                if(!visisted[v] && adjMatrix[u][v]!=0 && distances[u]!=Integer.MAX_VALUE && distances[u]+ adjMatrix[u][v] < distances[v])
                {
                    distances[v]=distances[u]+adjMatrix[u][v];
                }

            }
        }

    }
    public int minDistance()
    {
       int  mind=Integer.MAX_VALUE;
       int minnode=-1;
       for(int i=0;i<n;i++)
       {
            if(!visisted[i] & distances[i]<mind)
            {
                mind=distances[i];
                minnode=i;
            }
       }
       return minnode;

    }


    public static void main(String args[])
    {
        int n = 5;
        int source = 0;

        int[][] adjMatrix = {
            { 0, 9, 6, 5, 3 },
            { 0, 0, 0, 0, 0 },
            { 0, 2, 0, 4, 0 },
            { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0 }
        };

        dijkshtra d = new dijkshtra(n);
        d.Dijkstra(source,adjMatrix);

        System.out.println("The shortest path from node :");
        for (int i = 0; i < d.distances.length; i++) {
            System.out.println(source + " to " + i + " is " + d.distances[i]);
        }
    }


    
}
