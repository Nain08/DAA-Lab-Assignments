package src;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSortGraph
{
    private LinkedList<Integer> adj[];
    TopologicalSortGraph(int v)
    {
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]=new LinkedList<Integer>();
        }
    }
    public void addEdge(int source,int destination)
    {
        adj[source].add(destination);
    }
    public void topologicalSort()
    {
        Stack<Integer> stack=new Stack<>();
        boolean vis[]=new boolean[adj.length];
        for(int i=0;i<adj.length;i++)
        {
            if(vis[i]==false)
                topologicalSortUtil(i,vis,stack);
        }
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop()+" ");
        }
    }
    public void topologicalSortUtil(int v,boolean vis[],Stack<Integer> stack)
    {
        vis[v]=true;
        for(int neighbor:adj[v])
        {
            if(!vis[neighbor])
            {
                topologicalSortUtil(neighbor,vis,stack);
            }
        }
        stack.push(v);
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");
        int v= scan.nextInt();
        int e= scan.nextInt();
        TopologicalSortGraph graph=new TopologicalSortGraph(v);
        System.out.println("Enter "+e+" edges");
        for(int i=0;i<e;i++)
        {
            int source=scan.nextInt();
            int destination= scan.nextInt();
            graph.addEdge(source,destination);
        }
        graph.topologicalSort();
    }

}
