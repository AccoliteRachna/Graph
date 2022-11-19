import java.util.*;
public class Graph{
    int[][] adj = new int[5][5];
    Graph(){
    for (int[] row: adj)
         Arrays.fill(row, 0);
    }
    void addEdge(int x,int y,int w){
        adj[x-65][y-65] = w;
        adj[y-65][x-65] = w;
    }
    void dfs(int s,int d,ArrayList<Integer>paths,int distance,boolean[] visited){
        if(d==s){
            paths.add(distance);
        }
        for(int j=0;j<adj[s].length;j++)
        {
            if(adj[s][j]!=0 && visited[j]==false)
            {
                distance += adj[s][j];
                visited[j] = true;
                dfs(j,d,paths,distance,visited);
                visited[j] = false;
                distance-=adj[s][j];
            }
        }
    }
    public double calculateAverageDistanceBetweenTwoPoints(char x, char y)
    {
        int s = x-65;
        int d = y-65;
        ArrayList<Integer> paths = new ArrayList<>();
        boolean[] visited = new boolean[5];
        for(int i=0;i<visited.length;i++)
            visited[i] = false;
        visited[s] = true;
        dfs(s,d,paths,0,visited);
        int total = 0;
        for(int i:paths)
        {
            System.out.println(i);
            total+=i;
        }
        double dist = total/paths.size();
        return dist;
    }
    public static void main(String[] args) {
        Graph obj = new Graph();
        obj.addEdge('A', 'B', 12);
        obj.addEdge('B', 'C', 3);
        obj.addEdge('A', 'C', 13);
        obj.addEdge('C', 'E', 4);
        obj.addEdge('A', 'E', 8);
        obj.addEdge('A', 'D', 11);
        obj.addEdge('D', 'E', 7);
        Scanner sc = new Scanner(System.in);
        char x = sc.next().charAt(0);
        char y = sc.next().charAt(0);
        System.out.println(obj.calculateAverageDistanceBetweenTwoPoints(x,y));
    }
}