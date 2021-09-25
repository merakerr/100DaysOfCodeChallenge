/*
     You are given a graph.
    2. You are required to find and print if the graph is connected (there is a path from 
     every vertex to every other).

i/p
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

o/p:
false
*/
    
    import java.io.*;
    import java.util.*;
    public class isGraphConnected {
       static class Edge {
          int src;
          int nbr;
          int wt;
    
          Edge(int src, int nbr, int wt) {
             this.src = src;
             this.nbr = nbr;
             this.wt = wt;
          }
       }
       public static void gcc(ArrayList<Edge>[] graph, int src, boolean[] vis) {
            vis[src] = true;
            for(Edge e : graph[src]) {
                int nbr = e.nbr;
                if(vis[nbr] == false) {
                    gcc(graph, nbr, vis);
                }
            }
        }
    public static boolean isConnected(ArrayList<Edge>[] graph) {
            int count = 0;
            int n = graph.length;
            boolean[] vis = new boolean[n];
    
            for(int v = 0; v < n; v++) {
                if(vis[v] == false) {
                    count++;
                    if(count > 1) {
                        return false;
                    }
                    gcc(graph, v, vis);
                }
            }
            return true;
        }
       public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
          int vtces = Integer.parseInt(br.readLine());
          ArrayList<Edge>[] graph = new ArrayList[vtces];
          for (int i = 0; i < vtces; i++) {
             graph[i] = new ArrayList<>();
          }
    
          int edges = Integer.parseInt(br.readLine());
          for (int i = 0; i < edges; i++) {
             String[] parts = br.readLine().split(" ");
             int v1 = Integer.parseInt(parts[0]);
             int v2 = Integer.parseInt(parts[1]);
             int wt = Integer.parseInt(parts[2]);
             graph[v1].add(new Edge(v1, v2, wt));
             graph[v2].add(new Edge(v2, v1, wt));
             
             
          }
    
          boolean res = isConnected(graph);
          System.out.println(res);
       }
    }
