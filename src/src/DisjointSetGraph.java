package src;

import java.util.Scanner;

public class DisjointSetGraph
{
    int V,E;
    Edge edge[];
    class Edge
    {
        int src,dest;
    }
    DisjointSetGraph(int v,int e)
    {
        V=v;
        E=e;
        edge=new Edge[E];
        for(int i=0;i<E;i++)
        {
            edge[i]=new Edge();
        }
    }
    class subset
    {
        int parent,rank;
    }
    int find(subset[] subsets,int i)
    {
        if((subsets[i]).parent!=i)
            subsets[i].parent=find(subsets,subsets[i].parent);
        return subsets[i].parent;
    }
    void Union(subset[] subsets,int x,int y)
    {
        int xroot=find(subsets,x);
        int yroot=find(subsets,y);
        if(subsets[xroot].rank<subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[yroot].rank < subsets[xroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }
    public int isCycle(DisjointSetGraph graph)
    {
        int V=graph.V;
        int E=graph.E;
        subset[] subsets=new subset[V];
        for(int v=0;v<V;v++)
        {
            subsets[v]=new subset();
            subsets[v].parent=v;
            subsets[v].rank=0;
        }
        for(int e=0;e<E;e++)
        {
            int x=find(subsets,graph.edge[e].src);
            int y=find(subsets,graph.edge[e].dest);
            if(x==y)
                return 1;
            Union(subsets,x,y);
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of vertices and edges:");
        int V= scan.nextInt();
        int E= scan.nextInt();
        DisjointSetGraph graph=new DisjointSetGraph(V,E);
        System.out.println("Enter edges");
        for(int i=0;i<E;i++)
        {
            graph.edge[i].src= scan.nextInt();
            graph.edge[i].dest= scan.nextInt();
        }
        if(graph.isCycle(graph)==1)
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph does not contain any cycle");
    }
}
