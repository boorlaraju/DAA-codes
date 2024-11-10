import java.util.*;
public class kruskals {
    static int adj[][];
    static int parent[];
    static int u,v;
    static int mst=0;
    public static int findparent(int u){
        if(parent[u]==u){
            return u;
        }
        else{
            return findparent(parent[u]);
        }
    }
    public static void findmin(int n){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj[i][j]<min && adj[i][j]!=0){
                    min=adj[i][j];
                    u=i;
                    v=j;
                }
            }
        }
    }
    public static void kruskalscode(int n){
        int k=n-1;
        while(k!=0){
             findmin(n);
             int pu=findparent(u);
             int pv=findparent(v);
            if(pu!=pv){
                mst=mst+adj[u][v];
                parent[pv]=pu;
                // System.out.println("madhu"+adj[u][v]);
 
                k--;
            }
            adj[u][v]=0;
            adj[v][u]=0;
            // System.out.println("YES");
           
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size");
        int n=sc.nextInt();
        adj=new int[n][n];
        parent=new int[n];
        System.out.println("enter the adj matrix");
        for(int i=0;i<n;i++){
            parent[i]=i;
            for(int j=0;j<n;j++){
                adj[i][j]=sc.nextInt();
            }
        }
        kruskalscode(n);
        System.out.println(mst);
        sc.close();
    }
}
