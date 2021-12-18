package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph
{
    private LinkedList<Integer> adj[];
    public Graph(int v)
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
        adj[destination].add(source);
    }
    public int bfs(int source,int destination)
    {
        boolean vis[]=new boolean[adj.length];
        int parent[]=new int[adj.length];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);
        parent[source]=-1;
        vis[source]=true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == destination) {
                break;
            }
            for (int neighbors : adj[cur]) {
                if (!vis[neighbors]) {
                    vis[neighbors] = true;
                    queue.add(neighbors);
                    parent[neighbors] = cur;
                }
            }
        }
        int cur=destination;
        int distance=0;
        while (parent[cur]!=-1)
        {
            System.out.print(cur+"->");
            cur=parent[cur];
            distance++;
        }
        System.out.print(cur);
        return  distance;
    }
    public boolean dfs(int source,int destination)
    {
        boolean vis[]=new boolean[adj.length];
        vis[source]=true;
        Stack<Integer> stack=new Stack<>();
        stack.push(source);
        while(!stack.isEmpty())
        {
            int cur=stack.pop();
            if(cur==destination)
                return true;
            for(int neighbor:adj[cur])
            {
                if(!vis[neighbor])
                {
                    vis[neighbor]=true;
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of vertices and edges ");
        int v=scan.nextInt();
        int e= scan.nextInt();
        Graph graph=new Graph(v);
        System.out.println("Enter "+e+" edges");
        for(int i=0;i<e;i++)
        {
            int source= scan.nextInt();
            int destination= scan.nextInt();
            graph.addEdge(source,destination);
        }
        System.out.println("Enter the source and destination ");
        int source= scan.nextInt();
        int destination= scan.nextInt();
        System.out.println("Path Possible :"+graph.dfs(source,destination));
        int dist=graph.bfs(source,destination);
        System.out.println("The minimum distance is = "+dist);


    }
}
