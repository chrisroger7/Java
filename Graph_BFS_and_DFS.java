import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph1 {
    int V; 
    LinkedList<Integer>[] adj;

    public Graph1(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
    
    public boolean BFS(int start, int goal) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(current==goal) {
            	System.out.println("\n goal is found : " + current);
            	return true;
            }
            System.out.print(current + " ");

            for (Integer neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println("\n The goal is not found after traversing the entire graph.");
        return false;
    }

    public boolean DFS(int start, int goal) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if(current==goal) {
            	System.out.println("\n goal is found : " + current);
            	return true;
            }
            
            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;
            }

            for (Integer neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println("\n The goal is not found after traversing the entire graph.");
        return false;
    }
}

public class Graph_BFS_and_DFS {
	public static void main(String[] args) {
        Graph1 g = new Graph1(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        
        System.out.println("Edges of the graph:");
        for (int i = 0; i < 7; i++) {
            System.out.println(i + " -> " + g.adj[i]);
        }
        System.out.println();
        
        System.out.println("BFS starting from vertex 0 and searching for vertex 4");
        g.BFS(0,4);
        System.out.println();
        
        System.out.println("BFS starting from vertex 0 and searching for vertex 7");
        g.BFS(0,7);
        System.out.println();
        
        System.out.println("DFS starting from vertex 0 and searching for vertex 3");
        g.DFS(0,3);
        System.out.println();
        
        System.out.println("DFS starting from vertex 0 and searching for vertex 7");
        g.DFS(0,7);
        System.out.println();
    }
}